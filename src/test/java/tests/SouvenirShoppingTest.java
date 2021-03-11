package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import settings.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class SouvenirShoppingTest extends TestBase {

    @Test
    @DisplayName("Selected souvenir should be shown in the shopping cart with the correct price")
    public void quicklySouvenirBuyingTest() {
        step("Open and check souvenir page", (step) -> {
            open("/catalog/suveniry");
            $("#breadcrumbs").sibling(0).shouldHave(text("Сувениры"));
        });
        step("Select and put souvenir in the shopping cart", (step) -> {
            $("[href='/card/solonka_i_perechnitsa_-minomyetchiki']").scrollIntoView(true);
            String souvenirPrice = $("[href='/card/solonka_i_perechnitsa_-minomyetchiki'] footer").getText();
            $("[href='/card/solonka_i_perechnitsa_-minomyetchiki'] button [fill='currentColor']").click();
            $("footer [href='/basket/']").click();
            $("#header [href='/basket/']").click();
            $$("[style^='position: sticky'] span").findBy(text("Сумма заказа")).sibling(0).shouldHave(text(souvenirPrice));
        });
    }
}
