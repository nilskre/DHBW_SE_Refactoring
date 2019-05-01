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
        StringBuilder allRentalDates = new StringBuilder();
        while (enum_rentals.hasMoreElements()) {
            double thisAmount;
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for rental line
            thisAmount = rental.getAmountFor();
            frequentRenterPoints += 1;
            // add bonus for a two day new release rental
            boolean movieIsNewRelease = rental.getMovie().getMoviePriceCategory() == MoviePriceCategory.NEW_RELEASE;
            if (movieIsNewRelease && rental.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            allRentalDates.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }

        allRentalDates.append("Amount owed is ").append(totalAmount).append("\n");
        allRentalDates.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return allRentalDates.toString();
    }
}