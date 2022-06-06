package domashca_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PageObject;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class HomeWorkFive {
}

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        String firstname = "Mihail";
        String lastname = "Lubeznow";
        String userEmail = "mihail@mail.ru";
        String userNumber = "1234567890";
        String currentAddress = "Miami";
        String Male = "Male";
        String Music = "Music";


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //шаги
        new PageObject().setFirstName(firstname);
        new PageObject().lastName(lastname);
        new PageObject().userEmail(userEmail);
        new PageObject().userNumber(userNumber);
        new PageObject().currentAddress(currentAddress);
        //$("#currentAddress").setValue("Miami"); из чего получили более лаконичную конструкцию
        new PageObject().Male(Male);
        new PageObject().Music(Music);
        $(byText("Music")).click(); //из чего получили более лаконичную конструкцию
        //(календарь)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("April")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2020")).click();
        $(byText("10")).click();
        //(календарь)
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg")); // загрузка файла
        $("#subjectsInput").sendKeys("m");
        $(byText("Maths")).pressEnter();
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Noida").pressEnter();
        $("#submit").click();

        //проверки
        $(".modal-content").shouldHave(text("Mihail Lubeznow"),
                text("mihail@mail.ru"),
                text("Male"),
                text("1234567890"),
                text("10 April,2020"),
                text("Maths"),
                text("Music"),
                text("1.jpg"),
                text("Miami"),
                text("NCR Noida"));
    }
}

