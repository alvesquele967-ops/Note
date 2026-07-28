public interface Animal {
    String type = "animal";

    void eat();

    void sleep();

    default void run() {
        System.out.println("动物跑");
    }

    static void info(){
        System.out.println("这是animal接口");
    }
}
