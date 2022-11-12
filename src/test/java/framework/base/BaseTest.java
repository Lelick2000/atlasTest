package framework.base;

import com.codeborne.selenide.Selenide;
import framework.driver.DriverContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import project.constants.enums.urls.Urls;
import project.utils.BrowserUtils;


public abstract class BaseTest {
    public static final Logger logger = LogManager.getLogger();

    /**
     * To override.
     */
    protected abstract void runTest();

    /**
     * Before Class method
     * Make a browser window
     */
    @BeforeEach
    public void before() {
        openBrowserAndExecuteBasicActions();
    }

    protected void openBrowserAndExecuteBasicActions() {
        DriverContainer.setDrivers();
        Selenide.clearBrowserCookies();
        Selenide.open(Urls.BASE_UI.getUrl());
        BrowserUtils.waitForUrlEqual(Urls.BASE_UI.getUrl());
    }

    /**
     * Close browser
     */
    @AfterEach
    public void afterMethod() {
        DriverContainer.quit();
    }
}

