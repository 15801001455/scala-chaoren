package 测试接口实现;

public class TestClass implements TestInterface{

    @Override
    public String result(String param) {
        return "默认返回方法";
    }
}
