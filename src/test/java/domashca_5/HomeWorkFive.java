package domashca_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class HomeWorkFive {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void successfulTest() {
        //объявление переменных
        String setFirstName = "Mihail",
                setLastname = "Lubeznow",
                setUserEmail = "mihail@mail.ru",
                setUserNumber = "1234567890",
                currentAddress = "Miami",
                setGender = "Male",
                setHobbies = "Music",
                uploadPicture = "2.jpg",
                selectState = "NCR",
                selectCity = "Noida",
                setSubjectValue = "Maths",
                dateOfBirth = "10 April,2020";

        //шаги
        registrationFormPage.openPage()
        .setFirstName(setFirstName)
        .setLastName(setLastname)
        .setUserEmail(setUserEmail)
        .setUserNumber(setUserNumber)
        .currentAddress(currentAddress)
        //$("#currentAddress").setValue("Miami"); из чего получили более лаконичную конструкцию
        .setGender(setGender)
        .setHobbies(setHobbies)
        //$(byText("Music")).click(); из чего получили более лаконичную конструкцию
        .dateOfBirth(dateOfBirth)
        .uploadPicture(uploadPicture)
        .setSubjectValue(setSubjectValue)
        .selectState(selectState)
        .selectCity(selectCity)
        .clickSubmit();


        //проверки
        registrationFormPage
                .checkResult("Student Name", setFirstName + " " + setLastname)
                .checkResult("Student Email", setUserEmail)
                .checkResult("Gender", setGender)
                .checkResult("Mobile", setUserNumber)
                .checkResult("Date of Birth", dateOfBirth)
                .checkResult("Subjects", setSubjectValue)
                .checkResult("Hobbies", setHobbies)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", selectState + " " + selectCity);
    }
}

