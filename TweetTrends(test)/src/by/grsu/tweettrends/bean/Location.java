package by.grsu.tweettrends.bean;

public class Location {
    private double longitude;
    private double latitude;
    private State state;

    public Location(double longitude,double latitude){
        this.latitude =latitude;
        this.longitude = longitude;
        //state = StateWorker.getState(latitude,longitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
