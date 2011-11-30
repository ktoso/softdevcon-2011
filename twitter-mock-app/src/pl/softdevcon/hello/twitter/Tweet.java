package pl.softdevcon.hello.twitter;

import org.joda.time.DateTime;

public class Tweet {
    public final String author;
    public final String message;
    public final DateTime date;

    public Tweet(String message, String author) {
        this(message, author, new DateTime());
    }

    public Tweet(String message, String author, DateTime date) {
        this.author = author;
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString() {
        return "\"" + message + "\"" + " by " + author + " @ " + date;
    }
}
