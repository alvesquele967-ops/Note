package chiku.liu;

import chiku.liu.config.SpringConfig;
import chiku.liu.service.GreetingService;
import jakarta.annotation.PreDestroy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        更推荐注解与Java配置
        try (
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)) {

            GreetingService greetingService =
                    (GreetingService) context.getBean("greetingService");

            GreetingService greetingService2 =
                    (GreetingService) context.getBean("greetingService");

            System.out.println(greetingService == greetingService2);
//        默认就是单例，两次取出的是同一个对象
            String result =
                    greetingService.printMessage("测试");

            System.out.println(
                    "[Main] " + result
            );

            try {
                greetingService.printMessage("异常");
            } catch (RuntimeException e) {
                System.out.println(
                        "[Main] 捕获异常："
                                + e.getMessage()
                );
            }
        }
//        当程序离开代码块时会自动执行context.close();然后Spring才会调用@PreDestroy，或者自己手动写close
    }
}
