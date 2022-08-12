package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FirstTestPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTestPageObject {

    FirstTestPage firstTestPage = new FirstTestPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void autoTest() {
        firstTestPage.openPage()
                .setFirstName("Kirill")
                .setLastName("Chernyshov")
                .setLastEmail("user@email.com")
                .setLastGender("Male")
                .setLastPhone("7880852282")
                .setBirtDate("24", "May", "1994")
                .setHobbies()
                .setSubjects();


        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg"));
        $("#currentAddress").setValue("Russia, Mosсow");
        //$(By.xpath("//h2[text()='" + form + "']//ancestor::div[@class='block-wrapper']")).scrollIntoView(false);
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-body").shouldHave(
                text("Kirill"),
                text("Chernyshov"),
                text("user@email.com"),
                text("Male"),
                text("7880852282"),
                text("24 May,1994"),
                text("Sports"),
                text("1.jpg"),
                text("Russia, Mosсow"),
                text("NCR Delhi"));
    }
}
