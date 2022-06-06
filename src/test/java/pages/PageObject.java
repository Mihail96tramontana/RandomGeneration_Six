package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PageObject {
}

    public void setFirstName(String value) { //дополнительная конструкция
        $("#firstName").setValue(value); //копия конструкции с локатором
    }

    public void lastName(String value) {
        $("#lastName").setValue(value);

    }

    public void userEmail (String value) {
        $("#userEmail").setValue(value);
    }
    public void userNumber (String value) {
        $("#userNumber").setValue(value);
    }
    public void currentAddress (String value) {
        $("#currentAddress").setValue(value);
    }
    public void Male (String value) {
        $(byText("Male")).click();
    }
    public void Music (String value) {
        $(byText("Music")).click();
    }
}