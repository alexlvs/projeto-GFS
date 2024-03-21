import java.util.List;
import java.util.Scanner;

public class demoGFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o filme que deseja pesquisar: ");
        String movieTitle = scanner.nextLine();
        List<Movie> searchResults = API.searchMovie(movieTitle);
        displaySearchResults(searchResults);

        
        System.out.print("Digite o nome do gênero que deseja listar os filmes: ");
        String genreName = scanner.nextLine();
        List<Movie> genreMovies = API.getMoviesByGenre(genreName);
        displayMoviesByGenre(genreName, genreMovies);

        
        System.out.print("Digite o título da série que deseja pesquisar: ");
        String seriesTitle = scanner.nextLine();
        List<Serie> seriesResults = API.searchSeries(seriesTitle);
        displaySeriesResults(seriesResults);
    }

    private static void displaySearchResults(List<Movie> movies) {
        if (!movies.isEmpty()) {
            System.out.println("Resultados da pesquisa:");
            for (Movie movie : movies) {
                System.out.println(movie.getnome() + ": " + movie.getdescricao());
            }
        } else {
            System.out.println("Nenhum filme encontrado.");
        }
    }

    private static void displayMoviesByGenre(String genreName, List<Movie> movies) {
        if (!movies.isEmpty()) {
            System.out.println("Filmes do gênero '" + genreName + "':");
            for (Movie movie : movies) {
                System.out.println(movie.getnome() + ": " + movie.getdescricao());
            }
        } else {
            System.out.println("Nenhum filme encontrado para o gênero '" + genreName + "'.");
        }
    }

    private static void displaySeriesResults(List<Serie> series) {
        if (!series.isEmpty()) {
            System.out.println("Resultados da pesquisa de séries:");
            for (Serie serie : series) {
                System.out.println(serie.getName() + ": " + serie.getdescricao());
            }
        } else {
            System.out.println("Nenhuma série encontrada.");
        }
    }
}