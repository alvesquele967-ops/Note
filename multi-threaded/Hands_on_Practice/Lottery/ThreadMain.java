package Hands_on_Practice.Lottery;

import java.util.ArrayList;
import java.util.Collections;

public class ThreadMain {
    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 50, 100, 20, 500, 200, 10, 88, 300, 66, 1000);

        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);

        t1.start();
        t2.start();
    }
}
