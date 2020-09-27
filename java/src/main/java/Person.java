import lombok.Data;

@Data
public class Person {
    private Long oaid;
    private String oaname;

    public Person() {
    }

    public Person(Long oaid, String oaname) {
        this.oaid = oaid;
        this.oaname = oaname;
    }
}
