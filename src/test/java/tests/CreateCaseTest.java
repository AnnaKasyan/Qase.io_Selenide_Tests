package tests;

import models.TestCase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateTestCasePage;
import pages.EditTestCasePage;
import pages.SelectedProjectPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertEquals;

public class CreateCaseTest extends BaseTest {

    protected SelectedProjectPage selectedProjectPage;
    protected CreateTestCasePage createTestCasePage;
    protected EditTestCasePage editTestCasePage;

    @BeforeMethod
    public void initialize() {
        loginPage.navigate();
        loginPage.login(USERNAME, PASSWORD);
        selectedProjectPage = new SelectedProjectPage();
        createTestCasePage = new CreateTestCasePage();
        editTestCasePage = new EditTestCasePage();
    }

    @Test
    public void createTestCaseTest() {
        projectsPage.chooseProject();
        selectedProjectPage.isProductsPageOpened()
                .clickCreateCaseButton()
                .fillForm(TestDataHelper.getTestCaseData())
                .clickSaveButton()
                .openDetailsTestCase();
        TestCase actualDetailsTestCase = selectedProjectPage.clickEditCaseButton()
                .getTestCaseDetails();
        editTestCasePage.clickCancelButton();
        assertEquals(actualDetailsTestCase, TestDataHelper.getTestCaseData());
    }
}
