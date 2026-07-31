package MyReflect4;

//获取成员方法
import java.io.ObjectStreamException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("MyReflect4.Student");

//        获取所有方法对象
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

//        不能获取父类的，但是可以获取本类中私有的方法
        System.out.println("=========");
        aClass.getDeclaredMethods();
        for (Method method : aClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        //获取单个方法，另外后面要跟参数类型以确定到底是要获取哪一个
        System.out.println("=========");
        Method eat = aClass.getDeclaredMethod("eat", String.class);
        System.out.println(eat);

//        获取方法的修饰符
        int modifiers = eat.getModifiers();
        System.out.println(modifiers);

//        获取方法的名字
        String name = eat.getName();
        System.out.println(name);

//        获取方法的形参
        Parameter[] parameters = eat.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

//        获取方法抛出的异常
        Class<?>[] exceptionTypes = eat.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }

        Field name1 = aClass.getDeclaredField("name");
        name1.setAccessible(true);

        Student student2 = new Student("贺博",20);
        Object value1 = name1.get(student2);
        System.out.println(value1);

        eat.setAccessible(true);
//        参数分别是参数的调用者和调用时传递的实际参数
        String result =(String) eat.invoke(student2, "焖子");
//        给eat改成返回String然后返回一个内容
        System.out.println(value1 + result);

    }
}
