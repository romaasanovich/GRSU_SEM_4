package by.grsu.tweettrends.manager;

import by.grsu.tweettrends.repository.Dictionary;

public class DictionaryManager {

    private Dictionary dictionary;

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public DictionaryManager() {
        dictionary = new Dictionary();
    }
}
