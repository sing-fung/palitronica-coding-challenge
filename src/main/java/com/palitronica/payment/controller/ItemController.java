package com.palitronica.payment.controller;

import com.palitronica.payment.common.Result;
import com.palitronica.payment.exception.BusinessException;
import com.palitronica.payment.model.dto.ItemDTO;
import com.palitronica.payment.service.ItemService;
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
@RequestMapping(value = "/api/item")
@Slf4j
@Validated
public class ItemController
{
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService)
    { this.itemService = itemService; }

    @PostMapping
    public ResponseEntity<Result<Object>> save(@RequestBody @Validated(ItemDTO.Insert.class) ItemDTO dto)
    {
        if(dto.getPrice() <= 0)
        { throw new BusinessException("price should be larger than 0"); }

        itemService.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Result.success());
    }
}
