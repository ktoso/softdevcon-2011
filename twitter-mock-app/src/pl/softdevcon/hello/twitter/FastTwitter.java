package pl.softdevcon.hello.twitter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class FastTwitter implements Twitter {
    
    List<Tweet> tweets = newArrayList();
    
    @Override
    public List<Tweet> publicTimeline() {
        return tweets;
    }

    @Override
    public void post(Tweet tweet) {
        tweets.add(tweet);
        sortTweets();
    }

    private void sortTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet tweet, Tweet tweet1) {
                return tweet.date.compareTo(tweet1.date);
            }
        });
    }
}
