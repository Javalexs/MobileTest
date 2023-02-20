package tests.selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


public class LoginTests extends TestBase {
    @Test
    void checkTextLogInToWikipedia() {
        step("Жмем кнопку регистрации", () -> {
            $(byClassName("android.support.v7.widget.LinearLayoutCompat")).click();
        });
        step("Проверяем наличие текста ", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
        });
    }
}
