package lamda;

import java.util.*;
import java.util.stream.Collectors;

public class Function2 {


    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.setName("张三");
        p.setId(12);
        Person p1 = new Person();
        p1.setName("张三");
        p1.setId(13);
        Person p2 = new Person();
        p2.setName("李四");
        p2.setId(14);
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.forEach(item -> System.out.println(item));

        Map<String, LongSummaryStatistics> collect = list.stream().collect(
                Collectors.groupingBy(Person::getName, Collectors.summarizingLong(Person::getId)));
        Set<String> strings = collect.keySet();
        for(String str : strings){
            System.out.println(str + "," + collect.get(str).getSum());
        }
    }
}
