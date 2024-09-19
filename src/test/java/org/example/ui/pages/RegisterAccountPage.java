package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
    // Inputs
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));

    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));

    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));

    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));

    private SelenideElement phoneInput = element(Selectors.byId("customer.phoneNumber"));

    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));

    private SelenideElement userNameInput = element(Selectors.byId("customer.username"));

    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));

    private SelenideElement confirmInput = element(Selectors.byId("repeatedPassword"));

    // Buttons
    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    // Error fields
    SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));

    SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));

    SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

    SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

    SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

    SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

    SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));

    SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

    SelenideElement confirmError = element(Selectors.byId("repeatedPassword.errors"));

    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {

        setInputIfNotNull(firstNameInput, bankAccount.getFirstName());
        setInputIfNotNull(lastNameInput, bankAccount.getLastName());
        setInputIfNotNull(addressInput, bankAccount.getAddress());
        setInputIfNotNull(cityInput, bankAccount.getCity());
        setInputIfNotNull(stateInput, bankAccount.getState());
        setInputIfNotNull(zipCodeInput, bankAccount.getZipCode());
        setInputIfNotNull(phoneInput, bankAccount.getPhone());
        setInputIfNotNull(ssnInput, bankAccount.getSsn());
        setInputIfNotNull(userNameInput, bankAccount.getUserName());
        setInputIfNotNull(passwordInput, bankAccount.getPassword());
        setInputIfNotNull(confirmInput, bankAccount.getConfirm());

        registerButton.click();
    }

    public static void setInputIfNotNull(SelenideElement inputElement, String value) {
        if (value != null) {
            inputElement.sendKeys(value);
        }
    }
}
