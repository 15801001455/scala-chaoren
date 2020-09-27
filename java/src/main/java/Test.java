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

public class Test {

    public final static String bigDecimal2StringNoZero(BigDecimal number, Integer length) {
        if (number == null) {
            return "";
        }
        BigDecimal scaleNumber = number.setScale(length, BigDecimal.ROUND_HALF_UP);
        return scaleNumber.stripTrailingZeros().toPlainString();
    }

    public static void main(String[] args) {
        List<String> containList = new ArrayList<>();
        containList.add("张三");
        containList.add("李四");
        containList.add("王五");
        System.out.println(containList.contains("张三1"));

        List<String> filterList = new ArrayList<>();
        filterList.add("1");
        filterList.add("2");
        filterList.add("3");
        String s2 = filterList.stream().filter(x -> x.contains("-1")).findAny().orElse("0");
        System.out.println(s2);

        BigDecimal bb = new BigDecimal("1257.5");
        String s1 = bigDecimal2StringNoZero(bb, 2);

        System.out.println(s1); //111231.56


        Long lon = 0L;
        System.out.println(lon != 0);


        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH,6);
        System.out.println(c.getTime());

        BigDecimal num = new BigDecimal("10000.12");
        System.out.println(bigDecimal2StringNoZero(num,4));



        boolean flag1 = false;
        System.out.println(flag1 + "");


        String str2 = "a|2,b|3";
        String str3 = "a|2";
        System.out.println(str2.contains("b|3"));
        String[] split2 = str3.split("\\|");
        System.out.println(split2[0]);
        System.out.println(split2[1]);

        String b = null;
        System.out.println("1".equals(b));
        //System.out.println(b== 1);
        System.out.println(aaa("2.34556"));
        System.out.println(aaa("0.234"));
        System.out.println(aaa("3"));
        System.out.println(aaa("-3"));

        System.out.println("-----------------------------------------");
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(Double.valueOf("2.34556")));

        BigDecimal dealPrice = new BigDecimal("0.354");
        System.out.println(dealPrice.toString());
        BigDecimal aaa = new BigDecimal(df.format(Double.valueOf(dealPrice.toString())));
        System.out.println(aaa.toString());

        Double loanAmount = new Double("0.00");
        System.out.println(loanAmount.compareTo(0D) <=0);

        String str = "a^b|c^d";
        String[] split = str.split("\\|");
        for(String sp : split){
            //System.out.println(sp);
            String[] split1 = sp.split("\\^");
            for(String s : split1){
                System.out.println(s);
            }

        }

        String a = "a,b,c|bcd|";
        a = a.substring(0,a.lastIndexOf("|"));
        System.out.println(a);

        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        System.out.println(bigDecimal2String("2", 4));
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
