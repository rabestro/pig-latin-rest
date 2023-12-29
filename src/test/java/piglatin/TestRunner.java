package piglatin;

import com.intuit.karate.junit5.Karate;

class TestRunner {

    @Karate.Test
    Karate testPigLatin() {
        return Karate.run("pig-latin-translator").relativeTo(getClass());
    }
}
