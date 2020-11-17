package model;

public class FormatPrice {
    private String format;
    private double price;
    public FormatPrice(String format, double price){
        this.format = format;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getFormat() {
        return format;
    }
}
