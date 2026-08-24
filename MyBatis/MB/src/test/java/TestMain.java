import chiku.liu.entity.NetworkDevice;
import chiku.liu.mapper.NetworkDeviceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    private SqlSession sqlSession;
    private NetworkDeviceMapper mapper;

    // @Before：每个@Test方法执行前运行
    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.md";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        自动事务，默认是false
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(NetworkDeviceMapper.class);
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
        List<NetworkDevice> devices = mapper.selectAll();
        for (NetworkDevice device : devices) {
            System.out.println(device);
        }
    }

    @Test
    public void testSelectById() {
        NetworkDevice device = mapper.selectById(7);
        System.out.println("查询id=7: " + device);
    }

    @Test
    public void testSelectByName() {
//        List<NetworkDevice> devices = mapper.selectByName("%核心%");
        List<NetworkDevice> devices = mapper.selectByName("核心");
        for (NetworkDevice device : devices) {
            System.out.println(device);
        }
    }

    @Test
    public void testSelectRoomIdAndName() {
        List<NetworkDevice> devices = mapper.selectByRoomIdAndName("1", "核心");
        for (NetworkDevice device : devices) {
            System.out.println(device);
        }
    }

    @Test
    public void testSelectByDevice() {
        NetworkDevice device = new NetworkDevice();
        device.setDeviceName("核心");
        device.setRoomId(1L);
        List<NetworkDevice> devices = mapper.selectByDevice(device);
        for (NetworkDevice device1 : devices) {
            System.out.println(device1);
        }
    }

    @Test
    public void testSelectByStatusAndName() {
        Map<String, Object> device = new HashMap<>();
//        device.put("deviceName", "核心");
//        device.put("status", "ONLINE");
//        device.put("roomId", 1);
        List<NetworkDevice> devices = mapper.selectByStatusAndName(device);
        for (NetworkDevice device1 : devices) {
            System.out.println(device1);
        }
    }

    @Test
    public void testSelectBySomeOfAll(){
        Map<String, Object> device = new HashMap<>();
        device.put("deviceName", "数据");
        device.put("status", "ONLINE");
        device.put("roomId", 1);
        List<NetworkDevice> devices = mapper.selectBySomeOfAll(device);
        for (NetworkDevice device1 : devices) {
            System.out.println(device1);
        }
    }

//    记得看上方27，32行
//    @Test
//    public void testInsert() {
//        NetworkDevice device = new NetworkDevice();
//        device.setRoomId(1L);
//        device.setStatus("OFFLINE");
//        device.setIpAddress("192.168.1.3");
//        device.setDeviceName("发送测试设备3");
//        int i = mapper.insert(device);
//        System.out.println(i);
//        System.out.println(device.getId());
//    }

    @Test
    public void testUpdate() {
        // ① 重点：先查询数据库，拿到真实旧数据，不能new空对象
        NetworkDevice device = mapper.selectById(18);

        // ② 对查到出来的对象做翻转逻辑
        if (device.getRoomId() != null) {
            if(device.getRoomId() == 1L){
                device.setRoomId(2L);
            }else{
                device.setRoomId(1L);
            }
        }

        // status翻转
        String status = device.getStatus();
        if("ONLINE".equals(status)){
            device.setStatus("OFFLINE");
        }else{
            device.setStatus("ONLINE");
        }

        // ③ 把修改完的实体丢给update，执行更新
        mapper.update(device);
    }

    @Test
    public void testDelete() {
        NetworkDevice device = new NetworkDevice();
        Integer[] i = {16,19};
        int x = mapper.deleteById(i);
        System.out.println(x);

    }

    @Test
    public void testInsertSome(){
        List<NetworkDevice> devices = new ArrayList<>();
        NetworkDevice device1 = new NetworkDevice();
        NetworkDevice device2 = new NetworkDevice();
//        device_name, ip_address, status, room_id
        device1.setDeviceName("批量测试1");
        device1.setRoomId(1L);
        device1.setStatus("ONLINE");
        device1.setIpAddress("192.168.1.4");
        device2.setDeviceName("批量测试2");
        device2.setRoomId(2L);
        device2.setStatus("OFFLINE");
        device2.setIpAddress("192.168.1.5");
        devices.add(device1);
        devices.add(device2);
        int i = mapper.insertSome(devices);
        System.out.println(i);



    }

}
