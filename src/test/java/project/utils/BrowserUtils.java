package project.utils;

import com.codeborne.selenide.Selenide;
import framework.base.BaseTest;
import org.openqa.selenium.TimeoutException;

public class BrowserUtils {
    public static boolean waitForUrlEqual(String url) {
        try {
            Selenide.Wait()
                    .withMessage("Ожидание открытия ссылки " + url)
                    .until(driver -> driver.getCurrentUrl().equals(url));
            return true;
        } catch (TimeoutException e) {
            BaseTest.logger.warn("Превышено время ожидания URL: " + url);
            return false;
        }
    }
}
