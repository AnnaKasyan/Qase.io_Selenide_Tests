package utils;

import models.TestCase;

public class TestDataHelper {

    public static TestCase getTestCaseData() {
        TestCase dataTestCase = TestCase.builder()
                .title("Test Case")
                .description("This is test case")
                .pre_conditions("123")
                .post_conditions("456")
                .priority("Low")
                .severity("Minor")
                .type("Usability")
                .suite("Test cases without suite")
                .build();
        return dataTestCase;
    }
}
