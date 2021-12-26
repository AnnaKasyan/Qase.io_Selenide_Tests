package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }
}
