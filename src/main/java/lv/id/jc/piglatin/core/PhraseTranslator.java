package lv.id.jc.piglatin.core;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component("phraseTranslator")
public class PhraseTranslator implements UnaryOperator<String> {
    private final Function<String, Matcher> wordMatcher;
    private final Function<MatchResult, String> pigLatinTranslator;

    /**
     * Constructs a new PhraseTranslator.
     *
     * @param wordMatcher a function that takes a string and returns a Matcher for words in the string
     * @param wordTranslator a function that takes a string and translates it to Pig Latin
     */
    public PhraseTranslator(
        Function<String, Matcher> wordMatcher,
        @Validated @Qualifier("wordTranslator")
        UnaryOperator<String> wordTranslator
    ) {
        this.wordMatcher = wordMatcher;
        this.pigLatinTranslator = wordTranslator.compose(MatchResult::group);
    }

    /**
     * Translates a phrase to Pig Latin.
     *
     * @param phrase the phrase to translate
     * @return the translated phrase
     */
    @Override
    public String apply(String phrase) {
        return wordMatcher.apply(phrase).replaceAll(pigLatinTranslator);
    }
}
