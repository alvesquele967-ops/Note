package chiku.liu.equipmentmanagement.controller;

import chiku.liu.equipmentmanagement.service.DeviceService;
import chiku.liu.equipmentmanagement.vo.NetworkDeviceVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeviceController.class)
class DeviceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeviceService deviceService;

    @Test
    void listNetworkDevicesReturnsJson() throws Exception {
        NetworkDeviceVO device = new NetworkDeviceVO();
        device.setId(1L);
        device.setDeviceName("核心交换机");
        device.setIpAddress("192.168.1.1");
        device.setStatus("ONLINE");
        device.setCreateTime(LocalDateTime.of(2026, 8, 25, 10, 30));
        when(deviceService.listNetworkDevices()).thenReturn(List.of(device));

        mockMvc.perform(get("/api/devices"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].deviceName").value("核心交换机"))
                .andExpect(jsonPath("$[0].ipAddress").value("192.168.1.1"))
                .andExpect(jsonPath("$[0].status").value("ONLINE"))
                .andExpect(jsonPath("$[0].createTime").value("2026-08-25T10:30:00"));
    }
}
