package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrder();
    void saveOrder(long autoId, String username, String p, String e, String ln, String fn);
    void deleteOrder(long id);
}
