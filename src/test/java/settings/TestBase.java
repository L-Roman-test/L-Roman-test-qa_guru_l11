package settings;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static config.ConfigHelper.isVideoOn;
import static settings.AttachmentsHelper.*;

public class TestBase {

    @BeforeAll
    public static void settings() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.baseUrl = "https://shop.kalashnikov.com";
        Configuration.browserSize = "1920x1080";

        if (ConfigHelper.isRemoteWebDriver()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = ConfigHelper.getWebRemoteDriver();
        }
    }

    @AfterEach
    public void attachments() {
        String sessionId = getSessionId();
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) {
            attachVideo(sessionId);
        }
        closeWebDriver();
    }
}

