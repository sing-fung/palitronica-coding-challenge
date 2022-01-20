package com.palitronica.payment.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item implements Serializable
{
    private static final long serialVersionUID = -1707144727129248042L;

    private String id;
    private String code;
    private double price;
}
