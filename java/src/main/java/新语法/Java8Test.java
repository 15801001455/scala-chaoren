package 新语法;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {
    @Test
    public void consumerTest(){
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");
        f.andThen(f2).accept("test");

        f.andThen(f).andThen(f).andThen(f).accept("test1");

    }

    @Test
    public void functionTest(){
        Function<Integer,Integer> f = s -> ++s;
        Function<Integer,Integer> g = s -> s * 2;
        //执行F时，先执行G，并且把G的输出当做F的输入
        System.out.println(f.compose(g).apply(1));//先g后f函数
        System.out.println(f.andThen(g).apply(1));//先f后g函数
        //System.out.println(Function.identity().apply("a"));
    }

    @Test
    public void predicateTest(){
        Predicate<String> p  = o -> o.equalsIgnoreCase("test");
        Assert.assertFalse(p.negate().test("test"));
        Assert.assertFalse(p.test("test"));
    }

    @Test
    public void testMap(){
        Stream<String> s = Stream.of("test", "t1", "t2");
        List<String> collect = s.map(n -> n.concat(".txt")).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }
}
