import java.lang.reflect.Method;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[5];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10)+1;
        }

        for(int x : arr){
            System.out.println(x);
        }

        System.out.println("==============");

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int x : arr){
            System.out.println(x);
        }

        Test();
    }

    @Test(value = "TEST",Bool = false)
    //注解的解析
    public static void Test() throws Exception {
        Class<?> clazz = Main.class;
        Method method = clazz.getDeclaredMethod("Test");
        if (method.isAnnotationPresent(Test.class)) {
            Test test = method.getAnnotation(Test.class);
            System.out.println(test.value());
            System.out.println(test.Bool());
        }
    }
}