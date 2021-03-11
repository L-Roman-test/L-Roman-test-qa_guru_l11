package settings;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void settings() {
        Configuration.baseUrl = "https://shop.kalashnikov.com";
        Configuration.browserSize = "1920x1080";
    }
}

