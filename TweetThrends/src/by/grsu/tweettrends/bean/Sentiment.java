package by.grsu.tweettrends.bean;

public class Sentiment {
    String word;
    double sentiment;

    public Sentiment(String word, double sentiment) {
        this.word = word;
        this.sentiment = sentiment;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getSentiment() {
        return sentiment;
    }

    public void setSentiment(double sentiment) {
        this.sentiment = sentiment;
    }

}
