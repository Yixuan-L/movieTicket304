package model;

public class TheatreModel {
    private String branch_name;
    private String open_time;
    private String close_time;
    private String city;
    private String location;

    public TheatreModel(String branch_name, String open_time, String close_time, String city, String location) {
        this.branch_name = branch_name;
        this.open_time = open_time;
        this.close_time = close_time;
        this.city = city;
        this.location = location;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public String getOpen_time() {
        return open_time;
    }

    public String getClose_time() {
        return close_time;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }
}
