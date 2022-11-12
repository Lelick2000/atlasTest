package project.page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardPage {
    private final SelenideElement shoppingCartCount = $(".shopping_cart_badge");
    private final SelenideElement addToCartButton = $x("//button[contains(@data-test, 'add-to-cart')]");
    private final SelenideElement removeFromCartButton = $x("//button[contains(@data-test, 'remove')]");

    public int checkShoppingCart() {
        return !shoppingCartCount.exists() ? 0 : Integer.parseInt(shoppingCartCount.text());
    }

    public void addItemToShoppingCart() {
        addToCartButton.shouldBe(Condition.visible).click();
        assertTrue(removeFromCartButton.exists(), "No remove button");
        assertEquals(removeFromCartButton.text(), "REMOVE");
        assertTrue(checkShoppingCart() > 0, "No items in the cart");
    }
}
