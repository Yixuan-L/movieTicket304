package ui;

import database.DatabaseConnectionHandler;
import delegates.DatabaseDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomerAccount extends JFrame {
    private DatabaseConnectionHandler dbHandler;
    private DatabaseDelegate delegate;
    public CustomerAccount() {
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
}
