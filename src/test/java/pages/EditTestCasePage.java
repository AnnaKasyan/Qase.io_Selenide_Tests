package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Placeholder;
import models.TestCase;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class EditTestCasePage {

    final static SelenideElement TITLE = $("#title");
    final static SelenideElement CANCEL_BUTTON = $(byXpath("//button[text()='Cancel']"));

    public TestCase getTestCaseDetails() {
        TestCase testCase = new TestCase();
        testCase.setTitle(TITLE.val());
        testCase.setDescription(new Placeholder("description").getText());
        testCase.setPre_conditions(new Placeholder("description").getText());
        testCase.setPost_conditions(new Placeholder("description").getText());
        testCase.setPriority(new Dropdown("priority").getText());
        testCase.setSeverity(new Dropdown("severity").getText());
        testCase.setType(new Dropdown("type").getText());
        testCase.setSuite(new Dropdown("suite").getText());
        return testCase;
    }

    public SelectedProjectPage clickCancelButton() {
        CANCEL_BUTTON.click();
        return new SelectedProjectPage();
    }
}
