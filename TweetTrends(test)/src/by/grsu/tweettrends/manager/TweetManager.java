package by.grsu.tweettrends.manager;

import by.grsu.tweettrends.bean.Tweet;
import by.grsu.tweettrends.repository.Dictionary;
import by.grsu.tweettrends.repository.TweetRepository;

import java.util.ArrayList;
import java.util.Map;

public class TweetManager {
    private TweetRepository tweetRepository;

    public TweetManager() {
        tweetRepository = new TweetRepository();
        setTweetsSentiment();
    }

    public TweetRepository getTweetRepository() {
        return tweetRepository;
    }

    public void setTweetRepository(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }


    private void setTweetsSentiment() {
        ArrayList<Tweet> tweets = tweetRepository.getTweets();
        Map<String, Double> dict = new Dictionary().getDictionary();
        for (Tweet tweet : tweets) {
            String[] words = tweet.getTextTweet().split(" ");
            double tweetSentiment = 0;
            for (String word : words) {
                word = word.toLowerCase();
                Double sent = dict.get(word);
                if(sent!= null) {
                    tweetSentiment += sent;
                }
            }
            tweet.setTweetSentiment(tweetSentiment);
        }
    }


}
