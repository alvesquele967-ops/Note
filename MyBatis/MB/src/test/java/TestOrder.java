import chiku.liu.entity.Company;
import chiku.liu.entity.Order;
import chiku.liu.entity.Room;
import chiku.liu.mapper.OrderForCompanyMapper;
import chiku.liu.mapper.RoomMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestOrder {
    private SqlSession sqlSession;
    private OrderForCompanyMapper mapper;

    // @Before：每个@Test方法执行前运行
    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.md";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        自动事务，默认是false
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(OrderForCompanyMapper.class);
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
    public void selectAll(){
        List<Order> orders = mapper.selectAll();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void selectAllForCompany(){
        List<Company> companys = mapper.selectAllOrder();
        for (Company company : companys) {
            System.out.println(company);
        }
    }
}
