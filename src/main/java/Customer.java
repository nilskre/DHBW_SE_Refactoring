import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return getRentalRecord();
    }

    private String getRentalRecord() {
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += calculateRentalRecord();
        return result;
    }

    private String calculateRentalRecord() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String allRentalDates = "";
        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for rental line
            thisAmount = rental.getAmountFor();
            frequentRenterPoints += 1;
            // add bonus for a two day new release rental
            boolean movieIsNewRelease = rental.getMovie().getMoviePriceCategory() == MoviePriceCategory.NEW_RELEASE;
            if (movieIsNewRelease && rental.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            allRentalDates += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        allRentalDates += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        allRentalDates += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return allRentalDates;
    }
}