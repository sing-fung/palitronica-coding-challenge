package com.palitronica.payment.service;

import com.palitronica.payment.model.dto.OrderRequestDTO;
import com.palitronica.payment.model.dto.OrderResponseDTO;

/**
 * @author sing-fung
 * @since 1/20/2022
 */

public interface OrderService
{
    OrderResponseDTO save(OrderRequestDTO dto);
}
