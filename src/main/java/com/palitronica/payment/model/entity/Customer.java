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
public class Customer implements Serializable
{
    private static final long serialVersionUID = -8503574526972569081L;

    private String id;
    private String name;
    private String country;
    private String city;
    private String street;
    private String zip;
}
