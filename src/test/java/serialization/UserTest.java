package serialization;

import io.restassured.RestAssured;
import schema.request.RequestUser;
import schema.response.UserResponse;

public class UserTest {

    public UserResponse getUserResponse(RequestUser body, String url){
      return   RestAssured.
                given().
                body(body).
                post(url).
                then().extract().
                as(UserResponse.class);
    }
}
