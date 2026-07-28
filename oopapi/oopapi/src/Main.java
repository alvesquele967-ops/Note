import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
        public static void main(String[] args) throws Exception {
            // 多态：接口引用指向实现类对象
            Animal dog = new Dog();
            dog.run();

            System.out.println("----------------");

            Animal cat = new Cat();
            cat.run();

            // 调用接口静态方法，只能用接口名调用
            Animal.info();
            System.out.println(Animal.type);

            System.out.println("----------------");

            canRun(cat);
            canRun(new Dog());

            Date date = new Date();
            System.out.println(date);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // 1. 固定字符串时间版本（和视频逻辑完全一致）
            String startDate = "2024-09-30 12:00:01";
            System.out.println("原始字符串(北京时间): " + startDate);

            LocalDateTime parsed = LocalDateTime.parse(startDate, dtf);
            // 绑定上海时区
            ZonedDateTime zonedDateTimeCN = parsed.atZone(ZoneId.of("Asia/Shanghai"));
            System.out.println("中国时区时间: " + zonedDateTimeCN.format(dtf));

            // 【核心方法】同一瞬间，切换为东京时区
            ZonedDateTime zonedDateTimeJP = zonedDateTimeCN.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
            System.out.println("日本时区时间: " + zonedDateTimeJP.format(dtf));

            System.out.println("========================");

            // 2. 实时获取当前时间版本（同样这套写法）
            ZonedDateTime nowCN = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
            System.out.println("当前北京时间：" + nowCN.format(dtf));

            ZonedDateTime nowJP = nowCN.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
            System.out.println("当前东京时间：" + nowJP.format(dtf));

            System.out.println("========================");

        }

        public static void canRun(Animal animal){
            animal.run();
        }

}
