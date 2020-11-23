package ui;

import database.DatabaseConnectionHandler;
import delegates.OperationDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 20;
    private DatabaseConnectionHandler dbHandler;
    private OperationDelegate delegate;

    private JTextField nameField;
    private JTextField amountField;
    private JTextField formatField;
    private JTextField genreField;
    private JTextField ratingField;
    private JTextField activeField;
    public Integer payment;

    public PaymentUI() {
        super("PaymentUI");
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.connectToOracle();
    }

    public void showFrame() {
        this.delegate = delegate;
        JLabel nameLabel = new JLabel("Payment Type: ");
        JLabel priceLabel = new JLabel("Amount: ");
        JLabel formatLabel = new JLabel("Format: ");
        JLabel genreLabel = new JLabel("Genre: ");
        JLabel ratingLabel = new JLabel("Rating: ");
        JLabel activeLabel = new JLabel("Price: ");

        nameField = new JTextField(TEXT_FIELD_WIDTH);
        amountField = new JTextField(TEXT_FIELD_WIDTH);
        formatField = new JTextField(TEXT_FIELD_WIDTH);
        genreField = new JTextField(TEXT_FIELD_WIDTH);
        ratingField = new JTextField(TEXT_FIELD_WIDTH);
        activeField = new JTextField(TEXT_FIELD_WIDTH);


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


        String [] a = {"Card"};                //定义字符串
        JComboBox jcombo = new JComboBox(a);                                                //实例化下拉列表
        JList jlist = new JList(a);                                                            //实例化列表框
        //实例化JScrollPane面板
        JScrollPane jp = new JScrollPane(jlist);
        jp.setPreferredSize(new Dimension(100, 200));
        contentPane.add(jcombo);



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

//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(formatLabel, c);
//        contentPane.add(formatLabel);
//
//        // place the from date field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(formatField, c);
//        contentPane.add(formatField);
//
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.insets = new Insets(0, 0, 0, 10);
//        gb.setConstraints(genreLabel, c);
//        contentPane.add(genreLabel);
//
//        // place the from date field
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.insets = new Insets(0, 0, 0, 0);
//        gb.setConstraints(genreField, c);
//        contentPane.add(genreField);
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
                                           if (jcombo.getSelectedItem().toString() == "Card") {
                                               CardUI ui = new CardUI();
                                               ui.showFrame(new OperationDelegate() {
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
                                                       payment = dbHandler.makePaymentCard(amount, cardnumber, cvv);
                                                       System.out.println("CARD" + payment.toString());
                                                       return payment;
                                                   }

                                                   @Override
                                                   public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id, String seat_id, String hall_id, String movie_start_time) {
                                                       return false;
                                                   }
                                               });
//                                               new CardUI().showFrame() {
//
//                                                   @Override
//                                                   public boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price) {
//                                                       return false;
//                                                   }
//
//                                                   @Override
//                                                   public boolean deleteMovie(String movie_name) {
//                                                       return false;
//                                                   }
//
//                                                   @Override
//                                                   public void reserve(String text, String text1, String text2, String text3, String text4) {
//
//                                                   }
//
//                                                   @Override
//                                                   public int makePaymentCash(int amount) {
//                                                       return 0;
//                                                   }
//
//                                                   @Override
//                                                   public int makePaymentCard(int amount, String cardnumber, String cvv) {
//                                                       payment = dbHandler.makePaymentCard(amount, cardnumber, cvv);
//                                                       System.out.println("CARD" + payment.toString());
//                                                       return payment;
                                           }

                                           else if (jcombo.getSelectedItem().toString() == "Cash") {
                                               CashUI ui = new CashUI();
                                               ui.showFrame(new OperationDelegate() {
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
                                                       payment = dbHandler.makePaymentCash(amount);
                                                       System.out.println("CASH" + payment.toString());
                                                       return payment;
                                                   }

                                                   @Override
                                                   public int makePaymentCard(int amount, String cardnumber, String cvv) {
                                                       return 0;
                                                   }

                                                   @Override
                                                   public boolean createReservation(String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id, String seat_id, String hall_id, String movie_start_time) {
                                                       return false;
                                                   }
                                               });
//                                               new CashUI().showFrame(new OperationDelegate() {
//                                                   @Override
//                                                   public boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price) {
//                                                       return false;
//                                                   }
//
//                                                   @Override
//                                                   public boolean deleteMovie(String movie_name) {
//                                                       return false;
//                                                   }
//
//                                                   @Override
//                                                   public void reserve(String text, String text1, String text2, String text3, String text4) {
//
//                                                   }
//
//                                                   @Override
//                                                   public int makePaymentCash(int amount) {
//                                                       payment = dbHandler.makePaymentCash(amount);
//                                                       System.out.println("CASH" + payment.toString());
//                                                       return payment;
//                                                   }
//
//                                                   @Override
//                                                   public int makePaymentCard(int amount, String cardnumber, String cvv) {
//                                                       return 0;
//                                                   }
//                                               });
                                           }
                                       }
                                   }
        );


        // size the window to obtain a best fit for the components

        System.out.println("FINALL" + payment);
        this.pack();

        // center the frame
        Dimension d = this.getToolkit().getScreenSize();
        Rectangle r = this.getBounds();
        this.setLocation((d.width - r.width) / 2, (d.height - r.height) / 2);

        // make the window visible
        this.setVisible(true);

    }

    public static void main(String[] args) {
        PaymentUI paymentUI = new PaymentUI();
//        paymentUI.showFrame(new OperationDelegate() {
//            @Override
//            public boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price) {
//                return false;
//            }
//
//            @Override
//            public boolean deleteMovie(String movie_name) {
//                return false;
//            }
//
//            @Override
//            public void reserve(String text, String text1, String text2, String text3, String text4) {
//
//            }
//
//            @Override
//            public int makePaymentCash(int amount) {
//                return 0;
//            }
//
//            @Override
//            public int makePaymentCard(int amount, String cardnumber, String cvv) {
//                return 0;
//            }
//
////            @Override
////            public void pay(String payment_type, Integer amount) {
////
////            }
//        });
//        SearchUI searchUI = new SearchUI();
//        searchUI.showFrame(new SearchDelegate() {
//            @Override
//            public MovieModel[] view(String selectedItem, String type) {
////                return dbhan
//
//            }
//
//            @Override
//            public void show() {
//
//            }
////            @Override
////            public void view(String selectedItem, String type) {
////
////            }
//
////            @Override
////            public void view(Object selectedItem, String type) {
////
////            }
//
////            @Override
////            public void view(String type, String location) {
////
////            }
//        });
//    }
    }

}
