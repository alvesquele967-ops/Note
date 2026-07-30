package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Man createProxy(ManMain manMain) {
        Man man =(Man) Proxy.newProxyInstance(
//                用于指定用哪个类加载器，去加载生成的代理类
                ProxyUtil.class.getClassLoader(),
//                指定接口，这些接口生成的代理长什么，也就是有哪些方法
                new Class[]{Man.class},
//                用于指定生成的代理对象要干什么事情
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        参数一：代理的对象
//                        参数二：要运行的方法
//                        参数三：调用方法时，传递的实参
                        if ("workIn".equals(method.getName())) {
                            System.out.println("准备工作");
                        }else if ("eat".equals(method.getName())) {
                            System.out.println("准备吃饭");
                        }
                        return method.invoke(manMain, args);
                    }
                }
                );
        return man;
    }
}
