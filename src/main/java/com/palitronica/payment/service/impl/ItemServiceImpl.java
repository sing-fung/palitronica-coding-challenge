package com.palitronica.payment.service.impl;

import com.palitronica.payment.dao.ItemDAO;
import com.palitronica.payment.exception.BusinessException;
import com.palitronica.payment.model.entity.Item;
import com.palitronica.payment.model.dto.ItemDTO;
import com.palitronica.payment.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService
{
    private ItemDAO itemDAO;

    public ItemServiceImpl(ItemDAO itemDAO)
    {
        this.itemDAO = itemDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ItemDTO dto)
    {
        Item i = itemDAO.queryByCode(dto.getCode());
        if (i != null)
        { throw new BusinessException("item code is already used"); }

        Item item = new Item();
        BeanUtils.copyProperties(dto, item);
        item.setId(UUID.randomUUID().toString());
        itemDAO.insert(item);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ItemDTO> queryAll()
    {
        List<Item> itemList = itemDAO.queryAll();
        List<ItemDTO> dtoList = new ArrayList<>();

        for(Item item : itemList)
        {
            ItemDTO dto = new ItemDTO();
            BeanUtils.copyProperties(item, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }
}