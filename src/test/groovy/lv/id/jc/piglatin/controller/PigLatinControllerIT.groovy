package lv.id.jc.piglatin.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

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
            status == 200
            contentAsString == '{"sentence":"appleay"}'
        }
    }

    def "translate method with empty text"() {
        expect:
        mockMvc.perform(MockMvcRequestBuilders
            .post("/pig-latin")
            .contentType(MediaType.APPLICATION_JSON)
            .content('{"sentence":""}'))
            .andExpect(status().isOk())
            .andExpect(jsonPath('$.sentence').value(''))
    }
}
