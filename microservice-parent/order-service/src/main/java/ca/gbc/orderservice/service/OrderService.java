package ca.gbc.orderservice.service;

import ca.gbc.orderservice.dto.OrderRequest;

public interface OrderService {
    // Define the method signature for placing an order
    void placeOrder(OrderRequest orderRequest);
}
