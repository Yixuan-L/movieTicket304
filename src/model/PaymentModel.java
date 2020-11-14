package model;

public class PaymentModel {
    private String pid;
    private double amount;

    public PaymentModel(String pid, double amount) {
        this.pid = pid;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getPid() {
        return pid;
    }
}
