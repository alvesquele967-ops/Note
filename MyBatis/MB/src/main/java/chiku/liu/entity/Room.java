package chiku.liu.entity;

import lombok.Data;

//自动生成getter和setter方法，别忘了
@Data
public class Room {
    private int id;
    private String roomName;
    private String  location;
    private String creatAt;
}
