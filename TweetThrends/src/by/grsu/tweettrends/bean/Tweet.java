package by.grsu.tweettrends.bean;

public class Tweet {
    private Coordinate coordinate;

    private String textTweet;
    private double tweetSentiment;

    public Tweet(Coordinate coordinate, String tweet, double tweetSentiment) {
        this.coordinate = coordinate;
        textTweet = tweet;
        this.tweetSentiment = tweetSentiment;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
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
