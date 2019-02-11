package cn.itcast.microservice.controller;

import cn.itcast.microservice.pojo.Item;
import cn.itcast.microservice.pojo.Order;
import cn.itcast.microservice.service.ItemService;
import cn.itcast.microservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;


    @RequestMapping("/order")
    public Order queryOrderById(String id){
        return orderService.queryOrederById(id);
    }

    @RequestMapping("/item")
    public Item queryItem(Long id){
        return itemService.queryItemById(id);
    }


}
