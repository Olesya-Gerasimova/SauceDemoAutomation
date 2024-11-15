package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    // Селекторы для кнопок добавления товаров в корзину
    private SelenideElement backpackAddButton = $("#add-to-cart-sauce-labs-backpack");
    private SelenideElement tshirtAddButton = $("#add-to-cart-sauce-labs-bolt-t-shirt");
    private SelenideElement onesieAddButton = $("#add-to-cart-sauce-labs-onesie");

    // Метод для добавления рюкзака в корзину
    @Step("Добавляем рюкзак в корзину")
    public ProductPage addBackpackToCart() {
        backpackAddButton.click();
        return this;
    }

    // Метод для добавления футболки в корзину
    @Step("Добавляем футболку в корзину")
    public ProductPage addTShirtToCart() {
        tshirtAddButton.click();
        return this;
    }

    // Метод для добавления комбеза в корзину
    @Step("Добавляем комбез в корзину")
    public ProductPage addOnesieToCart() {
        onesieAddButton.click();
        return this;
    }

    // Метод для перехода в корзину
    @Step("Переходим в корзину")
    public CartPage proceedToCart() {
        $(".shopping_cart_link").click();
        return page(CartPage.class);
    }
}
