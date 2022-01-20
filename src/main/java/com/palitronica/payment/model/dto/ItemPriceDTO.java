package com.palitronica.payment.model.dto;

import lombok.*;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemPriceDTO
{
    private String item_code;
    private String item_total_price;
}
