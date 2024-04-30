package StepsDef;

import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.given;

public class postReq {

        @Given("^Post request validation$")
    public void Postrequestvalidation(){
     String Userdata ="{"+" \"name\":\"Shipra Tripathi\", "+" \"email\":\"shipra.tripathi@gmail.com\","+" \"Position\":\"Test Analyst\" "+"}";
     given().header("Content-Type", "application/json; charset=utf-8")
             .when().post("https://reqres.in/api/users/2")
             .then()
             .assertThat().statusCode(201)
             .log().all();
     System.out.println(Userdata);

     //(we taking string)this is the payload which is in JSON string format
            // What kind of data we need to send as a payload in Given keyword,because we want to create new data
            //When we create new user it will return https status code 201

        }

    }

