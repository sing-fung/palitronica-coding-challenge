package com.palitronica.payment.controller;

import com.palitronica.payment.common.Result;
import com.palitronica.payment.model.dto.CustomerDTO;
import com.palitronica.payment.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@RestController
@RequestMapping(value = "/api/customer")
@Slf4j
@Validated
public class CustomerController
{
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService)
    { this.customerService = customerService; }

    @PostMapping
    public ResponseEntity<Result<Object>> save(@RequestBody @Validated(CustomerDTO.Insert.class) CustomerDTO dto)
    {
        customerService.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Result.success());
    }
}