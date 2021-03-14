package settings;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    public static void settings() {
        Configuration.baseUrl = "https://shop.kalashnikov.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();

        if (config.getRemoteURL() != null) {
            Configuration.remote = config.getRemoteURL();
        }
    }
}

