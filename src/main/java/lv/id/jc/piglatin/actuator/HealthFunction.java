package lv.id.jc.piglatin.actuator;

import java.util.function.IntFunction;

import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class HealthFunction implements IntFunction<Health> {

    /**
     * Converts an HTTP status code into a Health object that represents the health of a service.
     *
     * @param statusCode the HTTP status code to be converted
     * @return a Health object representing the health of the service
     */
    @Override
    public Health apply(int statusCode) {
        if (statusCode == HttpStatus.OK.value()) {
            return Health.up().build();
        }
        return Health.down()
            .withDetail("HTTP Status Code", statusCode)
            .build();
    }
}
