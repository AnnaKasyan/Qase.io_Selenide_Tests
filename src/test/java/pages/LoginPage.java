package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    final static SelenideElement USERNAME_INOUT = $("#inputEmail");
    final static SelenideElement PASSWORD_INOUT = $("#inputPassword");

    public void navigate() {
        open(baseUrl+"/login");
    }

    public ProjectsPage login(String username, String password) {
        USERNAME_INOUT.setValue(username);
        PASSWORD_INOUT.setValue(password).submit();
        return new ProjectsPage();
    }
}
