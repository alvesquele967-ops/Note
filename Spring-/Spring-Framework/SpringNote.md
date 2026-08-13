# Spring Framework 核心入门笔记

## 1. Spring 八大模块

| 模块 | 作用 |
|---|---|
| Core Container | 管理 Bean，完成 IoC 和 DI |
| AOP | 日志、事务、权限、性能统计 |
| Aspects | Spring 与 AspectJ 集成 |
| Data Access | JDBC、事务、ORM、JPA |
| Web | MVC、Controller、REST API |
| Messaging | 消息传递 |
| Instrumentation | 类加载和字节码增强 |
| Test | JUnit、Mock、Spring 测试 |

---

## 2. IoC、DI、Bean 与容器

### IoC

对象的创建权交给 Spring。

```java
Printer printer = new ConsolePrinter();
```

原本由程序员 `new`，使用 Spring 后由容器创建。

### DI

Spring 将一个对象需要的依赖注入给它。

### Bean

被 Spring 创建和管理的对象。

### Spring 容器

负责：

- 创建 Bean
- 保存 Bean
- 注入依赖
- 管理 Bean 生命周期

---

## 3. XML 配置 Bean

```xml
<bean id="printer"
      class="chiku.liu.printer.ConsolePrinter"/>
```

- `id`：Bean 名称
- `class`：用于创建对象的完整类名

创建 XML 容器：

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
```

获取 Bean：

```java
GreetingService service =
        context.getBean(
                "greetingService",
                GreetingService.class
        );
```

---

## 4. Setter 注入

Java：

```java
private Printer printer;

public void setPrinter(Printer printer) {
    this.printer = printer;
}
```

XML：

```xml
<property name="printer" ref="printer"/>
```

Spring 相当于执行：

```java
GreetingService service = new GreetingService();
service.setPrinter(printer);
```

特点：对象创建后再注入，适合可选依赖。

---

## 5. 构造器注入

Java：

```java
private final Printer printer;

public GreetingService(Printer printer) {
    this.printer = printer;
}
```

XML：

```xml
<constructor-arg ref="printer"/>
```

Spring相当于执行：

```java
GreetingService service =
        new GreetingService(printer);
```

特点：创建对象时必须提供依赖，通常优先使用。

---

## 6. Java 配置

```java
@Configuration
public class SpringConfig {

    @Bean
    public Printer printer() {
        return new ConsolePrinter();
    }

    @Bean
    public GreetingService greetingService(
            Printer printer
    ) {
        return new GreetingService(printer);
    }
}
```

创建容器：

```java
ApplicationContext context =
        new AnnotationConfigApplicationContext(
                SpringConfig.class
        );
```

- `@Configuration`：声明配置类
- `@Bean`：将方法返回的对象注册为 Bean
- 方法参数：Spring 自动注入对应 Bean

XML 和 Java 配置是否生效，取决于启动时加载哪一种配置。

---

## 7. 组件扫描

配置类：

```java
@Configuration
@ComponentScan("chiku.liu")
public class SpringConfig {
}
```

`@ComponentScan` 会扫描指定包及其子包。

常用组件注解：

| 注解 | 用途 |
|---|---|
| `@Component` | 普通组件 |
| `@Service` | 业务层 |
| `@Repository` | 持久层 |
| `@Controller` | 表示层 |

示例：

```java
@Component
public class ConsolePrinter implements Printer {
}
```

```java
@Service
public class GreetingService {
}
```

接口不能直接创建对象，因此接口本身通常不会成为 Bean，Spring 管理的是实现类对象。

---

## 8. `@Autowired` 自动装配

作用：从 Spring 容器中寻找合适的 Bean 并注入。

### 构造器注入

```java
@Autowired
public GreetingService(Printer printer) {
    this.printer = printer;
}
```

只有一个构造器时，`@Autowired` 可以省略。

### Setter 注入

```java
@Autowired
public void setPrinter(Printer printer) {
    this.printer = printer;
}
```

### 字段注入

```java
@Autowired
private Printer printer;
```

正式项目通常优先使用构造器注入。

---

## 9. 多个同类型 Bean

假设存在两个实现：

```text
Printer
├── ConsolePrinter
└── FilePrinter
```

Spring 无法判断注入哪一个，可能抛出：

```text
NoUniqueBeanDefinitionException
```

### `@Primary`

设置默认 Bean：

```java
@Component
@Primary
public class ConsolePrinter implements Printer {
}
```

### `@Qualifier`

明确指定 Bean：

```java
public GreetingService(
        @Qualifier("filePrinter") Printer printer
) {
    this.printer = printer;
}
```

记忆：

- `@Autowired`：自动注入
- `@Primary`：默认选择
- `@Qualifier`：点名选择

---

## 10. Bean 作用域

### singleton

默认作用域，同一个容器中只有一个对象。

```java
Object bean1 = context.getBean("greetingService");
Object bean2 = context.getBean("greetingService");

