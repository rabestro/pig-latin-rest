package lv.id.jc.piglatin

import lv.id.jc.piglatin.controller.PigLatinController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired(required = false)
    private PigLatinController webController

    def 'context loads'() {
        expect:
        true
    }

    def 'all expected beans are created'() {
        expect: "the WebController is created"
        webController
    }

}
