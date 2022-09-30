import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

@Feature("Create an user")
public class Example {


// get method
    @Story("Reques")
    @Test
    public void getAnUser(){
        RestAssured
                .given().
                when().
                        get("https://reqres.in/api/users/2").
                then().
                        assertThat().
                        contentType(ContentType.JSON).
                        statusCode(200);
    }
    @Test
    public void registerPost(){
        RestAssured
                .given().
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}").
                when().
                post("https://reqres.in/api/register").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
    }

    @Test
    public void putMethod(){
        RestAssured
                .given().
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}").
                when().
                put("https://reqres.in/api/users/2").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
    }
    // get method
    @Test
    public void deleteMethod(){
        RestAssured
                .given().
                when().
                get("https://reqres.in/api/users/2").
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);
    }
    @Test
    public void loggingInformation(){
        RestAssured.
                given().
                log().headers().
                when().
                get("https://reqres.in/api/users/2").
                then().
                log().body();
    }

    @Test
    public void checkElementInTheBody(){
        RestAssured.given().
                    log().headers().
                when().
                get("https://reqres.in/api/users/2").
                then().
                        log().body().
                        assertThat().
                        body("data.id",equalTo(2));

    }

    //login information

    /**
     * ver si se puede lo de la base de datos conexion.
     * */
    // data

    @Test(dataProvider ="set_data", dataProviderClass =  DataProviderMethod.class)
    public void usingDataProviderFromAnotherClass(String firstValue, String secondValue){
        System.out.println("externally data " + firstValue +" " + secondValue );
    }



}
