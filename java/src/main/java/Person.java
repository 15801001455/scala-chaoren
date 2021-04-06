import lombok.Data;

import java.math.BigDecimal;

@Data
public class Person {
    private Long oaid = 0L;
    private String oaname;
    private Integer companyBid = 0;
    private BigDecimal totalCommission=new BigDecimal(0L);

    public Person() {
    }

    public Person(Long oaid, String oaname) {
        this.oaid = oaid;
        this.oaname = oaname;
    }
}
