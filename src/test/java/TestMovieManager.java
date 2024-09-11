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
    public void testGetAllDefault() {

        String[] exp = new String[0];
        String[] act = testMovieManager.findAll();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test // Добавить фильм в список.
    public void testAddNewMovie() {

        testMovieManager.addNewMovie(testName);
        String[] exp = {"Матрица"};
        String[] act = testMovieManager.findAll();

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

        String[] exp = {"Матрица", "Матрица1", "Матрица2", "Матрица3", "Матрица4", "Матрица5", "Матрица6"};
        String[] act = testMovieManager.findAll();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testFindLastUserMaxValidCount() { // Получить реверсивный список, настройка пользователя, максимальный валидный счётчик.
        MovieManager testMovieManager = new MovieManager(7);

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6", "Матрица5", "Матрица4", "Матрица3", "Матрица2", "Матрица1", "Матрица"};
        String[] act = testMovieManager.findLast();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testFindLastUserMinValidCount() { // Получить реверсивный список, настройка пользователя, минимальный валидный счётчик.
        MovieManager testMovieManager = new MovieManager(1);

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6"};
        String[] act = testMovieManager.findLast();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testFindLastUserRandomValidCount() { // Получить реверсивный список, настройка пользователя, случайный валидный счётчик.
        MovieManager testMovieManager = new MovieManager(3);

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6", "Матрица5", "Матрица4"};
        String[] act = testMovieManager.findLast();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testFindLastUserOverMaxCountByOne() { // Реверсивный список, настройка пользователя, невалидный счётик, выше максимума на 1.

        MovieManager testMovieManager = new MovieManager(8);

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6", "Матрица5", "Матрица4", "Матрица3", "Матрица2", "Матрица1", "Матрица"};
        String[] act = testMovieManager.findLast();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testFindLastUserCountZero() { // Реверсивный список, настройка пользователя, невалидный счётик,  0.
        MovieManager testMovieManager = new MovieManager(0);

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);


        String[] exp = {"Матрица6", "Матрица5", "Матрица4", "Матрица3", "Матрица2"};
        String[] act = testMovieManager.findLast();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testFindLastUserCountBelowZero() { // Реверсивный список, настройка пользователя, невалидный счётик, меньше нуля.
        MovieManager testMovieManager = new MovieManager(-1);

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6", "Матрица5", "Матрица4", "Матрица3", "Матрица2"};
        String[] act = testMovieManager.findLast();

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void testFindLastDefault() { // Получить реверсивный список, настройка по умолчанию.

        testMovieManager.addNewMovie(testName);
        testMovieManager.addNewMovie(testName1);
        testMovieManager.addNewMovie(testName2);
        testMovieManager.addNewMovie(testName3);
        testMovieManager.addNewMovie(testName4);
        testMovieManager.addNewMovie(testName5);
        testMovieManager.addNewMovie(testName6);

        String[] exp = {"Матрица6", "Матрица5", "Матрица4", "Матрица3", "Матрица2"};
        String[] act = testMovieManager.findLast();

        Assertions.assertArrayEquals(exp, act);

    }

}

