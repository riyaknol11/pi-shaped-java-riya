package com.example.ecommerce.order_service.service;

import com.example.ecommerce.order_service.dto.OrderRequestDto;
import com.example.ecommerce.order_service.dto.OrderRequestItemDto;
import com.example.ecommerce.order_service.entity.Orders;
import com.example.ecommerce.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public List<OrderRequestDto> getAllOrders(){
        log.info("Fetching all orders");
        List<Orders> orders = orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrderRequestDto.class)).toList();
    }

    public OrderRequestDto getOrderById(Long id){
        log.info("Fetching orders by id: {}", id);
        Orders order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));
        return modelMapper.map(order, OrderRequestDto.class);
    }
}
