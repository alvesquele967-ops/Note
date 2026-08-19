package chiku.liu.mapper;

import chiku.liu.entity.Company;
import chiku.liu.entity.NetworkDevice;
import chiku.liu.entity.Order;
import chiku.liu.entity.Room;

import java.util.List;

public interface OrderForCompanyMapper {

    List<Order> selectAll();

    List<Company> selectAllOrder();
}
