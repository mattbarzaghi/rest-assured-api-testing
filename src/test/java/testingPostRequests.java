import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class testingPostRequests {

    @Test
    public void test_01(){

        // create new map with body request
        Map<String, Object> map = new HashMap<>();

        map.put("name", "Matteo");
        map.put("job", "Test automation developer");

        //System.out.println(map);

        JSONObject request = new JSONObject(map);

        request.put("name", "Matteo");
        request.put("job", "Test automation developer");

        given()
                .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .log().all();
    }



}
