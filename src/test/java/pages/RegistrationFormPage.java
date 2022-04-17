package pages;

import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();

    String pageEndpoint = "/automation-practice-form";
    String practiceFormHeaderText = "Student Registration Form";
    String resultsFormHeaderText = "Thanks for submitting the form";

    //Locators
    SelenideElement practiceFormWrapper = $(".practice-form-wrapper");

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailAddress = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement genderWrapper = $("#genterWrapper");
    SelenideElement birthDateInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    SelenideElement uploadPicture = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateSelector = $("#state");
    SelenideElement citySelector = $("#city");
    SelenideElement submitButton = $("#submit");

    //Results Table Locators
    SelenideElement resultsFormTableWrapper = $("#example-modal-sizes-title-lg");
    SelenideElement resultsFormTable = $(".table-responsive");
    SelenideElement resultsTableName = resultsFormTable.
            $(byText("Student Name")).sibling(0);
    SelenideElement resultsTableEmail = resultsFormTable.
            $(byText("Student Email")).sibling(0);
    SelenideElement resultsTableGender = resultsFormTable.
            $(byText("Gender")).sibling(0);
    SelenideElement resultsTableMobilePhone = resultsFormTable.
            $(byText("Mobile")).sibling(0);
    SelenideElement resultsTableDateOfBirth = resultsFormTable.
            $(byText("Date of Birth")).sibling(0);
    SelenideElement resultsTableSubjects = resultsFormTable.
            $(byText("Subjects")).sibling(0);
    SelenideElement resultsTableHobbies = resultsFormTable.
            $(byText("Hobbies")).sibling(0);
    SelenideElement resultsTablePicture = resultsFormTable.
            $(byText("Picture")).sibling(0);
    SelenideElement resultsTableAddress = resultsFormTable.
            $(byText("Address")).sibling(0);
    SelenideElement resultsTableStateCity = resultsFormTable.
            $(byText("State and City")).sibling(0);


    SelenideElement closeResultsButton = $(".modal-footer").$("#closeLargeModal");

    //Actions
    public RegistrationFormPage openPage() {
        open(pageEndpoint);
        checkPracticeFormVisible();

        return this;
    }

    public RegistrationFormPage removeAdvertising() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setZoomLevel(double zoom) {
        zoom(zoom);

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationFormPage setEmailAddress(String emailAddress) {
        userEmailAddress.setValue(emailAddress);

        return this;
    }


    public RegistrationFormPage setGender(String gender) {
            genderWrapper.$(byTagAndText("label",gender)).click();

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjectByPartMatch(String subject, int letters) {
        subjectsInput.setValue(subject.substring(0,letters-1)).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbyCheckbox(String hobby) {
        hobbiesWrapper.$(byTagAndText("label",hobby)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String pictureFile) {
        uploadPicture.uploadFromClasspath(pictureFile);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationFormPage setState(String state) {
        stateSelector.click();
        stateSelector.$(byTagAndText("div",state)).click();

        return this;
    }

    public RegistrationFormPage setCity(String city) {
        citySelector.click();
        citySelector.$(byTagAndText("div",city)).click();

        return this;
    }

    public RegistrationFormPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationFormPage clickCloseResultsButton() {
        closeResultsButton.scrollIntoView(true).click();

        return this;
    }

    public RegistrationFormPage checkPracticeFormVisible() {
        practiceFormWrapper.shouldBe(visible)
                .shouldHave(text(practiceFormHeaderText));

        return this;
    }

    public RegistrationFormPage checkResultsTableAppeared() {
        resultsFormTableWrapper.shouldHave(text(resultsFormHeaderText));

        return this;
    }

    public RegistrationFormPage checkResultsTableName(String fullName) {
        resultsTableName.shouldHave(text(fullName));

        return this;
    }

    public RegistrationFormPage checkResultsTableEmail(String userEmail) {
        resultsTableEmail.shouldHave(text(userEmail));

        return this;
    }

    public RegistrationFormPage checkResultsTableGender(String gender) {
        resultsTableGender.shouldHave(text(gender));

        return this;
    }

    public RegistrationFormPage checkResultsTableMobilePhone(String phoneNumber) {
        resultsTableMobilePhone.shouldHave(text(phoneNumber));

        return this;
    }

    public RegistrationFormPage checkResultsTableDateOfBirth(String dateOfBirth) {
        resultsTableDateOfBirth.shouldHave(text(dateOfBirth));

        return this;
    }

    public RegistrationFormPage checkResultsTableSubjects(String subject) {
        resultsTableSubjects.shouldHave(text(subject));

        return this;
    }

    public RegistrationFormPage checkResultsTableHobbies(String hobby) {
        resultsTableHobbies.shouldHave(text(hobby));

        return this;
    }

    public RegistrationFormPage checkResultsTablePicture(String pictureName) {
        resultsTablePicture.shouldHave(text(pictureName));

        return this;
    }

    public RegistrationFormPage checkResultsTableAddress(String currentAddress) {
        resultsTableAddress.shouldHave(text(currentAddress));

        return this;
    }

    public RegistrationFormPage checkResultsTableStateCity(String state, String city) {
        resultsTableStateCity.shouldHave(text(String.format("%s %s", state, city)));

        return this;
    }

//    public RegistrationFormPage checkResultsTableSubjects(String[] subjectsList) {
//        while (subject in subjectsList) {
//            resultsTableName.shouldHave(text(subject));
//        }
//
//        String.join(", ", subjectMath, subjectEng, subjectCompSci)));
//
//        return this;
//    }


}
