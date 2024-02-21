package lv.id.jc.piglatin.actuator

import org.springframework.boot.actuate.health.Health
import spock.lang.Specification
import spock.lang.Subject

class HealthFunctionSpec extends Specification {
    @Subject
    def healthFunction = new HealthFunction()

    def "should return UP when HTTP status code is 200"() {
        given:
        int httpStatusCode = 200

        when:
        var health = healthFunction.apply httpStatusCode

        then:
        health == Health.up().build()
    }

    def "should return DOWN when HTTP status code is not 200"() {
        given:
        int httpStatusCode = 404

        when:
        var health = healthFunction.apply httpStatusCode

        then:
        health.status == Health.down().build().status

        and:
        health.details.get("HTTP Status Code") as int == httpStatusCode
    }
}
