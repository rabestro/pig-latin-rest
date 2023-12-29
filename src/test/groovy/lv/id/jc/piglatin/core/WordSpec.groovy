package lv.id.jc.piglatin.core

import jakarta.validation.Validation
import spock.lang.Narrative
import spock.lang.Rollup
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('Word Annotation')
@Narrative('''
As a user
I want to validate words
So that I can translate them to Pig Latin
''')
@Subject(Word)
class WordSpec extends Specification {
    def validator = Validation.buildDefaultValidatorFactory().getValidator()

    def "has violations for '#input' (#description)"() {

        given: 'we create a bean with an invalid word'
        var bean = new TestBean(input)

        when: 'we validate the bean'
        var violations = validator.validate(bean)

        then: 'there is one violation'
        violations

        where: 'we test different invalid words'
        input       | description
        ''          | 'Empty string'
        ' '         | 'Whitespace'
        '\t'        | 'Tab'
        null        | 'Null word'
        'apple123'  | 'Word with numbers'
        'apple!'    | 'Word with special characters'
        'apple pie' | 'Word with whitespace'
        'apple-'    | 'Word with hyphen'
        'apple_'    | 'Word with underscore'
        'apple.'    | 'Word with dot'
        "apple'"    | 'Word with trailing apostrophe'
        "'apple"    | 'Word with leading apostrophe'
        "ap'pl'e"   | 'Word with two apostrophes'
    }

    def 'no violations for #word'() {

        given: 'we create a bean with a valid word'
        var bean = new TestBean(word)

        when: 'we validate the bean'
        var violations = validator.validate(bean)

        then: 'there are no violations'
        violations.isEmpty()

        where: 'we test different valid words'
        word << ['apple', "can't", 'äpple', 'ApPlE', 'a']
    }

    static class TestBean {
        @Word
        String value

        TestBean(String value) {
            this.value = value
        }
    }
}
