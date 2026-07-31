package MyReflection3;

import java.lang.reflect.Field;

//和之前的差不多
public class MyReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("MyReflection3.Student");

        Field[] fields = aClass.getFields();
        Field[] fields1 = aClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("=========");
        for (Field field : fields1) {
            System.out.println(field);
        }

        System.out.println("=========");
        Field gender = aClass.getField("gender");
        System.out.println(gender);

        System.out.println("=========");

        Field name = aClass.getDeclaredField("name");
        Field age = aClass.getDeclaredField("age");
        System.out.println(age);

//        获取权限修饰符
        System.out.println("=========");
        int modifiers = age.getModifiers();
        System.out.println(modifiers);

//        获取成员变量的数据类型
        System.out.println("=========");
        Class<?> ageType = age.getType();
        System.out.println(ageType);

//        获取成员变量的名字
        System.out.println("=========");
        String n = age.getName();
        System.out.println(n);

//        获取成员变量记录的值
        System.out.println("=========");
        Student s = new Student("贺博",20,"女");
        name.setAccessible(true);
        String value =(String) name.get(s);
        System.out.println(value);

        name.set(s,"河伯");

        System.out.println(s);
    }
}
