package lv.id.jc.piglatin.core

import spock.lang.*

@Title('Words Matcher')
@Narrative('''
As a user
I want to match words in a sentence
So that I can translate them to Pig Latin
''')
class WordsMatcherSpec extends Specification {

    def 'match words in #description'() {
        given:
        @Subject def wordMatcher = new WordsMatcher()

        when:
        def results = wordMatcher.apply(sentence).results()

        then:
        results.collect { it.group() } == words

        where:
        sentence                    | words                            | description
        ''                          | []                               | 'Empty string'
        'a'                         | ['a']                            | 'Single character word'
        'hello world'               | ['hello', 'world']               | 'Phrase with multiple words'
        '123'                       | []                               | 'Phrase with numbers'
        '!@#$'                      | []                               | 'Phrase with special characters'
        'Hello, World!'             | ['Hello', 'World']               | 'Phrase with punctuation'
        "Don't"                     | ["Don't"]                        | 'Phrase with apostrophe'
        "I'm"                       | ["I'm"]                          | 'Phrase with contraction'
        "'red'"                     | ["red"]                          | 'Phrase with single quotes'
        '"red"'                     | ["red"]                          | 'Phrase with double quotes'
        'Hello, World! I\'m "red".' | ['Hello', 'World', "I'm", 'red'] | 'Complex phrase'
    }
}
