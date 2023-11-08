package videostore;

import java.math.BigDecimal;

public class NewReleaseMovie implements Movie{

    private final String title;

    public NewReleaseMovie(String title) {
        this.title = title;
    }

    @Override
    public BigDecimal getPrice(int daysRented) {
        return BigDecimal.valueOf(daysRented * 3);
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean givesBonus() {
        return true;
    }
}
