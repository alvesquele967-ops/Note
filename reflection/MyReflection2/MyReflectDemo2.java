package MyReflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class MyReflectDemo2 {
    public static void main(String[] args) throws Exception {
//        获取class字节码文件对象
        Class aClass = Class.forName("MyReflection2.Student");
//        Constructor[] constructors = aClass.getConstructors();
//
//        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }

//        此时protectd和private都获取到了
//        Constructor[] constructors2 =  aClass.getDeclaredConstructors();
//        for (Constructor constructor : constructors2) {
//            System.out.println(constructor);
//        }

        Constructor constructor = aClass.getDeclaredConstructor();
        System.out.println( constructor );

        Constructor constructor1 =  aClass.getDeclaredConstructor(String.class);
        System.out.println( constructor1 );

//        把Declared删掉就会报错
        Constructor constructor2 =  aClass.getDeclaredConstructor(int.class);
        System.out.println( constructor2 );

        Constructor constructor3 = aClass.getDeclaredConstructor(String.class, int.class);
        System.out.println( constructor3 );

        int modifiers = constructor3.getModifiers();
        System.out.println(modifiers);

        Parameter[] parameters = constructor3.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

//        ctrl+p
        Student student = new Student();

        constructor3.setAccessible(true);
//        允许反射调用原本不能直接访问的成员
        Student 神人 =(Student) constructor3.newInstance("贺博", 20);
        System.out.println(神人);
    }
}
