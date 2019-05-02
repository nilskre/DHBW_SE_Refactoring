package movie;

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

    public String getRentalsRecord() {
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += getAllRentalsAsTable();
        result += "Amount owed is " + getTotalAmount()+ "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    private String getAllRentalsAsTable() {
        Enumeration enum_rentals = rentals.elements();
        StringBuilder allRentalDates = new StringBuilder();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            allRentalDates.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rental.getAmountFor()).append("\n");
        }
        return allRentalDates.toString();
    }

    private double getTotalAmount() {
        Enumeration enum_rentals = rentals.elements();
        double charge = 0;

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            charge += each.getAmountFor();
        }
        return charge;
    }

    private int getFrequentRenterPoints() {
        Enumeration enum_rentals = rentals.elements();
        int frequentRenterPoints = 0;
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            boolean movieIsNewRelease = rental.getMovie().getMoviePriceCategory() == MoviePriceCategory.NEW_RELEASE;
            if (movieIsNewRelease && rental.getDaysRented() > 1)
                frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}