package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import settings.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class MainPageTests extends TestBase {

    @BeforeEach
    public void openMainPage() {
        open("");
    }

    @Test
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
}
