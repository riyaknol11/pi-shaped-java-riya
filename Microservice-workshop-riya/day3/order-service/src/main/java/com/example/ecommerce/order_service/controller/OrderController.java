package com.example.ecommerce.order_service.controller;

import com.example.ecommerce.order_service.dto.OrderRequestDto;
import com.example.ecommerce.order_service.entity.Orders;
import com.example.ecommerce.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/core")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService productService;

    @GetMapping("/helloOrder")
    public String getOrder(){
        return "Hello from order";
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllProducts(){
        List<OrderRequestDto> inventories = productService.getAllOrders();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getProductById(@RequestBody Long id){
        OrderRequestDto order = productService.getOrderById(id);
        return ResponseEntity.ok(order);

    }
}
