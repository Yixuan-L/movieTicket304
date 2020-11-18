package delegates;

import model.BranchRevenueModel;
import model.BranchTicketModel;
import model.CustomerModel;
import model.FormatPrice;
import oracle.sql.TIMESTAMP;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface DatabaseDelegate {


    void showCustomers();
    void showHalls();
    void showTheaters();
    void showTickets();
    void showSeats();
    void showOrders();
    void  showCard() throws SQLException;
    void  showMovie() throws SQLException;
    void showCash() throws SQLException;

    void updateCustomer(int id , String[] updateInfo);
    int makePaymentCash(int amount);
    int makePaymentCard(int amount, String cardnumber, String cvv);
    boolean createReservation (String branch_name, String movie_name, String movie_language, String movie_format, String customer_name, int payment_id, String seat_id, String hall_id,  String movie_start_time );

    BranchRevenueModel[] branchRevenue();
    BranchTicketModel[] branchTicket();
    FormatPrice[] formatPrice();
    void customerAllMovie();

    boolean deleteMovie(String moviename);


//    boolean addMovie(int movie_id, String movie_name, String language, String format, String movie_genre, String firm_rating, int active_date);

}
