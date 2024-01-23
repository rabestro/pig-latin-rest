package lv.id.jc.piglatin.actuator;

import java.util.function.IntFunction;

import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;

/**
 * The HealthFunction class is an implementation of the IntFunction functional interface.
 * It is responsible for converting an HTTP status code into a Health object that represents the health of a service.
 */
class HealthFunction implements IntFunction<Health> {
    /**
     * Converts an HTTP status code into a Health object that represents the health of a service.
     *
     * @param code the HTTP status code to be converted
     * @return a Health object representing the health of the service
     */
    @Override
    public Health apply(int code) {
        if (code == HttpStatus.OK.value()) {
            return Health.up().build();
        }
        return Health.down()
            .withDetail("HTTP Status Code", code)
            .build();
    }
}