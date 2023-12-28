package lv.id.jc.piglatin.core

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.*

@Title('Pig Latin Translator')
@Narrative('''
As a user
I want to translate English phrase to Pig Latin
So that I can communicate with my friends
''')
@See(['https://en.wikipedia.org/wiki/Pig_Latin'])
@SpringBootTest(classes = [PigLatinTranslator, WordsMatcher, WordTranslator])
class PigLatinTranslatorSpec extends Specification {

    @Subject
    @Autowired
    PigLatinTranslator pigLatinTranslator

    @Issue('5')
    @Unroll('#description')
    def 'translate English phrase to Pig Latin'() {
        expect:
        pigLatinTranslator.apply(englishWord) == pigLatinWord

        where:
        englishWord      | pigLatinWord           | description
        ''               | ''                     | 'Zero - Empty string'
        'a'              | 'aay'                  | 'One - Single character word'
        'apple'          | 'appleay'              | 'WordValidation beginning with A'
        'ear'            | 'earay'                | 'WordValidation beginning with E'
        'igloo'          | 'iglooay'              | 'WordValidation beginning with I'
        'object'         | 'objectay'             | 'WordValidation beginning with O'
        'under'          | 'underay'              | 'WordValidation beginning with U'
        'equal'          | 'equalay'              | 'WordValidation beginning with vowel and followed by qu'
        'pig'            | 'igpay'                | 'WordValidation beginning with P'
        'koala'          | 'oalakay'              | 'WordValidation beginning with K'
        'xenon'          | 'enonxay'              | 'WordValidation beginning with X'
        'qat'            | 'atqay'                | 'WordValidation beginning with Q without a following U'
        'chair'          | 'airchay'              | 'Ch treated like a consonant at the beginning of a word'
        'queen'          | 'eenquay'              | 'Qu treated like a consonant at the beginning of a word'
        'square'         | 'aresquay'             | 'Qu and a preceding consonant treated like a consonant at the beginning of a word'
        'therapy'        | 'erapythay'            | 'Th treated like a consonant at the beginning of a word'
        'thrush'         | 'ushthray'             | 'Thr treated like a consonant at the beginning of a word'
        'school'         | 'oolschay'             | 'Sch treated like a consonant at the beginning of a word'
        'yttria'         | 'yttriaay'             | 'Yt treated like a vowel at the beginning of a word'
        'xray'           | 'xrayay'               | 'Xr treated like a vowel at the beginning of a word'
        'yellow'         | 'ellowyay'             | 'Y treated like a consonant at the beginning of a word'
        'rhythm'         | 'ythmrhay'             | 'Y treated like a vowel at the end of a consonant cluster'
        'my'             | 'ymay'                 | 'Y as second letter in two letter word'
        'quick fast run' | 'ickquay astfay unray' | 'A whole phrase'
    }
}
