package ca.gbc.orderservice.controller;

import ca.gbc.orderservice.dto.OrderRequest;
import ca.gbc.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ca.gbc.orderservice.client.InventoryClient;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final InventoryClient inventoryClient;

    @Operation(summary = "Place an order", description = "Checks inventory and places an order if in stock.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Order placed successfully"),
            @ApiResponse(responseCode = "400", description = "Product not in stock"),
            @ApiResponse(responseCode = "422", description = "Invalid request")
    })
    @PostMapping
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody OrderRequest orderRequest) {
        boolean isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (!isInStock) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "OutOfStock");
            response.put("message", "The product with SKU " + orderRequest.skuCode() + " is not in stock.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        orderService.placeOrder(orderRequest);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Order placed successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
