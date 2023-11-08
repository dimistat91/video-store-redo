package videostore;

import java.math.BigDecimal;

public interface Movie {

    BigDecimal getPrice(int daysRented);

    String getTitle();

    boolean givesBonus();



}