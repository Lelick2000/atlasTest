package project.actions.api.steps;

import framework.api.service.ApiService;
import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Step;
import project.models.ApiUser;
import project.models.UserJob;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiSteps {
    private final ApiService apiService = new ApiService();

    @Step("Get users with page param")
    public void getUsersWithPage(Integer page, String name) {
        JsonPath responseBody = apiService.getUsersPage(page);
        assertEquals(page, responseBody.get("page"));

        List<ApiUser> responseUsersList = responseBody.getList("data", ApiUser.class);
        assertTrue(responseUsersList.stream().anyMatch(el -> el.getFirstName().equals(name)), "No such name");
    }

    @Step("Post user with body params")
    public void postUser(UserJob userJob) {
        UserJob responseJob = apiService.postUsers(userJob);
        assertEquals(userJob.getName(), responseJob.getName());
        assertEquals(userJob.getJob(), responseJob.getJob());
    }
}
