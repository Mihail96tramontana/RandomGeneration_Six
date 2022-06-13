package domashca_5;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class HomeWorkSix {

    //скрипты для генерации значений
    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().phoneNumber();
    String currentAddress = faker.address().streetAddressNumber();


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    void successfulTest() {
        //объявление переменных
        String firstname = "Mihail",
                lastName = "Lubeznow",
                userEmail = "mihail@mail.ru",
                userNumber = "1234567890",
                currentAddress = "Miami",
                gender = "Male",
                hobbies = "Music",
                uploadPicture = "2.jpg",
                state = "NCR",
                city = "Noida",
                subjectValue = "Maths",
                day = "10",
                month = "April",
                year = "2020";

        //шаги
        registrationFormPage.openPage()
        .setFirstName(firstname)
        .setLastName(lastName)
        .setUserEmail(userEmail)
        .setUserNumber(userNumber)
        .currentAddress(currentAddress)
        //$("#currentAddress").setValue("Miami"); из чего получили более лаконичную конструкцию
        .setGender(gender)
        .setHobbies(hobbies)
        //$(byText("Music")).click(); из чего получили более лаконичную конструкцию
        .dateOfBirth(day, month, year)
        .uploadPicture(uploadPicture)
        .setSubjectValue(subjectValue)
        .selectState(state)
        .selectCity(city)
        .clickSubmit();


        //проверки
        registrationFormPage
                .checkResult("Student Name", firstname + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjectValue)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}

