package pl.softdevcon.hello.twitter;

import com.google.inject.ImplementedBy;

import java.util.List;

@ImplementedBy(FastTwitter.class)
public interface Twitter {

    List<Tweet> publicTimeline();

    void post(Tweet tweet);

}
