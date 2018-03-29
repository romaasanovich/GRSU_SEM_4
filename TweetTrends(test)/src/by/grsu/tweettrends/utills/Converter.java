package by.grsu.tweettrends.utills;

import by.grsu.tweettrends.bean.Location;
import by.grsu.tweettrends.bean.Sentiment;
import by.grsu.tweettrends.bean.Tweet;

import java.io.File;
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

    public static Map<String,Double> fromStrToSentiments() {
        try {
             Map<String,Double> dict = new HashMap<String, Double>();
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

    private static  Tweet fromStrToTweet(String strTweet) {
        String[] tokens = strTweet.split("\t");
        String[] coordinates = tokens[0].split(",");
        coordinates[0] = removeCharAt(coordinates[0], 0);
        coordinates[1] = removeCharAt(coordinates[1], coordinates[1].length() - 1);
        Date date = fromStrToDate(tokens[2]);
        String tweetText = tokens[3];
        Tweet tweet = new Tweet(new Location(Double.parseDouble(coordinates[1]), Double.parseDouble(coordinates[0])), tweetText, 0);
        return tweet;
    }

    private static  Date fromStrToDate(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateInString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static  String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

}
