package chiku.liu.config;

import chiku.liu.printer.ConsolePrinter;
import chiku.liu.printer.Printer;
import chiku.liu.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//表示SpringConfig是一个Spring配置类
@Configuration
//会扫描chiku.liu包及其所有子包，并寻找带有组件注解的类，如@Component,@Service,@Repository,@Controller等
@ComponentScan("chiku.liu")
//开启Spring的AOP自动代理功能
@EnableAspectJAutoProxy
public class SpringConfig {

//    @Bean
//    public Printer printer() {
//        return new ConsolePrinter();
//    }
//
//    @Bean
//    public GreetingService greetingService(Printer printer) {
//        return new GreetingService(printer);
//    }

}
