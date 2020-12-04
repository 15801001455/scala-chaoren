import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBeanCopyProperties {

    @Test
    public void test1(){
        Person p1 = new Person();
        p1.setName("");
        Person p2 = new Person();
        p2.setName("李四");
        BeanUtils.copyProperties(p1,p2);
        System.out.println(p2.getName());
    }

    @Data
    public static class Person{
        private String id;
        private String name;
    }

    @Test
    public void floatAndInteger() {
        String str = "12.3456";
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match = pattern.matcher(str);
        System.out.println(match.matches());
    }
}
