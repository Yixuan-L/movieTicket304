package model;

public class BranchRevenueModel {
    private String branch;
    private double  revenue;

    public BranchRevenueModel(String branch, double revenue) {
        this.branch = branch;
        this.revenue = revenue;


    }

    public String getBranch() {
        return branch;
    }

    public double getRevenue() {
        return revenue;
    }


}
