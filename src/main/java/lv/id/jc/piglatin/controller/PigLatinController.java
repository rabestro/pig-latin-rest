package lv.id.jc.piglatin.controller;


import lv.id.jc.piglatin.api.PigLatinApi;
import lv.id.jc.piglatin.model.TranslationRequest;
import lv.id.jc.piglatin.model.TranslationResponse;
import lv.id.jc.piglatin.service.TranslationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * PigLatinController handles translation requests for translating English sentences to Pig Latin.
 */
@RestController
public class PigLatinController implements PigLatinApi {

    private final TranslationService translationService;

    public PigLatinController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public ResponseEntity<TranslationResponse> translate(TranslationRequest translationRequest) {
        var textEnglish = translationRequest.getSentence();
        var textPigLatin = translationService.translate(textEnglish);
        return new ResponseEntity<>(new TranslationResponse(textPigLatin), HttpStatus.OK);
    }
}
