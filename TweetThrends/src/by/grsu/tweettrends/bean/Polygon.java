package by.grsu.tweettrends.bean;

import java.util.ArrayList;

public class Polygon {
    ArrayList<Coordinate> coordinates;

    public Polygon(ArrayList<Coordinate> coordinates) {
        this.coordinates = new ArrayList<Coordinate>(coordinates);
    }

    public void setCoordinates(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

}

