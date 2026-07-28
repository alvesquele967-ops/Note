public class Main {
    public class InterfaceDemo {
        public static void main(String[] args) {
            // 多态：接口引用指向实现类对象
            Animal dog = new Dog();
            dog.run();

            System.out.println("----------------");

            Animal cat = new Cat();
            cat.run();

            // 调用接口静态方法，只能用接口名调用
            Animal.info();
            System.out.println(Animal.type);
        }
    }
}
