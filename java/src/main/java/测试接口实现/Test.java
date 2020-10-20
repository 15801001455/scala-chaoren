package 测试接口实现;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.setTestInterface(TestInterface.patternOne);
        TestInterface testInterface = p.getTestInterface();
        String zhangsan = testInterface.result("lisi");
        System.out.println(zhangsan);
    }
}
