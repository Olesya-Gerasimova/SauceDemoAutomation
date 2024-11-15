package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CartPage {

    // Селекторы
    private ElementsCollection cartItems = $$(".cart_item");
    private SelenideElement checkoutButton = $("#checkout");

    @Step("Проверяем, что в корзине 3 товара")
    public CartPage checkCartItemsSize() {
        // Используем shouldHave() с size() для проверки количества элементов
        cartItems.shouldHave(size(3));  // Проверяем, что в корзине 3 товара
        return this;
    }

    @Step("Переходим на страницу оформления заказа")
    public CheckoutPage proceedToCheckout() {
        checkoutButton.click();
        return page(CheckoutPage.class);
    }
}
