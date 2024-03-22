# TEXT-FORGE API

## 1. Objetivo

A TEXT-FORGE é uma API projetada para realizar duas tarefas principais: verificar se uma string é um palíndromo e contar a ocorrência de cada caractere na string fornecida.

## 2. Regras

* A API não remove caracteres não alfanuméricos ao verificar se a string é um PALÍNDROME. Isso significa que a comparação de caracteres é realizada exatamente como fornecida na string de entrada. Por exemplo, se a palavra "ovo" for considerada um palíndromo, ela só será reconhecida como tal se a string fornecida consistir apenas dos caracteres "o", "v" e "o". Se houver caracteres não alfanuméricos na string, como "@" ou "#", eles não serão removidos ou ignorados durante a verificação do palíndromo. Isso garante que a API mantenha a integridade dos dados fornecidos e forneça resultados precisos, mesmo em casos onde a presença de caracteres não alfanuméricos é relevante para a análise do texto.

* Não há remoção de caracteres não alfanuméricos: Todos os caracteres presentes na string fornecida são contabilizados, incluindo caracteres não alfanuméricos. Isso significa que símbolos, pontuações e outros caracteres especiais serão considerados na contagem.

* A contagem diferencia letras maiúsculas de minúsculas: A API faz distinção entre letras maiúsculas e minúsculas ao contar caracteres. Portanto, por exemplo, 'A' e 'a' são contados separadamente na contagem de caracteres.

* A contagem diferencia letras acentuadas e não acentuadas: Caracteres acentuados são considerados separadamente de suas contrapartes não acentuadas na contagem de caracteres. Por exemplo, 'á' e 'a' são contados como caracteres distintos.

## 3. Algorítimos

**Two-pointer Approach:** Esta abordagem é eficiente e adequado para verificar se uma string é um palíndromo, pois realiza a verificação de forma direta e sem necessidade de alocação de memória adicional

**Character Counting Algorithm:** Essa implementação é eficiente e direta, pois utiliza um mapa para armazenar as contagens de caracteres e itera sobre a string de entrada apenas uma vez

## 4. Arquitetura / Ferramentas

* Linguagem/plataforma Java 

* Framework Spring Boot

* Maven

* JUnit

* JMeter

* Swagger UI

## Testes

### Unitários

Os testes unitários para as principais classes da TEXT-FORGE API foram criados seguindo o padrão TDD (Test-Driven Development), utilizando o framework JUnit

Para executar os testes unitários, você pode utilizar o comando abaixo a partir do diretório raiz do projeto

`./mvnw test`

### Carga

Um plano de teste foi criado para avaliar o desempenho da TEXT-FORGE API, simulando 50.000 requisições simultâneas.

`src/main/test/jmeter/HTTP Request.jmx`

## Utilização da TEXT-FORGE API

**Enpoint da API**

`http://textforge.us-east-1.elasticbeanstalk.com/api/manipulacao-string`

Ou clique [AQUI](http://textforge.us-east-1.elasticbeanstalk.com/api/manipulacao-string) 

**Exemplo JSON de requisição**

```json
{
  "texto":"ovo"
}
```

**Exemplo JSON de resposta**

```json
{
  "palindromo": true,
  "ocorrencias_caracteres": {
    "o": 2,
    "v": 1
  }
}
```

## Documentação e Interação com TEXT-FORGE API pelo Swagger-UI

Com o Swagger UI, você pode explorar o endpoint disponível na API

Para acessar o Swagger UI, siga este link:[TEXT-FORGE API SWAGGER-UI](http://textforge.us-east-1.elasticbeanstalk.com/swagger-ui/index.html)