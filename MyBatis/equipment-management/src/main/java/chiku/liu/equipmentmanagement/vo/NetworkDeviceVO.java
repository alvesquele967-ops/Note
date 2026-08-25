package chiku.liu.equipmentmanagement.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NetworkDeviceVO {
    private Long id;
    private String deviceName;
    private String ipAddress;
    private String status;
    private LocalDateTime createTime;
}
