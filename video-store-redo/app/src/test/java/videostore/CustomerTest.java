package videostore;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Stelios");
    }

    @Test
    public void when_renting_one_new_movie_for_3_days_then_statement_has_9_price_and_2_credits()
            throws Exception {
        customer.addRental(getInterstellarRentalFor(3));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tInterstellar\t9.0\n"
                        + "Amount owed is 9.0\n"
                        + "You earned 2 frequent renter points"));
    }

    @Test
    public void when_renting_two_new_movie_for_3_and_4_days_respectively_then_statement_has_21_price_and_4_credits()
            throws Exception {
        customer.addRental(getInterstellarRentalFor(3));
        customer.addRental(getJudgeRentalFor(4));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tInterstellar\t9.0\n"
                        + "\tThe Judge\t12.0\n" + "Amount owed is 21.0\n"
                        + "You earned 4 frequent renter points"));
    }

    @Test
    public void when_renting_one_child_movie_for_2_days_then_statement_has_1_5_price_and_1_credit()
            throws Exception {
        customer.addRental(getLionKingRentalFor(2));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tLion King\t1.5\n"
                        + "Amount owed is 1.5\n"
                        + "You earned 1 frequent renter points"));
    }

    @Test
    public void when_renting_one_regular_movie_for_5_days_then_statement_has_6_5_price_and_1_credit()
            throws Exception {
        customer.addRental(getGodFatherRentalFor(5));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tThe Godfather\t6.5\n"
                        + "Amount owed is 6.5\n"
                        + "You earned 1 frequent renter points"));
    }

    @Test
    public void when_renting_one_child_movie_for_5_days_then_statement_has_4_5_price_and_1_credit()
            throws Exception {
        customer.addRental(getLionKingRentalFor(5));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tLion King\t4.5\n"
                        + "Amount owed is 4.5\n"
                        + "You earned 1 frequent renter points"));
    }

    @Test
    public void rent_no_movies() {
        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "Amount owed is 0.0\n"
                        + "You earned 0 frequent renter points"));
    }

    @Test
    public void when_renting_regular_movie_for_1_day_then_statement_has_2_price_and_1_credit() {
        customer.addRental(getGodFatherRentalFor(1));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tThe Godfather\t2.0\n"
                        + "Amount owed is 2.0\n"
                        + "You earned 1 frequent renter points"));
    }

    @Test
    public void when_renting_a_new_release_for_1_day_then_statement_has_3_price_and_1_credit() {
        customer.addRental(getInterstellarRentalFor(1));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tInterstellar\t3.0\n"
                        + "Amount owed is 3.0\n"
                        + "You earned 1 frequent renter points"));
    }

    @Test
    public void when_renting_all_types_of_movies() {
        customer.addRental(getInterstellarRentalFor(3));
        customer.addRental(getLionKingRentalFor(5));
        customer.addRental(getGodFatherRentalFor(5));

        assertThat(customer.statement(),
                is("Rental Record for Stelios\n" + "\tInterstellar\t9.0\n"
                        + "\tLion King\t4.5\n" + "\tThe Godfather\t6.5\n"
                        + "Amount owed is 20.0\n"
                        + "You earned 4 frequent renter points"));

    }

    private Rental getInterstellarRentalFor(int daysRented) {
        return new Rental(new NewReleaseMovie("Interstellar"),
                daysRented);
    }

    private Rental getJudgeRentalFor(int daysRented) {
        return new Rental(new NewReleaseMovie("The Judge"),
                daysRented);
    }

    private Rental getLionKingRentalFor(int daysRented) {
        return new Rental(new ChildrenMovie("Lion King"), daysRented);
    }

    private Rental getGodFatherRentalFor(int daysRented) {
        return new Rental(new RegularMovie("The Godfather"),
                daysRented);
    }



}