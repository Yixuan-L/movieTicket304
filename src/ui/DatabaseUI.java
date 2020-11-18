package ui;

import database.DatabaseConnectionHandler;
import delegates.DatabaseDelegate;
import delegates.FeaturesDelegate;
import delegates.OperationDelegate;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DatabaseUI extends JFrame implements DatabaseDelegate {

    private DatabaseDelegate delegate;

//    private DatabaseConnectionHandler dbHandler;

    public DatabaseUI() {
        super("Database");
//        dbHandler = new DatabaseConnectionHandler();
//        dbHandler.connectToOracle();
    }

    public void showFrame(DatabaseDelegate delegate) {
        this.delegate = delegate;

        JButton theatreButton = new JButton("Theatre");
        JButton hallButton = new JButton("Hall");
        JButton seatButton = new JButton("seat");
        JButton orderButton = new JButton("order");
        JButton ticketButton = new JButton("ticket");


        JButton customerButton = new JButton("Customers");

        JButton featuresButton = new JButton("Features");


        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);

        // layout components using the GridBag layout manager
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        // theatre button

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(theatreButton, c);
        contentPane.add(theatreButton);

        // place the hall button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(hallButton, c);
        contentPane.add(hallButton);

        // place the seat button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(seatButton, c);
        contentPane.add(seatButton);

        //place the order button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(orderButton, c);
        contentPane.add(orderButton);

        // place the ticket button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(ticketButton, c);
        contentPane.add(ticketButton);




        // place the customer button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(customerButton, c);
        contentPane.add(customerButton);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(featuresButton, c);
        contentPane.add(featuresButton);


        customerButton.addActionListener(e -> this.delegate.showCustomers());
        theatreButton.addActionListener(e -> this.delegate.showTheaters());
        ticketButton.addActionListener(e -> this.delegate.showTickets());
        seatButton.addActionListener(e -> this.delegate.showSeats());
        hallButton.addActionListener(e -> this.delegate.showHalls());
        orderButton.addActionListener(e -> this.delegate.showOrders());

        // 暂时直接设置一个按钮测试update customer info
        JButton updateCustomerButton = new JButton("updateCutomerInfo");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(updateCustomerButton, c);
        contentPane.add(updateCustomerButton);
        updateCustomerButton.addActionListener(e -> this.delegate.updateCustomer( 1, new String[]{"newname1", "newaddress1", "newemail1", "new2323323"}));

        // 暂时直接设置一个按钮测试 user pay by cash
        JButton payCashButton = new JButton("paycash");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(payCashButton, c);
        contentPane.add(payCashButton);
        payCashButton.addActionListener(e -> this.delegate.makePaymentCash( 40));

        // 暂时直接设置一个按钮测试 user pay by card
        JButton payCardButton = new JButton("paycard");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(payCardButton, c);
        contentPane.add(payCardButton);
        payCardButton.addActionListener(e -> this.delegate.makePaymentCard( 50, "4566778899999999", "998"));


        // 暂时直接设置一个按钮测试 delete one movie
        JButton deleteMovieButton = new JButton("deleteMovie");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(deleteMovieButton, c);
        contentPane.add(deleteMovieButton);
        deleteMovieButton.addActionListener(e -> this.delegate.deleteMovie("2012"));


        // 暂时直接设置一个按钮测试 add reservation (order)
        JButton generateOrderButton = new JButton("addReservation");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(generateOrderButton, c);
        contentPane.add(generateOrderButton);
        generateOrderButton.addActionListener(e -> this.delegate.createReservation("theatre1", "2012", "English", "2D", "Mike",8 ));

        //button test for branchRevenue
        JButton branchRevenueButton = new JButton("branch_Revenue");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(branchRevenueButton, c);
        contentPane.add(branchRevenueButton);
        branchRevenueButton.addActionListener(e -> this.delegate.branchRevenue());

        //button test for branchRevenue
        JButton branchTicketButton = new JButton("branch_Ticket");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(branchTicketButton, c);
        contentPane.add(branchTicketButton);
        branchTicketButton.addActionListener(e -> this.delegate.branchTicket());

        //button test for format_price
        JButton formatPriceButton = new JButton("format_Price");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(formatPriceButton, c);
        contentPane.add(formatPriceButton);
        formatPriceButton.addActionListener(e -> this.delegate.formatPrice());

        //button test for customer buy all movies
        JButton CustomerAllMovieButton = new JButton("Customer_all_movie");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(CustomerAllMovieButton, c);
        contentPane.add(CustomerAllMovieButton);
        CustomerAllMovieButton.addActionListener(e -> this.delegate.customerAllMovie());


        //button test for customer buy all movies
        JButton showMovieButton = new JButton("Show movie table join moviePrice table");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(showMovieButton, c);
        contentPane.add(showMovieButton);
        showMovieButton.addActionListener(e -> {
            try {
                this.delegate.showMovie();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });



        //跳转到功能页面
        featuresButton.addActionListener(e -> {
            close();

            new FeaturesUI().showFrame(new FeaturesDelegate() {
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
            });
        });


                // size the window to obtain a best fit for the components
        this.pack();

        // center the frame
        Dimension d = this.getToolkit().getScreenSize();
        Rectangle r = this.getBounds();
        this.setLocation((d.width - r.width) / 2, (d.height - r.height) / 2);

        // make the window visible
        this.setVisible(true);
    }

    public void close() {
        this.dispose();
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
//    public void updateCustomer(int id, String[] updateInfo) {
//        dbHandler.updateCustomer(id, updateInfo);
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
//    public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id) {
//        return dbHandler.createReservation (  branch_name,  movie_name, movie_language, movie_format, customer_name , payment_id);
//    }
//
//    @Override
//    public BranchRevenueModel[] branchRevenue() {
//        return dbHandler.branchRevenue();
//    }
//
//    @Override
//    public BranchTicketModel[] branchTicket() {
//        return dbHandler.branchticket();
//    }
//
//    @Override
//    public FormatPrice[] formatPrice() {
//        return dbHandler.formatPrice();
//    }
//
//    @Override
//    public void customerAllMovie() {
//        CustomerModel[] models = dbHandler.customerAllMovie();
//        CustomersAllMovieUI ui = new CustomersAllMovieUI((models));
//        ui.showFrame();
//    }
//
//    @Override
//    public boolean deleteMovie(String moviename) {
//        return dbHandler.deleteMovie(moviename);
//    }


//
//    public static void main(String[] args) {
//        DatabaseUI databaseUI = new DatabaseUI();
//        databaseUI.showFrame(new DatabaseDelegate() {
            @Override
            public void showCustomers() {

            }

            @Override
            public void showHalls() {

            }

            @Override
            public void showTheaters() {

            }

            @Override
            public void showTickets() {

            }

            @Override
            public void showSeats() {

            }

            @Override
            public void showOrders() {

            }

            @Override
            public void updateCustomer(int id, String[] updateInfo) {

            }

            @Override
            public int makePaymentCash(int amount) {
                return 0;
            }

            @Override
            public int makePaymentCard(int amount, String cardnumber, String cvv) {
                return 0;
            }

            @Override
            public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id) {
                return false;
            }

            @Override
            public BranchRevenueModel[] branchRevenue() {
                return new BranchRevenueModel[0];
            }

            @Override
            public BranchTicketModel[] branchTicket() {
                return new BranchTicketModel[0];
            }

            @Override
            public FormatPrice[] formatPrice() {
                return new FormatPrice[0];
            }

            @Override
            public void customerAllMovie() {

            }

            @Override
            public void showMovie() {

            }

            @Override
            public boolean deleteMovie(String moviename) {
                return false;
            }

//    @Override
//    public boolean addMovie(int movie_id, String movie_name, String language, String format, String movie_genre, String firm_rating, int active_date) {
//        return false;
//    }
//        });
//    }
}
