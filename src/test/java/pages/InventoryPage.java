package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {
    private final SelenideElement backpack = $("#add-to-cart-sauce-labs-backpack");
    private final SelenideElement boltTShirt = $("#add-to-cart-sauce-labs-bolt-t-shirt");
    private final SelenideElement onesie = $("#add-to-cart-sauce-labs-onesie");
    private final SelenideElement cartIcon = $(".shopping_cart_link");

    @Step("Добавляем в корзину Sauce Labs Backpack")
    public void addBackpackToCart() {
        backpack.click();
    }

    @Step("Добавляем в корзину Sauce Labs Bolt T-Shirt")
    public void addBoltTShirtToCart() {
        boltTShirt.click();
    }

    @Step("Добавляем в корзину Sauce Labs Onesie")
    public void addOnesieToCart() {
        onesie.click();
    }

    @Step("Переход в корзину")
    public void goToCart() {
        cartIcon.click();
    }
}
