package chiku.liu.mapper;


import chiku.liu.entity.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomMapper {

    @Select("select * from machine_room;")
    List<Room> selectAll();

    @Insert("insert into machine_room(room_name,location) values (#{roomName},#{location});")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void TestRoomInsert(Room room);

//    同样的也可以使用xml，复杂的可以用xml，简单的可以用注解
    Integer updateRoom(Room room);

}
