import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OneMoreTest extends BaseTest {

    @Test
    @CustomAnnotations("foo,fail")
    public void failingTest() {
        assertEquals("pass", 1, 1);
        assertEquals("failing test", 1, 2);
    }

    @Test
    @CustomAnnotations("foo,pass")
    public void passingTest() {
        assertEquals("passing test", 1, 1);
        assertEquals("passing test", 2, 2);
    }
}
