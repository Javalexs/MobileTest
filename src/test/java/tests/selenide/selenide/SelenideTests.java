package tests.selenide.selenide;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.selenide.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.back;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SelenideTests extends TestBase {
    @Test
    @Tag("android")
    @DisplayName("Проверка текста в окне регистрации пользователя на устройстве Android")
    void checkTextLogInToWikipedia() {
        step("Жмем кнопку регистрации пользователя", () -> {
            $(byClassName("android.support.v7.widget.LinearLayoutCompat")).click();
        });
        step("Проверяем наличие текста ", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
        });
    }

    @Test
    @Tag("ios")
    @DisplayName("Проверка ввода электронной почты на устройстве iOS")
    void loginRegTest() {
        step("Жмем кнопку", () ->{
            $(id("Text Button")).click();
        });
        step("Вводим адрес электронной почты", () ->{
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("google@gmail.com");
            $(id("Text Input")).pressEnter();
        });
        step("Проверяем результат ввода", () ->{
            assertEquals("google@gmail.com", $(id("Text Output")).getText());
        });
    }
}
