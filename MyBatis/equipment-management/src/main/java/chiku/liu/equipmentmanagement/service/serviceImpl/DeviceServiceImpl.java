package chiku.liu.equipmentmanagement.service.serviceImpl;

import chiku.liu.equipmentmanagement.entity.NetworkDevice;
import chiku.liu.equipmentmanagement.mapper.NetworkDeviceMapper;
import chiku.liu.equipmentmanagement.service.DeviceService;
import chiku.liu.equipmentmanagement.vo.NetworkDeviceVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final NetworkDeviceMapper mapper;

    public DeviceServiceImpl(NetworkDeviceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<NetworkDeviceVO> listNetworkDevices() {
        List<NetworkDevice> devices = mapper.selectAll();
        return devices.stream()
                .map(this::toVO)
                .toList();
    }

    private NetworkDeviceVO toVO(NetworkDevice device) {
        NetworkDeviceVO vo = new NetworkDeviceVO();
        vo.setId(device.getId());
        vo.setDeviceName(device.getDeviceName());
        vo.setIpAddress(device.getIpAddress());
        vo.setStatus(device.getStatus());
        vo.setCreateTime(device.getCreateTime());
        return vo;
    }
}
