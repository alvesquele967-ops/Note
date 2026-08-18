package chiku.liu.mapper;

import chiku.liu.Main;
import chiku.liu.entity.NetworkDevice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NetworkDeviceMapper {
//    后续这个方法是要查询表里所有的网络设备的
    List<NetworkDevice> selectAll();

    NetworkDevice selectById(Integer id);

    List<NetworkDevice> selectByName(String name);
//    多参数时，@Param ("xxx")，xml 就写 #{xxx}，解除参数顺序绑定，代码好读。
    List<NetworkDevice> selectByRoomIdAndName(@Param("roomId") String roomId,
                                              @Param("deviceName") String name);

    List<NetworkDevice> selectByDevice(NetworkDevice device);

    List<NetworkDevice> selectByStatusAndName(Map map);
    List<NetworkDevice> selectBySomeOfAll(Map map);

//    可以改返回值，返回行数
    int insert(NetworkDevice networkDevice);

    int insertSome(@Param("networkDevices") List<NetworkDevice> networkDevice);

    void update(NetworkDevice networkDevice);

    int deleteById(Integer[] id);

}
