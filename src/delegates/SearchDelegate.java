package delegates;

import model.MovieModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SearchDelegate {
    ArrayList<MovieModel> view(String selectedItem, String type);
    void show();
    void project(String selectedItem, String c1, String c2, String c3, String type) throws SQLException;
}
