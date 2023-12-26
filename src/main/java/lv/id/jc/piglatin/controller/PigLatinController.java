package lv.id.jc.piglatin.controller;


import lv.id.jc.piglatin.api.PigLatinApi;
import lv.id.jc.piglatin.model.TranslationRequest;
import lv.id.jc.piglatin.model.TranslationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PigLatinController implements PigLatinApi {

    @Override
    public ResponseEntity<TranslationResponse> translate(TranslationRequest translationRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
