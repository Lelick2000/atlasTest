package framework.base;

import com.codeborne.selenide.Selenide;
import framework.driver.DriverContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
    @BeforeMethod
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
    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        /*DriverContainer.quit();*/
    }

}

