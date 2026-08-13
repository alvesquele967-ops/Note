package chiku.liu.service;

import chiku.liu.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

//运行JUnit测试的时候，启动一个Spring测试容器，并读取配置类
@SpringJUnitConfig(SpringConfig.class)
class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    void printMessageShouldReturnResult() {

        String result =
                greetingService.printMessage("测试");

        assertEquals(
                "打印完成：测试",
                result
        );
    }

    @Test
    void printMessageShouldThrowException() {

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> greetingService
                                .printMessage("异常")
                );

        assertEquals(
                "消息内容不能是异常",
                exception.getMessage()
        );
    }

    @Test
    void greetingServiceShouldBeInjected() {
        assertNotNull(greetingService);
    }
}