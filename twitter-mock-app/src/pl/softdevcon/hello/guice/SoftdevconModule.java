package pl.softdevcon.hello.guice;

import com.google.inject.AbstractModule;
import pl.softdevcon.hello.twitter.SlowTwitter;
import pl.softdevcon.hello.twitter.Twitter;

public class SoftdevconModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Twitter.class).annotatedWith(Slow.class).to(SlowTwitter.class);
    }
}
