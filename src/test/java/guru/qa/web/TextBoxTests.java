package guru.qa.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {

        String name = "Dmitrii Kudriashov";
        String email = "kd20121989@gmail.com";
        String curAddr = "Some Street in Some City";
        String permAddr = "Same street in same city";

        open("/text-box");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(curAddr);
        $("[id=permanentAddress]").setValue(permAddr);
        $("#submit").scrollIntoView(true).click();

        //Asserts
        $("[id=output] [id=name]").shouldHave(text(name));
        $("[id=output]").$("[id=email]").shouldHave(text(email));
        $("[id=output]").$("[id=currentAddress]").shouldHave(text(curAddr));
        $("#output").$("#permanentAddress").shouldHave(text(permAddr));
    }
}
