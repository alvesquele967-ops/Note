import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

//要运行之后代码要先注释51，52行自定义异常测试
//选择排序&二分查找
public class choose {
    public static void main(String[] args){
        int arr[] = new int[20];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
        }

        System.out.println("排序前：");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println("\n============");

        // 选择排序 升序
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println("排序后：");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println("\n============");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse("2020-12-31 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        } //或改写public static void main(String[] args) throws Exception,即抛出所有的异常
        //saveAge(160);
        //saveAge2(160); //可以使用try，catch
        //快捷键ctrl+alt+t、

        System.out.println("\n============");
        int target = 50; // 你想要搜索的值，可以随便修改
        int index = findMax(arr, target);
        if(index == -1){
            System.out.println("未找到数字 " + target);
        }else{
            System.out.println("找到数字"+ target +"，数组下标："+ index);
        }

        //        电话号码输入测试
        while (true){
        System.out.println("\n============");
        System.out.println("请输入：");
        Scanner num = new Scanner(System.in);
        String num1 = num.nextLine();

        if(num1.matches("(1[3-9]\\d{9})|((0)\\d{2,7}-?[1-9]\\d{4,19})")){
            System.out.println("成功！");
            break;
        }else {
            System.out.println("格式错误，请重新输入");
            continue;
        }
        }

        while (true){
            System.out.println("\n============");
            System.out.println("请输入");
//        邮箱输入测试
            Scanner mail = new Scanner(System.in);
            String mail1 = mail.nextLine();

            //第一条范围更改，限制更少，可用于发送至指定邮箱这种，后者的话是一个限制比较严的，比如说某些运营商专门的登录网站使用
            if (mail1.matches("\\w{2,64}@\\w{1,125}(\\.[a-zA-Z]{2,})+")) {
//            if(mail1.matches("^[a-zA-Z0-9][a-zA-Z0-9_]{0,62}[a-zA-Z0-9]@[a-zA-Z0-9-]{1,125}\\.[a-zA-Z]{2,}$")){
                System.out.println("成功！");
                break;
            }else {
                System.out.println("格式错误，请重新输入");
                continue;
            }

        }



    }

    // 二分查找：在有序数组查找target，返回下标，找不到返回-1
    public static int findMax(int[] arrList, int target){
        int left = 0;
        int right = arrList.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(arrList[mid] == target){
                return mid;
            }else if(arrList[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void saveAge(int age){
        if(age > 0 && age < 150){
            System.out.println("年龄被成功保存： " + age);
        }else {
            // 用一个异常对象封装这个问题
            throw new  AgeIllegalRuntimeException("/age is illegal,ur age is " + age);
            }
        }

        //throws用在方法上
    public static void saveAge2 (int age)throws AgeIllegalException{
        if(age > 0 && age < 150){
            System.out.println("年龄被成功保存： " + age);
        }else {
            // 用一个异常对象封装这个问题
            throw new  AgeIllegalRuntimeException("/age is illegal,ur age is " + age);
        }
    }

}