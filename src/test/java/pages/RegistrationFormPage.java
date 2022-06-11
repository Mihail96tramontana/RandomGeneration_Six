package pages;

import pages.component.CalendarComponent;
import pages.component.ResultsTableComponent;
import pages.componentsabject.SubjectComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    public CalendarComponent calendarComponent = new CalendarComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    public SubjectComponent subjectComponent = new SubjectComponent();


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) { //дополнительная конструкция
        $("#firstName").setValue(value); //копия конструкции с локатором
        return this;
    }

    public RegistrationFormPage lastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationFormPage userEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationFormPage userNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage currentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage setMale(String value) {
        $(byText("Male")).click();
        return this;
    }

    public RegistrationFormPage setMusic(String value) {
        $(byText("Music")).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/2.jpg")); // загрузка файла
        return this;
    }

    public RegistrationFormPage setSubjectValue(String value) {
        subjectComponent.subjectComponent(value);
        return this;
    }

    public RegistrationFormPage dateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSelectState(String value) {
        $("#react-select-3-input").val("NCR").pressEnter();
        return this;
    }

    public RegistrationFormPage setSelectCity(String value) {
        $("#react-select-4-input").val("Noida").pressEnter();
        return this;
    }

    public RegistrationFormPage setSubmit() {
        $("#submit").scrollTo().click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        ResultsTableComponent.checkResult(key, value);
        return this;
    }
}