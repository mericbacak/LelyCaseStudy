package LelyCaseStudy.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RestAssuredBase extends Constants {

    public void LogResponseBody() {
        when()
                .get(Uri)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();

    }

    public void ChechDataid4Digit() {
        //when().get(Uri).then().body("data.id",lessThanOrEqualTo(1000000)); when().get(Uri).then().body("data.id",greaterThanOrEqualTo(100000));
        RestAssured
                .when()
                .get(Uri)
                .then()
                .body("data.id",not(hasValue(nullValue()))).log();

        Response res = RestAssured.given().when().get(Uri);
        JsonPath js = res.jsonPath();
        List<Object> values = js.getList("data.findAll { it.id < 100000 && it.id>10000  }.id");
        if (values.size() == 0) {
            System.out.println("No id found about 4 digit");
        }
        else {
            System.out.println(values);
        }


    }

    public void PostReq() {

        String requestBody = "{\n" +
                "  \"email\": \"umut@gmail.com\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"status\": \"active\",\n"+
                "  \"name\": \"test\" \n}";


        Response response = given()
                .header("Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post(Uri)
                .then()
                .extract().response();

                JsonPath js = response.jsonPath();

        List<Object> values = js.getList("data.findAll { it.email=='umut@gmail.com' }.email");
        if (values.size() == 0) {
            System.out.println("umut@gmail.com emaili görüntülenmedi.");
        }
        else {
            System.out.println(values);
        }
        List<Object> values2 = js.getList("data.findAll { it.email=='umut@gmail.com' }.gender");
        if (values2.size() == 0) {
            System.out.println("umut@gmail.com adresine ait gender görüntülenmedi");
        }
        else {
            System.out.println(values2);
        }
        List<Object> values3 = js.getList("data.findAll { it.email=='umut@gmail.com' }.status");
        if (values3.size() == 0) {
            System.out.println("umut@gmail.com adresine ait status görüntülenmedi.");
        }
        else {
            System.out.println(values3);
        }
        List<Object> values4 = js.getList("data.findAll { it.email=='umut@gmail.com' }.name");
        if (values3.size() == 0) {
            System.out.println("umut@gmail.com adresine ait name görüntülenmedi.");
        }
        else {
            System.out.println(values4);
        }



    }
    public void CheckAlreadyBeTaken(){
        String requestBody = "{\n" +
                "  \"email\": \"umut@gmail.com\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"status\": \"active\",\n"+
                "  \"name\": \"test\" \n}";


        Response response = (Response) given()
                .header("Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post(Uri);
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(422);
        response.then().body("message",containsString("has already been taken"));
        //System.out.println("The time taken to fetch the response "+post(Uri)
        //.timeIn(TimeUnit.MILLISECONDS) + " milliseconds");


    }

}
