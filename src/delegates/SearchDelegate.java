package delegates;

import model.MovieModel;

public interface SearchDelegate {
    MovieModel[] view(String selectedItem, String type);
    void show();
}
