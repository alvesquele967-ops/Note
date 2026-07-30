package MyReflection;

//反射获取class类
public class MyReflectDemo {
    public static void main(String[] args) throws Exception {
//        最为常用
//        包名+类名
        Class aClass = Class.forName("MyReflection.Student");
//        一般更多的是当做参数进行传递
        Class bClass = Student.class;
//        当已经有了这个类的对象时，才能使用
        Student student = new Student();
        Class cClass = student.getClass();

        System.out.println(aClass == bClass);
        System.out.println(bClass == cClass);
    }
}
