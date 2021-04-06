import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

    /**
     * 给定 a、b 两个文件，各存放 50 亿个 URL，每个 URL 各占 64B，内存限制是 4G。请找出 a、b 两个文件共同的 URL。
     * 经过计算可知 ：a是320G大小的文件 b是320G大小的文件 都放到内存里肯定是计算不了的
     *
     * @param number
     * @param length
     * @return
     */

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

    public static Integer getNum(List<Integer> a,List<Integer> origal){
        if(!origal.contains(1)){
            return 1;
        }
        //缩小查询范围 负数和重复的数字先去掉  可以得到1,2,4,7,100,1000 或者这种数 3,6,7,10,100  1,4,6
        List<Integer> args = a.stream().distinct().filter(t -> t > 0).sorted().collect(Collectors.toList());
        Integer max = args.get(0);
        if(max-1 > 0 && !origal.contains(max-1)){
            return max-1;
        }
        if(!origal.contains(max+1)){
            return max+1;
        }
        args.remove(new Integer(max));
        return getNum(args,origal);
    }

    public static void main(String[] args) throws Exception{
        /*System.out.println(10%3*2);
        System.out.println(Integer.valueOf("03"));
        System.out.println(DateTime.now().getYear());
        System.out.println(DateTime.now().minusYears(1).getYear());
        //List<Integer> aa = Arrays.asList(-1,0,1,2,3,3,4,7,8);
        //List<Integer> aa = Arrays.asList(-1,0,7,9,Integer.MAX_VALUE);
        List<Integer> aa = Arrays.asList(Integer.MIN_VALUE,0,1,4,7,9,Integer.MAX_VALUE);
        Integer ss = getNum(aa,aa);//找最小的不在范围内的正整数
        System.out.println(ss);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");*/
        /*Example e = new Example();
        e.run();
        System.out.println("main");*/
        //为什么会打印42呢？
        /*Object obj = new Object(){
            public int hashCode(){
                return 42;
            }
        };
        System.out.println(obj.hashCode());*/
//        CollectionsUtils
        /*int x = 4;
        System.out.println("value is " + ((x>4)?99.91111:9));//9.0*/
        /*Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        cal.add(Calendar.HOUR, -6);
        Integer.parseInt(FastDateFormat.getInstance("yyyyMMdd").format(cal.getTime()));
        System.out.println(Integer.parseInt(FastDateFormat.getInstance("yyyyMMdd").format(cal.getTime())));

        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> submit1 = pool.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;
        });
        Future<Integer> submit2 = pool.submit(() -> {
            System.out.println("222");
            return 2;
        });
        pool.shutdown();
        System.out.println(submit1.get());
        System.out.println(submit2.get());*/
        /*Person p2 = new Person();
        Person p = new Person();
        p.setOaid(101L);
        p.setOaname("张三");
        BeanUtils.copyProperties(p,p2);
        System.out.println(p2);
        Person p1 = new Person();
        p1.setOaid(101L);
        p1.setOaname("");
        BeanUtils.copyProperties(p1,p2);
        System.out.println(p2);*/

        /*
        用下面的merge方法能解决的办法
        Person p2 = new Person();
        Person p = new Person();
        p.setOaid(101L);
        p.setOaname("张三");
        p.setCompanyBid(5);
        p.setTotalCommission(BigDecimal.valueOf(2.5));
        //BeanUtil.copyProperties(p,p2, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        merge(p2,p);
        System.out.println(p2);
        Person p1 = new Person();
        p1.setOaid(101L);
        p1.setOaname(null);
        //BeanUtil.copyProperties(p1,p2, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        merge(p2,p1);
        System.out.println(p2);*/

        Integer a = 12323423;
        Integer b = 12323423;
        System.out.println(a == b);
    }

    /**
     * 深度拷贝的方法 自己总结的 就是多次拷贝的时候不拷贝null值和一些自定义的值 防止多次拷贝被覆盖
     * @param target
     * @param destination
     * @param <M>
     * @throws Exception
     */
    public static <M> void merge(M target, M destination) throws Exception {
        //获取目标bean
        BeanInfo beanInfo = Introspector.getBeanInfo(target.getClass());
        // 遍历所有属性
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            if (descriptor.getWriteMethod() != null) {
                Object defaultValue = descriptor.getReadMethod().invoke(destination);
                if(defaultValue != null){
                    if(defaultValue instanceof String){
                        if(!"".equals(defaultValue)){
                            descriptor.getWriteMethod().invoke(target, defaultValue);
                        }
                    }
                    if(defaultValue instanceof BigDecimal){
                        BigDecimal v = (BigDecimal)defaultValue;
                        if(v.compareTo(BigDecimal.ZERO) != 0){
                            descriptor.getWriteMethod().invoke(target, defaultValue);
                        }
                    }
                    if(defaultValue instanceof Integer){
                        Integer v = (Integer)defaultValue;
                        if(v.compareTo(0) != 0){
                            descriptor.getWriteMethod().invoke(target, defaultValue);
                        }
                    }
                    if(defaultValue instanceof Long){
                        Long v = (Long)defaultValue;
                        if(v.compareTo(0L) != 0){
                            descriptor.getWriteMethod().invoke(target, defaultValue);
                        }
                    }
                }
            }
        }
    }

    public void test(){
        System.out.println(6+6+"(Result)"+6+6);
    }

    static class Example extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run");
        }
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
