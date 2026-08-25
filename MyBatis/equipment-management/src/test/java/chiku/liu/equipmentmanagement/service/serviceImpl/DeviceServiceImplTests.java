package chiku.liu.equipmentmanagement.service.serviceImpl;

import chiku.liu.equipmentmanagement.entity.NetworkDevice;
import chiku.liu.equipmentmanagement.mapper.NetworkDeviceMapper;
import chiku.liu.equipmentmanagement.vo.NetworkDeviceVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeviceServiceImplTests {

    @Test
    void listNetworkDevicesMapsEntitiesToViewObjects() {
        NetworkDeviceMapper mapper = mock(NetworkDeviceMapper.class);
        NetworkDevice device = new NetworkDevice();
        LocalDateTime createTime = LocalDateTime.of(2026, 8, 25, 10, 30);
        device.setId(1L);
        device.setDeviceName("核心交换机");
        device.setIpAddress("192.168.1.1");
        device.setStatus("ONLINE");
        device.setCreateTime(createTime);
        when(mapper.selectAll()).thenReturn(List.of(device));

        DeviceServiceImpl service = new DeviceServiceImpl(mapper);

        List<NetworkDeviceVO> result = service.listNetworkDevices();

        assertThat(result).singleElement().satisfies(vo -> {
            assertThat(vo.getId()).isEqualTo(1L);
            assertThat(vo.getDeviceName()).isEqualTo("核心交换机");
            assertThat(vo.getIpAddress()).isEqualTo("192.168.1.1");
            assertThat(vo.getStatus()).isEqualTo("ONLINE");
            assertThat(vo.getCreateTime()).isEqualTo(createTime);
        });
    }
}
