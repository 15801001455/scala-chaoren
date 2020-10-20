package 测试接口实现;

public interface TestInterface {

    String result(String param);

    TestInterface patternOne = ret -> {
        return ret + ":patternOne";
    };

    TestInterface patternTwo = ret -> {
        return ret + ":patternTwo";
    };

}
