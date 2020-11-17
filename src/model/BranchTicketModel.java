package model;

public class BranchTicketModel {
    private String branch;
    private int ticket;   //one people one ticket

    public BranchTicketModel(String branch, int ticket){
        this.branch = branch;
        this.ticket = ticket;

    }

    public String getBranch() {
        return branch;
    }

    public int getPeople() {
        return ticket;
    }
}
