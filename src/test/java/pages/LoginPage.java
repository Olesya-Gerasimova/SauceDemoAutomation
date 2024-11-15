package pages;

import io.qameta.allure.Step;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    // Селекторы элементов
    private SelenideElement usernameInput = $("#user-name");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement loginButton = $("#login-button");

    @Step("Вводим имя пользователя: {0}")
    public LoginPage enterUsername(String username) {
        usernameInput.shouldBe(Condition.visible).setValue(username);  // Ожидаем видимость перед вводом
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage enterPassword(String password) {
        passwordInput.shouldBe(Condition.visible).setValue(password);  // Ожидаем видимость перед вводом
        return this;
    }

    @Step("Нажимаем кнопку логина")
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.enabled).click();  // Ожидаем, что кнопка активна перед кликом
    }

    @Step("Авторизация с пользователем {0} и паролем {1}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
