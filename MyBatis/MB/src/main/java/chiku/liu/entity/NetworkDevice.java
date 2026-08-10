package chiku.liu.entity;

import java.lang.management.LockInfo;

public class NetworkDevice {
//    这里long不能保存NULL，所以使用包装类型NULL
    private Long id;
    private String deviceName;
    private String ipAddress;
    private String status;
    private Long roomId;

//    alt+Insert快捷键生成getter&setter。ctrl+A全选，或者点击第一个按住shift点最后一个
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "NetworkDevice{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", status='" + status + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
