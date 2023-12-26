package lv.id.jc.piglatin.controller;


import lv.id.jc.piglatin.api.PigLatinApi;
import lv.id.jc.piglatin.model.TranslationRequest;
import lv.id.jc.piglatin.model.TranslationResponse;
import lv.id.jc.piglatin.service.PigLatinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PigLatinController implements PigLatinApi {

    private final PigLatinService pigLatinService;

    public PigLatinController(PigLatinService pigLatinService) {
        this.pigLatinService = pigLatinService;
    }

    @Override
    public ResponseEntity<TranslationResponse> translate(TranslationRequest translationRequest) {
        var textEnglish = translationRequest.getText();
        var textPigLatin = pigLatinService.translate(textEnglish);
        return new ResponseEntity<>(new TranslationResponse(textPigLatin), HttpStatus.OK);
    }
}
