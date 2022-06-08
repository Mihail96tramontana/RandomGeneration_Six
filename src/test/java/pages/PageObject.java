package pages;

import pages.component.CalendarComponent;
import pages.component.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageObject {

public  CalendarComponent calendarComponent = new CalendarComponent();
public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
public


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
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg")); // загрузка файла
        return this;
    }
    public PageObject setSubjectValue(String value) {
        $("#setSubjectValue").val("NCR").pressEnter();
        $(byText("Maths")).pressEnter();
        return this;
    }
    public PageObject dateOfBirth (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public PageObject setSelectState (String value) {
        $("#setSelectState").val("NCR").pressEnter();
        return this;
    }
    public PageObject setSelectCity (String value) {
        $("#setSelectCity").val("Noida").pressEnter();
        return this;
    }
    public PageObject setSubmit (String value) {
        $("#setSubmit").click();
    }
}