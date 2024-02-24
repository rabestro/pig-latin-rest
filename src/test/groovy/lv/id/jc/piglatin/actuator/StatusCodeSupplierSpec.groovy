package lv.id.jc.piglatin.actuator

import spock.lang.Specification
import spock.lang.Subject

import java.net.http.HttpClient
import java.net.http.HttpResponse

class StatusCodeSupplierSpec extends Specification {
    def httpClient = Mock HttpClient
    def httpResponse = Mock HttpResponse

    @Subject
    StatusCodeSupplier statusCodeSupplier

    void setup() {
        statusCodeSupplier = new StatusCodeSupplier(httpClient)
        statusCodeSupplier.blogUrl = 'https://localhost'
    }

    def "should return status code when getAsInt is called"() {
        given:
        httpResponse.statusCode() >> 200
        httpClient.send(_, _) >> httpResponse

        when:
        int statusCode = statusCodeSupplier.getAsInt()

        then:
        statusCode == 200
    }

    def "should throw RuntimeException when IOException occurs"() {
        given:
        httpClient.send(_, _) >> { throw new IOException() }

        when:
        statusCodeSupplier.getAsInt()

        then:
        thrown RuntimeException
    }
}
