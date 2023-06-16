package pl.ipastula.sales;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Reservation {

    public Reservation(String id, BigDecimal total, String paymentId) {
        this.id = id;
        this.total = total;
        this.paymentId = paymentId;
    }

    Reservation() {}

    @Id
    String id;
    BigDecimal total;
    String paymentId;
}
