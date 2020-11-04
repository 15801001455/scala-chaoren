package lamda;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.function.Function;

public class Function1 {

    @Test
    public void testFunction1() throws Exception{
        PersonQuery query = new PersonQuery();
        query.setName("李四");
        query.setSex("女性");
        PersonReturn data = readFromCache(a -> getPerson(a),query,PersonReturn.class);
        System.out.println(data.getSex());
    }

    public <T> T readFromCache(Function<PersonQuery,T> service,PersonQuery param,Class<T> rc) throws Exception {
        T apply = service.apply(param);
        if(apply!=null){
            return apply;
        }
        return null;
    }

    public PersonReturn getPerson(PersonQuery query){
        PersonReturn personReturn = new PersonReturn();
        personReturn.setId("123");
        personReturn.setSex("男性");
        return personReturn;
    }
}
