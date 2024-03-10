package lv.id.jc.piglatin.actuator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.IntSupplier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class StatusCodeSupplier implements IntSupplier {
    private final HttpClient httpClient;

    @Value("${blog.url:'https://jc.id.lv'}")
    private String blogUrl;

    public StatusCodeSupplier(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Returns the HTTP response code obtained by making a GET request to the specified base URL.
     *
     * @return The HTTP response code.
     * @throws RuntimeException if an IOException or InterruptedException occurs during the execution of the GET request.
     */
    @Override
    public int getAsInt() {
        try {
            var request = HttpRequest.newBuilder()
                .uri(URI.create(blogUrl))
                .build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
