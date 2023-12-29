package lv.id.jc.piglatin.controller

import spock.lang.Specification
import spock.lang.Subject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import lv.id.jc.piglatin.model.TranslationRequest
import lv.id.jc.piglatin.model.TranslationResponse
import lv.id.jc.piglatin.service.TranslationService
import spock.lang.Title

class PigLatinControllerSpec extends Specification {

    TranslationService translationService = Mock()
    @Subject
    PigLatinController controller = new PigLatinController(translationService)

    def "translate method with valid TranslationRequest"() {
        given:
        def request = new TranslationRequest('apple')
        def response = new TranslationResponse('appleay')
        translationService.translate('apple') >> 'appleay'

        when:
        ResponseEntity<TranslationResponse> result = controller.translate(request)

        then:
        result.statusCode == HttpStatus.OK
        result.body == response
    }

    def "translate method with empty text"() {
        given:
        def request = new TranslationRequest('')
        def response = new TranslationResponse('')
        translationService.translate('') >> ''

        when:
        ResponseEntity<TranslationResponse> result = controller.translate(request)

        then:
        result.statusCode == HttpStatus.OK
        result.body == response
    }

    def "translate method when TranslationService throws exception"() {
        given:
        def request = new TranslationRequest('apple')
        translationService.translate('apple') >> { throw new RuntimeException('Translation failed') }

        when:
        controller.translate(request)

        then:
        thrown RuntimeException
    }
}
