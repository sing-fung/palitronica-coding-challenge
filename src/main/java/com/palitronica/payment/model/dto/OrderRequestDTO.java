package com.palitronica.payment.model.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "you didn't select any item", groups = Insert.class)
    private List<ItemQuantityDTO> itemQuantityDTOs;

    public interface Insert {}
}

