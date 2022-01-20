package com.palitronica.payment.dao;

import org.springframework.stereotype.Repository;
import com.palitronica.payment.model.entity.OrderOverview;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Repository
public interface OrderOverviewDAO
{
    int insert(OrderOverview orderOverview);
}