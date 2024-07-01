package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {//report plugins
                "pretty",//prints colored logs to the console
                "html:target/reports/default-cucumber-reports.html",//plugin used to generate reports in html format
        },
        features = "src/test/resources/",
        glue = {"stepdefinitions","Hooks"},// java code larinin calisacagi package lar.
        tags = "@Department1",
        dryRun = false // test calismasi icin false dememiz gerekiyor.
        // True dendigi zaman test calismaz,sadece eksik definitionlar verir.

)
public class RunnerUsers {}

