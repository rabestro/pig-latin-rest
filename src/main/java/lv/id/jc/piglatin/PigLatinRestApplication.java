package lv.id.jc.piglatin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.http.HttpClient;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class PigLatinRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigLatinRestApplication.class, args);
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    @Bean
    public AtomicInteger translationCounter() {
        return new AtomicInteger(0);
    }
}
