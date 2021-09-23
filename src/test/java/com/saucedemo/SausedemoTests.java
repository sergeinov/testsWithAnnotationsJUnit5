package com.saucedemo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SausedemoTests {

    static final String URL = "https://www.saucedemo.com/";

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @CsvSource(value = {
            "standard_user, secret_sauce",
            "locked_out_user, secret_sauce",
            "problem_user, secret_sauce"
    })

    @ParameterizedTest(name = "Check authorization user: {0}")
    void authorizationValidUserTest(String login, String pass) {                            // with @CsvSource
        // Step 1: Go to the site
        open(URL);
        // Step 2: Enter a login data
        $("#user-name").setValue(login);
        // Step 3: Enter a password data
        $("#password").setValue(pass);
        // Step 4: Click button "Login"
        $("#login-button").click();
        // Step 5: Check to entrance to site
        $("span.title").shouldHave(text("Products"));
    }

}
