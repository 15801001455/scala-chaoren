import java.util.ArrayList;
import java.util.List;

public class 轮训 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1L,"张三"));
        personList.add(new Person(2L,"李四"));
        personList.add(new Person(3L,"王五"));
        int count = 0;
        int total = personList.size();

        for(int i=0;i<1;i++){
            if(count == total - 1){
                System.out.println(personList.get(count).getOaname());
                count = 0;
            }else{
                System.out.println(personList.get(count).getOaname());
                count++;
            }
        }
    }


}
