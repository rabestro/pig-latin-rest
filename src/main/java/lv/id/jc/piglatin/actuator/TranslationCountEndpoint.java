package lv.id.jc.piglatin.actuator;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id = "translationcount")
public class TranslationCountEndpoint {

    private final AtomicInteger counterService;

    public TranslationCountEndpoint(@Qualifier("translationCounter") AtomicInteger counterService) {
        this.counterService = counterService;
    }

    @ReadOperation
    public Map<String, Integer> count() {
        return Map.of("count", counterService.get());
    }

    @WriteOperation
    public Map<String, Integer> set(int count) {
        counterService.set(count);
        return count();
    }

    @DeleteOperation
    public void reset() {
        counterService.set(0);
    }
}
