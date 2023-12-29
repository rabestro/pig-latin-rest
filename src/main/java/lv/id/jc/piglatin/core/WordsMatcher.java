package lv.id.jc.piglatin.core;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * This class is responsible for matching words in a given phrase.
 */
@Component
public class WordsMatcher implements Function<String, Matcher> {
    private static final Pattern WORD = Pattern
        .compile("(\\p{L}|(?<=\\p{L})'(?=\\p{L}))+", Pattern.CASE_INSENSITIVE);

    /**
     * This method applies the word-matching pattern to a given phrase.
     * It returns a Matcher object that can be used to find words in the phrase.
     *
     * @param phrase the phrase to apply the word-matching pattern to
     * @return a Matcher object for finding words in the phrase
     */
    @Override
    public Matcher apply(String phrase) {
        return WORD.matcher(phrase);
    }
}
