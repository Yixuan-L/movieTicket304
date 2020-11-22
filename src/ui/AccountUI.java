package ui;

import database.DatabaseConnectionHandler;
import delegates.AccountDelegate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccountUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 20;
    private DatabaseConnectionHandler dbHandler;
    private AccountDelegate delegate;

    private JTextField nameField;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField idField;
    private String[] updateInfo;

    public AccountUI() {
        super("Account");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame(AccountDelegate delegate) {
        this.delegate = delegate;
        JLabel idLabel = new JLabel("ID: ");
        JLabel nameLabel = new JLabel("Name: ");
        JLabel addressLabel = new JLabel("Address: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel phoneLabel = new JLabel("Phone: ");
//        JLabel idLabel = new JLabel("ID: ");

        nameField = new JTextField(TEXT_FIELD_WIDTH);
        addressField = new JTextField(TEXT_FIELD_WIDTH);
        emailField = new JTextField(TEXT_FIELD_WIDTH);
        phoneField = new JTextField(TEXT_FIELD_WIDTH);
        idField = new JTextField(TEXT_FIELD_WIDTH);

        JButton update_account = new JButton("Update Account");
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

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(idLabel, c);
        contentPane.add(idLabel);

        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(idField, c);
        contentPane.add(idField);

        // place the type label
        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(nameLabel, c);
        contentPane.add(nameLabel);

        // place the type field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(nameField, c);
        contentPane.add(nameField);

        // place the location label
        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(addressLabel, c);
        contentPane.add(addressLabel);

        // place the location field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(addressField, c);
        contentPane.add(addressField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(emailLabel, c);
        contentPane.add(emailLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(emailField, c);
        contentPane.add(emailField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(phoneLabel, c);
        contentPane.add(phoneLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(phoneField, c);
        contentPane.add(phoneField);


        // place the view button
        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(update_account, c);
        contentPane.add(update_account);

        // register customer button with action event handler

//        System.out.println(updateInfo[0]);
        update_account.addActionListener(e ->
                dbHandler.updateCustomer(
                        Integer.parseInt(idField.getText()),
                        new String[]{
                                nameField.getText(),
                                addressField.getText(),
                                emailField.getText(),
                                phoneField.getText()}
                )
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

//    public static void main(String[] args) {
//        AccountUI searchUI = new AccountUI();
//        searchUI.showFrame(new AccountDelegate() {
//
//            @Override
//            public void updateCustomer(int id, String[] updateInfo) {
//
//            }
//
//            @Override
//            public void signupAccount() {
//
//            }
//        }
//    );
//    }
}
