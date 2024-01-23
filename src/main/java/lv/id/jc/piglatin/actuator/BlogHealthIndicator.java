package lv.id.jc.piglatin.actuator;

import java.util.function.IntFunction;
import java.util.function.IntSupplier;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * The BlogHealthIndicator class is responsible for checking the health of a blog service by making a GET request to the blog's base URL.
 * It implements the HealthIndicator interface provided by Spring Boot actuator library.
 */
@Component
public class BlogHealthIndicator implements HealthIndicator {
    private final IntFunction<Health> healthFunction;
    private final IntSupplier statusCodeSupplier;

    public BlogHealthIndicator() {
        this(new StatusCodeSupplier(), new HealthFunction());
    }

    public BlogHealthIndicator(IntSupplier statusCodeSupplier, IntFunction<Health> healthFunction) {
        this.healthFunction = healthFunction;
        this.statusCodeSupplier = statusCodeSupplier;
    }

    /**
     * Returns the health status of the blog service.
     * <p>
     * The health status is determined by making a GET request to the blog's base URL
     * and applying a health function to the HTTP response code. If the request is
     * successful, the health function is applied to the response code and a Health
     * object is returned. If an exception occurs during the request, a Health object
     * is returned with a status of down and the exception as the detail.
     *
     * @return A Health object representing the health status of the blog service.
     */
    @Override
    public Health health() {
        try {
            return healthFunction.apply(statusCodeSupplier.getAsInt());
        } catch (RuntimeException e) {
            return Health.down(e).withException(e.getCause()).build();
        }
    }
}
