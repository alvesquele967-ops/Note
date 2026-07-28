public class Dog implements Animal {

    @Override
    public void run() {
        System.out.println("小狗四条腿奔跑");
    }
}

public class Cat implements Animal {

    @Override
    public void run() {
        System.out.println("小猫轻快奔跑");
    }
}