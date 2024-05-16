package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class GRequest {

    @Given("User should be able to send get request")
    public void userShouldBeAbleToSendGetRequest() {
        int expectedstatuscode =200;
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking")
                .then().log().all().statusCode(200);
                assertEquals(200,expectedstatuscode);
                System.out.println("Status code    "   + expectedstatuscode);





    }



    @And("User should receive a response with status code")
    public void userShouldReceiveAResponseWithStatusCode() {

    }


}
