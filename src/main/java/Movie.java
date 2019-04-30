package main.java;

public class Movie {
    private String title;
    private MoviePriceCategory moviePriceCategory;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        moviePriceCategory = MoviePriceCategory.values()[newpriceCode];
    }

    public String getTitle() {
        return title;
    }

    public MoviePriceCategory getMoviePriceCategory() {
        return moviePriceCategory;
    }
}