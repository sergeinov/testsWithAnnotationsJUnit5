package com.arcsinus;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class ArcsinusTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    void checkMenuButton(){

    }

    void checkNavMenu() {

    }

}
