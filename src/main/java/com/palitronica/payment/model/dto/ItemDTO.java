package com.palitronica.payment.model.dto;

import lombok.*;
import javax.validation.constraints.*;

/**
 * @author sing-fung
 * @since 1/9/2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO
{
    private String id;
    @NotBlank(message = "code could not be empty", groups = Insert.class)
    private String code;
    private double price;

    public interface Insert {}
}
