package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndToEndTest {

    @BeforeAll
    static void setUp() {
        // Добавляем Allure Selenide Listener для логирования шагов в отчет Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        open("https://www.saucedemo.com/");
    }

    @Test
    void endToEndTest() {
        // Шаг 1: Логинимся
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        // Шаг 2: Добавляем товары в корзину
        $("#add-to-cart-sauce-labs-backpack").click();
        $("#add-to-cart-sauce-labs-bolt-t-shirt").click();
        $("#add-to-cart-sauce-labs-onesie").click();

        // Шаг 3: Переходим в корзину
        $("#shopping_cart_container > a").click();

        // Шаг 4: Проверяем, что товары в корзине
        int numberOfItems = webdriver().driver().getWebDriver().findElements(byClassName("cart_item")).size();
        assertEquals(3, numberOfItems);

        // Шаг 5: Переходим на страницу оформления заказа
        $(byText("Checkout")).click();

        // Шаг 6: Заполняем форму для оформления заказа
        $("#first-name").setValue("John");
        $("#last-name").setValue("Doe");
        $("#postal-code").setValue("12345");
        $("#continue").click();

        // Шаг 7: Проверяем общую сумму заказа
        $(byText("58.29")).shouldBe(Condition.visible);

        // Шаг 8: Завершаем покупку
        $("#finish").click();
    }
}
