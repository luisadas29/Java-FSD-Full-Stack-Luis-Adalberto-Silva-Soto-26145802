package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicare.Account;
import com.medicare.Medicine;
import com.medicare.OrderItem;
import com.medicare.Orders;
import com.repository.AccountRepository;
import com.repository.OrdersRepository;
//import com.repository.OrderItemRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    private final OrdersRepository orderRepository;
    private final AccountRepository accountRepository;
    //private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrdersService(OrdersRepository orderRepository, AccountRepository accountRepository) {//, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.accountRepository = accountRepository;
      //  this.orderItemRepository = orderItemRepository;
    }


    
//    @Transactional
//    public Orders createOrder(Account account, List<Medicine> medicines, float totalCost) {
//        Orders order = new Orders();
//        order.setAccount(account);
//        order.setEmailid(account.getEmailid());
//        order.setItems(createOrderItems(medicines, order)); // Pass the order to createOrderItems
//        order.setTotalCost(totalCost);
//        order.setOrderDate(new Date());
//        // Save the order to the database
//        Orders savedOrder = orderRepository.save(order);
//
//        // Update the order ID in the associated order items
//        List<OrderItem> orderItems = savedOrder.getItems();
//        for (OrderItem orderItem : orderItems) {
//            orderItem.setOrder(savedOrder);
//        }
//        return savedOrder;
//    }
//    
//    private List<OrderItem> createOrderItems(List<Medicine> medicines, Orders order) {
//        return medicines.stream()
//            .map(medicine -> {
//                OrderItem orderItem = new OrderItem();
//                orderItem.setMedicineId(medicine.getMedicineid());
//                orderItem.setQuantity(1); // Assuming each medicine adds 1 quantity to the order
//                orderItem.setOrder(order); // Set the order for the order item
//                return orderItem;
//            })
//            .collect(Collectors.toList());
//    }
    private List<String> createOrderItemStrings(List<Medicine> medicines) {
        return medicines.stream()
            .map(medicine -> {
                String orderItemString = String.format(
                    "Medicine: %s, Quantity: %d, Price: %.2f",
                    medicine.getName(),
                    1, // Assuming each medicine adds 1 quantity to the order
                    medicine.getPrice()
                );
                return orderItemString;
            })
            .collect(Collectors.toList());
    }
    
    
    public Orders createOrder(Account account, List<Medicine> medicines, float totalCost) {
        Orders order = new Orders();
        order.setAccount(account);
        order.setEmailid(account.getEmailid());
        order.setTotalCost(totalCost);
        order.setOrderDate(new Date());

        List<String> orderItems = createOrderItemStrings(medicines);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String orderItemsJson = objectMapper.writeValueAsString(orderItems);
            order.setOrderItemStrings(orderItemsJson);
        } catch (JsonProcessingException e) {
            // Handle the exception (e.g., log an error)
        }

        Orders savedOrder = orderRepository.save(order);
        return savedOrder;
    }
    
//    public Orders createOrder(Account account, List<Medicine> medicines, float totalCost) {
//        Orders order = new Orders();
//        order.setAccount(account);
//        order.setEmailid(account.getEmailid());
//        order.setTotalCost(totalCost);
//        order.setOrderDate(new Date());
//
//        List<String> orderItems = createOrderItemStrings(medicines);
//        order.setOrderItemStrings(orderItems);
//
//        Orders savedOrder = orderRepository.save(order);
//        return savedOrder;
//    }
//    
    

//        public List<Orders> getOrderHistory(String email) {
//            // Fetch order history for the given account
//            List<Orders> orders = orderRepository.findByemailidOrderByOrderDateDesc(email);
//            System.out.println(Arrays.toString(orders.toArray()));
//            // Fetch order items for each order
//            for (Orders order : orders) {
//                List<OrderItem> orderItems = fetchOrderItemsForOrder(order);
//                System.out.println("Order ID: " + order.getOrderid());
//                System.out.println("Order Items: " + orderItems.toString());
//                order.setItems(orderItems);
//            }
//
//            return orders;
//        }
//
//        private List<OrderItem> fetchOrderItemsForOrder(Orders order) {
//            // Fetch order items for the given order ID
//            return orderItemRepository.findByOrderOrderid(order);
//        	//return orderItemRepository.findByOrderid(order);
//        }
//

    public List<Orders> getOrderHistory(String email) {
        
        List<Orders> orders = orderRepository.findByEmailid(email);
        List<Orders> orders1 = orderRepository.findAll();
        
        //System.out.println("Orders received with email "+email+" in getOrderHistory: "  + orders);
        return orders;
    }
    
    public List<Orders> getAllOrders() {
        
       
        List<Orders> orders1 = orderRepository.findAll();
        
        //System.out.println("Orders received with email "+email+" in getOrderHistory: "  + orders);
        return orders1;
      
    }
    

    
    
//    

}
