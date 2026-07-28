> 并发：在同一时刻，有多个指令在单个CPU上交替执行<br>
> 并行：在同一时刻，有多个指令在多个CPU上同时执行
例如2核4线程：两个核心，同时可以运行四个线程

|                |            优点            |            缺点             |
|:--------------:|:------------------------:|:-------------------------:|
|   继承Thread类    | 编程比较简单，可以直接实用Thread类中的方法 |    可以扩展性性较差，不能再继承其他的类     |
|  实现Runnable接口  |  扩展性强，实现该接口的同时还可以继承其他的类  | 编程相对复杂，不能直接使用Thread类中的方法  |
|  实现Callable接口  |     同上一行,且可以获取多线程的结果     |           同上一行            |

# 常见的成员方法

|           方法名称            |                说明                |
|:----------------------------:|:---------------------------------:|
|       String getName()       |          返回此线程的名称          |
| void setName(String name)    |    设置线程的名字（构造方法也可以设置名字）    |
| static Thread currentThread() |          获取当前线程的对象         |
| static void sleep(long time) |     让线程休眠指定的时间，单位为毫秒     |
| setPriority(int newPriority) |          设置线程的优先级           |
|     final int getPriority()    |          获取线程的优先级           |
| final void setDaemon(boolean on) |        设置为守护线程          |
|    public static void yield() |         出让线程/礼让线程          |
|    public static void join()  |         插入线程/插队线程          |


