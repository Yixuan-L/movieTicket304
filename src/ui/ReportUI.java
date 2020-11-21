package ui;

import database.DatabaseConnectionHandler;


import delegates.ReportDelegate;

import model.BranchRevenueModel;
import model.BranchTicketModel;
import model.FormatPrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReportUI extends JFrame implements ReportDelegate {
    private DatabaseConnectionHandler dbHandler;
    private ReportDelegate delegate;
    public ReportUI() {
        super("Generate Report");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame(ReportDelegate delegate) {

        this.delegate = delegate;


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

        //button test for branchRevenue
        JButton formatPriceButton = new JButton("movieFormat_Price");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(formatPriceButton, c);
        contentPane.add(formatPriceButton);
        formatPriceButton.addActionListener(e -> this.delegate.formatPrice());

        //button test for branchRevenue
        //button test for customer buy all movies
        JButton CustomerAllMovieButton = new JButton("Customer_all_movie");
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(CustomerAllMovieButton, c);
        contentPane.add(CustomerAllMovieButton);
        CustomerAllMovieButton.addActionListener(e -> this.delegate.customerAllMovie());



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
    public void branchRevenue() {

    }

    @Override
    public void branchTicket() {

    }

    @Override
    public void formatPrice() {
    }

    @Override
    public void customerAllMovie() {

    }

}
