package lv.id.jc.piglatin.service;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * The TranslationService class provides a service for translating English sentences to Pig Latin.
 */
@Service
public class TranslationService {

    private final UnaryOperator<String> translator;
    private final AtomicInteger translationCounter;

    public TranslationService(
        @Qualifier("phraseTranslator") UnaryOperator<String> translator,
        @Qualifier("translationCounter") AtomicInteger translationCounter
    ) {
        this.translator = translator;
        this.translationCounter = translationCounter;
    }

    public String translate(String text) {
        translationCounter.incrementAndGet();
        return translator.apply(text.toLowerCase(Locale.ROOT));
    }
}
