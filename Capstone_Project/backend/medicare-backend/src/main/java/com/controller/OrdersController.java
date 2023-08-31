package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.repository.AccountRepository;
import com.service.OrdersService;
import com.medicare.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	private final OrdersService orderService;
    private final AccountRepository accountRepository;

    @Autowired
    public OrdersController(OrdersService orderService, AccountRepository accountRepository) {
        this.orderService = orderService;
        this.accountRepository = accountRepository;
    }

        @PostMapping("/checkout")
        public ResponseEntity<String> checkout(@RequestBody CheckOutRequest checkoutRequest) {
            String userEmail = checkoutRequest.getUserEmail();
            Account account = accountRepository.findByEmailid(userEmail);

            if (account == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account not found with email: " + userEmail);
            }

            try {
                Orders order = orderService.createOrder(account, checkoutRequest.getMedicines(), checkoutRequest.getTotalCost());

                // Deduct the total cost from the account's balance
                float updatedBalance = account.getAmount() - checkoutRequest.getTotalCost();
                account.setAmount(updatedBalance);
                accountRepository.save(account);

                return ResponseEntity.ok("Order created successfully. Order ID: " + order.getOrderid());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order: " + e.getMessage());
            }
        }


    
//    @PostMapping("/checkout")
//    public ResponseEntity<String> checkout(@RequestBody CheckOutRequest checkoutRequest) {
//        try {
//            String userEmail = checkoutRequest.getUserEmail();
//            Account account = accountRepository.findByEmailid(userEmail);
//            if (account == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account not found with email: " + userEmail);
//            }
//
//            Orders order = orderService.createOrder(account, checkoutRequest.getMedicines(), checkoutRequest.getTotalCost());
//
//            // Deduct the total cost from the account's balance
//            float updatedBalance = account.getAmount() - checkoutRequest.getTotalCost();
//            account.setAmount(updatedBalance);
//            accountRepository.save(account);
//
//            return ResponseEntity.ok("Order created successfully. Order ID: " + order.getOrderid());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order: " + e.getMessage());
//        }
//    }


//    @PostMapping("/checkout")
//    public ResponseEntity<String> checkout(@RequestBody CheckOutRequest checkoutRequest) {
//    	try {
//    	String userEmail = checkoutRequest.getUserEmail();
//        Account account = accountRepository.findByEmailid(userEmail);
//        if (account == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account not found with email: " + userEmail);
//        }
//    
//        Orders order = orderService.createOrder(account, checkoutRequest.getMedicines(), checkoutRequest.getTotalCost());
//
//        // Deduct the total cost from the account's balance
//        float updatedBalance = account.getAmount() - checkoutRequest.getTotalCost();
//        account.setAmount(updatedBalance);
//        accountRepository.save(account);
//
//        return ResponseEntity.ok("Order created successfully. Order ID: " + order.getOrderid());
//    } catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order: " + e.getMessage());
//    }
//}
//    @GetMapping("/history")
//    public ResponseEntity<List<OrderResponse>> getOrderHistory(@RequestParam String email) {
//        try {
//            List<Orders> orders = orderService.getOrderHistory(email);
//
//            List<OrderResponse> orderResponses = orders.stream()
//                    .map(this::convertToOrderResponse)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(orderResponses);
//        } catch (Exception e) {
//        	List<OrderResponse> emptyList = new ArrayList<>();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emptyList);
//        }
//    }
    
//    // Convert Order to OrderResponse
//    private OrderResponse convertToOrderResponse(Orders order) {
//        OrderResponse orderResponse = new OrderResponse();
//        orderResponse.setId(order.getOrderid());
//        orderResponse.setEmailId(order.getEmailid());
//        orderResponse.setTotalCost(order.getTotalCost());
//        orderResponse.setOrderDate(order.getOrderDate());
//
//        List<OrderItemResponse> orderItemResponses = order.getItems().stream()
//                .map(this::convertToOrderItemResponse)
//                .collect(Collectors.toList());
//
//        orderResponse.setItems(orderItemResponses);
//
//        return orderResponse;
//    }
//    
//    private OrderItemResponse convertToOrderItemResponse(OrderItem orderItem) {
//        OrderItemResponse orderItemResponse = new OrderItemResponse();
//        orderItemResponse.setId(orderItem.getId());
//        orderItemResponse.setMedicineId(orderItem.getMedicineId());
//        orderItemResponse.setQuantity(orderItem.getQuantity());
//        return orderItemResponse;
//    }
       
