package pages;

import pages.component.CalendarComponent;
import pages.component.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageObject {

public  CalendarComponent CalendarComponent = new CalendarComponent();
public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();


    public PageObject openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PageObject setFirstName (String value) { //дополнительная конструкция
        $("#firstName").setValue(value); //копия конструкции с локатором

        return this;
    }

    public PageObject lastName (String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public PageObject userEmail (String value) {
        $("#userEmail").setValue(value);

        return this;
    }
    public PageObject userNumber (String value) {
        $("#userNumber").setValue(value);

        return this;
    }
    public PageObject currentAddress (String value) {
        $("#currentAddress").setValue(value);

        return this;
    }
    public PageObject Male (String value) {
        $(byText("Male")).click();

        return this;
    }
    public PageObject Music (String value) {
        $(byText("Music")).click();

        return this;
    }
    public PageObject uploadPicture (String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg")); // загрузка файла

        return this;
    }
    public PageObject react-select-3-input (String value) {
        $("#react-select-3-input").val("NCR").pressEnter();
    }
    public PageObject dateOfBirth (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        CalendarComponent.setDate(day, month, year);

        return this;
    }
}