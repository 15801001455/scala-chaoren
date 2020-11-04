package lamda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo1 {

    //模拟 Map<Long, AgentCloudCustomerVO.AgentCloudCustomer> clientCountMap =
    // clientCountDetail.stream().collect(Collectors.toMap(t -> isGroupByBid ? t.getBid() : t.getDeptbcid(), t -> t, (k1, k2) -> k2));
    @Test
    public void testLamda1() {
        List<Person> p = new ArrayList<>();
        p.add(new Person(1,"张三"));
        p.add(new Person(2,"李四"));
        p.add(new Person(3,"王五"));
        p.add(new Person(3,"赵柳"));
//        Map<Integer, Person> collect = p.stream().collect(Collectors.toMap(t -> t.getId(), t -> t, (k1, k2) -> k2));
        Map<Integer, Person> collect = p.stream().collect(Collectors.toMap(t -> t.getId(), t -> t, (k1, k2) -> k1));//第三个参数就是遇到相同的key的时候比较的
//        Map<Integer, Person> collect = p.stream().collect(Collectors.toMap(t -> t.getId(), t -> t));//有重复的key的时候就报错了这里
        for(Integer key : collect.keySet()){
            Person person = collect.get(key);
            System.out.println(person.getId() + "," + person.getName());
        }
    }

}
