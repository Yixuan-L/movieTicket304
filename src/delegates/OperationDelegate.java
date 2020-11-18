package delegates;

public interface OperationDelegate {
    boolean addMovie( String movie_name, String language, String format, String movie_genre, String firm_rating);
    boolean deleteMovie(String movie_name);
}
