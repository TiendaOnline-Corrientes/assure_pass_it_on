import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import schema.request.RequestUser;
import schema.response.UserResponse;
import serialization.UserTest;
import org.testng.asserts.SoftAssert;
import static model.builder.UserRequestBuilder.createRequestUser;
import static model.factory.UserDataFactory.userWithMissingData;
import static model.factory.UserDataFactory.userWithNullInformation;

@Feature("User Creation")
public class serialization extends BaseTest {


    private RequestUser user = new RequestUser();

    private UserTest userTest = new UserTest();

    SoftAssert softassert = new SoftAssert();

    @Test
    public void createAnUser() {
        user.setName("marcos");
        user.setJob("tester");
        RestAssured.given().
                body(user).
                when().
                post("/users");
    }

    @Test
    public void isUserCorrectCreating() {
        user.setName("marcos");
        user.setJob("tester");
        UserResponse userCreated = userTest.getUserResponse(user, "/users");
        softassert.assertEquals(userCreated.getName(), "marcos");
        softassert.assertEquals(user.getJob(), "tester");
        softassert.assertAll();
    }

    // patron builder
    @Story("User Creation-User with correct values")
    @Test
    public void isUserCorrectCreating2() {
        RequestUser user = createRequestUser().
                name("marcos").
                job("tester").
                build();

        UserResponse userCreated = userTest.getUserResponse(user, ManageVariables.getPrimarilyPath());
        softassert.assertEquals(userCreated.getName(), "marcos");
        softassert.assertEquals(user.getJob(), "tester");
        softassert.assertAll();
    }

    // factory
    @Story("User Creation-User with empty values")
    @Test
    public void isUserWithEmptyValues() {
        RequestUser user =  userWithMissingData();
        UserResponse userCreated = userTest.getUserResponse(user, ManageVariables.getPrimarilyPath());
        softassert.assertEquals(userCreated.getName(), StringUtils.EMPTY);
        softassert.assertEquals(user.getJob(), StringUtils.EMPTY);
        softassert.assertAll();
    }
    @Story("User Creation-User with null values")
    @Test
    public void isUserWithNullValues() {
        RequestUser user =  userWithNullInformation();
        UserResponse userCreated = userTest.getUserResponse(user, ManageVariables.getPrimarilyPath());
        softassert.assertEquals(userCreated.getName(), null);
        softassert.assertEquals(user.getJob(), null);
        softassert.assertAll();
    }
}
