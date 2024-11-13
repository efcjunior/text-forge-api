# TEXT-FORGE API

## 1. Objective

TEXT-FORGE is an API designed to perform two main tasks: check if a string is a palindrome and count the occurrence of each character in the provided string.

## 2. Rules

* The API does not remove non-alphanumeric characters when checking if a string is a PALINDROME. This means that character comparison is performed exactly as provided in the input string. For example, if the word "ovo" is considered a palindrome, it will only be recognized as such if the provided string consists only of the characters "o," "v," and "o." If there are non-alphanumeric characters in the string, such as "@" or "#," they will not be removed or ignored during the palindrome check. This ensures that the API preserves the integrity of the provided data and delivers accurate results, even in cases where the presence of non-alphanumeric characters is relevant to the text analysis.

* No removal of non-alphanumeric characters: All characters present in the provided string are counted, including non-alphanumeric characters. This means symbols, punctuation, and other special characters are considered in the count.

* Case sensitivity: The API differentiates between uppercase and lowercase letters when counting characters. Therefore, for example, 'A' and 'a' are counted separately in the character count.

* Accent sensitivity: Accented characters are considered separately from their unaccented counterparts in the character count. For example, 'á' and 'a' are counted as distinct characters.

## 3. Algorithms

**Two-pointer Approach:** This approach is efficient and suitable for checking if a string is a palindrome, as it performs the check straightforwardly and without requiring additional memory allocation.

**Character Counting Algorithm:** This implementation is efficient and straightforward, as it uses a map to store character counts and iterates over the input string only once.

## 4. Architecture / Tools

* Language/platform: Java

* Framework: Spring Boot

* Maven

* JUnit

* JMeter

* Swagger UI

## Tests

### Unit Tests

Unit tests for the main classes of the TEXT-FORGE API were created following the TDD (Test-Driven Development) pattern, using the JUnit framework.

To run the unit tests, you can use the command below from the project's root directory:

`./mvnw test`

### Load Testing

A test plan was created to evaluate the performance of the TEXT-FORGE API by simulating 50,000 simultaneous requests.

`src/main/test/jmeter/HTTP Request.jmx`

## Usage of TEXT-FORGE API

**API Endpoint**

`http://textforge.us-east-1.elasticbeanstalk.com/api/manipulacao-string`

Or click [HERE](http://textforge.us-east-1.elasticbeanstalk.com/api/manipulacao-string)

**Example JSON Request**

```json
{
  "texto": "ovo"
}
```

**Example JSON Response**

```json
{
  "palindrome": true,
  "character_occurrences": {
    "o": 2,
    "v": 1
  }
}
```

## Documentation and Interaction with TEXT-FORGE API via Swagger-UI

With Swagger UI, you can explore the available endpoint in the API.

To access Swagger UI, follow this link: [TEXT-FORGE API SWAGGER-UI](http://textforge.us-east-1.elasticbeanstalk.com/swagger-ui/index.html)
