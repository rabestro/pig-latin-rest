package lv.id.jc.piglatin.core;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * This class is responsible for translating words to Pig Latin.
 */
@Component("wordTranslator")
public class WordTranslator implements UnaryOperator<String> {
    private static final Pattern RULES = Pattern.compile("""
        (?:
            (?<vowel>[aeiou]|xr|yt)
            |
            (?<consonant>y?(?:[^aeiouy]*qu|[^aeiouy]*))
        )
        (?<body>.*)
        """, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS
    );
    private static final String TEMPLATE = "${vowel}${body}${consonant}ay";

    /**
     * Translates a word to Pig Latin.
     *
     * @param word the word to translate
     * @return the translated word
     */
    @Override
    public String apply(@Word String word) {
        return RULES.matcher(word).replaceFirst(TEMPLATE);
    }
}
