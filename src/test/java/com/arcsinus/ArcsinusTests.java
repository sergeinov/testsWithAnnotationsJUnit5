package com.arcsinus;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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

    @Test
    void checkMenuButton() {
        // Step 1: Go to the site
        open(URL);
        // Step 2: Click on the button to open menu
        $(".header--nav--btn").click();
        // Step 3: Close the window of menu
        $("#close-nav").click();
    }

    @Test
    void checkNavMenu() {
        // Step 1: Go to the site
        open(URL);
        // Step 2: Click on the link "Компания"
        $(".header--nav--btn").click();
        $(linkText("Компания")).click();
        // Step 3: Click on the link "Проекты"
        $(".header--nav--btn").click();
        $(linkText("Проекты")).click();
        // Step 4: Click on the link "Клиенты"
        $(".header--nav--btn").click();
        $(linkText("Клиенты")).click();
        // Step 5: Click on the link "Команда"
        $(".header--nav--btn").click();
        $(linkText("Команда")).click();
        // Step 6: Click on the link "Отзывы"
        $(".header--nav--btn").click();
        $(linkText("Отзывы")).click();
        // Step 7: Click on the link "Контакты"
        $(".header--nav--btn").click();
        $(linkText("Контакты")).click();
    }

}
