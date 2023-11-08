package videostore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Customer {

    private final String name;

    private final List<Rental> rentals = new ArrayList<>();


    protected Customer(String name) {
        this.name = name;
    }

    protected void addRental(Rental arg) {
        rentals.add(arg);
    }

    protected String getName() {
        return name;
    }

    protected String statement() {
        return printStatement(calculateTotalAmount());
    }


    private BigDecimal calculateSingleMovieAmount(Rental rental) {
        BigDecimal thisAmount = new BigDecimal("0.0");
        return thisAmount.add(rental.calculateRental());
    }


    private BigDecimal calculateTotalAmount() {
        BigDecimal totalAmount = new BigDecimal("0.0");

        for (Rental rental : rentals) {
            totalAmount = totalAmount.add(calculateSingleMovieAmount(rental));
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints= rental.calculatePoints(frequentRenterPoints);
        }
        return frequentRenterPoints;
    }

    private String header() {
        return ("Rental Record for " + getName() + "\n");
    }

    private String showAmount(Rental rental, BigDecimal thisAmount) {
        return String.format("\t%s\t%s\n", rental.getMovie().getTitle(), thisAmount);
    }

    private String printStatement(BigDecimal totalAmount) {
        StringBuilder print = new StringBuilder(header());

        for (Rental rental : rentals) {
            print.append(showAmount(rental, calculateSingleMovieAmount(rental)));
        }
        return print + footer(totalAmount);
    }

    private String footer(BigDecimal totalAmount) {
        return String.format("Amount owed is %s\nYou earned %s frequent renter points", totalAmount, getFrequentRenterPoints());
    }
}






