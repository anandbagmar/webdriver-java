import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class DemoTest extends BaseTest{

    @Test
    @CustomAnnotations ("browser,for,bar")
    public void bingSearchForWatiN()
    {
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("go")).click();

        assertEquals(driver.findElement(By.partialLinkText("Selenium - Welcome to nginx!")).getAttribute("href"), "http://seleniumhq.org/");
    }

    @Test
    @CustomAnnotations ("for,fail")
    public void failingTest()
    {
        assertEquals("failing test", 1, 2);
    }

    @Test
    @CustomAnnotations ("for,pass")
    public void passingTest()
    {
        assertEquals("passing test", 1, 1);
    }
}
