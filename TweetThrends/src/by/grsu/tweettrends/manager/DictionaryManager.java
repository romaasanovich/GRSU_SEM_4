package by.grsu.tweettrends.manager;

import by.grsu.tweettrends.repository.Dictionary;
import by.grsu.tweettrends.utills.Converter;

public class DictionaryManager {

    private Dictionary dictionary;

    public DictionaryManager() {
        dictionary = Dictionary.getInstance();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void readDictionary() {
        dictionary.setDictionary(Converter.fromStrToSentiments());
    }
}
