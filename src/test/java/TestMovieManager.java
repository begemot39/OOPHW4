import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestMovieManager {

    public String testName = "Матрица";
    public String testName1 = "Матрица1";
    public String testName2 = "Матрица2";
    public String testName3 = "Матрица3";
    public String testName4 = "Матрица4";
    public String testName5 = "Матрица5";
    public String testName6 = "Матрица6";
    MovieManager testMovieManager = new MovieManager();


    @Test // Получить счётчик фильмов, настройка по умолчанию.
    public void testGetMovieCountDefault() {

        int exp = 5;
        int act = testMovieManager.getMovieCount();

        Assertions.assertEquals(exp, act);
    }

    @Test // Получить счётчик фильмов, валидная настройка пользователя.
    public void testGetMovieCountUserValid() {
        MovieManager testMovieManager = new MovieManager(10);

        int exp = 10;
        int act = testMovieManager.getMovieCount();

        Assertions.assertEquals(exp, act);
    }

    @Test // Получить счётчик фильмов, невалидная настройка пользователя.
    public void testGetMovieCountUserInvalid() {
        MovieManager testMovieManager = new MovieManager(-10);

        int exp = 5;
        int act = testMovieManager.getMovieCount();

        Assertions.assertEquals(exp, act);
    }

    @Test // Получить список фильмов, настройка по умолчанию.
    public void testGetAllMoviesDefault() {

        String[] exp = new String[0];
        String[] act = testMovieManager.getAllMovies();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test // Добавить фильм в список.
    public void testAddNewMovie() {

        testMovieManager.addNewMovie(testName);
        String[] exp = {"Матрица"};
        String[] act = testMovieManager.getAllMovies();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test // Вывести список несколько фильмов.
    public void testAddFewNewMovies() {

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица","Матрица1","Матрица2","Матрица3","Матрица4","Матрица5","Матрица6"};
        String[] act = testMovieManager.getAllMovies();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test // Получить реверсивный список, настройка пользователя, максимальный валидный счётчик.
    public void testGetReverseMovieUserValidMaxCount() {

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6","Матрица5","Матрица4","Матрица3","Матрица2","Матрица1","Матрица"};
        String[] act = testMovieManager.getReverseMovieUser(testMovieManager.getAllMovies(), 7);

        Assertions.assertArrayEquals( exp, act );

    }

    @Test // Получить реверсивный список, настройка пользователя, счётчик 1.
    public void testGetReverseMovieUserOneCount() {

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6"};
        String[] act = testMovieManager.getReverseMovieUser(testMovieManager.getAllMovies(), 1);

        Assertions.assertArrayEquals( exp, act );

    }

    @Test // Получить реверсивный список, настройка пользователя, невалидный отрицательный счётчик.
    public void testGetReverseMovieUserNegativeCount() {

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = null;
        String[] act = testMovieManager.getReverseMovieUser(testMovieManager.getAllMovies(), -7);

        Assertions.assertArrayEquals( exp, act );

    }

    @Test // Получить реверсивный список, настройка пользователя, невалидный  счётчик, больше размера массива фильмов.
    public void testGetReverseMovieUserBiggerInvalidCount() {

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = null;
        String[] act = testMovieManager.getReverseMovieUser(testMovieManager.getAllMovies(), 17);

        Assertions.assertArrayEquals( exp, act );

    }


    @Test // Получить реверсивный список, настройка по умолчанию.
    public void testGetReverseMovieDefault() {

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6","Матрица5","Матрица4","Матрица3", "Матрица2"};
        String[] act = testMovieManager.getReverseMovieDefault( testMovieManager.getAllMovies());

        Assertions.assertArrayEquals( exp, act );

    }
}

