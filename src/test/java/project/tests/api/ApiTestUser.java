package project.tests.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Steps;
import project.actions.api.steps.ApiSteps;
import project.models.UserJob;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTestUser {
    private final UserJob requestUser = new UserJob();
    private UserJob responseUser = new UserJob();
    private JsonPath response;
    @Steps
    ApiSteps apiSteps;

    @When("I make GET USERS with param page = {int} with response status 200")
    public void getUsersWithPage(Integer page) {
        response = apiSteps.getUsersWithPage(page);
    }

    @Then("The response have “first_name” with value = {string}")
    public void checkFirstNameInResponse(String name) {
        apiSteps.checkResponseContainsName(name, response);
    }

    @And("The response page param has value {int}")
    public void checkPageParamInResponse(Integer page) {
        apiSteps.checkPageParam(page, response);
    }

    @When("I make Post USERS with username= {string} and job title = {string} with response status 201")
    public void postNewUserWithJob(String name, String job) {
        requestUser.setName(name);
        requestUser.setJob(job);
        responseUser = apiSteps.postUser(requestUser);
    }

    @Then("The response have name equals to request one")
    public void checkUsersWithFieldName() {
        assertEquals(requestUser.getName(), responseUser.getName());
    }

    @Then("The response have job equals to request one")
    public void checkUsersWithFieldJob() {
        assertEquals(requestUser.getJob(), responseUser.getJob());
    }
}
