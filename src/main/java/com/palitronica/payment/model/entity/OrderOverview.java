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
public class OrderOverview implements Serializable
{
    private static final long serialVersionUID = 5797340409266468320L;

    private String id;
    private String customer_id;
    private double total_taxes;
    private double total_price;
}