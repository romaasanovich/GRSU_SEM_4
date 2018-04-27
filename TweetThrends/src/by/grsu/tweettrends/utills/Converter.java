package by.grsu.tweettrends.utills;

import by.grsu.tweettrends.bean.Coordinate;
import by.grsu.tweettrends.bean.Polygon;
import by.grsu.tweettrends.bean.State;
import by.grsu.tweettrends.bean.Tweet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Converter {

    public static ArrayList<Tweet> fromStrToTweets() {
        try {
            ArrayList<Tweet> tweets = new ArrayList<>();
            String fileStr = FileWorker.readFile(Constats.TEXAS_PATH);
            ArrayList<String> subStrings = convertToSubStrings(fileStr);
            for (String str : subStrings) {
                tweets.add(fromStrToTweet(str));
            }
            return tweets;
        } catch (IOException ex) {

        }
        return null;
    }

    private static ArrayList<String> convertToSubStrings(String str) {
        String[] tokens = str.split("\n");
        ArrayList<String> strTweets = new ArrayList<>(Arrays.asList(tokens));
        return strTweets;
    }

    public static Map<String, Double> fromStrToSentiments() {
        try {
            Map<String, Double> dict = new HashMap<String, Double>();
            String fileStr = FileWorker.readFile(Constats.SENTIMENTS_PATH);
            String[] subStrings = fileStr.split("\n");
            for (String substr : subStrings) {
                String[] sentimentInStr = substr.split(",");
                dict.put(sentimentInStr[0], Double.parseDouble(sentimentInStr[1]));
            }
            return dict;

        } catch (IOException ex) {
            return null;
        }
    }

    //    public void fromJsonToStates() {
//        try {
////            String path = Constats.STATE_JSON_PATH;
//            String json = FileWorker.readFile(path);
//            Gson gson = new Gson();
//            ArrayList<Map<String, ArrayList<ArrayList<Coordinate>>>> states = gson.fromJson(json, new TypeToken<ArrayList<ArrayList<Coordinate>>>(){}.getType());
//            Map<String, ArrayList<Polygon>> state = gson.fromJson(json,new TypeToken<Map<String, ArrayList<Polygon>>>(){}.getType());
//            String ssss;
    public static ArrayList<State> GetStatesFromFile() throws FileNotFoundException {
        ArrayList<State> states = new ArrayList<State>();

        String path = Constats.STATE_JSON_PATH;
        String line = FileWorker.readFile(path);
        String[] data = line.split("\\[|\\]|\\{|\\}| |\\,|\\:");
        ArrayList<String> temp = new ArrayList<String>(Arrays.asList(data));
        temp.removeAll(Arrays.asList("", null));
        State state = null;
        int count = 0;
        boolean curCoordinate = false;
        Coordinate point = new Coordinate();
        ArrayList<Coordinate> points = new ArrayList<Coordinate>();
        for (String obj : temp) {
            double coordinate;
            if (!isNumeric(obj)) {
                if (state != null) {
                    states.add(state);
                }
                state = new State(obj);
                count+=1;
                if(count == 39 ){
                    String sss;
                }
            } else {
                coordinate = Double.parseDouble(obj);
                curCoordinate ^= true;
                if (curCoordinate) {
                    point = new Coordinate();
                    point.setLongitude(coordinate);
                } else {
                    point.setLatitude(coordinate);
                    points.add(point);
                    if (points.size() != 1) {
                        if (points.get(0).getLatitude() == point.getLatitude() && points.get(0).getLongitude() == point.getLongitude()) {
                            state.addPolygon(new Polygon(points));
                            points.clear();
                        }
                    }
                }
            }
        }
        return states;
    }

    //        } catch (Exception ex) {
//
//        }
//
//    }
    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    private static Tweet fromStrToTweet(String strTweet) {
        String[] tokens = strTweet.split("\t");
        String[] coordinates = tokens[0].split(",");
        coordinates[0] = removeCharAt(coordinates[0], 0);
        coordinates[1] = removeCharAt(coordinates[1], coordinates[1].length() - 1);
        Date date = fromStrToDate(tokens[2]);
        String tweetText = tokens[3];
        Tweet tweet = new Tweet(new Coordinate(Double.parseDouble(coordinates[1]), Double.parseDouble(coordinates[0])), tweetText, 0);
        return tweet;
    }


    private static Date fromStrToDate(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateInString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

}
