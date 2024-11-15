package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import io.qameta.allure.Allure;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {

    @Test
    @Description("Тест успешной авторизации")
    public void successfulLoginTest() {
        open("https://www.saucedemo.com/");
        new LoginPage().login("standard_user", "secret_sauce");
        Allure.step("Проверяем успешную авторизацию");
        // Добавьте дальнейшие проверки, если необходимо
    }

    @Test
    @Description("Тест авторизации заблокированного пользователя")
    public void blockedUserLoginTest() {
        open("https://www.saucedemo.com/");
        new LoginPage().login("locked_out_user", "secret_sauce");
        Allure.step("Проверяем сообщение о заблокированном пользователе");
        // Проверка, что появилось сообщение о заблокированном пользователе
    }
}
