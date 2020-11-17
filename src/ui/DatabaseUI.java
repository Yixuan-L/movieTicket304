package ui;

import delegates.DatabaseDelegate;
import delegates.FeaturesDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseUI extends JFrame {

    private DatabaseDelegate delegate;

    public DatabaseUI() {
        super("Database");
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
}
