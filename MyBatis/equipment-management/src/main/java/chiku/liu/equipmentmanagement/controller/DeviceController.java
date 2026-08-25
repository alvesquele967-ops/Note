package chiku.liu.equipmentmanagement.controller;

import chiku.liu.equipmentmanagement.service.DeviceService;
import chiku.liu.equipmentmanagement.vo.NetworkDeviceVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/list")
    public List<NetworkDeviceVO> listNetworkDevices() {
        return deviceService.listNetworkDevices();
    }
}
