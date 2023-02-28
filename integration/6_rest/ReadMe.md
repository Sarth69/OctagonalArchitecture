"Ctrl+Shift+V" ou "⇧⌘V" pour afficher la prévisualisation (mais pas sur MyDocker...).

# 3IF4030 : Intégration applicative

## REST en Java avec Spring

* Ouvrir le dossier `workspace/integration/6_rest`.

* Ouvrir un terminal.

* Créer un projet Web basé sur Spring Boot :
```
    curl https://start.spring.io/starter.tgz \
        -d type=maven-project \
        -d language=java \
        -d javaVersion=17 \
        -d dependencies=web \
        -d description="Demo rest Random with Spring Boot" \
        -d groupId=if4030.rest \
        -d packageName=if4030.rest \
        -d name=random \
        -d artifactId=random \
    | tar zxf -
```
* En utilisant la [documentation de Spring](https://spring.io/quickstart),
  définissez dans la classe `if4030.rest.RandomApplication`
  deux méthodes `nextRandom()` et `setBounds()`, accessibles
  en REST et fournissant les services habituels.

* Construire et lancer le serveur :
  * `./mvnw spring-boot:run`

* Dans un autre terminal, faites des appels au service :
  * `curl http://localhost:8080/nextRandom`
  * `curl http://localhost:8080/setBounds\?min=10\&max=20`

