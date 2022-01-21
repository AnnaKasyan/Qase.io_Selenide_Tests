package tests;

import adapters.CaseAdapter;
import models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CaseApiTest {
    CaseAdapter caseAdapter;
    String projectCode = "CODE";

    @BeforeClass
    public void setUp() {
        caseAdapter = new CaseAdapter();
    }


    @Test
    public void createCaseTest() {
        CaseResponseBody expectedResponse = CaseResponseBody.builder().
                status(true).
                result(ResultCode.builder().
                        code(projectCode).
                        build()).
                build();
        Case testCase = Case.builder().
                code(projectCode).
                description("description").
                preconditions("pre_conditions").
                postconditions("post_conditions").
                title("TestCase125").
                severity(2).
                priority(2).
                type(2).
                build();
        CaseResponseBody actualResponse = caseAdapter.createCase(projectCode,testCase);
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getCaseTest() {
        String id = "3";
        Case expectedCase = Case.builder().
                        id(3).
                        position(3).
                        title("TestCase").
                        description("description").
                        preconditions("pre_conditions").
                        postconditions("post_conditions").
                        severity(2).
                        priority(2).
                        type(2).
                        build();
        CaseResponseBody<Object> expectedResponseResult = CaseResponseBody.builder().
                status(true).result(expectedCase).build();
        CaseResponseBody<Case> actualResponseBody = caseAdapter.getCase(projectCode, id,200);
        assertEquals(actualResponseBody, expectedResponseResult);
    }


    @Test
    public void getAllProjectsTest() {
        CaseResponseBody<AllCases> actualResponse = caseAdapter.getAllCases(projectCode,200);
        System.out.println(actualResponse);
    }

    @Test
    public void deleteCaseTest() {
        String id = "5";;
        CaseResponseBody<AllCases> actualResponse =  caseAdapter.deleteCase(projectCode,id);
        System.out.println(actualResponse);

    }
}
