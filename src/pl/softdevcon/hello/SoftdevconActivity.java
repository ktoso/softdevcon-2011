package pl.softdevcon.hello;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.google.inject.Inject;
import pl.softdevcon.hello.twitter.Tweet;
import pl.softdevcon.hello.twitter.Twitter;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.List;

public class SoftdevconActivity extends RoboActivity implements View.OnClickListener {

    private static final String TAG = SoftdevconActivity.class.getSimpleName();

    private static final String AUTHOR = "Konrad";

    @Inject
    Twitter twitter;

    @InjectView(R.id.msg)
    EditText msg;

    @InjectView(R.id.tweets)
    ListView tweets;

    @InjectView(R.id.send)
    Button send;

    @InjectView(R.id.hello)
    TextView hello;

    @Inject
    LayoutInflater inflater;

    ArrayAdapter tweetsAdapter;
    private List<Tweet> visibleTweets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        twitter.post(new Tweet("Hello World", AUTHOR));
        twitter.post(new Tweet("Hello Warszawa", AUTHOR));
        twitter.post(new Tweet("Hello Poznan", AUTHOR));
        twitter.post(new Tweet("Hello Wroclaw", AUTHOR));

        visibleTweets = twitter.publicTimeline();

        for (Tweet tweet : visibleTweets) {
            Log.i(TAG, tweet.toString());
        }

        send.setOnClickListener(this);

        //noinspection unchecked
        tweetsAdapter = new TweetAdapter();
        tweets.setAdapter(tweetsAdapter);

    }

    @Override
    public void onClick(View view) {
        Tweet tweet = new Tweet(msg.getText().toString(), AUTHOR);

        Log.i(TAG, "Creating post: " + tweet);
        twitter.post(tweet);

        visibleTweets = twitter.publicTimeline();
//        tweetsAdapter.notifyDataSetChanged(); // todo this is needed :-)
    }

    private class TweetAdapter extends ArrayAdapter<Tweet> {
        public TweetAdapter() {
            super(SoftdevconActivity.this, R.layout.tweet, R.id.tweet_message, SoftdevconActivity.this.visibleTweets);
        }

//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View row;
//
//            if (null == convertView) {
//                row = inflater.inflate(R.layout.tweet, null);
//            } else {
//                row = convertView;
//            }
//
//            TextView tv = (TextView) row.findViewById(R.id.tweet_message);
//
//            Tweet theTweet = getItem(position);
//            tv.setText(theTweet.toString());
//
//            return row;
//        }
    }
}
