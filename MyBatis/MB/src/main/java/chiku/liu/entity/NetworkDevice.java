package chiku.liu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.management.LockInfo;

@Data
//生成无参构造方法
@NoArgsConstructor
//生成包含所有成员变量的全参构造方法
@AllArgsConstructor
public class NetworkDevice {
//    这里long不能保存NULL，所以使用包装类型NULL
    private Long id;
    private String deviceName;
    private String ipAddress;
    private String status;
    private Long roomId;

}
