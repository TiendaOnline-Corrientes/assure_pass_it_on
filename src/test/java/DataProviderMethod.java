
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class DataProviderMethod {

    private JSONObject bodyParameters = new JSONObject();

    @DataProvider(name = "set_data")
    public Object[][] feedData() {

        return new Object[][]{
                {"marcos", "qa engineer"},
                {"ken", "chairman"}
        };
    }

    @Test(dataProvider = "set_data")
    public void createUser(String name, String job) {
        bodyParameters.put("name", name);
        bodyParameters.put("job", job);
        given().
                log().
                all().
                contentType(ContentType.JSON).
                body(bodyParameters.toString()).
                when().
                post("https://reqres.in/api/users").
                then().
                log().
                all();

    }
}
