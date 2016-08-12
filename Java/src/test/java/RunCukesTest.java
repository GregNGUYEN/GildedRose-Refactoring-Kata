import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@CucumberOptions(features="src/features/",
        format = {"pretty", "html:target/report/",
                "json:target/report/cucu_json_report.json",
                "junit:target/report/cucumber_junit_report.xml",})


@RunWith(Cucumber.class)
public class RunCukesTest {
    // this is the adapter/bridge code
    // between cucumber jvm and junit
    // you do not need to edit this
}
 