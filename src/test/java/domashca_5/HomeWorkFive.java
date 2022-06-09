package domashca_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class HomeWorkFive {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    RegistrationFormPage RegistrationFormPage = new RegistrationFormPage();

    @Test
    void successfulTest() {
        //объявление переменных
        String firstname = "Mihail",
                lastname = "Lubeznow",
                userEmail = "mihail@mail.ru",
                userNumber = "1234567890",
                currentAddress = "Miami",
                Male = "Male",
                Music = "Music",
                uploadPicture = "uploadPicture",
                setSelectState = "setSelectState",
                setSelectCity = "setSelectCity",
                setSubmit = "setSubmit",
                setSubjectValue = "Maths";


        RegistrationFormPage.openPage();

        //шаги
        RegistrationFormPage.openPage()
        .setFirstName(firstname)
        .lastName(lastname)
        .userEmail(userEmail)
        .userNumber(userNumber)
        .currentAddress(currentAddress)
        //$("#currentAddress").setValue("Miami"); из чего получили более лаконичную конструкцию
        .Male(Male)
        .Music(Music)
        //$(byText("Music")).click(); из чего получили более лаконичную конструкцию
        .dateOfBirth("10", "April", "2020" )
        .uploadPicture(uploadPicture)
        .setSubjectValue(setSubjectValue)
        .setSelectState(setSelectState)
        .setSelectCity(setSelectCity)
        .setSubmit();


        //проверки
        RegistrationFormPage
                .checkResult("Student Name", "Student Name " + firstname + " " + lastname)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "10 April,2020")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "2.jpg")
                .checkResult("Address", "Miami")
                .checkResult("State and City", "NCR Noida");
    }
}