//            @GetMapping("/history")
//            public ResponseEntity<List<OrderResponse>> getOrderHistory(@RequestParam String email) {
//                try {
//                    List<Orders> orders = orderService.getOrderHistory(email);
//
//                    List<OrderResponse> orderResponses = orders.stream()
//                            .map(this::convertToOrderResponse)
//                            .collect(Collectors.toList());
//
//                    return ResponseEntity.ok(orderResponses);
//                } catch (Exception e) {
//                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
//                }
//            }
            
//            @GetMapping("/history")
//            public ResponseEntity<List<Orders>> getOrderHistory(@RequestParam String email) {
//                try {
//                    List<Orders> orders = orderService.getOrderHistory(email);
//                    return ResponseEntity.ok(orders);
//                } catch (Exception e) {
//                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
//                }
//            }
        @GetMapping("/history")
        public ResponseEntity<List<Orders>> getOrderHistory(@RequestParam String email) {
            List<Orders> orders = orderService.getOrderHistory(email);
            return ResponseEntity.ok(orders);
        }
        
        @GetMapping("/allOrders")
        public ResponseEntity<List<Orders>> getAllOrders(){
        	List<Orders> orders = orderService.getAllOrders();
        	return ResponseEntity.ok(orders);
        }
//            
//            private OrderResponse convertToOrderResponse(Orders order) {
//                OrderResponse orderResponse = new OrderResponse();
//                orderResponse.setId(order.getOrderid());
//                orderResponse.setEmailId(order.getEmailid());
//                orderResponse.setTotalCost(order.getTotalCost());
//                orderResponse.setOrderDate(order.getOrderDate());
//                orderResponse.setOrder(order); // Pass the entire order to the frontend
//
//                return orderResponse;
//            }

//            private OrderResponse convertToOrderResponse(Orders order) {
//                OrderResponse orderResponse = new OrderResponse();
//                orderResponse.setId(order.getOrderid());
//                orderResponse.setEmailId(order.getEmailid());
//                orderResponse.setTotalCost(order.getTotalCost());
//                orderResponse.setOrderDate(order.getOrderDate());
//
//                // Convert order item strings to order item responses
//                List<OrderItemResponse> orderItemResponses = Arrays.stream(order.getOrderItemStrings().split(";"))
//                        .map(this::convertToOrderItemResponse)
//                        .collect(Collectors.toList());
//
//
//                orderResponse.setItems(orderItemResponses);
//
//                return orderResponse;
//            }

//            
//            private OrderItemResponse convertToOrderItemResponse(String orderItemString) {
//                // Parse the order item string and create an OrderItemResponse
//            	//logger.debug("Parsing order item string: {}", orderItemString);
//                String[] parts = orderItemString.split(",");
//                String medicineName = parts[0].substring(parts[0].indexOf(":") + 1).trim();
//                int quantity = Integer.parseInt(parts[1].substring(parts[1].indexOf(":") + 1).trim());
//                float price = Float.parseFloat(parts[2].substring(parts[2].indexOf(":") + 1).trim());
//
//                OrderItemResponse orderItemResponse = new OrderItemResponse();
//                orderItemResponse.setMedicineName(medicineName);
//                orderItemResponse.setQuantity(quantity);
//                orderItemResponse.setPrice(price);
//
//                return orderItemResponse;
//            }

//            private OrderItemResponse convertToOrderItemResponse(String orderItemString) {
//                // Parse the order item string and create an OrderItemResponse
//                String[] parts = orderItemString.split(",");
//                String medicineName = parts[0].substring(parts[0].indexOf(":") + 1).trim();
//                int quantity = Integer.parseInt(parts[1].substring(parts[1].indexOf(":") + 1).trim());
//                float price = Float.parseFloat(parts[2].substring(parts[2].indexOf(":") + 1).trim());
//
//                OrderItemResponse orderItemResponse = new OrderItemResponse();
//                orderItemResponse.setMedicineName(medicineName);
//                orderItemResponse.setQuantity(quantity);
//                orderItemResponse.setPrice(price);
//
//                return orderItemResponse;
//            }
        }

    
