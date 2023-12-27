package lv.id.jc.piglatin.service;

import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;

@Service
public class PigLatinService {
    private final UnaryOperator<String> translator;

    public PigLatinService(UnaryOperator<String> translator) {
        this.translator = translator;
    }

    public String translate(@NotNull String text) {
        return translator.apply(text);
    }
}
