package by.grsu.tweettrends.repository;

import by.grsu.tweettrends.bean.State;

import java.util.ArrayList;

public class StateRepository {
    ArrayList<State> states;

    private static StateRepository instance;

    public static StateRepository getInstance() {
        if (instance == null) {
            instance = new StateRepository();
        }
        return instance;
    }

    private StateRepository() {

    }

    public StateRepository(ArrayList<State> states) {
        this.states = states;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }
}
