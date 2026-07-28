public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("够吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("狗睡觉");
    }

    @Override
    public void run() {
        System.out.println("小狗轻快奔跑");
    }
}
