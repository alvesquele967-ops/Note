package chiku.liu;

import chiku.liu.entity.NetworkDevice;
import chiku.liu.mapper.NetworkDeviceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
//        专门建立sqlSession的工厂。。。。最后是按照那个config.xml里的配置构建MyBatis
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        让sqlSessionFactory创建一个sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        获取Mapper对象
        NetworkDeviceMapper mapper = sqlSession.getMapper(NetworkDeviceMapper.class);
//        真正查询数据库
        List<NetworkDevice> devices = mapper.selectAll();
        for (NetworkDevice device : devices) {
            System.out.println(device);
        }
        System.out.println(mapper.selectById(7));
        sqlSession.close();
    }
}