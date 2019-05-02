package movie;

import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer testCumstomer;

    @Before
    public void setUp() {
        testCumstomer = new Customer("TestCustomer");
    }

    @Test
    public void addRental() {
    }

    @Test
    public void getName() {
        assertEquals("TestCustomer", testCumstomer.getName());
    }

    @Test
    public void testGetEmptyRentalRecord() {
        String expectedResult = "Rental Record for " + testCumstomer.getName() + "\n";
        expectedResult += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        expectedResult += "";
        expectedResult += "Amount owed is " +  0.0 + "\n";
        expectedResult += "You earned " + 0 + " frequent renter points";
        assertEquals(expectedResult, testCumstomer.getRentalsRecord());
    }

    @Test
    public void testGetRentalRecord() {
        testCumstomer.addRental(new Rental(new Movie("MovieTitle", 0), 10));
        String expectedResult = "Rental Record for " + testCumstomer.getName() + "\n";
        expectedResult += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        expectedResult += "\tMovieTitle\t\t10\t14.0\n";
        expectedResult += "Amount owed is " +  14.0 + "\n";
        expectedResult += "You earned " + 1 + " frequent renter points";
        assertEquals(expectedResult, testCumstomer.getRentalsRecord());
    }

    @Test
    public void testGetRentalRecordNewRelease() {
        testCumstomer.addRental(new Rental(new Movie("NewRelease", 1), 10));
        String expectedResult = "Rental Record for " + testCumstomer.getName() + "\n";
        expectedResult += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        expectedResult += "\tNewRelease\t\t10\t30.0\n";
        expectedResult += "Amount owed is " +  30.0 + "\n";
        expectedResult += "You earned " + 2 + " frequent renter points";
        assertEquals(expectedResult, testCumstomer.getRentalsRecord());
    }
}