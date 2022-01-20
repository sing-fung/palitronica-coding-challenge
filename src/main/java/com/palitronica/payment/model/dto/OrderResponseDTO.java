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
public class OrderResponseDTO
{
    private String customer_name;
    private double total_taxes;
    private double total_price;
    private List<ItemPriceDTO> itemPrices;
}
