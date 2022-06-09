package pages.componentsabject;

import com.codeborne.selenide.conditions.Value;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubjectComponent {
    public void subjectComponent(String value) {
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();
    }
}
