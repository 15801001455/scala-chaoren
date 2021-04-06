import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * @author George
 * @description   进行比较 和Test2配合使用
 **/
public class HashClassEnd {

    public static void main(String[] args) throws IOException {
        /*String a = "12345";
        String b = "12346";
        System.out.println(a.hashCode() % 5);
        System.out.println(b.hashCode() % 5);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(0 % 5);
        System.out.println(1 % 5);
        System.out.println(2 % 5);
        System.out.println(3 % 5);
        System.out.println(4 % 5);
        System.out.println(5 % 5);*/
        BufferedReader br = null;
        HashSet<String> set = new HashSet<String>();
        String line = "";

        for (int j = 1; j < 6; j++) {
            String oPath = "d://ooxx" + j + ".txt";
            String xPath = "d://xxoo" + j + ".txt";
            br = new BufferedReader(new FileReader(oPath));
            while ((line = br.readLine()) != null){
                set.add(line);
            }
            br = new BufferedReader(new FileReader(xPath));
            while((line = br.readLine())  != null){
                if (set.contains(line)){
                    System.out.println(line);
                }
            }
        }
        br.close();
    }
}
/*————————————————
        版权声明：本文为CSDN博主「乔治大哥」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/qq_41946557/article/details/102711573*/
