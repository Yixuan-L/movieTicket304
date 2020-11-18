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

public class movieTicket implements FeaturesDelegate
        /*DatabaseDelegate*/ {
//    private DatabaseConnectionHandler dbHandler;

    public movieTicket() {
//        dbHandler = new DatabaseConnectionHandler();
//        dbHandler.connectToOracle();

    }
    private void start(){
//        DatabaseUI databaseUI = new DatabaseUI();
//        databaseUI.showFrame(this);
        FeaturesUI featuresUI = new FeaturesUI();
        featuresUI.showFrame(this);
    }

//    @Override
//    public void showCustomers() {
//        CustomerModel[] models = dbHandler.showCustomers();
//        ShowCustomersUI ui = new ShowCustomersUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public void showHalls() {
//        HallModel[] models = dbHandler.showHalls();
//        ShowHallUI ui = new ShowHallUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public void showTheaters() {
//        TheatreModel[] models = dbHandler.showTheaters();
//        ShowTheatreUI ui = new ShowTheatreUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public void showTickets() {
//        TicketModel[] models = dbHandler.showTickets();
//        ShowTicketUI ui = new ShowTicketUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public void showSeats() {
//        SeatModel[] models = dbHandler.showSeats();
//        ShowSeatUI ui = new ShowSeatUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public void showOrders() {
//        OrderModel[] models = dbHandler.showOrders();
//        ShowOrderUI ui = new ShowOrderUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public int makePaymentCash(int amount) {
//        return dbHandler.makePaymentCash(amount);
//    }
//
//    @Override
//    public int makePaymentCard(int amount, String cardnumber, String cvv) {
//        return dbHandler.makePaymentCard(amount, cardnumber, cvv);
//    }
//
//    @Override
//    public void updateCustomer(int id , String[] updateInfo) {
//        dbHandler.updateCustomer(id, updateInfo);
//    }
//
//
////加上ui后需要override
//    public BranchRevenueModel[] branchRevenue(){
//        return dbHandler.branchRevenue();
//    }
//    //加上ui后需要override
//    public BranchTicketModel[] branchTicket(){
//        return dbHandler.branchticket();
//    }
//    //加上ui后需要override
//    public FormatPrice[] formatPrice(){
//        return dbHandler.formatPrice();
//    }
////
//    @Override
//    public void customerAllMovie() {
//        CustomerModel[] models = dbHandler.customerAllMovie();
//        CustomersAllMovieUI ui = new CustomersAllMovieUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public boolean deleteMovie(String moviename ) {
//        return dbHandler.deleteMovie(moviename);
//    }
//
//    @Override
//    public boolean createReservation ( String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id ) {
//        return dbHandler.createReservation (  branch_name,  movie_name, movie_language, movie_format, customer_name , payment_id);
//    }

    public static void main(String[] args){
        movieTicket ticket = new movieTicket();
        ticket.start();
    }


    @Override
    public void search() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void ticketConversion() {

    }

    @Override
    public void saleReport() {

    }

    @Override
    public void movieReport() {

    }

    @Override
    public void branchSalesReport() {

    }
}
