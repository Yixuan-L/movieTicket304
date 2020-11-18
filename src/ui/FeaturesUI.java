package ui;

import database.DatabaseConnectionHandler;
import delegates.DatabaseDelegate;
import delegates.FeaturesDelegate;
import delegates.OperationDelegate;
import model.BranchRevenueModel;
import model.BranchTicketModel;
import model.FormatPrice;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class FeaturesUI extends JFrame {
    private FeaturesDelegate delegate;

    private DatabaseConnectionHandler dbHandler;


    public FeaturesUI() {
        super("Movie DMBS");
    }

    public void showFrame(FeaturesDelegate delegate) {
        this.delegate = delegate;

        JLabel customerLabel = new JLabel("Customer: ");
        JLabel adminLabel = new JLabel("Admin: ");

        JButton searchButton = new JButton("Search Movie");
        JButton reserveButton = new JButton("Reserve Movie");
        JButton accountButton = new JButton("Account Info");

        JButton operation = new JButton("Theatre Operation");
        JButton database = new JButton("Database");
        JButton report = new JButton("Report");


        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);

        // layout components using the GridBag layout manager
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // place the customer label
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(customerLabel, c);
        contentPane.add(customerLabel);

        // place the search button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(searchButton, c);
        contentPane.add(searchButton);

        // place the reserve button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(reserveButton, c);
        contentPane.add(reserveButton);

        // customer account button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(accountButton, c);
        contentPane.add(accountButton);

        // place the clerk label
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(30, 0, 10, 0);
        gb.setConstraints(adminLabel, c);
        contentPane.add(adminLabel);

        // place the rent button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(operation, c);
        contentPane.add(operation);

        // place the branch rental report button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 20, 0);
        gb.setConstraints(report, c);
        contentPane.add(report);

        report.addActionListener(e -> {
            this.dispose();
            dbHandler = new DatabaseConnectionHandler();
            dbHandler.connectToOracle();
            new ReportUI().showFrame(new DatabaseDelegate() {
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
                    return dbHandler.branchRevenue();
                }

                @Override
                public BranchTicketModel[] branchTicket() {
                    return dbHandler.branchticket();
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
                public void showCash() {

                }

                @Override
                public void showCard() {

                }

                @Override
                public boolean deleteMovie(String moviename) {
                    return false;
                }
            });
        });


        operation.addActionListener(e -> {
            this.dispose();
            dbHandler = new DatabaseConnectionHandler();
            dbHandler.connectToOracle();
            new OperationUI().showFrame(new OperationDelegate() {

                @Override
                public boolean addMovie(  String movie_name, String language, String format, String movie_genre, String firm_rating, double movie_price) {
                    return dbHandler.addMovie( movie_name, language, format, movie_genre, firm_rating, movie_price);
                }

                @Override
                public boolean deleteMovie(String moviename) {
                    return dbHandler.deleteMovie(moviename);
                }
            });
        });

        database.addActionListener(e -> {
            this.dispose();
            dbHandler = new DatabaseConnectionHandler();
            dbHandler.connectToOracle();
            new DatabaseUI().showFrame(new DatabaseDelegate() {
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
                public void showMovie() throws SQLException {
                    dbHandler.showMovie();
                }

                @Override
                public void showCash() throws SQLException {
                    dbHandler.showCash();
                }

                @Override
                public void showCard() throws SQLException {
                    dbHandler.showCard ();
                }

                @Override
                public void updateCustomer(int id, String[] updateInfo) {
                    dbHandler.updateCustomer(id, updateInfo);
                }

                @Override
                public int makePaymentCash(int amount) {
                    return dbHandler.makePaymentCash(amount);
                }

                @Override
                public int makePaymentCard(int amount, String cardnumber, String cvv) {
                    return dbHandler.makePaymentCard(amount, cardnumber, cvv);
                }

                @Override
                public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id) {
                    return dbHandler.createReservation (  branch_name,  movie_name, movie_language, movie_format, customer_name , payment_id);
                }

                @Override
                public BranchRevenueModel[] branchRevenue() {
                    return dbHandler.branchRevenue();
                }

                @Override
                public BranchTicketModel[] branchTicket() {
                    return dbHandler.branchticket();
                }

                @Override
                public FormatPrice[] formatPrice() {
                    return dbHandler.formatPrice();
                }

                @Override
                public void customerAllMovie() {
                    CustomerModel[] models = dbHandler.customerAllMovie();
                    CustomersAllMovieUI ui = new CustomersAllMovieUI((models));
                    ui.showFrame();
                }

                @Override
                public boolean deleteMovie(String moviename) {
                    return false;
                }

//                @Override
//                public boolean deleteMovie(String moviename) {
//                    return dbHandler.deleteMovie(moviename);
//                }

//                @Override
//                public boolean addMovie(int movie_id, String movie_anme, String language, String format, String movie_genre, String firm_rating, int active_date) {
//                    return false;
//                }

            });
        });

        // place the rental report button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(database, c);
        contentPane.add(database);
//
//        // place the return button
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(returnButton, c);
//        contentPane.add(returnButton);
//
//        // place the return report button
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(returnReportButton, c);
//        contentPane.add(returnReportButton);
//
//        // place the branch return report button
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(branchReturnReportButton, c);
//        contentPane.add(branchReturnReportButton);

        // register customer button with action event handler
        searchButton.addActionListener(e -> this.delegate.search());
        reserveButton.addActionListener(e -> this.delegate.reserve());
//        operation.addActionListener(e -> this.delegate.rent());
//        database.addActionListener(e -> this.delegate.rentalReport());
//        report.addActionListener(e -> this.delegate.branchRentalReport());
//        returnButton.addActionListener(e -> this.delegate.returnBack());
//        returnReportButton.addActionListener(e -> this.delegate.returnReport());
//        branchReturnReportButton.addActionListener(e -> this.delegate.branchReturnReport());

        // anonymous inner class for closing the window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
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

//    public static void main(String[] args) {
//        FeaturesUI optionsUI = new FeaturesUI();
//        optionsUI.showFrame(new FeaturesDelegate() {
//            @Override
//            public void search() {
//
//            }
//
//            @Override
//            public void reserve() {
//
//            }
//
//            @Override
//            public void ticketConversion() {
//
//            }
//
//            @Override
//            public void saleReport() {
//
//            }
//
//            @Override
//            public void movieReport() {
//
//            }
//
//            @Override
//            public void branchSalesReport() {
//
//            }
////
////            @Override
////            public void rent() {
////
////            }
////
////            @Override
////            public void rentalReport() {
////
////            }
////
////            @Override
////            public void branchRentalReport() {
////
////            }
////
////            @Override
////            public void returnBack() {
////
////            }
////
////            @Override
////            public void returnReport() {
////
////            }
////
////            @Override
////            public void branchReturnReport() {
////
////            }
//        });
//    }
}
