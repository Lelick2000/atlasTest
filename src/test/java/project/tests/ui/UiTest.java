package project.tests.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.actions.ui.steps.CardPageSteps;
import project.actions.ui.steps.InventoryPageSteps;
import project.actions.ui.steps.LoginPageSteps;
import project.models.User;
import project.tests.UiTestRunner;

public class UiTest {
    private final User user = new User();
    @Steps
    LoginPageSteps loginPageSteps;
    @Steps
    InventoryPageSteps inventoryPageSteps;
    @Steps
    CardPageSteps cardPageSteps;

    @Given("I want to login user with username = {string} and password = {string}")
    public void loginUser(String username, String password) {
        UiTestRunner.logger.info("step 1: Login website with existing user");
        user.setUsername(username);
        user.setPassword(password);
        loginPageSteps.loginUser(user);
    }

    @Then("I want to change sorting from a-Z to Z-a")
    public void changeSorting() {
        UiTestRunner.logger.info("step 2: Setting sorting from z to a");
        inventoryPageSteps.setZaSort();
    }

    @Then("I want to open bottom left card details")
    public void openCard() {
        UiTestRunner.logger.info("step 3: open lef bottom card");
        inventoryPageSteps.openLeftButtomElement();
    }

    @When("Nothing added to shopping cart, its empty")
    public void checkShoppingCart() {
        UiTestRunner.logger.info("step 4: check that shopping cart is empty");
        cardPageSteps.isShoppingCartEmpty();
    }

    @When("I added item to the shopping cart")
    public void addItemToShoppingCart() {
        UiTestRunner.logger.info("step 5: add item to shopping cart");
        cardPageSteps.addItemToShoppingCart();
    }

    @Then("Text inside card changed from “Add to cart” to “Remove”")
    public void checkThatButtonChanged() {
        UiTestRunner.logger.info("step 6: assert that “Add to cart” changed to “Remove”");
        cardPageSteps.checkThatAddCartButtonChanged();
    }

    @And("Shopping cart image change to +1")
    public void checkThatShoppingCartQtyChanged() {
        UiTestRunner.logger.info("step 7: cart quantity changed to +1");
        cardPageSteps.isShoppingCartNotEmpty();
    }
}
