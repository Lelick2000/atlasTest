package framework.api.service;

import framework.api.endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import project.models.UserJob;

import static framework.api.configuration.ApiConfigurationBuilder.buildRequestSpecification;

public class ApiService {
    private final RequestSpecification requestSpec = buildRequestSpecification();

    public JsonPath getUsersPage(Integer page) {
        return RestAssured.given(requestSpec)
                .pathParams("page", page)
                .get(Endpoints.USERS_WITH_PAGE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }

    public UserJob postUsers(UserJob userJob) {
        return RestAssured.given(requestSpec)
                .body(userJob)
                .post(Endpoints.USERS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(UserJob.class);
    }
}
