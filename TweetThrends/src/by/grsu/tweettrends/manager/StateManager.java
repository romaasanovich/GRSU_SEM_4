package by.grsu.tweettrends.manager;

import by.grsu.tweettrends.bean.Coordinate;
import by.grsu.tweettrends.bean.Polygon;
import by.grsu.tweettrends.bean.State;
import by.grsu.tweettrends.bean.Tweet;
import by.grsu.tweettrends.repository.StateRepository;
import by.grsu.tweettrends.utills.Converter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StateManager {
    StateRepository stateRepository;

    public StateManager() {
        this.stateRepository = StateRepository.getInstance();
    }

    public StateRepository getStateRepository() {
        return stateRepository;
    }

    public void readStateFromJson() throws FileNotFoundException {
        stateRepository.setStates(Converter.GetStatesFromFile());
    }

    public void setStateSentiments() {
        TweetManager tweetManager = new TweetManager();
        ArrayList<Tweet> tweets = tweetManager.getTweetRepository().getTweets();
        ArrayList<State> states = stateRepository.getStates();
        ArrayList<Coordinate> coordinates = new ArrayList<>();

        for (Tweet tweet : tweets) {
            for (State state : states) {
                coordinates = getStateCoordinates(state);
                if (isInState(coordinates, tweet.getCoordinate())) {
                    state.setCountOfTweets(state.getCountOfTweets() + 1);
                    state.setSumSentiment(state.getSumSentiment() + tweet.getTweetSentiment());
                }
            }
        }
    }

    private boolean isInState(ArrayList<Coordinate> coordinates, Coordinate tweetCoordinate) {
        if (coordinates.size() < 3) {
            return false;
        }
        boolean result = false;
        int j = 0;
        for (int i = 0; i < coordinates.size(); i++) {
            if ((coordinates.get(i).getLatitude() > tweetCoordinate.getLatitude() != coordinates.get(j).getLatitude() > tweetCoordinate.getLatitude()) &&
                    (tweetCoordinate.getLongitude() < (coordinates.get(j).getLongitude() - coordinates.get(i).getLongitude()) *
                            (tweetCoordinate.getLatitude() - coordinates.get(i).getLatitude()) /
                            (coordinates.get(j).getLatitude() - coordinates.get(i).getLatitude()) + coordinates.get(i).getLongitude())
                    ) {
                result = inverseBoolean(result);
            }
            j = i;
        }

        return result;
    }

    private boolean inverseBoolean(Boolean bool){
        if(bool == true){
            return false;
        }
        else return true;
    }

    private ArrayList<Coordinate> getStateCoordinates(State state) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for (Polygon polygon : state.getPolygons()) {
            for (Coordinate coord : polygon.getCoordinates()) {
                coordinates.add(coord);
            }
        }
        return coordinates;
    }

}
