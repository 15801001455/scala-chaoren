package lamda;

import org.junit.Test;

import java.util.Collection;
import java.util.function.Function;

/**
 * 可见上面方法的参数类型不可以使用 Collection，
 * 使用通配符 Collection<?> 也不行，因为Java 不允许把对象放进一个未知类型的集合里。
 * 为解决这个问题，可以使用 Java 5 提供的泛型方法，在声明方法时定义一个或多个类型形参。泛型用法格式如下：
 *
 * 该泛型方法的方法签名比普通方法的方法签名多了类型形参声明，类型形参声明以尖括号括起来，多个类型形参直接以逗号（，）隔开，所有的类型形参声明放在方法修饰符和返回值类型之间。
 * 采用支持泛型的方法，就可以将上面的 fromArrayToCollection 方法改写为如下形式：
 */
public class Function1 {

    static void b(Object[] a, Collection<Object> c){
        for(Object o : a){
            c.add(o);
        }
    }

    static <T> void a(T[] a, Collection<T> c){
        for(T o : a){
            c.add(o);
        }
    }

    @Test
    public void testFunction1() throws Exception{
        PersonQuery query = new PersonQuery();
        query.setName("李四");
        query.setSex("女性");
        PersonReturn data = readFromCache(a -> getPerson(a),query);
        System.out.println(data.getSex());
    }

    // update jyc  <T,U,V> 这一部分应该没有顺序区分,只是在声明方法时定义一个或多个类型形参
    public <T> T readFromCache(Function<PersonQuery,T> service,PersonQuery param) throws Exception {
        T apply = service.apply(param);
        if(apply!=null){
            return apply;
        }
        return null;
    }

    // update jyc  <T,U,V> 这一部分应该没有顺序区分,只是在声明方法时定义一个或多个类型形参
    public <T,U> T readFromCache(Function<U,T> service,U param) throws Exception {
        T apply = service.apply(param);
        if(apply!=null){
            return apply;
        }
        return null;
    }

    public PersonReturn getPerson(PersonQuery query){
        PersonReturn personReturn = new PersonReturn();
        personReturn.setId("123");
        personReturn.setSex("男性");
        return personReturn;
    }
}
