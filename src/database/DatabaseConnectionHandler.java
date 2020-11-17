package database;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import com.mysql.jdbc.Driver;

public class DatabaseConnectionHandler {
//    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String ORACLE_URL = "jdbc:mysql://localhost:3306/304movie?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String ORACLE_USERNAME = "root";
    private static final String ORACLE_PASSWORD = "houzi25252525";

    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public DatabaseConnectionHandler() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public boolean connectToOracle() {
        try {
            System.out.println("sssssssssssssssssssasdsad");
            if (connection != null)
                connection.close();

            connection = DriverManager.getConnection(ORACLE_URL, ORACLE_USERNAME, ORACLE_PASSWORD);
            connection.setAutoCommit(false);
            System.out.println("\nConnected to Oracle!");
            return true;

        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }


    public TheatreModel[] showTheaters() {
        ArrayList<TheatreModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM THEATER";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                TheatreModel model = new TheatreModel(

                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));

                models.add(model);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return models.toArray(new TheatreModel[models.size()]);
    }

    public void updateTheaters(int id, String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE theater SET  = ? WHERE branch_id = ?");
            ps.setString(1, name);
            ps.setInt(2, id);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Branch " + id + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }


    public void updateCustomer(int id, String[] updateInfo) {
        try {
//            String[] column = new String[]{"name", "address", "email", "phoneNumber"};
//            String query = "UPDATE theater SET"
//            for(int i = 0; i < column.length; i++){
//
//            }
            String query = "Update customer set name = ?, address = ?, email = ?, phoneNumber= ? where customer_id= ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, updateInfo[0]);
            ps.setString(2, updateInfo[1] );
            ps.setString(3, updateInfo[2]);
            ps.setString(4, updateInfo[3]);
            ps.setInt(5, id);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Branch " + id + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public HallModel[] showHalls() {
        ArrayList<HallModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HALLS";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                HallModel model = new HallModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4));

                models.add(model);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return models.toArray(new HallModel[models.size()]);
    }

    public SeatModel[] showSeats() {
        ArrayList<SeatModel> models = new ArrayList<>();
        try {
                String sql = "SELECT * FROM SEATS ";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SeatModel model = new SeatModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));

                models.add(model);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return models.toArray(new SeatModel[models.size()]);
    }



    public CustomerModel[] showCustomers() {
        ArrayList<CustomerModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CUSTOMER";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CustomerModel model = new CustomerModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                models.add(model);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return models.toArray(new CustomerModel[models.size()]);
    }

    public TicketModel[] showTickets() {
        ArrayList<TicketModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TICKET";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                TicketModel model = new TicketModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
//                        rs.getString(6));
                models.add(model);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return models.toArray(new TicketModel[models.size()]);
    }

    public OrderModel[] showOrders() {
        ArrayList<OrderModel> models = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reservation";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                OrderModel model = new OrderModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                models.add(model);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return models.toArray(new OrderModel[models.size()]);
    }




}
