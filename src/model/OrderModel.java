package model;

import org.w3c.dom.html.HTMLImageElement;

public class OrderModel {
    private String confirmid;

    private String branch;
    private String time;
    private String movieid;

    private String paymentid;
    private String customerid;

    public OrderModel(String confirmid, String branch, String time, String movieid, String paymentid, String customerid) {
        this.confirmid = confirmid;

        this.time = time;
        this.branch = branch;
        this.movieid = movieid;
        this.paymentid = paymentid;

        this.customerid = customerid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getBranch() {
        return branch;
    }


    public String getConfirmid() {
        return confirmid;
    }

    public String getMovieid() {
        return movieid;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public String getTime() {
        return time;
    }

}
