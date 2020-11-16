package 新语法;

/**
 * 泛型类演示
 * 泛型类定义的泛型，在整个类中有效。如果被方法使用，那么泛型类的对象明确要操作的具体类型后，所要操作的类型已经固定了。就像上面main方法中。对象d，只能操作String类型,如果你要操作其他类型，只能额外去创建其他泛型对象e。
 * @param <T>
 */
public class Test<T,U> {
    public void show(T t,U u){
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        Test<String, Integer> str = new Test<>();
        str.show("张三",4);
    }
}
