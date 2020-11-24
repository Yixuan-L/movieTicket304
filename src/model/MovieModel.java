package model;

public class MovieModel {
    private int movieid;
    private String format;
    private double price;
    private String name;
    private String language;
    private String genre;

    private String rating;


    public MovieModel(Integer movieid, String name, String language, String format, String genre) {
        this.movieid = movieid;
        this.format = format;
//        this.price = price;
        this.name = name;
        this.language = language;
        this.genre = genre;

//        this.rating = rating;

    }

    public MovieModel(String string, String string1, String string2) {
    }

//    public MovieModel(int anInt, String string, String string1, String string2) {
//        this.movieid = movieid;
//        this.format = format;
////        this.price = price;
//        this.name = name;
//        this.language = language;
//        this.genre = genre;
//    }
//
//    public MovieModel(int anInt, String string, String string1) {
//    }
//
//    public MovieModel(String name, String string, String string1, String string2) {
////        this.movieid = movieid;
//        this.format = string;
////        this.price = price;
//        this.name = name;
//        this.language = string1;
//        this.genre = string2;
//    }

//    public MovieModel(String string, String string1, String string2, String string3, String string4) {
//    }

    public Integer getMovieid() {
        return movieid;
    }

    public double getPrice() {
        return price;
    }

    public String getFormat() {
        return format;
    }

    public String getName() {
        return name;
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


}
