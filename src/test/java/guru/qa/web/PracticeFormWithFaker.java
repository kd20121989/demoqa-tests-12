package guru.qa.web;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;


public class PracticeFormWithFaker {

    Faker faker = new Faker();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        }

    @Test
    void fillStudentRegistrationForm() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = String.format("%s %s", firstName, lastName);
        String userEmail = faker.internet().emailAddress();
        String genderMale = "Male";
        String genderFemale = "Female";
        String genderOther = "Other";
        String phoneNumber = faker.number().digits(10);
        String yearOfBirth = "1989";
        String monthOfBirth = "December";
        String dayOfBirth = "20";
        String dateOfBirth = dayOfBirth + " " + monthOfBirth + "," + yearOfBirth;
        String subjectEng = "English";
        String subjectMath = "Maths";
        String subjectCompSci = "Computer Science";
        String hobbyRead = "Reading";
        String hobbyMusic = "Music";
        String pictureName = "photo_2020-02-25_11-37-04 - Copy.jpg";
        String currentAddress = faker.address().fullAddress();
        String stateUttar = "Uttar Pradesh";
        String cityLucknow = "Lucknow";


        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        registrationFormPage
                .openPage()
                .removeAdvertising()
                .setZoomLevel(0.75)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailAddress(userEmail)
                .setGender(genderMale)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectByPartMatch(subjectMath,2)
                .setSubjectByPartMatch(subjectEng, 2)
                .setSubjectByPartMatch(subjectCompSci, 4)
                .setHobbyCheckbox(hobbyRead)
                .setHobbyCheckbox(hobbyMusic)
                .uploadPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setState(stateUttar)
                .setCity(cityLucknow)
                .clickSubmitButton()
                .checkResultsTableAppeared()
                .checkResultsTableName(fullName)
                .checkResultsTableEmail(userEmail)
                .checkResultsTableGender(genderMale)
                .checkResultsTableMobilePhone(phoneNumber)
                .checkResultsTableDateOfBirth(dateOfBirth)
                .checkResultsTableSubjects(subjectMath)
                .checkResultsTableSubjects(subjectEng)
                .checkResultsTableSubjects(subjectCompSci)
                .checkResultsTableHobbies(hobbyRead)
                .checkResultsTableHobbies(hobbyMusic)
                .checkResultsTablePicture(pictureName)
                .checkResultsTableAddress(currentAddress)
                .checkResultsTableStateCity(stateUttar,cityLucknow)
                .clickCloseResultsButton()
                .checkPracticeFormVisible();
    }
}
