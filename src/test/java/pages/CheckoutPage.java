package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;  // Здесь импортируем Condition
import io.qameta.allure.Step;

public class CheckoutPage {

    // Селекторы
    private SelenideElement firstNameInput = $("#first-name");
    private SelenideElement lastNameInput = $("#last-name");
    private SelenideElement postalCodeInput = $("#postal-code");
    private SelenideElement continueButton = $("#continue");
    private SelenideElement finishButton = $("#finish");
    private SelenideElement orderTotal = $(".summary_total_label");

    @Step("Заполняем форму с данными {0}, {1}, {2}")
    public CheckoutPage fillForm(String firstName, String lastName, String postalCode) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        postalCodeInput.setValue(postalCode);
        continueButton.click();
        return this;
    }

    @Step("Подтверждаем заказ и проверяем сумму")
    public void confirmOrder() {
        finishButton.click();
        // Теперь метод text() должен работать корректно
        orderTotal.shouldHave(text("$58.29"));
    }
}
