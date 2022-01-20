package com.palitronica.payment.dao;

import org.springframework.stereotype.Repository;
import com.palitronica.payment.model.entity.OrderItem;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Repository
public interface OrderItemDAO
{
    int insert(OrderItem orderItem);
}