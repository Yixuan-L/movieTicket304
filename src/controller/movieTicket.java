package controller;
import database.DatabaseConnectionHandler;
import delegates.*;
import model.*;
import ui.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class movieTicket implements
        DatabaseDelegate {
    private DatabaseConnectionHandler dbHandler;

    public movieTicket() {
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();

    }
    private void start(){
        DatabaseUI databaseUI = new DatabaseUI();
        databaseUI.showFrame(this);
    }

    @Override
    public void showCustomers() {
        CustomerModel[] models = dbHandler.showCustomers();
        ShowCustomersUI ui = new ShowCustomersUI((models));
        ui.showFrame();
    }

    @Override
    public void showHalls() {
        HallModel[] models = dbHandler.showHalls();
        ShowHallUI ui = new ShowHallUI((models));
        ui.showFrame();
    }

    @Override
    public void showTheaters() {
        TheatreModel[] models = dbHandler.showTheaters();
        ShowTheatreUI ui = new ShowTheatreUI((models));
        ui.showFrame();
    }

    @Override
    public void showTickets() {
        TicketModel[] models = dbHandler.showTickets();
        ShowTicketUI ui = new ShowTicketUI((models));
        ui.showFrame();
    }

    @Override
    public void showSeats() {
        SeatModel[] models = dbHandler.showSeats();
        ShowSeatUI ui = new ShowSeatUI((models));
        ui.showFrame();
    }

    @Override
    public void showOrders() {
        OrderModel[] models = dbHandler.showOrders();
        ShowOrderUI ui = new ShowOrderUI((models));
        ui.showFrame();
    }

    @Override
    public void updateCustomer(int id , String[] updateInfo) {
        dbHandler.updateCustomer(id, updateInfo);
    }

    public static void main(String[] args){
        movieTicket ticket = new movieTicket();
        ticket.start();
    }




}
