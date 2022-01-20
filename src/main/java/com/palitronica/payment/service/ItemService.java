package com.palitronica.payment.service;

import com.palitronica.payment.model.dto.ItemDTO;

import java.util.List;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

public interface ItemService
{
    void save(ItemDTO dto);

    List<ItemDTO> queryAll();
}
