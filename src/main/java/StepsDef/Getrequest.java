package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;


public class Getrequest {

        @Given("^validate get operations$")
        public void validategetoperations(){
      given().header("Content-Type","application/json; charset=utf-8")
              .when().get("https://reqres.in/api/users?page=2")
              .then()
              .assertThat().statusCode(200)
              .body("data.email[0]",equalTo("michael.lawson@reqres.in"))
               .body("data.id[0]",equalTo(7))
               .body("data.first_name[0]", equalTo("Michael"))
              .body("data.last_name[0]",equalTo("Lawson"))
              .body("data.email[1]",equalTo("lindsay.ferguson@reqres.in"))
              .body("data.first_name[1]",equalTo("Lindsay"))
              .body("data.last_name[1]",equalTo("Ferguson"))
              .body("data.id[1]",equalTo(8))


              .log().all(); //this line is use for printing all the response in console





            //.body("data.last_name[0]", equalTo("sykk")) //wrong data verify




        }



}

