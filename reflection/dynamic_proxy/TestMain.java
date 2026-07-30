package dynamic_proxy;

public class TestMain {
    public static void main(String[] args) {
        ManMain manMain = new ManMain("神人");
        Man man =  ProxyUtil.createProxy(manMain);

        String result = man.workIn("公司");
        System.out.println(result);
        man.eat();
    }
}
