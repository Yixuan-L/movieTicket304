package delegates;

public interface OperationDelegate {

    boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price);
    boolean deleteMovie(String movie_name);

    void reserve(String text, String text1, String text2, String text3, String text4);


    int makePaymentCash(int amount);

    int makePaymentCard(int amount, String cardnumber, String cvv);

    boolean createReservation ( String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id , String seat_id, String hall_id, String movie_start_time);

        }
