package ui;

import database.DatabaseConnectionHandler;
import delegates.OperationDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 20;
    private DatabaseConnectionHandler dbHandler;
    private OperationDelegate delegate;

    private JTextField typeField;
    private JTextField locationField;
    private JTextField lanField;
    private JTextField movie_typeField;
    private JTextField seatField;
    private JTextField hallField;
    private JTextField customerField;
    private JTextField paymentField;
    private JTextField movie_StartField;
    public Integer payRecord = 0;


    public ReservationUI() {
        super("Movie Reservation");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();

//        this.payRecord = paymentUI.payment;
    }

    public void showFrame(OperationDelegate delegate) {
        this.delegate = delegate;
//        PaymentUI paymentUI = new PaymentUI();
        JLabel movieLabel = new JLabel("Movie Name: ");
        JLabel locationLabel = new JLabel("Branch: ");
        JLabel label = new JLabel("Language: ");
        JLabel movie_typeLabel = new JLabel("Movie Format:");
        JLabel seatLabel = new JLabel("Seat: ");
        JLabel customerLabel = new JLabel("Customer Name: ");
        JLabel paymentLabel = new JLabel("Payment ID: ");
        JLabel hallLabel = new JLabel("Hall: ");
        JLabel movieTime = new JLabel("Movie Start Time: ");


        typeField = new JTextField(TEXT_FIELD_WIDTH);
        movie_typeField = new JTextField(TEXT_FIELD_WIDTH);
        locationField = new JTextField(TEXT_FIELD_WIDTH);
        lanField = new JTextField(TEXT_FIELD_WIDTH);
        seatField = new JTextField(TEXT_FIELD_WIDTH);
        hallField =  new JTextField(TEXT_FIELD_WIDTH);
        movie_StartField = new JTextField(TEXT_FIELD_WIDTH);
        paymentField = new JTextField(TEXT_FIELD_WIDTH);
        customerField = new JTextField(TEXT_FIELD_WIDTH);


        JButton viewButton = new JButton("Reserve");

        JButton payButton = new JButton("Pay");

        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);

        // layout components using the GridBag layout manager
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // place the type label
        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(movieLabel, c);
        contentPane.add(movieLabel);

        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(typeField, c);
        contentPane.add(typeField);

        // place the location label
        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(locationLabel, c);
        contentPane.add(locationLabel);

        // place the location field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(locationField, c);
        contentPane.add(locationField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(label, c);
        contentPane.add(label);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(lanField, c);
        contentPane.add(lanField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(movie_typeLabel, c);
        contentPane.add(movie_typeLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(movie_typeField, c);
        contentPane.add(movie_typeField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(customerLabel, c);
        contentPane.add(customerLabel);

        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(customerField, c);
        contentPane.add(customerField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(paymentLabel, c);
        contentPane.add(paymentLabel);

        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(paymentField, c);
        contentPane.add(paymentField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(seatLabel, c);
        contentPane.add(seatLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(seatField, c);
        contentPane.add(seatField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(hallLabel, c);
        contentPane.add(hallLabel);

        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(hallField, c);
        contentPane.add(hallField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(movieTime, c);
        contentPane.add(movieTime);

        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(movie_StartField, c);
        contentPane.add(movie_StartField);


        // place the view button
        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(viewButton, c);
        contentPane.add(viewButton);

        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(payButton, c);
        contentPane.add(payButton);



        // register customer button with action event handler
//        viewButton.addActionListener(e -> this.delegate.reserve(
//                typeField.getText(),
//                locationField.getText(),
//                lanField.getText(),
//                movie_typeField.getText(),
//                seatField.getText()
//        ));

//        viewButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                paymentUI.showFrame();
//
////                payRecord = paymentUI.payment;
////                System.out.println("YYYYYYY" + dbHandler.pmt);
//////                payRecord = dbHandler.pmt;
////                System.out.println("YYYYYYY" + payRecord.toString());
//            }
//        });
//
//        payRecord = paymentUI.payment;
//        System.out.println("hello"+ payRecord.toString());

        Integer I = 0;

        payButton.addActionListener(e -> {
            CardUI cardUI = new CardUI();
            cardUI.showFrame(new OperationDelegate() {
                @Override
                public boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price) {
                    return false;
                }

                @Override
                public boolean deleteMovie(String movie_name) {
                    return false;
                }

                @Override
                public void reserve(String text, String text1, String text2, String text3, String text4) {

                }

                @Override
                public int makePaymentCash(int amount) {
                    return 0;
                }

                @Override
                public int makePaymentCard(int amount, String cardnumber, String cvv) {
                    return dbHandler.makePaymentCard(amount, cardnumber, cvv);
//                    return 0;
                }

                @Override
                public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id, String seat_id, String hall_id, String movie_start_time) {
                    return false;
                }
            });
        });


        viewButton.addActionListener( e -> {
            this.delegate.createReservation(
                    locationField.getText(),
                    typeField.getText(),
                    lanField.getText(),
                    movie_typeField.getText(),
                    customerField.getText(),
                    Integer.parseInt(paymentField.getText()),
                    seatField.getText(),
                    hallField.getText(),
                    movie_StartField.getText()
            );
        }
        );


        // size the window to obtain a best fit for the components
        this.pack();

        // center the frame
        Dimension d = this.getToolkit().getScreenSize();
        Rectangle r = this.getBounds();
        this.setLocation((d.width - r.width) / 2, (d.height - r.height) / 2);

        // make the window visible
        this.setVisible(true);
        System.out.println(payRecord.toString());

    }


}
