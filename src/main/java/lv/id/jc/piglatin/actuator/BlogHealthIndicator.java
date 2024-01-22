package lv.id.jc.piglatin.actuator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.IntFunction;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * The BlogHealthIndicator class is responsible for checking the health of a blog service by making a GET request to the blog's base URL.
 * It implements the HealthIndicator interface provided by Spring Boot actuator library.
 */
@Component
public class BlogHealthIndicator implements HealthIndicator {
    private static final String BASE_URL = "https://jc.id.lv/";
    private final IntFunction<Health> healthFunction;

    /**
     * The BlogHealthIndicator constructor is used to create a new instance of the BlogHealthIndicator class.
     *
     * @param healthFunction a functional interface that takes an int parameter and returns a Health object.
     *                       This function is used to process the HTTP response code and determine the health status of the blog service.
     */
    public BlogHealthIndicator(IntFunction<Health> healthFunction) {
        this.healthFunction = healthFunction;
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
            var url = new URL(BASE_URL);
            var connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            return healthFunction.apply(code);
        } catch (IOException e) {
            return Health.down(e).withException(e).build();
        }
    }
}
