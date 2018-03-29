package by.grsu.tweettrends.repository;

import by.grsu.tweettrends.utills.Converter;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String,Double> dictionary = new HashMap<>();

    public Dictionary() {
        this.dictionary = Converter.fromStrToSentiments();
    }

    public Map<String, Double> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Double> dictionary) {
        this.dictionary = dictionary;
    }


}
