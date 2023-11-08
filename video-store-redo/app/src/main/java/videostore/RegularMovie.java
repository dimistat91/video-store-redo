package videostore;

import java.math.BigDecimal;

public class RegularMovie implements Movie{

    private final String title;
    public RegularMovie(String title) {
        this.title = title;
    }

    @Override
    public BigDecimal getPrice(int daysRented) {
        if (daysRented > 2)
            return BigDecimal.valueOf(2 + (daysRented - 2) * 1.5);
        else return BigDecimal.valueOf(2);
    }


    @Override
    public String getTitle() {
        return title;
    }

    //bonus NA
    @Override
    public boolean givesBonus() {
        return false;
    }
}
