package chiku.liu.mapper;

import chiku.liu.entity.NetworkDevice;

import java.util.List;

public interface NetworkDeviceMapper {
//    后续这个方法是要查询表里所有的网络设备的
    List<NetworkDevice> selectAll();

    NetworkDevice selectById(Integer id);

    List<NetworkDevice> selectByName(String name);

}
