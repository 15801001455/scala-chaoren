package 线程.教材1.模拟买票;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);

        String count = ".0";
        BigDecimal c = BigDecimal.valueOf(Float.valueOf(count));
        System.out.println(percent.format(c));

        List<Integer> list = new ArrayList<>();
        Integer a = 1;
        Integer b = 2;
        list.add(1);
        System.out.println(list.contains(a));
    }
}
