package by.grsu.tweettrends.repository;

import by.grsu.tweettrends.bean.Tweet;
import by.grsu.tweettrends.utills.Converter;

import java.util.ArrayList;
import java.util.List;

public class TweetRepository {
    private ArrayList<Tweet> tweets = new ArrayList<>();

    private static TweetRepository instance;

    public static TweetRepository getInstance() {
        if (instance == null) {
            instance = new TweetRepository();
        }
        return instance;
    }

    private TweetRepository() {

    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
