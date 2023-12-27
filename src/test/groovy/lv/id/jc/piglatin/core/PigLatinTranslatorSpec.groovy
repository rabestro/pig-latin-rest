package lv.id.jc.piglatin.core

import spock.lang.*

@Title('Pig Latin Translator')
@Narrative('''
As a user
I want to translate English phrase to Pig Latin
So that I can communicate with my friends
''')
@See(['https://en.wikipedia.org/wiki/Pig_Latin'])
class PigLatinTranslatorSpec extends Specification {
    @Subject
    def pigLatinTranslator = new PigLatinTranslator()

    @PendingFeature(
        reason = 'Not implemented yet',
        exceptions = [UnsupportedOperationException])
    @Issue('5')
    @Unroll('#description')
    def 'translate English phrase to Pig Latin'() {
        expect:
        pigLatinTranslator
            .apply(englishWord) == pigLatinWord

        where:
        englishWord      | pigLatinWord           | description
        ''               | ''                     | 'Zero - Empty string'
        'a'              | 'aay'                  | 'One - Single character word'
        'apple'          | 'appleay'              | 'Word beginning with A'
        'ear'            | 'earay'                | 'Word beginning with E'
        'igloo'          | 'iglooay'              | 'Word beginning with I'
        'object'         | 'objectay'             | 'Word beginning with O'
        'under'          | 'underay'              | 'Word beginning with U'
        'equal'          | 'equalay'              | 'Word beginning with vowel and followed by qu'
        'pig'            | 'igpay'                | 'Word beginning with P'
        'koala'          | 'oalakay'              | 'Word beginning with K'
        'xenon'          | 'enonxay'              | 'Word beginning with X'
        'qat'            | 'atqay'                | 'Word beginning with Q without a following U'
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
