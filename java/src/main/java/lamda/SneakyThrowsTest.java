package lamda;

import lombok.SneakyThrows;

/**
 * Java中的异常是一个极其重要的知识点。在阅读本文之前，读者需对异常有个基本的认识。
 * 在日常开发中，@SneakyThrows用的并不多，因为只是将异常抛出throw，还是需要你在调用方法时对异常做处理。它只是一个try-catch的简单写法：
 */
public class SneakyThrowsTest {
    public static void main(String[] args) {
        SneakyThrowsTest t = new SneakyThrowsTest();
        t.getPerson();
    }

    @SneakyThrows
    public Person getPerson(){
        Person p = new Person();
        p.setId(1);
        p.setName("张三");
        System.out.println(1/0);
        return p;
    }
}
