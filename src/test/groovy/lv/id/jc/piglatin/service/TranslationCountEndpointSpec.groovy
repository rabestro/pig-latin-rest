package lv.id.jc.piglatin.service

import lv.id.jc.piglatin.actuator.TranslationCountEndpoint
import spock.lang.Specification
import spock.lang.Subject

import java.util.concurrent.atomic.AtomicInteger

class TranslationCountEndpointSpec extends Specification {

    def counterService = new AtomicInteger(0)

    @Subject
    def endpoint = new TranslationCountEndpoint(counterService)

    def "should return count"() {
        given:
        counterService.set(1)

        when:
        def result = endpoint.count()

        then:
        result == [count: 1]
    }

    def "should set count"() {
        given:
        counterService.set(0)

        when:
        def result = endpoint.set(2)

        then:
        counterService.get() == 2

        and:
        result == [count: 2]
    }

    def "should reset count"() {
        given:
        counterService.set(9)

        when:
        endpoint.reset()

        then:
        counterService.get() == 0
    }
}
