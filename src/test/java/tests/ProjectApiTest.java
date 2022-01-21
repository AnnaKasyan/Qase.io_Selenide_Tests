package tests;

import adapters.ProjectAdapter;
import models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectApiTest {

    ProjectAdapter projectAdapter;

    @BeforeClass
    public void setUp() {
        projectAdapter = new ProjectAdapter();
    }


    @Test
    public void createProjectPositiveTest() {
        String projectCode = "CODE";
        ProjectResponseBody expectedResponse = ProjectResponseBody.builder().
                status(true).
                result(ResultCode.builder().
                        code(projectCode).
                        build()).
                build();
        Project project = Project.builder().
                title("TestProject").
                code(projectCode).
                build();
        ProjectResponseBody actualResponse = projectAdapter.createProject(project);
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getProjectTest() {
        String code = "CODE";
        Project expectedProject = Project.builder().
                title("TestProject").
                code(code).
                counts(Counts.builder().
                        suites(0).
                        cases(0).
                        milestones(0).
                        projectDefectsModel(ProjectDefectsModel.builder().
                                open(0).
                                total(0).
                                build()).
                        runs(Runs.builder().
                                total(0).
                                active(0).
                                build()).
                        build()).
                build();
        ProjectResponseBody<Object> expectedResponseResult = ProjectResponseBody.builder().
                status(true).result(expectedProject).build();
        ProjectResponseBody<Project> actualResponseBody = projectAdapter.getProject(code, 200);
        assertEquals(actualResponseBody, expectedResponseResult);
    }


    @Test
    public void getAllProjectsTest() {
        ProjectResponseBody<AllProjects> actualResponse = projectAdapter.getAllProjects(200);
        System.out.println(actualResponse);
        System.out.println(actualResponse.getResult().getEntities()[4].getCode());
    }

    @Test
    public void deleteProjectTest() {
        String projectCode = "CODE1";
        ProjectResponseBody<AllProjects> actualResponse = projectAdapter.deleteProject(projectCode);
        System.out.println(actualResponse);

    }
}
