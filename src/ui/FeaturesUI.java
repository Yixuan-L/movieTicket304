package ui;

import delegates.FeaturesDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FeaturesUI extends JFrame {
    private FeaturesDelegate delegate;

    public FeaturesUI() {
        super("Features");
    }

    public void showFrame(FeaturesDelegate delegate) {
        this.delegate = delegate;

        JLabel customerLabel = new JLabel("Customer: ");
        JLabel adminLabel = new JLabel("Admin: ");

        JButton searchButton = new JButton("Search Movie");
        JButton reserveButton = new JButton("Reserve Movie");

        JButton changeAnOrder = new JButton("Change Order");
        JButton searchOrder = new JButton("Search Order");
        JButton report = new JButton("Report");
//
//        JButton returnButton = new JButton("Return a Vehicle");
//        JButton returnReportButton = new JButton("Daily Return Report");
//        JButton branchReturnReportButton = new JButton("Daily Return Report for Branch");

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

        // place the clerk label
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(30, 0, 10, 0);
        gb.setConstraints(adminLabel, c);
        contentPane.add(adminLabel);

        // place the rent button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(changeAnOrder, c);
        contentPane.add(changeAnOrder);

        // place the rental report button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(searchOrder, c);
        contentPane.add(searchOrder);

        // place the branch rental report button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 20, 0);
        gb.setConstraints(report, c);
        contentPane.add(report);
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
//        changeAnOrder.addActionListener(e -> this.delegate.rent());
//        searchOrder.addActionListener(e -> this.delegate.rentalReport());
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

    public static void main(String[] args) {
        FeaturesUI optionsUI = new FeaturesUI();
        optionsUI.showFrame(new FeaturesDelegate() {
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
//
//            @Override
//            public void rent() {
//
//            }
//
//            @Override
//            public void rentalReport() {
//
//            }
//
//            @Override
//            public void branchRentalReport() {
//
//            }
//
//            @Override
//            public void returnBack() {
//
//            }
//
//            @Override
//            public void returnReport() {
//
//            }
//
//            @Override
//            public void branchReturnReport() {
//
//            }
        });
    }
}
