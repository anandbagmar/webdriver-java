import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

import static org.junit.Assume.assumeTrue;

public class BaseTest extends CustomRules {
    protected WebDriver driver;

    @Rule
    public TestAnnotations testAnnotations = new TestAnnotations();

    @Before
    public void setUp() throws Exception {
        System.out.println("*** in setUp");

        if (null != System.getenv("only"))
        {
            String runOnly = System.getenv("only");
            System.out.println("*_*_ runOnly annotations: " + runOnly);
            System.out.println("*_*_ Current test Annotations: " + testAnnotations.getCustomAnnotations().value());
            ArrayList<String> customAnnotations = testAnnotations.getCustomAnnotationsValue();
            if( null != customAnnotations) {
                assumeTrue("Test selection criteria not met for: " + runOnly, customAnnotations.contains(runOnly));
            }
        }
        else {
            System.out.println("_*_* Run all tests");
        }

        driver = new FirefoxDriver();
        driver.navigate().to("http://www.bing.com");
    }

    @After
    public void tearDown() throws Exception {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
