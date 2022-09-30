import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Testing {

    @Test
    public void FirstTest(){
        RestAssured.
                given().
                contentType(ContentType.JSON).
                when().
                get("https://reqres.in/api/users/2").
                then().log().all();
    }
}
