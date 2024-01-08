package lv.id.jc.piglatin.service;

import java.util.Locale;
import java.util.function.UnaryOperator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * The TranslationService class provides a service for translating English sentences to Pig Latin.
 */
@Service
public class TranslationService {
    private final UnaryOperator<String> translator;

    public TranslationService(@Qualifier("phraseTranslator") UnaryOperator<String> translator) {
        this.translator = translator;
    }

    public String translate(String text) {
        return translator.apply(text.toLowerCase(Locale.ROOT));
    }
}
