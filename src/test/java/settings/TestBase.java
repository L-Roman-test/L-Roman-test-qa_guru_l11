package settings;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static settings.AttachmentsHelper.*;

public class TestBase {

    static final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    public static void settings() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.baseUrl = "https://shop.kalashnikov.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();

        if (config.getRemoteURL() != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = config.getRemoteURL();
        }
    }

    @AfterEach
    public void attachments() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachText("Browser console logs", getConsoleLogs());
        if (config.getRemoteURL() != null) {
            attachVideo();
        }
        closeWebDriver();
    }
}

