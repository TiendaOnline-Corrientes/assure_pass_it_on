import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;


public class Example {



    @Test
    public void firsGetMethod(){
                given().
                when().
                        get("https://reqres.in/api/users/2").
                then().
                        assertThat().
                        contentType(ContentType.JSON).
                statusCode(200);
    }

    @Test
    public void loggingInformation(){
        given().
                log().headers().
                when().
                get("https://reqres.in/api/users/2").
                then().
                log().body();
    }

    @Test
    public void checkElementInTheBody(){
        given().
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
