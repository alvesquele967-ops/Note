package chiku.liu.entity;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String orderTime;
    private int total;
    private int cid;
    private Company company;
}
