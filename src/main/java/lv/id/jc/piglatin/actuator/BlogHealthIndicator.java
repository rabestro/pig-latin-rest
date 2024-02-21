package lv.id.jc.piglatin.actuator;

import java.util.function.IntFunction;
import java.util.function.IntSupplier;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class BlogHealthIndicator implements HealthIndicator {
    private final IntFunction<Health> healthFunction;
    private final IntSupplier statusCodeSupplier;

    public BlogHealthIndicator(IntSupplier statusCodeSupplier, IntFunction<Health> healthFunction) {
        this.healthFunction = healthFunction;
        this.statusCodeSupplier = statusCodeSupplier;
    }

    @Override
    public Health health() {
        try {
            return healthFunction.apply(statusCodeSupplier.getAsInt());
        } catch (RuntimeException e) {
            return Health.down(e).withException(e.getCause()).build();
        }
    }
}
