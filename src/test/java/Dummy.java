import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Dummy {


    @Test
    public void getAnUser(){
        RestAssured.
                given().
                contentType(ContentType.JSON).
                when().
                get("https://reqres.in/api/users/2").
                then().
                        assertThat().
                        statusCode(201);
    }
}
