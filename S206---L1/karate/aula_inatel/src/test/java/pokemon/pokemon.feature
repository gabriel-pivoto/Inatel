Feature: Testando API Pokemon.

Scenario: Testando retorno .
        Given url 'https://pokeapi.co/api/v2/pokemon/pikachu'
        When method get
        Then status 200

Scenario: Testando retorno com informações inválidas.
        Given url 'https://pokeapi.co/api/v2/pokemon/chocolate'
        When method get
        Then status 404
        