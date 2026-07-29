package Hands_on_Practice.RedBag;

import java.util.Random;

public class ThreadMain {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();
        MyThread myThread5 = new MyThread();
//alt+左键可以竖着选择
        myThread1.setName("用户1");
        myThread2.setName("用户2");
        myThread3.setName("用户3");
        myThread4.setName("用户4");
        myThread5.setName("用户5");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();


    }
}
