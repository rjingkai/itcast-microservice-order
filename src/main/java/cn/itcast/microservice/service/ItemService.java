package cn.itcast.microservice.service;

import cn.itcast.microservice.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemService {

    /**
     * 这是使用eureka之前的写法
     */
    @Autowired
    private RestTemplate restTemplate;
//
//    public Item queryItemById(Long id){
//        //spring 提供的一个发送请求的工具
//        return restTemplate.getForObject("http://localhost:8084/item/"+id,Item.class);
//    }


    /**
     * 这是使用了eureka之后的写法
     */

    @Autowired
    private DiscoveryClient discoveryClient;


    public Item queryItemById(Long id){

        //根据id获取服务列表
        List<ServiceInstance> instances =
                discoveryClient.getInstances("itcast-microservice-item");

        if (instances == null || instances.isEmpty()){
            return null;
        }

        //从服务列表中获取服务
        ServiceInstance serviceInstance = instances.get(0);

        serviceInstance.getHost();   //获取服务的地址
        serviceInstance.getPort();

        String url = "http://"+ serviceInstance.getHost() + ":" + serviceInstance.getPort();

        Item item = restTemplate.getForObject(url + "/item/" + id, Item.class);

        return item;



    }
}
