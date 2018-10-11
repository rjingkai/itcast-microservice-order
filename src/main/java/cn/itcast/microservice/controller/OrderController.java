package cn.itcast.microservice.controller;

import cn.itcast.microservice.pojo.Order;
import cn.itcast.microservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("/order")
    public Order queryOrderById(String id){
        return orderService.queryOrederById(id);
    }


}
