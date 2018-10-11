package cn.itcast.microservice.pojo;

public class OrderDetail {
    private String id;
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(String id, Item item) {
        this.id = id;
        this.item = item;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getId() {

        return id;
    }

    public Item getItem() {
        return item;
    }
}
