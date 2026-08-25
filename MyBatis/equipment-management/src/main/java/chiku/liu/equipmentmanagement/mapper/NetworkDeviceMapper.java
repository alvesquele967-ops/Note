package chiku.liu.equipmentmanagement.mapper;

import chiku.liu.equipmentmanagement.entity.NetworkDevice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NetworkDeviceMapper {

    List<NetworkDevice> selectAll();
}
