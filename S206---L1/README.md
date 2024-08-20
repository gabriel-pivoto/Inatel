# S206-L1
Repositório para a matéria de S206-L1

# INSTALAÇÃO DO PROJETO DA AULA 4 - CYPRESS
# FAVOR UTILIZAR OS SEGUINTES COMANDOS


Abra um terminal em uma pasta de sua escolha e use o seguinte comando:
```
git clone https://github.com/gabriel-pivoto/S206---L1.git
```
Em sequência, já dentro da pasta, abra o terminal novamente e digite o comando abaixo para fazer a instalação do npm:
```
npm install
```

Logo após ir para o arquivo support/commands.js e alterar as informações solicitadas pelos comentários nas linhas 31, 32 e 33.

# PARA GERAÇÃO DO RELATÓRIO
Para a geração do relátorio abra o terminal novamente e utilize o comando abaixo:
```
 ./node_modules/.bin/cypress run --spec 'cypress/e2e/trabalhoUI.cy.js/'
```


# INSTALAÇÃO DO PROJETO DE KARATE 
# NECESSÁRIO A INSTALAÇÃO DO MAVEN
Maven (mvn) https://maven.apache.org
### Comandos úteis Karate:

```
Criar estrutura inicial Karate:

mvn archetype:generate \
-DarchetypeGroupId=com.intuit.karate \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=1.0.1 \
-DgroupId=aula.inatel \
-DartifactId=aula_inatel

Executar um teste a partir do Runner ou suíte:
mvn test –Dtest=Ben10Runner

Executar testes separados por tags:
mvn test -Dkarate.options="--tags @tag”

Para ignorar alguma tag:
mvn test -Dkarate.options="--tags ~@tag" 

Todas as tags podem ser configuradas na classe da suíte de testes. (InatelTest.Java)

```
