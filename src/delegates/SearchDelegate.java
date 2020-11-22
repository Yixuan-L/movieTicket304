package delegates;

import model.MovieModel;

import java.util.ArrayList;

public interface SearchDelegate {
    ArrayList<MovieModel> view(String selectedItem, String type);
    void show();
}
