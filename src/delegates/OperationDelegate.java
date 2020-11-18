package delegates;

public interface OperationDelegate {
    boolean addMovie(int movie_id, String movie_name, String language, String format, String movie_genre, String firm_rating, int active_date);
    boolean deleteMovie(String movie_name);
}
