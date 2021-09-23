package com.arcsinus;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class ArcsinusTests {

    static final String URL = "https://arcsinus.ru/";

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @ValueSource(strings = {
            "Компания",
            "Проекты",
            "Клиенты",
            "Команда",
            "Отзывы",
            "Контакты"
    })
    @ParameterizedTest(name = "Check link of menu - {0}")
    void checkNavMenuTest(String menuName) {                                                    // with @ValueSource
        // Step 1: Go to the site
        open(URL);
        // Step 2: Click on the link of menu
        $(".header--nav--btn").click();
        $(linkText(menuName)).click();
        $("#close-nav").click();
    }


    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        "Ivan", "ivan@mail.ru", "1111118769", "This is an amazing project"
                ),
                Arguments.of(
                        "Sergey", "sergey@mail.ru", "2341122222", "Some description with bla-bla-bla"
                )
        );
    }

    @MethodSource("testWithMethodSource")
    @ParameterizedTest(name = "Fill form with data: {0}, {1}, {2}, {3}")
    void fillFormTest(String name, String email, String phoneNumber, String desc) {             // with @MethodSource
        // Step 1: Go to the site
        open(URL);
        // Step 2: Open menu
        $(".header--nav--btn").click();
        // Step 3: Enter name
        $("#name").setValue(name);
        // Step 4: Enter Email
        $("#email").setValue(email);
        // Step 5: Enter phone number
        $("#phone").setValue(phoneNumber);
        // Step 6: Enter description
        $("#description").setValue(desc);
        // Step 7: Check caching filds
        //$("[name = 'submit']").click();
    }

}
