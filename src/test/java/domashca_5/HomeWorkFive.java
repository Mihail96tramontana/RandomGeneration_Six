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
                setMale = "Male",
                setMusic = "Music",
                uploadPicture = "2.jpg",
                setSelectState = "NCR",
                setSelectCity = "Noida",
                setSubmit = "Submit",
                setSubjectValue = "Maths",
                dateOfBirth = "10 April,2020";


        RegistrationFormPage.openPage();

        //шаги
        RegistrationFormPage.openPage()
        .setFirstName(firstname)
        .lastName(lastname)
        .userEmail(userEmail)
        .userNumber(userNumber)
        .currentAddress(currentAddress)
        //$("#currentAddress").setValue("Miami"); из чего получили более лаконичную конструкцию
        .setMale(setMale)
        .setMusic(setMusic)
        //$(byText("Music")).click(); из чего получили более лаконичную конструкцию
        .dateOfBirth("10", "April", "2020" )
        .uploadPicture(uploadPicture)
        .setSubjectValue(setSubjectValue)
        .setSelectState(setSelectState)
        .setSelectCity(setSelectCity)
        .setSubmit();


        //проверки
        RegistrationFormPage
                .checkResult("Student Name", firstname + " " + lastname)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", setMale)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateOfBirth)
                .checkResult("Subjects", setSubjectValue)
                .checkResult("Hobbies", setMusic)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", setSelectState + " " + setSelectCity);
    }
}

