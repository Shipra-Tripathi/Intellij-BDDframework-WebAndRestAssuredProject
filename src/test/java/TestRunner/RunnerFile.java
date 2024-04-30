package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "src/main/resources/Files/AskmeOffer.feature", //given feature file path

        glue = "StepsDef",//given step def path

        plugin= {"pretty","html:target/myReport.html"})


public class RunnerFile {

}




        //tags = "@Regression",

          //using tags in cucumber we can execute particular scenarios
         //even if don't want to execute failed scenario we use tags= "not @name"



        //Pretty Format generates the Cucumber test report in the HTML format, i.e. an HTML file


        //monochrome = true,  //display the console output in readable format
        //dryRun = false


