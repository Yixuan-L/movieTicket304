package ui;

import database.DatabaseConnectionHandler;
import delegates.DatabaseDelegate;
import delegates.OperationDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OperationUI extends JFrame{
    private OperationDelegate delegate;

    private DatabaseConnectionHandler dbHandler;

    public OperationUI() {
        super("Theater Operation");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame(OperationDelegate delegate) {
        this.delegate = delegate;

        JButton addMovie = new JButton("Add Movie");
        JButton deleteMovie = new JButton("Delete Movie");
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

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(addMovie, c);
        contentPane.add(addMovie);
        addMovie.addActionListener(e -> new AddMovieUI().showFrame(new OperationDelegate() {
            @Override
            public boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price) {
                return dbHandler.addMovie(movie_name, language, format, movie_genre,firm_rating, price);
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
                return 0;
            }

            @Override
            public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id, String seat_id, String hall_id, String movie_start_time) {
                return false;
            }
//
//            @Override
//            public void pay(String payment_type, Integer amount) {
//
//            }
        }));


        // place the hall button
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 0, 10, 0);
        gb.setConstraints(deleteMovie, c);
        contentPane.add(deleteMovie);
//        deleteMovie.addActionListener(e -> this.delegate.deleteMovie("2012"));
        deleteMovie.addActionListener(e -> new RemoveMovieUI().showFrame(new OperationDelegate() {
            @Override
            public boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price) {
                return false;
            }

            @Override
            public boolean deleteMovie(String movie_name) {
                return dbHandler.deleteMovie(movie_name);
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
                return 0;
            }

            @Override
            public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id, String seat_id, String hall_id, String movie_start_time) {
                return false;
            }

//            @Override
//            public void pay(String payment_type, Integer amount) {
//
//            }
        }));
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
