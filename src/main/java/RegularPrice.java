public class RegularPrice implements Price {

    @Override
    public double getPrice(Rental rental) {
        int price = 2;
        if (rental.getDaysRented() > 2)
          price += (rental.getDaysRented() - 2) * 1.5;
        return price;
    }
}
