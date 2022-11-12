package project.actions.ui.steps;

import net.thucydides.core.annotations.Step;
import project.page.objects.InventoryPage;

public class InventoryPageSteps {
    InventoryPage inventoryPage = new InventoryPage();

    @Step("Set sorting from z to a")
    public void setZaSort() {
        inventoryPage.setZaSort();
    }

    @Step("Open buttom left card")
    public void openLeftButtomElement() {
        inventoryPage.clickLeftButtomElement();
    }


}
