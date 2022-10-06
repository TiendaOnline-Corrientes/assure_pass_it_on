import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Testing {

@Test
    public  void getAUser(){
    RestAssured.
            given().
            when().
                    get("").
            then().
                    assertThat().
                    statusCode(200);
}
}
