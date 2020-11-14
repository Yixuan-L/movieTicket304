package model;

public class SeatModel {
    private String seatid;
    private String hallid;
    private String seatType;

    public SeatModel(String seatid, String hallid, String seatType) {
        this.seatid = seatid;
        this.hallid = hallid;
        this.seatType = seatType;
    }

    public String getSeatid() {
        return seatid;
    }

    public String getHallid() {
        return hallid;
    }

    public String getSeatType() {
        return seatType;
    }
}
