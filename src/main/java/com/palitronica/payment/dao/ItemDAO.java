package com.palitronica.payment.dao;

import org.springframework.stereotype.Repository;
import com.palitronica.payment.model.entity.Item;

import java.util.List;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Repository
public interface ItemDAO
{
    int insert(Item item);

    List<Item> queryAll();

    Item queryByCode(String code);
}