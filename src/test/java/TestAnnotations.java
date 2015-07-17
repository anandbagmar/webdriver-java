import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.Arrays;

public class TestAnnotations extends TestWatcher{
    private CustomAnnotations customAnnotations;

    @Override
    protected void starting( Description description) {
        customAnnotations = description.getAnnotation( CustomAnnotations.class);
    }

    public CustomAnnotations getCustomAnnotations() {
        return customAnnotations;
    }

    /** @return the name field attached to the marker.
    Null if no annotation, "" if no value field. */
    public ArrayList<String> getCustomAnnotationsValue() {
        if( customAnnotations == null) {
            return null;
        }
        return new ArrayList<String> (Arrays.asList(customAnnotations.value().split(",")));
    }
}
