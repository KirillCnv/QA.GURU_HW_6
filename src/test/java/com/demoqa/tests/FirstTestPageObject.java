package com.demoqa.tests;

import com.demoqa.pages.FirstTestPage;
import com.demoqa.pages.components.ResultComponent;
import com.demoqa.utils.TestConfig;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTestPageObject extends TestConfig {

    FirstTestPage firstTestPage = new FirstTestPage();
    ResultComponent result = new ResultComponent();


    @Test
    void autoTest() {
        firstTestPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setLastEmail(email)
                .setLastGender(gender)
                .setLastPhone(mobileNumber)
                .setBirtDate(day, month, year)
                .setHobbies(hobbie)
                .setSubjects(subject)
                .uploadFile(uploadFoto)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .submit();
        result.checkTitle()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Date of Birth", fullDate)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", verificationFoto)
                .checkResult("Address", address)
                .checkResult("State and City", stateAndCity);
    }
}





