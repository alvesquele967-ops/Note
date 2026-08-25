package chiku.liu.equipmentmanagement.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NetworkDevice {
    private Long id;
    private String deviceName;
    private String ipAddress;
    private String status;
    private LocalDateTime createTime;
}
