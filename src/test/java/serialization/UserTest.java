package serialization;

import io.restassured.RestAssured;
import schema.request.RequestUser;
import schema.response.UserResponse;

import static io.restassured.RestAssured.given;

public class UserTest {

    public UserResponse getUserResponse(RequestUser body, String url){
      return given().
                body(body).
                post(url).
                then().extract().
                as(UserResponse.class);
    }

    public void deleteAUserBaseOnID(String id){
         given().
                when().
                        delete("/" + id).
                 then().
                        assertThat().
                        statusCode(204);
    }

}
