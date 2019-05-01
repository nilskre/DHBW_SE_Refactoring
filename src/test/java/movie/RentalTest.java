package movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RentalTest {
    private Rental testRental;
    private Movie testMovieRegular = new Movie("Movietitle", 0);

    @Before
    public void setUp() {
        testRental = new Rental(testMovieRegular, 2);
    }
    @Test
    public void getDaysRented() {
        assertEquals(2, testRental.getDaysRented());
    }

    @Test
    public void getMovie() {
        assertEquals(testMovieRegular, testRental.getMovie());
    }

    @Test
    public void getAmountFor() {
        assertEquals(2, testRental.getAmountFor(), 0.0);
    }
}