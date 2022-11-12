package project.tests;

import framework.base.BaseTest;
import net.thucydides.core.annotations.Steps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.actions.ui.steps.CardPageSteps;
import project.actions.ui.steps.InventoryPageSteps;
import project.actions.ui.steps.LoginPageSteps;
import project.models.User;

public class UiTest extends BaseTest {
    private final User user = new User();
    @Steps
    private final LoginPageSteps loginPageSteps = new LoginPageSteps();
    @Steps
    private final InventoryPageSteps inventoryPageSteps = new InventoryPageSteps();
    @Steps
    private final CardPageSteps cardPageSteps = new CardPageSteps();

    @BeforeClass
    @Parameters({"username", "password"})
    public void readParams(String username, String password) {
        this.user.setUsername(username);
        this.user.setPassword(password);
    }

    @Override
    @Test
    protected void runTest() {
        logger.info("step 1: Login website with existing user");
        loginPageSteps.loginUser(user);

        logger.info("step 2: Setting sorting from z to a");
        inventoryPageSteps.setZaSort();

        logger.info("step 3: open lef buttom card");
        inventoryPageSteps.openLeftButtomElement();

        logger.info("step 4: check that shopping cart is empty");
        cardPageSteps.isShoppingCartEmpty();

        logger.info("step 5: add item to shopping cart");
        logger.info("step 6: assert that “Add to cart” changed to “Remove”");
        logger.info("step 7: cart quantity changed to +1");
        cardPageSteps.addItemToShoppingCart();
    }
}
