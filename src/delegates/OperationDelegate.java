package delegates;

public interface OperationDelegate {

    boolean addMovie(String movie_name, String language, String format, String movie_genre, String firm_rating, double price);
    boolean deleteMovie(String movie_name);

    void reserve(String text, String text1, String text2, String text3, String text4);


    int makePaymentCash(int amount);

    int makePaymentCard(int amount, String cardnumber, String cvv);
}
