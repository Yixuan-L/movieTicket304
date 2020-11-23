package ui;

import database.DatabaseConnectionHandler;
import delegates.OperationDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardUI extends JFrame{
    private static final int TEXT_FIELD_WIDTH = 20;
    private DatabaseConnectionHandler dbHandler;
    private OperationDelegate delegate;

    private JTextField nameField;
    private JTextField amountField;
    private JTextField formatField;
    private JTextField genreField;
    private JTextField ratingField;
    public Integer activeField;

    public CardUI() {
        super("CardUI");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame(OperationDelegate delegate) {
        this.delegate = delegate;
        JLabel nameLabel = new JLabel("Payment Type: ");
        JLabel priceLabel = new JLabel("Amount: ");
        JLabel formatLabel = new JLabel("Card Number: ");
        JLabel genreLabel = new JLabel("CVV: ");
        JLabel ratingLabel = new JLabel("Rating: ");
        JLabel activeLabel = new JLabel("Price: ");

        nameField = new JTextField(TEXT_FIELD_WIDTH);
        amountField = new JTextField(TEXT_FIELD_WIDTH);
        formatField = new JTextField(TEXT_FIELD_WIDTH);
        genreField = new JTextField(TEXT_FIELD_WIDTH);
        ratingField = new JTextField(TEXT_FIELD_WIDTH);
//        activeField = new JTextField(TEXT_FIELD_WIDTH);


        JButton addMovie = new JButton("Pay");
//        JButton deleteMovie = new JButton("Sign Up");
//        JButton seatButton = new JButton("seat");
//        JButton orderButton = new JButton("order");
//        JButton ticketButton = new JButton("ticket");


        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);

        // layout components using the GridBag layout manager
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        // theatre button


//        String [] a = {"Card","Cash"};                //定义字符串
//        JComboBox jcombo = new JComboBox(a);                                                //实例化下拉列表
//        JList jlist = new JList(a);                                                            //实例化列表框
//        //实例化JScrollPane面板
//        JScrollPane jp = new JScrollPane(jlist);
//        jp.setPreferredSize(new Dimension(100, 200));
//        contentPane.add(jcombo);
//


        // place the type label
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(nameLabel, c);
//        contentPane.add(nameLabel);
//
//        // place the type field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(nameField, c);
//        contentPane.add(nameField);

        // place the location label
        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(priceLabel, c);
        contentPane.add(priceLabel);

        // place the location field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(amountField, c);
        contentPane.add(amountField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(formatLabel, c);
        contentPane.add(formatLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(formatField, c);
        contentPane.add(formatField);
//
        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(genreLabel, c);
        contentPane.add(genreLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(genreField, c);
        contentPane.add(genreField);
//
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(ratingLabel, c);
//        contentPane.add(ratingLabel);
//
//        // place the from date field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(ratingField, c);
//        contentPane.add(ratingField);
//
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(activeLabel, c);
//        contentPane.add(activeLabel);
//
//        // place the from date field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(activeField, c);
//        contentPane.add(activeField);


        // place the view button
        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(addMovie, c);
        contentPane.add(addMovie);

        // register customer button with action event handler
        addMovie.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent e) {
                                                delegate.makePaymentCard(Integer.valueOf(amountField.getText()), formatField.getText(), genreField.getText() );


                                           }
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

    }
}
