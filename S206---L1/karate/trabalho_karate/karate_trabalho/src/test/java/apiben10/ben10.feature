Feature: Testando API ben10.


Scenario: Testando retorno .
  Given url 'https://www.omdbapi.com/?t=ben_10&apikey=6585022c'
  When method get
  Then status 200

Scenario: Testando o titulo da obra .
  Given url 'https://www.omdbapi.com/?t=ben_10&apikey=6585022c'
  When method get
  Then match response.Title == "Ben 10"


  
Scenario: Testando o get de um episódio específico .
  Given url 'https://www.omdbapi.com/?t=ben_10&season=2&episode=10&apikey=6585022c'
  When method get
  Then match response.Title == "They Lurk Below"

Scenario: Testando se tem 4 temporadas .
  Given url 'https://www.omdbapi.com/?t=ben_10&season=2&apikey=6585022c'
  When method get
  Then match response.totalSeasons == '4' 


Scenario: Testando se tem 0 temporadas - teste negativo .
  Given url 'https://www.omdbapi.com/?t=ben_10&season=0&apikey=6585022c'
  When method get
  Then  match response.Error == 'Series or season not found!'


Scenario: Testando o get de um episódio específico - negativo .
  Given url 'https://www.omdbapi.com/?t=ben_10&season=2&episode=0&apikey=6585022c'
  When method get
  Then match response.Error != 'Series or episode not found!'