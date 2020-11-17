package delegates;

public interface DatabaseDelegate {


    void showCustomers();
    void showHalls();
    void showTheaters();
    void showTickets();
    void showSeats();
    void showOrders();
    void updateCustomer(int id , String[] updateInfo);
    int makePaymentCash(int amount);
    int makePaymentCard(int amount, String cardnumber, String cvv);
    boolean createReservation ( String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id );


    boolean deleteMovie(String moviename);

}
