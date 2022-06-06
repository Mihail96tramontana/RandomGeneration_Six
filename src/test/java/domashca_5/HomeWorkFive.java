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

    PageObject PageObject = PageObject;

    @Test
    void successfulTest() {
        String firstname = "Mihail";
        String lastname = "Lubeznow";
        String userEmail = "mihail@mail.ru";
        String userNumber = "1234567890";
        String currentAddress = "Miami";
        String Male = "Male";
        String Music = "Music";
        String uploadPicture = "uploadPicture";
        String react-select-3-input = "react-select-3-input";

        PageObject.openPage();

        //шаги
        PageObject.openPage()
        .setFirstName(firstname)
        .lastName(lastname)
        .userEmail(userEmail)
        .userNumber(userNumber)
        .currentAddress(currentAddress);
        //$("#currentAddress").setValue("Miami"); из чего получили более лаконичную конструкцию
        .Male(Male);
        .Music(Music);
        $(byText("Music")).click(); //из чего получили более лаконичную конструкцию
        //(календарь)
        PageObject.dateOfBirth("10", "April", "2020" );
        //(календарь)
        .uploadPicture(uploadPicture);

        //subjectsInput
        $("#subjectsInput").sendKeys("m");
        $(byText("Maths")).pressEnter();
        //subjectsInput

        PageObject.react-select-3-input(react-select-3-input);
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

