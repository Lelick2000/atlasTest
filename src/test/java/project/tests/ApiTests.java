package project.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import project.actions.api.steps.ApiSteps;
import project.models.UserJob;

@ExtendWith(SerenityJUnit5Extension.class)
public class ApiTests {
    private final UserJob userJob = new UserJob("Alex_test", "atlas_test");
    @Steps
    ApiSteps apiSteps;

    @Test
    public void getUsersWithPageTest() {
        apiSteps.getUsersWithPage(2, "Lindsay");
    }

    @Test
    public void postUserTest() {
        apiSteps.postUser(userJob);
    }
}