System.out.println(bean1 == bean2);
```

输出：

```text
true
```

### prototype

每次获取都会创建新对象。

```java
@Service
@Scope("prototype")
public class GreetingService {
}
```

两次获取比较：

```text
false
```

---

## 11. Bean 生命周期

生命周期：

```text
创建对象
→ 注入依赖
→ 初始化
→ 正常使用
→ 容器关闭
→ 销毁
```

### 初始化

```java
@PostConstruct
public void init() {
    System.out.println("初始化完成");
}
```

依赖注入完成后执行。

### 销毁

```java
@PreDestroy
public void destroy() {
    System.out.println("即将销毁");
}
```

Spring 容器正常关闭前执行。

自动关闭容器：

```java
try (AnnotationConfigApplicationContext context =
             new AnnotationConfigApplicationContext(
                     SpringConfig.class
             )) {

    GreetingService service =
            context.getBean(GreetingService.class);
}
```

`prototype` Bean 的销毁通常不由 Spring 自动管理。

---

# 12. AOP 基础

AOP 用于将日志、事务、权限和性能统计等公共功能从业务代码中分离。

开启 AOP：

```java
@Configuration
@ComponentScan("chiku.liu")
@EnableAspectJAutoProxy
public class SpringConfig {
}
```

切面类：

```java
@Aspect
@Component
public class LogAspect {
}
```

- `@Aspect`：声明切面类
- `@Component`：将切面注册为 Bean

---

## 13. 切点 `@Pointcut`

```java
@Pointcut(
        "execution(* chiku.liu.service.GreetingService.printMessage(..))"
)
public void printMessagePointcut() {
}
```

用于提取重复的切点表达式。

之后直接引用：

```java
@Before("printMessagePointcut()")
```

注意方法名后要写括号。

---

## 14. AOP 通知

### 前置通知

```java
@Before("printMessagePointcut()")
public void before() {
}
```

目标方法执行前触发。

### 正常返回通知

```java
@AfterReturning("printMessagePointcut()")
public void afterReturning() {
}
```

目标方法正常结束后触发，抛出异常时不执行。

### 异常通知

```java
@AfterThrowing(
        pointcut = "printMessagePointcut()",
        throwing = "ex"
)
public void afterThrowing(Throwable ex) {
}
```

目标方法抛出异常时触发。

### 最终通知

```java
@After("printMessagePointcut()")
public void after() {
}
```

无论正常还是异常都会执行，类似 `finally`。

---

## 15. `JoinPoint`

用于获取目标方法的信息。

```java
@Before("printMessagePointcut()")
public void before(JoinPoint joinPoint) {

    String methodName =
            joinPoint.getSignature().getName();

    Object[] args =
            joinPoint.getArgs();

    Object target =
            joinPoint.getTarget();
}
```

可以获取：

- 方法名
- 参数
- 目标对象
- 方法签名

---

## 16. `@Around` 环绕通知

```java
@Around("printMessagePointcut()")
public Object around(
        ProceedingJoinPoint joinPoint
) throws Throwable {

    System.out.println("方法执行前");

    Object result = joinPoint.proceed();

    System.out.println("方法执行后");

    return result;
}
```

`joinPoint.proceed()` 用于执行真正的目标方法。

如果不调用 `proceed()`，目标方法不会执行。

---

## 17. 性能统计

```java
@Around("printMessagePointcut()")
public Object measureTime(
        ProceedingJoinPoint joinPoint
) throws Throwable {

    long start = System.nanoTime();

    try {
        return joinPoint.proceed();
    } finally {
        long duration =
                System.nanoTime() - start;

        System.out.println(
                "耗时：" + duration + " 纳秒"
        );
    }
}
```

---

## 18. 获取返回值和异常

### 获取返回值

```java
@AfterReturning(
        pointcut = "printMessagePointcut()",
        returning = "result"
)
public void afterReturning(Object result) {
    System.out.println(result);
}
```

`returning` 的名称必须与参数名一致。

### 获取异常

```java
@AfterThrowing(
        pointcut = "printMessagePointcut()",
        throwing = "ex"
)
public void afterThrowing(Throwable ex) {
    System.out.println(ex.getMessage());
}
```

`throwing` 的名称必须与参数名一致。

---

## 19. 多个切面的顺序

```java
@Order(1)
public class PerformanceAspect {
}
```

```java
@Order(2)
public class LogAspect {
}
```

数字越小，优先级越高。

执行结构：

```text
PerformanceAspect 开始
→ LogAspect 开始
→ 目标方法
→ LogAspect 结束
→ PerformanceAspect 结束
```

---

# 20. Spring 测试

测试类应放在：

```text
src/test/java
```

加载 Spring 测试容器：

```java
@SpringJUnitConfig(SpringConfig.class)
class GreetingServiceTest {
}
```

作用：

- 接入 JUnit
- 加载 `SpringConfig`
- 创建 Spring 容器
- 扫描并注入 Bean
- 支持 AOP

等价于大致使用：

```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
```

注入测试对象：

```java
@Autowired
private GreetingService greetingService;
```

---

## 21. 常用测试断言

判断对象不为空：

```java
assertNotNull(greetingService);
```

判断没有抛出异常：

```java
assertDoesNotThrow(
        () -> greetingService.printMessage("测试")
);
```

判断结果相等：

```java
assertEquals(expected, actual);
```

判断抛出指定异常：

```java
assertThrows(
        IllegalArgumentException.class,
        () -> greetingService.printMessage("异常")
);
```

---

# 总结

- IoC：Spring 创建对象
- DI：Spring 注入依赖
- Bean：被 Spring 管理的对象
- 容器：创建、保存和管理 Bean
- `@ComponentScan`：扫描组件
- `@Autowired`：自动注入
- `@Primary`：默认实现
- `@Qualifier`：指定实现
- `singleton`：单例
- `prototype`：多例
- `@PostConstruct`：初始化
- `@PreDestroy`：销毁
- `@Aspect`：切面
- `@Pointcut`：切点
- `@Around`：环绕通知
- `@Order`：切面顺序
- `@SpringJUnitConfig`：测试时加载 Spring 容器