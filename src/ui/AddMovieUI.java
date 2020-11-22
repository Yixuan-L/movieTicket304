package ui;

import database.DatabaseConnectionHandler;
import delegates.AccountDelegate;
import delegates.OperationDelegate;

import javax.swing.*;
import java.awt.*;

public class AddMovieUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 20;
    private DatabaseConnectionHandler dbHandler;
    private OperationDelegate delegate;

    private JTextField nameField;
    private JTextField languageField;
    private JTextField formatField;
    private JTextField genreField;
    private JTextField ratingField;
    private JTextField activeField;

    public AddMovieUI() {
        super("AddMovie");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame(OperationDelegate delegate) {
        this.delegate = delegate;
        JLabel nameLabel = new JLabel("Movie Name: ");
        JLabel langLabel = new JLabel("Language: ");
        JLabel formatLabel = new JLabel("Format: ");
        JLabel genreLabel = new JLabel("Genre: ");
        JLabel ratingLabel = new JLabel("Rating: ");
        JLabel activeLabel = new JLabel("Price: ");

        nameField = new JTextField(TEXT_FIELD_WIDTH);
        languageField = new JTextField(TEXT_FIELD_WIDTH);
        formatField = new JTextField(TEXT_FIELD_WIDTH);
        genreField = new JTextField(TEXT_FIELD_WIDTH);
        ratingField = new JTextField(TEXT_FIELD_WIDTH);
        activeField = new JTextField(TEXT_FIELD_WIDTH);


        JButton addMovie = new JButton("Add Movie");
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
        gb.setConstraints(langLabel, c);
        contentPane.add(langLabel);

        // place the location field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(languageField, c);
        contentPane.add(languageField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(formatLabel, c);
        contentPane.add(formatLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(formatField, c);
        contentPane.add(formatField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(genreLabel, c);
        contentPane.add(genreLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(genreField, c);
        contentPane.add(genreField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(ratingLabel, c);
        contentPane.add(ratingLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(ratingField, c);
        contentPane.add(ratingField);

        c.gridwidth = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        gb.setConstraints(activeLabel, c);
        contentPane.add(activeLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(activeField, c);
        contentPane.add(activeField);


        // place the view button
        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(addMovie, c);
        contentPane.add(addMovie);

        // register customer button with action event handler
        addMovie.addActionListener(e -> this.delegate.addMovie(
                nameField.getText(),
                languageField.getText(),
                formatField.getText(),
                genreField.getText(),
                ratingField.getText(),
                Double.parseDouble(activeField.getText())
        ));

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
