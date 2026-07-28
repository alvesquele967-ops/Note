import java.lang.reflect.Method;

public class Demo {

//    @MyTest
    public void mytest1(){
        System.out.println("immytest1");
    }

    @MyTest
    public void mytest2(){
        System.out.println("immytest2");
    }

//    @MyTest
    public void mytest3(){
        System.out.println("immytest3");
    }

    @MyTest
    public void mytest4(){
        System.out.println("immytest4");
    }


    public static void main(String[] args) throws Exception {

        Demo demo = new Demo();
        //获取类对象，反射入口
        Class c = Demo.class;
        Method[] methods = c.getDeclaredMethods();
        //获取当前类中所有定义的方法
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                //反射执行此方法
                method.invoke(demo);
            }
        }
    }
}
