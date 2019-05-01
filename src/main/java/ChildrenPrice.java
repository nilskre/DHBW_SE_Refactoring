public class ChildrenPrice implements Price {

    @Override
    public double getPrice(Rental rental) {
        double price = 1.5;
        if (rental.getDaysRented() > 3) {
            price += (rental.getDaysRented() - 3) * 1.5;
        }
        return price;
    }
}