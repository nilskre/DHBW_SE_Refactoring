package movie;

public class Movie {
    private String title;
    private MoviePriceCategory moviePriceCategory;
    private Price price;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        moviePriceCategory = MoviePriceCategory.values()[newpriceCode];
        if (moviePriceCategory == MoviePriceCategory.REGULAR) {
            price = new RegularPrice();
        } else if (moviePriceCategory == MoviePriceCategory.NEW_RELEASE) {
            price = new NewReleasePrice();
        } else if (moviePriceCategory == MoviePriceCategory.CHILDRENS) {
            price = new ChildrenPrice();
        }
    }

    public String getTitle() {
        return title;
    }

    public MoviePriceCategory getMoviePriceCategory() {
        return moviePriceCategory;
    }

    public double getPrice(Rental rental) {
        return price.getPrice(rental);
    }
}