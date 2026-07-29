package Hands_on_Practice.Lottery2;



import java.util.ArrayList;
import java.util.Collections;

public class ThreadMain {
    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 50, 100, 20, 500, 200, 10, 88, 300, 66, 1000);

        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);
        MyThread t3 = new MyThread(list);
        MyThread t4 = new MyThread(list);
        MyThread t5 = new MyThread(list);


        t1.setName("奖品箱1");
        t2.setName("奖品箱2");
        t3.setName("奖品箱3");
        t4.setName("奖品箱4");
        t5.setName("奖品箱5");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
