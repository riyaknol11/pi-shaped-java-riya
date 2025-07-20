package com.example.ecommerce.inventory_service.controller;

import com.example.ecommerce.inventory_service.dto.ProductDto;
import com.example.ecommerce.inventory_service.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.security.Provider;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    @GetMapping("/fetchOrder")
    public String fetchFromOrders(HttpServletRequest httpServletRequest){
        ServiceInstance orderService = discoveryClient.getInstances("order-service").getFirst();
        log.info(httpServletRequest.getHeader("x-custom-header"));
        return restClient.get()
                .uri(orderService.getUri()+"/orders/core/helloOrder")
                .retrieve().body(String.class);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> inventories = productService.getAllInventory();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@RequestBody Long id){
        ProductDto product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
