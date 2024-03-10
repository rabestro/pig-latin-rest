# Reset Translation Counter
DELETE {{host}}/actuator/translation-count
HTTP 204

# Zero Translation Counter
GET {{host}}/actuator/translation-count
HTTP 200
[Asserts]
header "Content-Type" contains "json"
jsonpath "$.count" == 0

# Translate first sentence
POST {{host}}/pig-latin
Content-Type: application/json

{
    "sentence": "Hello, World!"
}

HTTP 200
Content-Type: application/json
[Asserts]
jsonpath "$.sentence" == "ellohay, orldway!"

# Check Translation Counter
GET {{host}}/actuator/count
HTTP 200
[Asserts]
jsonpath "$.count" == 1

# Translate second sentence
POST {{host}}/pig-latin
Content-Type: application/json

{
    "sentence": "The quick brown fox jumps over the lazy dog."
}

HTTP 200
Content-Type: application/json
[Asserts]
jsonpath "$.sentence" == "ethay ickquay ownbray oxfay umpsjay overay ethay azylay ogday."

# Second Counter Check
GET {{host}}/actuator/count
HTTP 200
[Asserts]
jsonpath "$.count" == 2

# Set Translation Counter
POST {{host}}/actuator/count
Content-Type: application/json

{"count": 9}

HTTP 200
[Asserts]
jsonpath "$.count" == 9

# Check Changed Counter
GET {{host}}/actuator/count
HTTP 200
[Asserts]
jsonpath "$.count" == 9
