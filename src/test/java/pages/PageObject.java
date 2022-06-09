package pages;

import pages.component.CalendarComponent;
import pages.component.ResultsTableComponent;
import pages.componentsabject.SubjectComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageObject {

    public CalendarComponent calendarComponent = new CalendarComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    public SubjectComponent subjectComponent = new SubjectComponent();


    public PageObject openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public PageObject setFirstName(String value) { //дополнительная конструкция
        $("#firstName").setValue(value); //копия конструкции с локатором
        return this;
    }

    public PageObject lastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public PageObject userEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public PageObject userNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public PageObject currentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public PageObject Male(String value) {
        $(byText("Male")).click();
        return this;
    }

    public PageObject Music(String value) {
        $(byText("Music")).click();
        return this;
    }

    public PageObject uploadPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/2.jpg")); // загрузка файла
        return this;
    }

    public PageObject setSubjectValue(String value) {
        $("#subjectsInput").pressEnter();
        subjectComponent.subjectComponent("Maths");
        return this;
    }

    public PageObject dateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PageObject setSelectState(String value) {
        $("#react-select-3-input").val("NCR").pressEnter();
        return this;
    }

    public PageObject setSelectCity(String value) {
        $("#react-select-4-input").val("Noida").pressEnter();
        return this;
    }

    public PageObject setSubmit(String value) {
        $("#setSubmit").click();
        return this;
    }

    public PageObject checkResult(String key, String value) {
        ResultsTableComponent.checkResult(key, value);
        return this;
    }
}