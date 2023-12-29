Feature: Pig Latin API
    This API translates English to Pig Latin

    Background:
        * url baseUrl
        * path '/pig-latin'

    Scenario: Hello World!
        Given request {text: "Hello World!"}
        When method post
        Then status 200
        And match response.text == 'ellohay orldway!'

    Scenario: Translate sentence to Pig Latin
        * def sentence =
      """
      {
        "text": "The quick brown fox jumps over the lazy dog"
      }
      """

        Given request sentence
        When method post
        Then status 200
        * def text = response.text
        And match text == 'ethay ickquay ownbray oxfay umpsjay overay ethay azylay ogday'
