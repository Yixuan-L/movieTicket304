package delegates;

import model.BranchRevenueModel;
import model.BranchTicketModel;
import model.CustomerModel;
import model.FormatPrice;

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

    BranchRevenueModel[] branchRevenue();
    BranchTicketModel[] branchTicket();
    FormatPrice[] formatPrice();
    void customerAllMovie();

    boolean deleteMovie(String moviename);

}
