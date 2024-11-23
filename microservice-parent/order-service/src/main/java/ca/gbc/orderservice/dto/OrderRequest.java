package ca.gbc.orderservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderRequest(
        Long id,
        String orderNumber,
        String skuCode,
        BigDecimal price,
        Integer quantity,
        String customerName,       // New field for customer name
        String product,            // New field for product name
        LocalDateTime orderDate    // New field for order date
) {}
