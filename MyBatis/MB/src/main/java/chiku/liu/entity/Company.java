package chiku.liu.entity;

import lombok.Data;

import java.util.List;

@Data
public class Company {
    private int id;
    private String companyName;
    private String contactPerson;
    private String address;
    private List<Order> orders;

}
