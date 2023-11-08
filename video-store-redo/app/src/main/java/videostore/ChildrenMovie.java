package videostore;

import java.math.BigDecimal;

public class ChildrenMovie implements Movie{

    private final String title;
    public ChildrenMovie(String title) {
        this.title = title;
    }

    @Override
    public BigDecimal getPrice(int daysRented) {
        if (daysRented > 3)
            return BigDecimal.valueOf(1.5 + (daysRented - 3) * 1.5);
        else return BigDecimal.valueOf(1.5);
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
