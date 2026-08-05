package chiku.liu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//表示这个类不是普通业务类，而是一个AOP切面类
@Aspect
//单独写Aspect不会自动注册所以还是要注解Component
@Component
@Order(2)
public class LogAspect {

//    当出现多个通知重复使用同一个切点表达式的时候，可以使用这个注解提取切点，之后通过方法引用
    @Pointcut(
            "execution(* chiku.liu.service.GreetingService.printMessage(..))"
    )
    public void printMessagePointcut() {
    }

//    表示在目标方法执行之前先执行以下方法
    @Before("printMessagePointcut()")
//            拦截方法执行，*代表返回值可以是任意类型，后面是目标方法，括号里是不限制参数
    public void beforePrintMessage(
            JoinPoint joinPoint
    ) {
        String methodName =
                joinPoint.getSignature().getName();

        Object[] args =
                joinPoint.getArgs();

        System.out.println(
                "[AOP] 方法即将执行：" + methodName
        );

        System.out.println(
                "[AOP] 方法参数："
                        + Arrays.toString(args)
        );
    }

    @AfterReturning(
            pointcut = "printMessagePointcut()",
            returning = "result"
    )
    public void afterPrintMessage(
            Object result
    ) {
        System.out.println(
                "[AOP] 方法正常执行完毕"
        );

        System.out.println(
                "[AOP] 返回值：" + result
        );
    }

    @AfterThrowing(
            pointcut =
                    "printMessagePointcut()",
            throwing = "ex"
    )
    public void afterThrowing(Throwable ex) {
        System.out.println("[AOP] 方法执行异常：" + ex.getMessage());
    }

    @After(
            "printMessagePointcut()"
    )
    public void afterFinally() {
        System.out.println("[AOP] 方法执行结束");
    }

}
