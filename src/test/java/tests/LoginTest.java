package tests;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest (){
        open("https://app.qase.io/login");
        $("#inputEmail").setValue("arelyeve2@gmail.com");
        $("#inputPassword").setValue("11208116").submit();
        $("#user-menu").shouldBe(visible);
    }

}
