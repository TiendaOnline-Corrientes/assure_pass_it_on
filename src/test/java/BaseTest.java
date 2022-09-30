import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.filters;

public abstract class BaseTest {


    @BeforeClass
    public static void settings() {
        RestAssured.requestSpecification = setRequestSpecification(ManageVariables.getHost(),ManageVariables.getPath());
    }

    private static RequestSpecification setRequestSpecification(String baseUri, String basePath) {
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
        return new RequestSpecBuilder().
                setBaseUri(baseUri).
                setBasePath(basePath).
                setContentType(ContentType.JSON)
                .build();
    }

    public ResponseSpecification verifyStatusAndContentType(int code) {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                expectStatusCode(code).
                build();
    }
}
