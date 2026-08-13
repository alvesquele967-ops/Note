package chiku.liu.printer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//让Spring扫描到这个类，并创建一个Bean
//此时<property name="prefix" value="[Spring]"/>不再生效
@Component
public class ConsolePrinter implements Printer {

    private String prefix = "[Spring]";

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String text) {
        System.out.println(prefix + text);
    }
}
