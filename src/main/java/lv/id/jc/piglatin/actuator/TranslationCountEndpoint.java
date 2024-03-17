package lv.id.jc.piglatin.actuator;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * This class represents an endpoint for counting translations.
 * It provides methods for reading, setting, and resetting the translation count.
 */
@Component
@Endpoint(id = "counter")
public class TranslationCountEndpoint {

    private final AtomicInteger counterService;

    public TranslationCountEndpoint(@Qualifier("translationCounter") AtomicInteger counterService) {
        this.counterService = counterService;
    }

    /**
     * Retrieves the current count of translations.
     *
     * @return A Map containing the count of translations.
     *         The key "count" maps to the current count value.
     */
    @ReadOperation
    public Map<String, Integer> count() {
        return Map.of("count", counterService.get());
    }

    /**
     * Sets the translation counts to the specified value.
     *
     * @param count The new count value.
     * @return A Map containing the updated count of translations.
     *         The key "count" maps to the new count value.
     */
    @WriteOperation
    public Map<String, Integer> set(int count) {
        counterService.set(count);
        return count();
    }

    /**
     * Resets the translation counts to zero.
     */
    @DeleteOperation
    public void reset() {
        counterService.set(0);
    }
}
