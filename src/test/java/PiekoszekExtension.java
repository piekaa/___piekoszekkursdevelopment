///hide
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.lang.reflect.Field;

public class PiekoszekExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) {
        if (throwable instanceof AssertionError) {
            replaceStackTrace(throwable, new StackTraceElement[0]);
            throw (AssertionError) throwable;
        }

        StackTraceElement[] stackTrace = throwable.getStackTrace();

        int limit = stackTrace.length;
        for (int i = 0; i < stackTrace.length; i++) {
            if (stackTrace[i].getFileName().endsWith("Test.java")) {
                limit = i;
            }
        }
        StackTraceElement[] newStackTrace = new StackTraceElement[limit];
        System.arraycopy(stackTrace, 0, newStackTrace, 0, limit);
        replaceStackTrace(throwable, newStackTrace);
        throwable.printStackTrace();
        Assertions.fail("Poleciał wyjątek, sprawdź stack trace");
    }

    private void replaceStackTrace(Throwable throwable, StackTraceElement[] newStackTrace) {
        try {
            Field field = Throwable.class
                    .getDeclaredField("stackTrace");
            field.setAccessible(true);
            field.set(throwable, newStackTrace);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
