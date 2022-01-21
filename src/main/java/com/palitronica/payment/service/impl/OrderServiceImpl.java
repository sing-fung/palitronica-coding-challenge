package com.palitronica.payment.service.impl;

import com.palitronica.payment.dao.CustomerDAO;
import com.palitronica.payment.dao.ItemDAO;
import com.palitronica.payment.dao.OrderItemDAO;
import com.palitronica.payment.dao.OrderOverviewDAO;
import com.palitronica.payment.exception.BusinessException;
import com.palitronica.payment.model.dto.*;
import com.palitronica.payment.model.entity.*;
import com.palitronica.payment.model.entity.OrderItem;
import com.palitronica.payment.model.entity.OrderOverview;
import com.palitronica.payment.service.OrderService;
import com.taxjar.Taxjar;
import com.taxjar.exception.TaxjarException;
import com.taxjar.model.rates.Rate;
import com.taxjar.model.rates.RateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService
{
    private CustomerDAO customerDAO;
    private ItemDAO itemDAO;
    private OrderOverviewDAO orderOverviewDAO;
    private OrderItemDAO orderItemDAO;

    public OrderServiceImpl(CustomerDAO customerDAO, ItemDAO itemDAO, OrderOverviewDAO orderOverviewDAO, OrderItemDAO orderItemDAO)
    {
        this.customerDAO = customerDAO;
        this.itemDAO = itemDAO;
        this.orderOverviewDAO = orderOverviewDAO;
        this.orderItemDAO = orderItemDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderResponseDTO save(OrderRequestDTO dto)
    {
        String customer_id = dto.getCustomer_id();
        Customer customer = customerDAO.queryById(customer_id);
        if (customer == null)
        { throw new BusinessException("customer does not exist"); }

        // initialize the order entity
        OrderOverview order = new OrderOverview();
        String order_id = UUID.randomUUID().toString();
        order.setId(order_id);
        order.setCustomer_id(customer_id);

        // get all item_codes
        List<String> item_codes = new ArrayList<>();
        for(ItemQuantityDTO itemQuantity : dto.getItemQuantityDTOs())
        { item_codes.add(itemQuantity.getItem_code()); }

        // put item_code and its price into a map
        List<Item> itemList = itemDAO.queryByCodes(item_codes);
        HashMap<String, Double> itemPriceMap = new HashMap<>();
        for(Item item : itemList)
        { itemPriceMap.put(item.getCode(), item.getPrice()); }

        Set<String> itemCodeSet = itemPriceMap.keySet();

        // order's total price before taxes
        double total_price = 0;

        // create OrderItem entities
        List<OrderItem> orderItemList = new ArrayList<>();
        List<ItemPriceDTO> itemPriceDTOList = new ArrayList<>();
        for(ItemQuantityDTO itemQuantity : dto.getItemQuantityDTOs())
        {
            String item_code = itemQuantity.getItem_code();

            if(!itemCodeSet.contains(item_code))
            { throw new BusinessException("item_code does not exist"); }

            OrderItem orderItem = new OrderItem();
            orderItem.setId(UUID.randomUUID().toString());
            orderItem.setOrder_id(order_id);
            orderItem.setItem_code(item_code);
            int quantity = itemQuantity.getQuantity();
            orderItem.setQuantity(quantity);
            double price = itemPriceMap.get(item_code);
            double item_total_price = price * quantity;
            orderItem.setItem_total_price(item_total_price);
            total_price += item_total_price;
            orderItemList.add(orderItem);

            ItemPriceDTO itemPriceDTO = new ItemPriceDTO();
            itemPriceDTO.setItem_code(item_code);
            itemPriceDTO.setItem_total_price(item_total_price);
            itemPriceDTOList.add(itemPriceDTO);
        }

        Float combinedRate = getCombinedRate(customer);
        double total_taxes = total_price * combinedRate;

        order.setTotal_taxes(total_taxes);
        order.setTotal_price(total_price + total_taxes);

        orderOverviewDAO.insert(order);
        orderItemDAO.batchInsert(orderItemList);

        OrderResponseDTO result = new OrderResponseDTO();
        result.setCustomer_name(customer.getName());
        result.setTotal_price(order.getTotal_price());
        result.setTotal_taxes(order.getTotal_taxes());
        result.setItemPrices(itemPriceDTOList);

        return result;
    }

    public Float getCombinedRate(Customer customer)
    {
        Taxjar client = new Taxjar("16fb767b82fd197971e996d5b89b4a6b");
        Float result = 0f;

        try {
            Map<String, String> params = new HashMap<>();
            params.put("country", customer.getCountry());
            params.put("city", customer.getCity());
            params.put("street", customer.getStreet());
            RateResponse res = client.ratesForLocation(customer.getZip(), params);
            Rate rate = res.rate;
            result = rate.getCombinedRate();
        } catch (TaxjarException e) {
            e.printStackTrace();
        }

        return result;
    }
}