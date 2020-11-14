package model;

public class TheatreModel {
    private String theatre;
    private String starTime;
    private String endTime;
    private String city;
    private String location;

    public TheatreModel(String theatre, String starTime, String endTime, String city, String location) {
        this.theatre = theatre;
        this.starTime = starTime;
        this.endTime = endTime;
        this.city = city;
        this.location = location;
    }

    public String getTheatre() {
        return theatre;
    }

    public String getStarTime() {
        return starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }
}
