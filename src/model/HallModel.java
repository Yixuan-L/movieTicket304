package model;

public class HallModel {
    private String hallid;
    private String branch;
    private int seatAmount;
    private String hallType;

    public HallModel(String hallid, String branch, int seatAmount, String hallType) {
        this.hallid = hallid;
        this.branch = branch;
        this.seatAmount = seatAmount;
        this.hallType  = hallType;
    }

    public String getHallid() {
        return hallid;
    }

    public String getBranch() {
        return branch;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public String getHallType() {
        return hallType;
    }
}
