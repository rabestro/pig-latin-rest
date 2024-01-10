package lv.id.jc.piglatin.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

@SpringBootTest
@AutoConfigureMockMvc
class PigLatinControllerIT extends Specification {

    @Autowired
    MockMvc mockMvc

    def "translate method with valid TranslationRequest"() {
        given:
        var request = MockMvcRequestBuilders
            .post("/pig-latin")
            .contentType(MediaType.APPLICATION_JSON)
            .content('{"sentence":"apple"}')

        when:
        def response = mockMvc.perform(request).andReturn().response

        then:
        with(response) {
            status == HttpStatus.OK.value()
            contentAsString == '{"sentence":"appleay"}'
        }
    }

    def "can't translate '#untranslatableExpression'"() {
        given:
        def payload = '{"sentence":"' + untranslatableExpression + '"}'

        when:
        def result = mockMvc.perform(MockMvcRequestBuilders
            .post("/pig-latin")
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload))

        then:
        result.andExpect(MockMvcResultMatchers.status().isIAmATeapot())

        where:
        untranslatableExpression << ['', '   ', '4572', '%$#@&']
    }
}
