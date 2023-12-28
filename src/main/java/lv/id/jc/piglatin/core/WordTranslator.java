package lv.id.jc.piglatin.core;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class WordTranslator implements Translator {
    private static final Pattern RULES = Pattern.compile(
        "((?<vowel>[aeiou]|xr|yt)|" +
        "(?<consonant>(?!xr|yt)y?(?:[^aeiouy]*qu|[^aeiouy]*)))" +
        "(?<body>.*)"
    );
    private static final String TEMPLATE = "${vowel}${body}${consonant}ay";

    @Override
    public String apply(String word) {
        return RULES.matcher(word).replaceFirst(TEMPLATE);
    }
}
