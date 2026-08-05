package chiku.liu.printer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
//当出现多个同类型Bean时，优先选择这个Bean
@Primary
public class FilePrinter implements Printer {

    @Override
    public void print(String text) {
        System.out.println("[File]" + text);
    }
}
