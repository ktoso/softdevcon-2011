package pl.softdevcon.hello;

import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.runners.model.InitializationError;
import pl.softdevcon.hello.guice.SoftdevconApplication;

public class InjectingRobolectricTestRunner extends RobolectricTestRunner {
    public InjectingRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    public void prepareTest(Object test) {
        SoftdevconApplication application = (SoftdevconApplication) Robolectric.application;
        Injector injector = application.getInjector();
        injector.injectMembers(test);
    }
}
