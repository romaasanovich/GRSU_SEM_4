package by.grsu.tweettrends.repository;

import by.grsu.tweettrends.bean.Tweet;
import by.grsu.tweettrends.utills.Converter;

import java.util.ArrayList;
import java.util.List;

public class TweetRepository {
    private ArrayList<Tweet> tweets = new ArrayList<>();

    public TweetRepository() {
        this.tweets = Converter.fromStrToTweets();
    }


    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
