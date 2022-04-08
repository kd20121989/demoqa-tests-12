package guru.qa.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        }

    @Test
    void fillStudentRegistrationForm() {
        String firstName = "Dmitrii";
        String lastName = "Kudriashov";
        String userEmail = "somemail@google.com";
        String gender = "Male";
        String phoneNumber = "9675915303";
        String yearOfBirth = "1989";
        String monthOfBirth = "December";
        String dayOfBirth = "20";
        String dateOfBirth = dayOfBirth + " " + monthOfBirth + "," + yearOfBirth;
        String subjectEng = "English";
        String subjectMath = "Maths";
        String subjectCompSci = "Computer Science";
        String hobbyRead = "Reading";
        String hobbyMusic = "Music";
        String pictureFile = "photo_2020-02-25_11-37-04 - Copy.jpg";
        String currentAddress = "13 Lightning Point Drive, Memphis";
        String stateUttar = "Uttar Pradesh";
        String cityLucknow = "Lucknow";

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byTagAndText("label",gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
//        $$(".react-datepicker__week").findBy(text(dayOfBirth)).click(); This is not working...
//      $(byTagAndText("div",(monthOfBirth + " " + dayOfBirth + "th"))).click(); // This is not working
//        $$(".react-datepicker__week").findBy(text("react-datepicker__day.react-datepicker__day--020")).click(); // This is not working
        $("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > " +
                "div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(4) > " +
                "div.react-datepicker__day.react-datepicker__day--020").click(); //This is disgusting but works...
        $("#subjectsInput").setValue(subjectMath.substring(0,1)).pressEnter()
                .setValue(subjectEng.substring(0,1)).pressEnter()
                .setValue(subjectCompSci.substring(0,3)).pressEnter();
        $(byTagAndText("label",hobbyRead)).click();
        $(byTagAndText("label",hobbyMusic)).click();
        $("#uploadPicture").uploadFromClasspath(pictureFile);
        $("#currentAddress").setValue(currentAddress);
        $(byTitle("Ad.Plus Advertising")).click();
        $("#state").scrollIntoView(true).click();
        $("#state").$(byTagAndText("div",stateUttar)).click();
        $("#city").click();
        $("#city").$(byTagAndText("div",cityLucknow)).click();
        zoom(0.67);
        $("#submit").click();

        //Assertions
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(dateOfBirth));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(
                String.join(", ",subjectMath,subjectEng,subjectCompSci)));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(
                String.join(", ",hobbyRead,hobbyMusic)));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(pictureFile));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(stateUttar + " " + cityLucknow));
        $(".modal-footer").$("#closeLargeModal").scrollIntoView(true).click();
        $(".practice-form-wrapper").shouldBe(visible);

    }
}
