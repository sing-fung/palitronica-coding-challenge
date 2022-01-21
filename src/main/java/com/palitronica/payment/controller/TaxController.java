package com.palitronica.payment.controller;

import com.palitronica.payment.model.dto.AddressDTO;
import com.taxjar.Taxjar;
import com.taxjar.exception.TaxjarException;
import com.taxjar.model.rates.Rate;
import com.taxjar.model.rates.RateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@RestController
@RequestMapping(value = "/api/tax")
@Slf4j
@Validated
public class TaxController
{
    @GetMapping
    public Float save(@RequestBody @Validated(AddressDTO.Insert.class) AddressDTO dto)
    {
        Taxjar client = new Taxjar("16fb767b82fd197971e996d5b89b4a6b");
        Float result = 0f;

        try {
            Map<String, String> params = new HashMap<>();
            params.put("country", dto.getCountry());
            params.put("city", dto.getCity());
            params.put("street", dto.getStreet());
            RateResponse res = client.ratesForLocation(dto.getZip(), params);
            Rate rate = res.rate;
            result = rate.getCombinedRate();
        } catch (TaxjarException e) {
            e.printStackTrace();
        }

        return result;
    }
}
