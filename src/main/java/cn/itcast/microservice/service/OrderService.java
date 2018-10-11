package cn.itcast.microservice.service;

import cn.itcast.microservice.pojo.Item;
import cn.itcast.microservice.pojo.Order;
import cn.itcast.microservice.pojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    private static final Map<String,Order> MAP = new HashMap<String, Order>();

    @Autowired
    ItemService itemService;

    static {
        Order order = new Order();
        order.setCreateDate(new Date());
        order.setOrderId("12345");
        order.setUserId(1L);

        List<OrderDetail> detailList = new ArrayList<OrderDetail>();
        Item item = new Item();
        item.setId(1L);
        detailList.add(new OrderDetail(order.getOrderId(),item));

        order.setOrderDetails(detailList);

        MAP.put(order.getOrderId(),order);
    }

    public Order queryOrederById(String id){
        Order order = MAP.get(id);

        //从商品微服务中调用商品的查询方法
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail detail:orderDetails) {
            Long idd = detail.getItem().getId();
            Item item = itemService.queryItemById(idd);
            detail.setItem(item);
        }


        return order;
    }


}
