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
public class OrderItem implements Serializable
{
    private static final long serialVersionUID = -719144645430966432L;

    private String id;
    private String order_id;
    private String item_code;
    private int quantity;
    private double item_total_price;
}
