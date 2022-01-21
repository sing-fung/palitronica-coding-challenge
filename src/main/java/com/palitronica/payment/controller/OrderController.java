package com.palitronica.payment.controller;

import com.palitronica.payment.exception.BusinessException;
import com.palitronica.payment.model.dto.ItemQuantityDTO;
import com.palitronica.payment.model.dto.OrderRequestDTO;
import com.palitronica.payment.model.dto.OrderResponseDTO;
import com.palitronica.payment.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sing-fung
 * @since 1/20/2022
 */

@RestController
@RequestMapping(value = "/api/order")
@Slf4j
@Validated
public class OrderController
{
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService)
    { this.orderService = orderService; }

    @PostMapping
    public OrderResponseDTO save(@RequestBody @Validated(OrderRequestDTO.Insert.class) OrderRequestDTO dto)
    {
        List<ItemQuantityDTO> itemQuantityDTOList = dto.getItemQuantityDTOs();
        for(ItemQuantityDTO itemQuantity : itemQuantityDTOList)
        {
            if(itemQuantity.getQuantity() <= 0)
            { throw new BusinessException("invalid quantity"); }
        }

        OrderResponseDTO result = orderService.save(dto);
        return result;
    }
}
