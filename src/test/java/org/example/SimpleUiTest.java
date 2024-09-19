package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {

    /**
     * ПРИНЦИПЫ РАЗРАБОТКИ ТЕСТОВ:
     * 1. DRY
     * 2. Веб-элементы НЕ ИЩУТСЯ в тексте, они ищутся в PAGE OBJECT классе
     * 3. Автотест сам создает РАНДОМИЗИРОВАННЫЕ ДАННЫЕ
     */

    @BeforeAll
    public static void setupUiTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
//        Configuration.browser = "firefox";
//        Configuration.timeout = 10;
    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        // 1.1. Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // 1.2. Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        // 2. Шаги теста
        registerAccountPage.register(bankAccount);

        // 3. Проверка ожидаемого результата
        registerAccountPage.getAddressError()
                .shouldHave(Condition.exactText("Address is required."));

        // все оставшиеся обязательные поля
    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly1() {
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