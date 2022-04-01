package guru.qa.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class PracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }
}
