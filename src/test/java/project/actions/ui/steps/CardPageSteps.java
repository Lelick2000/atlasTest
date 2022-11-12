package project.actions.ui.steps;

import net.thucydides.core.annotations.Step;
import project.page.objects.CardPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardPageSteps {
    CardPage cardPage = new CardPage();

    @Step("Check that shopping cart is empty")
    public void isShoppingCartEmpty() {
        assertEquals(cardPage.checkShoppingCart(), 0);
    }

    @Step("Check that shopping cart is not empty")
    public void isShoppingCartNotEmpty() {
        assertTrue(cardPage.checkShoppingCart() > 0, "Cart is empty");
    }

    @Step("Add item to shopping cart")
    public void addItemToShoppingCart() {
        cardPage.addItemToShoppingCart();
    }
}
