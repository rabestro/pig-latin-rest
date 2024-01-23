package lv.id.jc.piglatin.actuator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.IntSupplier;

class StatusCodeSupplier implements IntSupplier {
    private static final String BASE_URL = "https://jc.id.lv/";
    private final HttpClient httpClient;

    StatusCodeSupplier() {
        this(HttpClient.newHttpClient());
    }

    StatusCodeSupplier(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public int getAsInt() {
        var request = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).build();
        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
