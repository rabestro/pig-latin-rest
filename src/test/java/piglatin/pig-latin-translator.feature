Feature: Pig Latin API
    This API translates English to Pig Latin

    Background:
        * url 'https://piglatin.azurewebsites.net'
        * path '/pig-latin'

    Scenario: Hello World!
        Given request {"sentence": "Hello World!"}
        When method post
        Then status 200
        And match response.sentence == 'ellohay orldway!'

    Scenario: Translate phrase to Pig Latin
        * def sentence =
      """
      {
        "sentence": "The quick brown fox jumps over the lazy dog"
      }
      """

        Given request sentence
        When method post
        Then status 200
        * def text = response.sentence
        And match text == 'ethay ickquay ownbray oxfay umpsjay overay ethay azylay ogday'


    Scenario Outline: Translate "<text>"
        * def phrase = { "sentence": "<text>" }
        Given request phrase
        When method post
        Then status 200
        * def text = response.sentence
        And match text == '<pig-latin>'

        Examples:
            | text                                        | pig-latin                                                     |
            | The quick brown fox jumps over the lazy dog | ethay ickquay ownbray oxfay umpsjay overay ethay azylay ogday |
            | The first month is January                  | ethay irstfay onthmay isay anuaryjay                          |
            | The second month is February                | ethay econdsay onthmay isay ebruaryfay                        |
            | The third month is March                    | ethay irdthay onthmay isay archmay                            |
            | The fourth month is April                   | ethay ourthfay onthmay isay aprilay                           |
            | The fifth month is May                      | ethay ifthfay onthmay isay aymay                              |
            | The sixth month is June                     | ethay ixthsay onthmay isay unejay                             |
            | The seventh month is July                   | ethay eventhsay onthmay isay ulyjay                           |
            | The eighth month is August                  | ethay eighthay onthmay isay augustay                          |
            | The ninth month is September                | ethay inthnay onthmay isay eptembersay                        |
            | The tenth month is October                  | ethay enthtay onthmay isay octoberay                          |
            | The eleventh month is November              | ethay eleventhay onthmay isay ovembernay                      |
            | The twelfth month is December               | ethay elfthtway onthmay isay ecemberday                       |
