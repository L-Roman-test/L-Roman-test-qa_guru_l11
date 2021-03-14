package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import config.LoginConfig;
import settings.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class LoginTests extends TestBase {

    static final LoginConfig config = ConfigFactory.create(LoginConfig.class, System.getProperties());

    @Test
    @DisplayName("Basic positive login test via email")
    public void basicLoginViaEmailTest() {
        step("Open login form", (step) -> {
            open("");
            $("[href='/#login']").click();
        });
        step("Fill login form and LogIn", (step) -> {
            $("[name='USER_LOGIN']").setValue(config.getEmail());
            $("[name='USER_PASSWORD']").setValue(config.getPassword());
            $("[for='loginForm']").click();
        });
        step("Verify successful login", (step) -> {
            $("[href='/#login']").shouldBe(hidden);
        });
    }
}
