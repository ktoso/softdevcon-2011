package pl.softdevcon.hello.guice;

import com.google.inject.Module;
import roboguice.application.RoboApplication;

import java.util.List;

public class SoftdevconApplication extends RoboApplication{

    @Override
    protected void addApplicationModules(List<Module> modules) {
        modules.add(new SoftdevconModule());
    }

}
