package ui;

import database.DatabaseConnectionHandler;
import delegates.DatabaseDelegate;
import model.BranchRevenueModel;
import model.BranchTicketModel;
import model.FormatPrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReportUI extends JFrame implements DatabaseDelegate {
    private DatabaseConnectionHandler dbHandler;
    private DatabaseDelegate delegate;
    public ReportUI() {
        super("Generate Report");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame(DatabaseDelegate delegate) {

        JButton addMovie = new JButton("Branch Revenue");
        JButton deleteMovie = new JButton("Branch Ticket");
//        JButton seatButton = new JButton("seat");
//        JButton orderButton = new JButton("order");
//        JButton ticketButton = new JButton("ticket");



        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);

        // layout components using the GridBag layout manager
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        // theatre button

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
    public boolean deleteMovie(String moviename) {
        return false;
    }
}
