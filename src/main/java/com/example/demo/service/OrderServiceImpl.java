package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AutoRepository autoRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(long autoId, String username, String p, String e, String ln, String fn) {
        Order order = new Order();
        User user = userRepository.findByUsername(username);
        order.setAuto(autoRepository.getOne(autoId));
        order.setUser(user);
        order.setPhone(p);
        order.setEmail(e);
        order.setlName(ln);
        order.setfName(fn);
        order.setDate(new Date(System.currentTimeMillis()));
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }


}
