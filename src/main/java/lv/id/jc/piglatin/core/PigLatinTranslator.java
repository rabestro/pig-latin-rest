package lv.id.jc.piglatin.core;

import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PigLatinTranslator implements Translator {
    private final Function<String, Matcher> wordMatcher;
    private final Function<MatchResult, String> translator;

    public PigLatinTranslator(
        Function<String, Matcher> wordMatcher,
        @Qualifier("wordTranslator") Translator wordTranslator
    ) {
        this.wordMatcher = wordMatcher;
        this.translator = ((Function<MatchResult, String>) MatchResult::group)
            .andThen(wordTranslator);
    }

    @Override
    public String apply(String phrase) {
        return wordMatcher.apply(phrase).replaceAll(translator);
    }
}
