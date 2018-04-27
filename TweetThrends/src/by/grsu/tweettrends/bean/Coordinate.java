package by.grsu.tweettrends.bean;

public class Coordinate {

    private double longitude;

    private double latitude;

    public Coordinate(){
        this.longitude = 0;
        this.latitude = 0;
    }

    public Coordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}
