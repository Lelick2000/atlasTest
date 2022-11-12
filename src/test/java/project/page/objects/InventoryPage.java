package project.page.objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage {
    private final SelenideElement sortingButton = $x("//select[@data-test='product_sort_container']");

    public void setZaSort() {
        sortingButton.selectOptionByValue("za");
    }

    public void clickLeftButtomElement() {
        ElementsCollection items = $$(".inventory_item");
        items.get(1).$(".inventory_item_name").click();
    }
}
