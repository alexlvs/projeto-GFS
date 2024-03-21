import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class API {
    private static final String API_KEY = "da2310c6ac74e16053055f77a61c735c";

    public static List<Movie> getMoviesByGenre(String genreName) {
        OkHttpClient client = new OkHttpClient();
        List<Movie> movies = new ArrayList<>();

        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&with_genres=" + genreName;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String jsonData = response.body().string();
                JSONObject jsonObject = new JSONObject(jsonData);
                JSONArray resultsArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject movieObj = resultsArray.getJSONObject(i);
                    String title = movieObj.getString("title");
                    String overview = movieObj.getString("overview");
                    movies.add(new Movie(title, overview));
                }
            } else {
                System.out.println("Erro ao fazer solicitação à API");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public static List<Serie> getSeriesByGenre(int genreId) {
        OkHttpClient client = new OkHttpClient();
        List<Serie> series = new ArrayList<>();

        String url = "https://api.themoviedb.org/3/discover/tv?api_key=" + API_KEY + "&with_genres=" + genreId;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String jsonData = response.body().string();
                JSONObject jsonObject = new JSONObject(jsonData);
                JSONArray resultsArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject serieObj = resultsArray.getJSONObject(i);
                    String name = serieObj.getString("name");
                    String overview = serieObj.getString("overview");
                    series.add(new Serie(name, overview));
                }
            } else {
                System.out.println("Erro ao fazer solicitação à API");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return series;
    }

    public static List<Movie> searchMovie(String movieTitle) {
        throw new UnsupportedOperationException("Unimplemented method 'searchMovie'");
    }

    public static List<Serie> searchSeries(String seriesTitle) {
        throw new UnsupportedOperationException("Unimplemented method 'searchSeries'");
    }
}
