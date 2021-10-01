package fedor.parenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class RegFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void RegFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Sherlock");
        $("#lastName").setValue("Holmes");
        $("#userEmail").setValue("holmes@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9995554433");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1906")).click();
        $(byXpath("//div[@class='react-datepicker__day react-datepicker__day--001']")).click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/222.jpg");

        // На экранах с разрешением 1600*900 и ниже проверки, идущие после заполнения поля Current Address,
        // фейлятся из-за того, что не все элементы формы помещаются на экране + мешает рекламный блок.
        // Поэтому сделал скролл вниз, чтобы скрытые элементы были в зоне видимости
        $(byXpath("//*[@id='submit']")).scrollIntoView(true);

        $("#currentAddress").setValue("London, Baker street, 221b");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Sherlock Holmes"));
        $(".modal-body").shouldHave(text("holmes@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9995554433"));
        $(".modal-body").shouldHave(text("01 May,1906"));
        $(".modal-body").shouldHave(text("Chemistry"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("222.jpg"));
        $(".modal-body").shouldHave(text("London, Baker street, 221b"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
    }
}
