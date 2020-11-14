package model;

public class TicketModel {
    private String number;
    private String confirm;
    private String startTime;
    private String seatid;
    private String hallid;
    private String name;

    public TicketModel(String number, String confirm, String startTime, String seatid, String hallid, String name){
        this.number = number;
        this.confirm = confirm;
        this.seatid = seatid;
        this.hallid = hallid;
        this.startTime = startTime;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHallid() {
        return hallid;
    }

    public String getSeatid() {
        return seatid;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getNumber() {
        return number;
    }

    public String getStartTime() {
        return startTime;
    }


}
