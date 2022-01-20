package com.palitronica.payment.model.dto;

import lombok.*;

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
public class CustomerDTO
{
    private String id;
    @NotBlank(message = "name could not be empty", groups = Insert.class)
    private String name;
    @NotBlank(message = "country could not be empty", groups = Insert.class)
    private String country;
    @NotBlank(message = "city could not be empty", groups = Insert.class)
    private String city;
    @NotBlank(message = "street could not be empty", groups = Insert.class)
    private String street;

    public interface Insert {}
}
