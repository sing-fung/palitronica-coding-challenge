package com.palitronica.payment.service.impl;

import com.palitronica.payment.dao.CustomerDAO;
import com.palitronica.payment.model.entity.Customer;
import com.palitronica.payment.model.dto.CustomerDTO;
import com.palitronica.payment.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService
{
    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO)
    {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CustomerDTO dto)
    {
        Customer customer = new Customer();
        BeanUtils.copyProperties(dto, customer);
        customer.setId(UUID.randomUUID().toString());
        customerDAO.insert(customer);
    }
}