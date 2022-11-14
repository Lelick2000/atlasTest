package project.utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.TimeoutException;
import project.tests.UiTestRunner;

public class BrowserUtils {
    public static boolean waitForUrlEqual(String url) {
        try {
            Selenide.Wait()
                    .withMessage("Ожидание открытия ссылки " + url)
                    .until(driver -> driver.getCurrentUrl().equals(url));
            return true;
        } catch (TimeoutException e) {
            UiTestRunner.logger.warn("Превышено время ожидания URL: " + url);
            return false;
        }
    }
}
