package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.ProjectsPage;
import utils.PropertyReader;

public abstract class BaseTest {

    String USERNAME = System.getenv().getOrDefault("USER_NAME", PropertyReader.getProperty("qase.username"));
    String PASSWORD = System.getenv().getOrDefault("USER_PASSWORD", PropertyReader.getProperty("qase.password"));
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;


    @BeforeSuite
    public void setUp() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }
}
