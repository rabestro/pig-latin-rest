package lv.id.jc.piglatin.service;

import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
public class PigLatinService {
    public String translate(@NotNull String text) {
        return text;
    }
}
