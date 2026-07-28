public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("猫吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("猫睡觉");
    }

    @Override
    public void run() {
        System.out.println("小猫轻快奔跑");
    }
}