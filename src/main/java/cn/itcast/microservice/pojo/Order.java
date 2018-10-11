package cn.itcast.microservice.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Long userId;
    private Date createDate;
    private Date updateDate;
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(String orderId, Long userId, Date createDate, Date updateDate, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.userId = userId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.orderDetails = orderDetails;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderId() {

        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
}
