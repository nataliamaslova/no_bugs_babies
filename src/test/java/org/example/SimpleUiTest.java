package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        // 1. Preparation
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        // 2. Test steps
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Sasha");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Pshe");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        // 3. Verification of expected result
        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));
        // все оставшиеся обязательные поля
    }
}