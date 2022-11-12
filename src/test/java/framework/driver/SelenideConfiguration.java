package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

/**
 * Класс (фабрика), отвечающий за создание экземпляра веб-драйвера.
 */
public class SelenideConfiguration implements ISelenideConfiguration {
    /**
     * Получение экземпляра веб-драйвера, готового к использованию.
     */
    @Override
    public WebDriver getDriver() {
        return getLocalDriver();
    }

    /**
     * Создание экземпляра ChromeOptions, на основании файла driverOptions.json из ресурсов.
     *
     * @return ChromeOptions для инициализации драйвера.
     */
    private ChromeOptions getChromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();

        //setting args
        String[] args = new String[]{
                "start-maximized",
                "no-sandbox",
                "disable-gpu",
                "disable-extensions",
                "disable-web-security",
                "disable-infobars",
                "use-fake-device-for-media-stream",
                "use-fake-ui-for-media-stream",
                "disable-notifications",
                "ignore-certificate-errors",
                "disable-browser-side-navigation",
                "disable-dev-shm-usage"};
        chromeOptions.addArguments(args);

        //setting prefs
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("intl.accept_languages", "ru-ru");
        chromePrefs.put("profile.default_content_settings.popups", "0");
        chromePrefs.put("disable-popup-blocking", "true");
        chromePrefs.put("download.default_directory", ".//target//downloads//");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        //setting switches
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"disable-component-update", "disable-popup-blocking", "enable-automation"});

        //setting capabilities
        chromeOptions.setCapability("acceptInsecureCerts", true);

        return chromeOptions;
    }

    /**
     * Создание локального веб-драйвера.
     *
     * @return экземпляр локального драйвера.
     */
    private WebDriver getLocalDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = getChromeOptions();

        return new ChromeDriver(chromeOptions);
    }
}
