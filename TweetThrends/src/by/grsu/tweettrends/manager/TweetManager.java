package by.grsu.tweettrends.manager;

import by.grsu.tweettrends.bean.Tweet;
import by.grsu.tweettrends.repository.Dictionary;
import by.grsu.tweettrends.repository.TweetRepository;
import by.grsu.tweettrends.utills.Converter;

import java.util.ArrayList;
import java.util.Map;

public class TweetManager {
    private TweetRepository tweetRepository;

    public TweetManager() {
        this.tweetRepository = TweetRepository.getInstance();
    }

    public TweetRepository getTweetRepository() {
        return tweetRepository;
    }

    public void setTweetRepository(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public void readTweets(){
        tweetRepository.setTweets(Converter.fromStrToTweets());
        setTweetsSentiment();
    }

    private void setTweetsSentiment() {
        ArrayList<Tweet> tweets = tweetRepository.getTweets();
        Map<String, Double> dict = Dictionary.getInstance().getDictionary();
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
