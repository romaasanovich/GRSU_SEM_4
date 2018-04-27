package by.grsu.tweettrends.bean;

import java.util.ArrayList;
import java.util.Map;

public class State {
    private String nameState;

    private ArrayList<Polygon> polygons = new ArrayList<>();

    private double sumSentiment;

    private int countOfTweets;

    public double getSumSentiment() {
        return sumSentiment;
    }

    public String getNameState() {
        return nameState;
    }

    public double getSentiment() {
        if (countOfTweets != 0) {
            return sumSentiment / countOfTweets;
        }
        return 0.0;
    }

    public void setSumSentiment(double sumSentiment) {
        this.sumSentiment = sumSentiment;
    }

    public int getCountOfTweets() {
        return countOfTweets;
    }

    public void setCountOfTweets(int countOfTweets) {
        this.countOfTweets = countOfTweets;
    }

    public State(String nameState) {
        this.nameState = nameState;
    }

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }

    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }
}
