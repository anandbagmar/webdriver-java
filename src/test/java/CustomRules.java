import org.junit.Rule;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runners.model.Statement;

import static org.junit.Assert.assertTrue;

public class CustomRules extends RunListener {
    private static String watchedLog;
    private static long startTime;
    private static long finishedTime;

    @Rule
    public TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            watchedLog += description.getDisplayName() + " " + "success!\n";
        }

        @Override
        protected void failed(Throwable e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }

        @Override
        protected void starting(Description description) {
            startTime = System.currentTimeMillis();
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            finishedTime = System.currentTimeMillis();
            if (description.getAnnotations().contains("foo")) {
                long expectedTime = 4000;
                assertTrue("Test took more time than expected to execute. Expected: <" + expectedTime + ", Actual: " + (finishedTime - startTime), (finishedTime - startTime) < expectedTime);
            }
            super.finished(description);
        }
    };
}
