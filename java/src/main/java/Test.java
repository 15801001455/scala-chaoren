import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

    public final static String bigDecimal2StringNoZero(BigDecimal number, Integer length) {
        if (number == null) {
            return "";
        }
        BigDecimal scaleNumber = number.setScale(length, BigDecimal.ROUND_HALF_UP);
        return scaleNumber.stripTrailingZeros().toPlainString();
    }

    public static void testCycle(){
        for(int i=0;i<3;i++){
            System.out.println(i);
        }

        for(int i=3-1;i>=0;i--){
            System.out.println(i);
        }
    }

    static List<Integer> deleteList = new ArrayList<>();

    public static Integer getNum(List<Integer> a,List<Integer> origal){
        if(!origal.contains(1)){
            return 1;
        }
        //缩小查询范围 负数和重复的数字先去掉  可以得到1,2,4,7,100,1000 或者这种数 3,6,7,10,100  1,4,6
        List<Integer> args = a.stream().distinct().filter(t -> t > 0).sorted().collect(Collectors.toList());
        Integer max = Integer.MAX_VALUE;
        for(Integer i : args){
            if(i < max){
                max = i;
            }
        }
        //System.out.println(max);
        if(max-1 > 0 && !origal.contains(max-1)){
            return max-1;
        }
        if(!origal.contains(max+1)){
            return max+1;
        }
        args.remove(new Integer(max));
        return getNum(args,origal);
    }

    public static void main(String[] args) {
        //List<Integer> aa = Arrays.asList(-1,0,1,2,3,3,4,7,8);
        //List<Integer> aa = Arrays.asList(-1,0,7,9,Integer.MAX_VALUE);
        List<Integer> aa = Arrays.asList(Integer.MIN_VALUE,0,1,4,7,9,Integer.MAX_VALUE);
        Integer ss = getNum(aa,aa);//找最小的不在范围内的正整数
        System.out.println(ss);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    @org.junit.Test
    public void orElseTest() {
        List<String> filterList = new ArrayList<>();
        filterList.add("1");
        filterList.add("2");
        filterList.add("3");
        filterList.add("2");
        String s2 = filterList.stream().filter(x -> x.contains("2")).findAny().orElse("0");
        System.out.println(s2);
    }

    @org.junit.Test
    public void containsStr() {
        List<String> containList = new ArrayList<>();
        containList.add("张三");
        containList.add("李四");
        containList.add("王五");
        System.out.println(containList.contains("张三1"));
    }

    public final static String bigDecimal2String(String number, Integer length) {

        if (number == null) {
            return "";
        }
        BigDecimal b = new BigDecimal(number);
        BigDecimal scaleNumber = b.setScale(length, BigDecimal.ROUND_HALF_UP);
        String s = scaleNumber.stripTrailingZeros().toPlainString();
        return s;
    }

    /*public final static Double double2String(Double number, Integer length) {
        if (number == null) {
            return 0D;
        }
        BigDecimal d = new BigDecimal(number.toString());
        BigDecimal scaleNumber = d.setScale(length, BigDecimal.ROUND_HALF_UP);
        return scaleNumber.doubleValue();
    }*/

    //严格校验带两位小数的正数
    public static boolean isNumber(String str){
        Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){2})?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match=pattern.matcher(str);
        return match.matches();
    }

    //非负浮点数  ^\d+(\.\d+)?$
    public static boolean aaa(String str){
        Pattern pattern=Pattern.compile("\\d+(\\.\\d+)?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match=pattern.matcher(str);
        return match.matches();
    }
}
