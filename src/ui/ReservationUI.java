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
    public Integer payRecord = 0;


    public ReservationUI() {
        super("Movie Reservation");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame(OperationDelegate delegate) {
        this.delegate = delegate;

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

        JButton viewButton = new JButton("Reserve");

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
        gb.setConstraints(seatLabel, c);
        contentPane.add(seatLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(seatField, c);
        contentPane.add(seatField);


        // place the view button
        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(viewButton, c);
        contentPane.add(viewButton);

        // register customer button with action event handler
//        viewButton.addActionListener(e -> this.delegate.reserve(
//                typeField.getText(),
//                locationField.getText(),
//                lanField.getText(),
//                movie_typeField.getText(),
//                seatField.getText()
//        ));

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentUI paymentUI = new PaymentUI();
                paymentUI.showFrame();

//                payRecord = paymentUI.showFrame();
                System.out.println("YYYYYYY" + paymentUI.payment.toString());
                payRecord = dbHandler.pmt;
                System.out.println("YYYYYYY" + payRecord.toString());
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
