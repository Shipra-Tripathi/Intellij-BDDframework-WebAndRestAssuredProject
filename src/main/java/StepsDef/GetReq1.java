package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;


import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;


public class GetReq1 {

    @Given("User able to send the Get request")
    public void userAbleToSendTheGetRequest() {
        int expectedStatuscode =200;
             given()
              .baseUri("http://universities.hipolabs.com")
              .queryParam("country","South Africa")
              .queryParam("name", "University of Stellenbosch")
              .when()
              .get("/search")//?mark ke phle jo lika hai resources is- ("/search")
          .then().log().all().statusCode(200);
        assertEquals(200,expectedStatuscode,"statuscodematch");
        System.out.println( "StatuscodeMatch   "+   expectedStatuscode);




        //connection timeout
       //RestAssured.config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", 5000).setParam("http.socket.timeout", 5000));

}


    @And("User should be receive a response with status code")
    public void userShouldBeReceiveAResponseWithStatusCode() {





    }
}

