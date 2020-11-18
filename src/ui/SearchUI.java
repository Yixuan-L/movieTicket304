package ui;

import delegates.SearchDelegate;

import javax.swing.*;
import java.awt.*;

public class SearchUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 20;

    private SearchDelegate delegate;

    private JTextField typeField;
    private JTextField locationField;
    private JTextField dateField;


    public SearchUI() {
        super("Search Movie");
    }

    public void showFrame(SearchDelegate delegate) {
        this.delegate = delegate;

        JLabel movieLabel = new JLabel("Movie Name: ");
        JLabel locationLabel = new JLabel("Branch: ");
        JLabel dateLabel = new JLabel("Date: ");


        typeField = new JTextField(TEXT_FIELD_WIDTH);
        locationField = new JTextField(TEXT_FIELD_WIDTH);
        dateField = new JTextField(TEXT_FIELD_WIDTH);

        JButton viewButton = new JButton("View");

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


        // place the view button
        c.gridwidth = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 10);
        gb.setConstraints(viewButton, c);
        contentPane.add(viewButton);

        // register customer button with action event handler
        viewButton.addActionListener(e -> this.delegate.view(
                typeField.getText(),
                locationField.getText()
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

    public static void main(String[] args) {
        SearchUI searchUI = new SearchUI();
        searchUI.showFrame(new SearchDelegate() {
            @Override
            public void view(String type, String location) {

            }
        });
    }
}
