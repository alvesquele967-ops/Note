package chiku.liu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
//表示此切面的优先级为1，数字越小，优先级越高
@Order(1)
public class PerformanceAspect {

//    可以在目标方法执行前后运行代码，还能决定目标方法是否执行，因此它是能力最强的通知
    @Around(
            "chiku.liu.aop.LogAspect.printMessagePointcut()"
    )

//    由于被拦截的方法可能返回任意类型，所以统一使用最上层的Obeject
    public Object measureTime(
//            表示当前被拦截的方法
            ProceedingJoinPoint joinPoint
    ) throws Throwable {

        String methodName =
                joinPoint.getSignature().getName();
//        获取签名信息再获取方法名

//        记录开始时间,单位为纳秒
        long startTime = System.nanoTime();

//        输出开始日志
        System.out.println(
                "[性能统计] " + methodName + " 开始执行"
        );

        try {
            // 调用真正的业务方法,实际执行的是greetingService.printMessage("测试");
            Object result = joinPoint.proceed();

            return result;
        } finally {
            long endTime = System.nanoTime();

            long duration =
                    endTime - startTime;

            System.out.println(
                    "[性能统计] " + methodName
                            + " 耗时：" + duration + " 纳秒"
            );
        }
    }
}