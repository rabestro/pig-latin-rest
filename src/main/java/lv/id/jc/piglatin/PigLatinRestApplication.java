package lv.id.jc.piglatin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.http.HttpClient;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The main class for the Pig Latin REST application.
 * This class is responsible for starting the application and defining beans.
 */
@SpringBootApplication
public class PigLatinRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigLatinRestApplication.class, args);
    }

    /**
     * Returns a new instance of HttpClient.
     *
     * @return the new instance of HttpClient
     */
    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

   /**
    * Returns an AtomicInteger object representing a counter for translations.
    * The counter starts at 0.
    *
    * @return the AtomicInteger object representing the translation counter
    */
    @Bean
    public AtomicInteger translationCounter() {
        return new AtomicInteger(0);
    }
}
