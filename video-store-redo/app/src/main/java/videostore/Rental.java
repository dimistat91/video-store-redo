package videostore;

import java.math.BigDecimal;

class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    protected int getDaysRented() {
        return daysRented;
    }

    protected Movie getMovie() {
        return movie;
    }

    protected BigDecimal calculateRental() {
        return movie.getPrice(daysRented);
    }

    protected int calculatePoints(int points) {
        points++;
        // add bonus for a two-day new release rental
//            if ((rental.getMovie().getClass().getSimpleName().equals("NewReleaseMovie")) && rental.getDaysRented() > 1)
        if ((getMovie().givesBonus()) && getDaysRented() > 1) {
            points++;
        }
        return points;
    }
}