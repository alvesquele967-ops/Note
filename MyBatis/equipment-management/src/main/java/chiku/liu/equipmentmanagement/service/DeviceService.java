package chiku.liu.equipmentmanagement.service;

import chiku.liu.equipmentmanagement.vo.NetworkDeviceVO;

import java.util.List;

public interface DeviceService {
    List<NetworkDeviceVO> listNetworkDevices();
}
