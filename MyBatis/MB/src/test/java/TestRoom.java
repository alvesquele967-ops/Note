import chiku.liu.entity.Room;
import chiku.liu.mapper.RoomMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestRoom {
    private SqlSession sqlSession;
    private RoomMapper mapper;

    // @Before：每个@Test方法执行前运行
    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.md";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        自动事务，默认是false
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(RoomMapper.class);
    }

    // @After：每个@Test执行完毕后运行
    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        List<Room> rooms = mapper.selectAll();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    @Test
    public void testInsert() {
        Room room = new Room();
        room.setRoomName("五号");
        room.setLocation("湖南");
        mapper.TestRoomInsert(room);
    }

    @Test
    public void testUpdate() {
        Room room = new Room();
        room.setId(6);
        room.setLocation("北京");
        room.setRoomName("六号");
        int i = mapper.updateRoom(room);
        System.out.println(i);
    }
}
