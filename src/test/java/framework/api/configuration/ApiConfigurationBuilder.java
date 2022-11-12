package framework.api.configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static confuguration.YamlPropertiesReader.getApiBaseUri;

public class ApiConfigurationBuilder {

    public static RequestSpecification buildRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(getApiBaseUri())
                .setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}
