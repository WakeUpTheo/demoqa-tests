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
        //String permanentAddress = "some street 1";

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
        $("#currentAddress").setValue("London, Baker street, 221b");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        //$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        //$("#city").click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();


    }
}
