package com.demoqa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTestPage {

    // Elements

    private CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber");


    // Actions

    public FirstTestPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public FirstTestPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FirstTestPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FirstTestPage setLastEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public FirstTestPage setLastGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public FirstTestPage setLastPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public FirstTestPage setBirtDate(String day, String month, String yaer) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate("24", "May", "1994");
        return this;
    }

    public FirstTestPage setHobbies() {
        $(byText("Sports")).click();

        return this;
    }

    public FirstTestPage setSubjects() {
        $("#subjectsInput").setValue("physical Culture");

        return this;
    }


}