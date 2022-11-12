package project.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.actions.api.steps.ApiSteps;
import project.models.UserJob;

public class ApiTests {
    private final UserJob userJob = new UserJob("Alex_test", "atlas_test");
    private final ApiSteps apiSteps = new ApiSteps();

    @BeforeClass
    @Parameters({"", ""})
    public void readParams() {
    }

    @Test
    public void getUsersWithPageTest() {
        apiSteps.getUsersWithPage(2, "Lindsay");
    }

    @Test
    public void postUserTest() {
        apiSteps.postUser(userJob);
    }
}
