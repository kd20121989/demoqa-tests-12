package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTest {

    @BeforeAll
    static void initDB() {
        System.out.println("### @BeforeAll");
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("### @AfterAll");
    }

    @BeforeEach
    void openYaPage() {
        Selenide.open("https://ya.ru");
        System.out.println("### @BeforeEach");
    }

    @AfterEach
    void close() {
        WebDriverRunner.closeWindow();
        System.out.println("### @AfterEach");
    }

    @Test
    void assertTest() {
        // search in news
        System.out.println("### @Test1");
    }
    @Test
    void assertTest2() {
        // search in pictures
        System.out.println("### @Test2");
    }
}
