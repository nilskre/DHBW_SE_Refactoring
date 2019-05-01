package movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie testMovieRegular;
    private Movie testMovieNewRelease;
    private Movie testMovieChildren;

    @Before
    public void setUp() {
        testMovieRegular = new Movie("Movietitle", 0);
        testMovieNewRelease = new Movie("Movietitle", 1);
        testMovieChildren = new Movie("Movietitle", 2);
    }

    @Test
    public void getTitle() {
        assertEquals(testMovieRegular.getTitle(), "Movietitle");
    }

    @Test
    public void getMoviePriceCategory() {
        assertEquals(testMovieRegular.getMoviePriceCategory(), MoviePriceCategory.REGULAR);
    }

    @Test
    public void testRegularPriceOneDay() {
        Rental testRental = new Rental(testMovieRegular, 1);
        assertEquals(2, testMovieRegular.getPrice(testRental), 0.0);
    }

    @Test
    public void testRegularPriceFourDays() {
        Rental testRental = new Rental(testMovieRegular, 4);
        assertEquals(5.0, testMovieRegular.getPrice(testRental), 0.0);
    }

    @Test
    public void testNewReleasePrice() {
        Rental testRental = new Rental(testMovieNewRelease, 1);
        assertEquals(3, testMovieNewRelease.getPrice(testRental), 0.0);
    }

    @Test
    public void testChildrenPrice() {
        Rental testRental = new Rental(testMovieChildren, 1);
        assertEquals(1.5, testMovieChildren.getPrice(testRental), 0.0);
    }

    @Test
    public void testChildrenPriceFourDays() {
        Rental testRental = new Rental(testMovieChildren, 4);
        assertEquals(3.0, testMovieChildren.getPrice(testRental), 0.0);
    }
}