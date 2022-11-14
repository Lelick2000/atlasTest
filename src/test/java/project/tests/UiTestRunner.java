package project.tests;

import com.codeborne.selenide.Selenide;
import framework.driver.DriverContainer;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import project.utils.BrowserUtils;

import static confuguration.YamlPropertiesReader.getUiBaseUri;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/ui/")
public class UiTestRunner {
    public static final Logger logger = LogManager.getLogger();

    /**
     * Before Class method
     * Make a browser window
     */
    @BeforeClass
    public static void before() {
        openBrowserAndExecuteBasicActions();
    }

    protected static void openBrowserAndExecuteBasicActions() {
        DriverContainer.setDrivers();
        Selenide.clearBrowserCookies();
        Selenide.open(getUiBaseUri());
        BrowserUtils.waitForUrlEqual(getUiBaseUri());
    }

    /**
     * Close browser
     */
    @AfterClass
    public static void afterMethod() {
        DriverContainer.quit();
    }
}
