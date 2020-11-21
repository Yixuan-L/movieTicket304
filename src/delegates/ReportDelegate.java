package delegates;



import model.BranchRevenueModel;
import model.BranchTicketModel;

import model.FormatPrice;
import oracle.sql.TIMESTAMP;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface ReportDelegate {



    void branchRevenue();
    void branchTicket();
    void formatPrice();
    void customerAllMovie();





}
