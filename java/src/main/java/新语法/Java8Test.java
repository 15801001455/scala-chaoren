package 新语法;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
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

    @Test
    public void testFlatMap(){
        Stream<String> s = Stream.of("test","t1","t2","aaaa");
        s.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::println);
    }

    @Test
    public void testOption(){
        /**
         * 以前的方式
         */
        //String s = null;
        String s = "";
        /*if(s == null){
            s = "test";
        }
        System.out.println(s);*/
        /**
         * 新的方式
         */
        Optional<String> s1 = Optional.ofNullable(s);
        System.out.println(s1.orElse("test"));
    }

    //以前老的方式判断异常
    @Test
    public void testOptionException() throws Exception{
        String s = null;
        if(s == null){
            throw new Exception("test");
        }
        System.out.println(s);
    }

    @Test
    public void testOptionExceptionNew() throws Exception{
        String s = "null";
        Optional<String> s1 = Optional.ofNullable(s);
        System.out.println(s1.orElseThrow(()->new Exception("test")));
    }


    <T> void test(Collection<? extends T> from,Collection<T> to){
        for(T ele : from){
            to.add(ele);
        }
    }

    <T> void test1(Collection<? extends T> from,Collection<T> to){
        for(T ele : from){
            to.add(ele);
        }
    }

    @Test
    public void test1(){
        List<String> from = new ArrayList<>();
        List<Object> to = new ArrayList<>();
        test(from,to);
    }

}
