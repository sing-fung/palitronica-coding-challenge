package com.palitronica.payment.dao;

import org.springframework.stereotype.Repository;
import com.palitronica.payment.model.entity.Customer;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Repository
public interface CustomerDAO
{
    int insert(Customer customer);

    Customer queryById(String id);
}
