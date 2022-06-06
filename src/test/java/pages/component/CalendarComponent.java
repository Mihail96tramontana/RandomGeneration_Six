package pages.component;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").click();
        $(byText("April")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2020")).click();
        $(byText("10")).click();
    }
}
