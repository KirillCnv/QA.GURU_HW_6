package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FirstTestPage;
import com.demoqa.pages.components.ResultComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTestPageObject {

    FirstTestPage firstTestPage = new FirstTestPage();
    ResultComponent result = new ResultComponent();

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
                .setHobbies("Sports")
                .setSubjects("Computer Science")
                .uploadFile("src/test/resources/1.jpg")
                .setAddress("Russia, Mosсow")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();
        result.checkTitle()
                .checkResult("Student Name", "Kirill Chernyshov")
                .checkResult("Student Email", "user@email.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7880852282")
                .checkResult("Date of Birth", "24 May,1994")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.jpg")
                .checkResult("Address", "Russia, Mosсow")
                .checkResult("State and City", "NCR Delhi");
    }
}





