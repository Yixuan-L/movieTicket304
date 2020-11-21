package ui;

import delegates.OperationDelegate;
import delegates.SearchDelegate;

import javax.swing.*;
import java.awt.*;

public class ReservationUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 20;

    private OperationDelegate delegate;

    private JTextField typeField;
    private JTextField locationField;
    private JTextField dateField;
    private JTextField movie_typeField;
    private JTextField seatField;


    public ReservationUI() {
        super("Movie Reservation");
    }

    public void showFrame(OperationDelegate delegate) {
        this.delegate = delegate;

        JLabel movieLabel = new JLabel("Movie Name: ");
        JLabel locationLabel = new JLabel("Branch: ");
        JLabel dateLabel = new JLabel("Date: ");
        JLabel movie_typeLabel = new JLabel("Movie Type:");
        JLabel seatLabel = new JLabel("Seat: ");


        typeField = new JTextField(TEXT_FIELD_WIDTH);
        movie_typeField = new JTextField(TEXT_FIELD_WIDTH);
        locationField = new JTextField(TEXT_FIELD_WIDTH);
        dateField = new JTextField(TEXT_FIELD_WIDTH);
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
        gb.setConstraints(dateLabel, c);
        contentPane.add(dateLabel);

        // place the from date field
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 0, 0);
        gb.setConstraints(dateField, c);
        contentPane.add(dateField);

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
        viewButton.addActionListener(e -> this.delegate.reserve(
                typeField.getText(),
                locationField.getText(),
                dateField.getText(),
                movie_typeField.getText(),
                seatField.getText()
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
