package com.palitronica.payment.model.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemQuantityDTO
{
    @NotBlank(message = "item_id could not be empty")
    private String item_id;
    @Min(value = 1, message = "quantity should be larger than 0")
    private int quantity;
}
