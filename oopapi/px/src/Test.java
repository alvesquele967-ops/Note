import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//SOURCE:只作用于源码阶段，字节码文件中不存在
//CLASS（默认值）：保留到字节码文件阶段，运行阶段不存在
//RUNTIME：一直保留到运行阶段
@Retention(RetentionPolicy.RUNTIME)
//TYPE:类，接口
//FIELD:成员变量
//METHOD:成员方法
//PARTMETER:方法参数
//CONSTRUCTOR:构造器
//LOCAL_VARIABLE:局部变量
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Test {
    String value() default "";
    boolean Bool() default true;
}
