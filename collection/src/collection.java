import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class collection {
    public static void main(String[] args) {
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formated = nowTime.format(dtf);
        System.out.println(formated);

        String timeStr = "2023-09-01 12:00:01";
        LocalDateTime psdateTime = LocalDateTime.parse(timeStr, dtf);
        System.out.println(psdateTime);

        boolean isBefore = psdateTime.isBefore(nowTime);
        if(isBefore) {
            System.out.println("已经结束");
        }else {
            System.out.println("正在进行");
        }

        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        list.add(10);
        String str = (String) list.get(0);
        int str2 =(Integer) list.get(2);

        System.out.println(list);
        System.out.println(str);
        System.out.println(str2);

        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("我是第一个",9.8,"第一个",
                LocalDateTime.of(2020,9,1,0,0)));
        movieList.add(new Movie("我是第二个",7,"第二个",
                LocalDateTime.of(2020,9,2,0,0)));

        movieList.forEach(mv -> System.out.println(mv.toString())
        );

        movieList.remove(1);

        Collections.addAll(movieList,new Movie("测试",7.5,"三",
                LocalDateTime.of(2040,8,1,2,0)),
                new Movie("第四个测试",8,"四",
                        LocalDateTime.of(2020,8,2,0,0)));

        Collections.shuffle(movieList);
        System.out.println("------打乱后"+movieList+"-------");
        movieList.sort((m1,m2) ->
//        Collections.sort(movieList,(m1,m2) ->
                Double.compare(m2.score,m1.score));
        System.out.println("------根据评分排序后"+movieList+"------");

        for (Movie movie : movieList){
            System.out.println(movie.toString());
        }//顺带一提增强for循环不能用于删除元素

        Set<String> sets = new HashSet<>();//无序
//        Set<String> sets = new LinkedHashSet<>();
        sets.add("Java");
        sets.add("Python");
        sets.add("C#");
        sets.add("C++");
        //sets.add("Java");//不重复
        System.out.println(sets);

        Map<String,Integer> userbag = new HashMap<>();
        userbag.put("sale ticket",6);
        userbag.put("sale ticket2",5);
        Set<String> user_bag_thing = userbag.keySet();

        System.out.println("用户的优惠券有："+user_bag_thing);
        user_bag_thing.forEach(ticket -> {
            System.out.println("用户的优惠券有："+ticket+"有"+userbag.get(ticket)+"张");
        });

        //不存在时才会put
        userbag.putIfAbsent("sale ticket4",2);
//      或者
        userbag.forEach((key, value) -> {
            System.out.println("用户的优惠券有："+key+"有"+value+"张");
        });

        boolean sale3 = userbag.containsKey("sale ticket3");
        if(!sale3) {
            System.out.println("未查询到用户的优惠券3");
        }
    }


}


