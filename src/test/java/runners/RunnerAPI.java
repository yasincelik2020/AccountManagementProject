package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {//report plugins
                "pretty",//prints colored logs to the console
                "html:target/reports/html_reports/cucumber.html", //html formatinda rapor almak icin kullanilan plugin
                "json:target/reports/json-reports/cucumber1.json", //json formatinda rapor almak icin kullanilan plugin
                "junit:target/reports/xml-reports/cucumber1.xml",//plugin used to generate reports in html format
        },
        features = "src/test/resources/featuresAPI",
        glue = {"stepdefinitions"},// java code larinin calisacagi package lar.
        tags = "@10_01",
        dryRun = false // test calismasi icin false dememiz gerekiyor.
        // True dendigi zaman test calismaz,sadece eksik definitionlar verir.

)
public class RunnerAPI {}

