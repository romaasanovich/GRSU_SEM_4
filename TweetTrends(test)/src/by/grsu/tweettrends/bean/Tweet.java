package by.grsu.tweettrends.bean;

public class Tweet {
    private Location location ;
    private String textTweet;
    private double tweetSentiment;

    public Tweet(Location location,String tweet,double tweetSentiment ){
        this.location=location;
        textTweet=tweet;
        this.tweetSentiment =tweetSentiment;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTextTweet() {
        return textTweet;
    }

    public void setTextTweet(String textTweet) {
        this.textTweet = textTweet;
    }

    public double getTweetSentiment() {
        return tweetSentiment;
    }

    public void setTweetSentiment(double tweetSentiment) {
        this.tweetSentiment = tweetSentiment;
    }


}
