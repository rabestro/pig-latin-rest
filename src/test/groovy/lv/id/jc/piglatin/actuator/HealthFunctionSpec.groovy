package lv.id.jc.piglatin.actuator

import org.springframework.boot.actuate.health.Health
import org.springframework.http.HttpStatus
import spock.lang.Specification

class HealthFunctionSpec extends Specification {

    HealthFunction healthFunction = new HealthFunction()

    def "should return UP when HTTP status code is 200"() {
        given:
        int httpStatusCode = HttpStatus.OK.value()

        when:
        var health = healthFunction.apply(httpStatusCode)

        then:
        health.status == Health.up().build().status
    }

    def "should return DOWN when HTTP status code is not 200"() {
        given:
        int httpStatusCode = 404

        when:
        var health = healthFunction.apply(httpStatusCode)

        then:
        health.status == Health.down().build().status
        health.details.get("HTTP Status Code") == httpStatusCode
    }
}
