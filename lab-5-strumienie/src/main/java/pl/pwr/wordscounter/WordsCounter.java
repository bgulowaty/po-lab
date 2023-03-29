package pl.pwr.wordscounter;

import org.apache.commons.lang3.StringUtils;

public class WordsCounter {

    private WordsCounter() {
    }

    public static int count(String text, String wordToCount) {
        return StringUtils.countMatches(text.toLowerCase(), wordToCount.toLowerCase());
    }


}
