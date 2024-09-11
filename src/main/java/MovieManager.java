public class MovieManager {
    private String[] moviesList; // Массив фильмов.
    private int moviesCount; // Счётчик добавленных фильмов.

    // Конструкторы
    public MovieManager(int userMoviesCount) { // Задать пользовательский пул фильмов
        if (userMoviesCount > 0) {
            this.moviesCount = userMoviesCount;
        } else {
            this.moviesCount = 5;
        }
        this.moviesList = new String[0];
    }

    public MovieManager() { // Задать размер пула фильмов по умолчанию.
        this.moviesCount = 5;
        this.moviesList = new String[0];
    }

    // Действия
    public int getMovieCount() { // Получить счётчик количества фильмов.
        return moviesCount;
    }

    public String[] findAll() { // Получить список фильмов.
        return moviesList;
    }

    public void addNewMovie(String userMovie) { // Добавить новый фильм.

        String[] tmp = new String[moviesList.length + 1];

        for (int i = 0; i < moviesList.length; i++) {
            tmp[i] = moviesList[i];
        }
        tmp[tmp.length - 1] = userMovie;
        moviesList = tmp;

    }

    public String[] findLast() { // Вывести реверсивный список фильмов, настройки по умолчанию.

        int movCount = moviesList.length; // Фактический список фильмов
        int userMovCount = moviesCount; // Список фильмов пользователя.

        if (userMovCount > movCount) {
            userMovCount = movCount;
        }

        String[] reverseMovieList = new String[userMovCount];

        for (int i = 0; i < userMovCount; i++) {
            reverseMovieList[i] = moviesList[movCount - 1 - i];

        }

        return reverseMovieList;

    }
}
