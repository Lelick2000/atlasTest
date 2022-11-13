package project.tests;

import framework.base.BaseTest;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import project.actions.ui.steps.CardPageSteps;
import project.actions.ui.steps.InventoryPageSteps;
import project.actions.ui.steps.LoginPageSteps;
import project.models.User;

import static confuguration.YamlPropertiesReader.getUserPassword;
import static confuguration.YamlPropertiesReader.getUserUsername;

@ExtendWith(SerenityJUnit5Extension.class)
public class UiTest extends BaseTest {
    private final User user = new User(getUserUsername(), getUserPassword());
    @Steps
    LoginPageSteps loginPageSteps;
    @Steps
    InventoryPageSteps inventoryPageSteps;
    @Steps
    CardPageSteps cardPageSteps;

    @Override
    @Test
    protected void runTest() {
        logger.info("step 1: Login website with existing user");
        loginPageSteps.loginUser(user);

        logger.info("step 2: Setting sorting from z to a");
        inventoryPageSteps.setZaSort();

        logger.info("step 3: open lef bottom card");
        inventoryPageSteps.openLeftButtomElement();

        logger.info("step 4: check that shopping cart is empty");
        cardPageSteps.isShoppingCartEmpty();

        logger.info("step 5: add item to shopping cart");
        logger.info("step 6: assert that “Add to cart” changed to “Remove”");
        logger.info("step 7: cart quantity changed to +1");
        cardPageSteps.addItemToShoppingCart();
    }
}
