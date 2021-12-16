import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testingGetRequests {

    @Test
    public void test_01(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void test_02(){
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }

    @Test public void test_03(){
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.first_name[2]", equalTo("Tobias"))
                .log().all();
    }

    @Test public void test_04(){
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"))
                .log().all();
    }



}