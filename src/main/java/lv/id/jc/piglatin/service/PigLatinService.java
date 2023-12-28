package lv.id.jc.piglatin.service;

import java.util.Locale;
import java.util.function.UnaryOperator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lv.id.jc.piglatin.core.Translator;

@Service
public class PigLatinService {
    private final UnaryOperator<String> translator;

    public PigLatinService(@Qualifier("pigLatinTranslator") Translator translator) {
        this.translator = translator;
    }

    public String translate(String text) {
        return translator.apply(text.toLowerCase(Locale.ROOT));
    }
}
