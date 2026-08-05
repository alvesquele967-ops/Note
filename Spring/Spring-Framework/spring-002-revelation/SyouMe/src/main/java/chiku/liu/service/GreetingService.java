package chiku.liu.service;

import chiku.liu.printer.Printer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//表示这是一个业务层组件，请Spring创建并管理它
@Service
//修改作用域，之后每次获取都会创建一个对象
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//或@Scope("prototype")，顺带一提，默认也就是单例是singleton，这个也可以写到xml里去
public class GreetingService {

//    set注入
//    private Printer printer;

//    public void setPrinter(Printer printer) {
//        this.printer = printer;
//    }


//    构造器注入
    private final Printer printer;


    @Autowired
    public GreetingService(
//            Printer printer
            @Qualifier("filePrinter") Printer printer
//            明确使用名字为FilePrinter的Bean（首字母小写），且优先级大于Primary
//            小写是因为使用Component注册的时候Spring会默认将Bean的类名首字母小写
//            或在原注解旁打括号自己命名，然后这里就可以使用自己取的那个名字
    ) {
        this.printer = printer;
        System.out.println("[GreetingService]构造器执行");
    }

//    表示Bean创建并完成依赖注入后，执行这个初始化方法
    @PostConstruct
    public void init() {
        System.out.println("[GreetingService]初始化完成");
    }

    public String printMessage(String message) {
        System.out.println("[GreetingService]正在使用");

        if ("异常".equals(message)) {
            throw new IllegalArgumentException(
                    "消息内容不能是异常"
            );
        }

        printer.print(message);

        return "打印完成：" + message;
    }

    public String getMessage(String message) {
        return "收到：" + message;
    }

//    表示Spring容器关闭前，执行清理方法
    @PreDestroy
    public void destroy() {
        System.out.println("[GreetingService]即将销毁");
    }
}
