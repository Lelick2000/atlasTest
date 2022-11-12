package project.actions.ui.steps;

import net.thucydides.core.annotations.Step;
import org.testng.Assert;
import project.page.objects.CardPage;

public class CardPageSteps {
    private final CardPage cardPage = new CardPage();

    @Step("Check that shopping cart is empty")
    public void isShoppingCartEmpty() {
        Assert.assertEquals(cardPage.checkShoppingCart(), 0);
    }

    @Step("Check that shopping cart is not empty")
    public void isShoppingCartNotEmpty() {
        Assert.assertTrue(cardPage.checkShoppingCart() > 0, "Cart is empty");
    }

    @Step("Add item to shopping cart")
    public void addItemToShoppingCart() {
        cardPage.addItemToShoppingCart();
    }
}
