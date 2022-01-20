package com.palitronica.payment.model.dto;

import lombok.*;

import java.util.List;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequestDTO
{
    private String customer_id;
    private List<ItemQuantityDTO> itemQuantityDTOS;
}
