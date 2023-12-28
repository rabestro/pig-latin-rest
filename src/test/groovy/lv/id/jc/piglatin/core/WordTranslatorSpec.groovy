package lv.id.jc.piglatin.core


import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('WordValidation Translator')
@Narrative('''
As a user
I want to translate words to Pig Latin
So that I can communicate with my friends
''')
class WordTranslatorSpec extends Specification {
    @Subject
    def wordTranslator = new WordTranslator()

    def "test apply method with word #word - #description"() {
        expect:
        wordTranslator.apply(word) == expectedWord

        where:
        word      | expectedWord | description
        'a'       | 'aay'        | 'One - Single character word'
        'apple'   | 'appleay'    | 'WordValidation beginning with A'
        'ear'     | 'earay'      | 'WordValidation beginning with E'
        'igloo'   | 'iglooay'    | 'WordValidation beginning with I'
        'object'  | 'objectay'   | 'WordValidation beginning with O'
        'under'   | 'underay'    | 'WordValidation beginning with U'
        'equal'   | 'equalay'    | 'WordValidation beginning with vowel and followed by qu'
        'pig'     | 'igpay'      | 'WordValidation beginning with P'
        'koala'   | 'oalakay'    | 'WordValidation beginning with K'
        'xenon'   | 'enonxay'    | 'WordValidation beginning with X'
        'qat'     | 'atqay'      | 'WordValidation beginning with Q without a following U'
        'chair'   | 'airchay'    | 'Ch treated like a consonant at the beginning of a word'
        'queen'   | 'eenquay'    | 'Qu treated like a consonant at the beginning of a word'
        'square'  | 'aresquay'   | 'Qu and a preceding consonant treated like a consonant at the beginning of a word'
        'therapy' | 'erapythay'  | 'Th treated like a consonant at the beginning of a word'
        'thrush'  | 'ushthray'   | 'Thr treated like a consonant at the beginning of a word'
        'school'  | 'oolschay'   | 'Sch treated like a consonant at the beginning of a word'
        'yttria'  | 'yttriaay'   | 'Yt treated like a vowel at the beginning of a word'
        'xray'    | 'xrayay'     | 'Xr treated like a vowel at the beginning of a word'
        'yellow'  | 'ellowyay'   | 'Y treated like a consonant at the beginning of a word'
        'rhythm'  | 'ythmrhay'   | 'Y treated like a vowel at the end of a consonant cluster'
        'my'      | 'ymay'       | 'Y as second letter in two letter word'
    }
}
