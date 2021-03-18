package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import settings.TestBase;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("web")
@Feature("MainPage Tests")
public class MainPageTests extends TestBase {

    @BeforeEach
    public void openMainPage() {
        open("");
    }

    @Test
    @Story("Main page contains six product categories")
    @DisplayName("Page should have product categories in the header")
    public void categoriesTest() {
        step("Check header logo", (step) -> {
            $("#headerLogo").shouldBe(visible);
        });
        step("Check categories in the header", (step) -> {
            $("nav [href='/catalog/ognestrelnoe_oruzhie']").shouldHave(text("Огнестрельное оружие"));
            $("nav [href='/catalog/oruzhie']").shouldHave(text("Макеты и пневматика"));
            $("nav [href='/catalog/aksessuary_dlya_oruzhiya']").shouldHave(text("Аксессуары для оружия"));
            $("nav [href='/catalog/odezhda']").shouldHave(text("Одежда"));
            $("nav [href='/catalog/suveniry']").shouldHave(text("Сувениры"));
            $("nav [href='/catalog/snaryazhenie']").shouldHave(text("Снаряжение"));
        });
    }

    @Test
    @Story("The main page should have information on all brands")
    @DisplayName("All brands should be displayed")
    public void brandsTest() {
        step("Open window with additional information", (step) -> {
            $("[href='/#structure']").click();
        });
        step("Check all brands", (step) -> {
            $$(".scrollarea-content li").findBy(text("Бренды")).click();
            $(".scrollarea-content  [href='https://kalashnikov.media/']").shouldBe(visible);
            $(".scrollarea-content  [href='https://ak.kalashnikovgroup.ru/']").shouldBe(visible);
            $(".scrollarea-content  [href='https://baikal.kalashnikovgroup.ru/']").shouldBe(visible);
            $(".scrollarea-content  [href='http://izhmash.kalashnikovgroup.ru/']").shouldBe(visible);
            $(".scrollarea-content  [href='http://zala-aero.com/']").shouldBe(visible);
            $(".scrollarea-content  [href='https://rybinskshipyard.ru/']").shouldBe(visible);
            $(".scrollarea-content  [href='https://www.vympel-rybinsk.ru/']").shouldBe(visible);
        });
    }

    @Test
    @Story("The main page should have information on all divisions")
    @DisplayName("All divisions should be displayed")
    public void divisionsTest() {
        step("Open window with additional information", (step) -> {
            $("[href='/#structure']").click();
        });
        step("Check all brands", (step) -> {
            $$(".scrollarea-content li").findBy(text("Подразделения")).click();
            $(".scrollarea-content  [href='https://kalashnikovgroup.ru/']").shouldBe(visible);
            $(".scrollarea-content  [href='https://www.baikalinc.ru/']").shouldBe(visible);
            $(".scrollarea-content  [href='http://mmzavod.ru/']").shouldBe(visible);
            $(".scrollarea-content  [href='http://kalashnikov.engineering/']").shouldBe(visible);
            $(".scrollarea-content  [href='http://www.npomolniya.ru/']").shouldBe(visible);
        });
    }

    @Test
    @AllureId("1947")
    @DisplayName("The main page should have link to kalashnikov media")
    public void linkToMediaPage() {
        step("Click on \"Kалашников Media\"", (step) -> {
            $("[href='https://kalashnikov.media/']").click();
        });
        step("Verify that the kalashnikov.media opened", (step) -> {
            getWebDriver().switchTo().window(String.valueOf(getWebDriver().getWindowHandles().toArray()[1]));
            assertEquals(getWebDriver().getCurrentUrl(), "https://kalashnikov.media/");
        });
    }
}
