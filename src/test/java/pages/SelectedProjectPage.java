package pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestDataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SelectedProjectPage {

    final static SelenideElement SUITES_LINK = $(byText("Suites"));
    final static SelenideElement CREATE_CASE_BUTTON = $("#create-case-button");
    final static SelenideElement EDIT_CASE_BUTTON = $("a[title='Edit case']");
    final String testCaseLocator = "//*[@id='suitecases-container']//div[text()='%s']";
    final String testCaseTitle = TestDataHelper.getTestCaseData().getTitle();

    public SelectedProjectPage isProductsPageOpened() {
        SUITES_LINK.shouldBe(visible);
        return this;
    }

    public CreateTestCasePage clickCreateCaseButton() {
        CREATE_CASE_BUTTON.click();
        return new CreateTestCasePage();
    }

    public CreateTestCasePage openDetailsTestCase() {
        $(byXpath(String.format(testCaseLocator, testCaseTitle))).click();
        return new CreateTestCasePage();
    }

    public EditTestCasePage clickEditCaseButton() {
        EDIT_CASE_BUTTON.click();
        return new EditTestCasePage();
    }
}
