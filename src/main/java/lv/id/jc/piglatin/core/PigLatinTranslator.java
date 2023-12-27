package lv.id.jc.piglatin.core;

import org.springframework.stereotype.Component;

import java.util.function.UnaryOperator;

@Component
public class PigLatinTranslator implements UnaryOperator<String> {
    @Override
    public String apply(String englishWord) {
        // TODO: translation logic goes here
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
