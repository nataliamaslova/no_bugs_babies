package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    // ... добавить все важные элементы страницы в поля

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    // Дальше идут поля ошибок

    SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    // ...


    public void open() {
        Selenide.open("/parabank/register.htm");

    }

    public void register(BankAccount bankAccount) {
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());

        registerButton.click();
    }
}
