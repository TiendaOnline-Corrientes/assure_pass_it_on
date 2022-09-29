import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseTestUsage extends BaseTest {

    @Test
    public void getBreweryLists() {
        given().
                get("/users?page=2");

    }

    //agregar otro ejemplo.

}
