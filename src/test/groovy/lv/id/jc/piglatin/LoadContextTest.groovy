package lv.id.jc.piglatin


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification {
    @Autowired
    private ApplicationContext applicationContext

    def 'context loads'() {
        expect:
        applicationContext.isRunning()
    }
}
