package model;

public class MovieModel {
    private String movieid;
    private String dType;
    private double price;
    private String name;
    private String language;
    private String genre;
    private String duration;
    private String rating;
    private int activeDate;

    public MovieModel(String movieid, String dType, double price, String name, String language, String genre, String duration, String rating, int activeDate) {
        this.movieid = movieid;
        this.dType = dType;
        this.price = price;
        this.name = name;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.activeDate = activeDate;
    }

    public String getMovieid() {
        return movieid;
    }

    public double getPrice() {
        return price;
    }

    public String getdType() {
        return dType;
    }

    public String getName() {
        return name;
    }

    public int getActiveDate() {
        return activeDate;
    }

    public String getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getRating() {
        return rating;
    }

    public void setActiveDate(int activeDate) {
        this.activeDate = activeDate;
    }

}
