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
import java.util.List;

public class TestMain {
    private SqlSession sqlSession;
    private NetworkDeviceMapper mapper;

    // @Before：每个@Test方法执行前运行
    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(NetworkDeviceMapper.class);
    }

    // @After：每个@Test执行完毕后运行
    @After
    public void tearDown() {
        if(sqlSession != null){
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
}
