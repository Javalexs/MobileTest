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

    void countryPageSearchTest() {

        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Argentina");
        });
        step("Verify content found", () -> {
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
        step("Verify page is correct", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
            $(AppiumBy.className("android.webkit.WebView")).click();
            $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Argentina"));
        });
    }


    @Owner("Alexsey Fadeev")
    @Test
    void onBoardingStepsTest() {


        step("Check that the text 'The Free Encyclopedia …in over 300 languages' is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click on 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'New ways to explore' is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Click on 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'Reading lists with sync' is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("Click on 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'Send anonymous data' is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }

//    void checkTextLogInToWikipedia() {
//        step("Жмем кнопку регистрации пользователя", () -> {
//            $(byClassName("android.support.v7.widget.LinearLayoutCompat")).click();
//        });
//        step("Проверяем наличие текста ", () -> {
//            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
//        });
//    }
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
