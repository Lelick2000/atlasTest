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

    @Step("Get users with page param= {0}")
    public JsonPath getUsersWithPage(Integer page) {
        return apiService.getUsersPage(page);
    }

    @Step("Check that page param = {0}")
    public void checkPageParam(Integer page, JsonPath responseBody) {
        assertEquals(page, responseBody.get("page"));
    }

    @Step("Check response name= {0}")
    public void checkResponseContainsName(String name, JsonPath responseBody) {
        List<ApiUser> responseUsersList = responseBody.getList("data", ApiUser.class);
        assertTrue(responseUsersList.stream().anyMatch(el -> el.getFirstName().equals(name)), "No such name");
    }

    @Step("Post user with body params")
    public UserJob postUser(UserJob userJob) {
        return apiService.postUsers(userJob);

    }
}
