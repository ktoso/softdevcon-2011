package pl.softdevcon.hello.twitter;

import android.util.Log;
import pl.softdevcon.hello.guice.Slow;

import java.util.List;

@Slow
public class SlowTwitter extends FastTwitter implements Twitter {

    private static final String TAG = SlowTwitter.class.getSimpleName();

    private static final int HOW_SLOW = 10000;

    @Override
    public List<Tweet> publicTimeline() {
        beSlow();

        return super.publicTimeline();
    }

    @Override
    public void post(Tweet tweet) {
        beSlow();

        super.post(tweet);
    }

    private void beSlow() {
        try {
            Thread.sleep(HOW_SLOW);
        } catch (InterruptedException e) {
            Log.e(TAG, "Oh no!", e);
        }
    }
}
