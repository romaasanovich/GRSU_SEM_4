package by.grsu.tweettrends.repository;

import by.grsu.tweettrends.utills.Converter;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String,Double> dictionary = new HashMap<>();

    private static Dictionary instance;

    public static Dictionary getInstance(){
        if(instance ==null){
            instance = new Dictionary();
        }
        return instance;
    }

    private Dictionary() {

    }

    public Map<String, Double> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Double> dictionary) {
        this.dictionary = dictionary;
    }


}
