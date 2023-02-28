"Ctrl+Shift+V" ou "⇧⌘V" pour afficher la prévisualisation (mais pas sur MyDocker...).

# 3IF4030 : Intégration applicative

## SOAP en Java avec Apache Axis2

* Ouvrir le dossier `workspace/integration/5_soap`.

* Ouvrir un terminal.

* Compléter la classe (un [POJO](https://fr.wikipedia.org/wiki/Plain_old_Java_object) !)
  `if4030/soap/RandomService.java` décrivant le service.

* Compiler le service :
  * `javac if4030/soap/RandomService.java`

* Créer la description WSDL du service :
  * `java2wsdl.sh -cp . -cn if4030.soap.RandomService -of META-INF/RandomService.wsdl`

* Ouvrir le fichier `META-INF/RandomService.wsdl` et modifier le nom des sous-éléments de
  l'élément `setBounds` (`args0 => min` et `args1 => max`).
  
* Installer le service dans le répertoire utilisé par Axis2 :
  * `cp -R . /opt/axis2/repository/services/RandomService`

* Ajouter le service dans la liste des services Axis2 :
  * `echo RandomService >>/opt/axis2/repository/services/services.list`

* Démarrer le serveur Axis2 :
  * `axis2server.sh`

* Dans un autre terminal, faites des appels au service :
  * `curl http://localhost:8080/axis2/services/RandomService/nextRandom`
  * `curl http://localhost:8080/axis2/services/RandomService/setBounds\?min=10\&max=20`

* Générer le talon pour le client :
  * `wsdl2java.sh -uri META-INF/RandomService.wsdl -s -S .`

* Compléter la classe `if4030/soap/RandomServiceClient.java`

* Compiler le talon et le client :
  * `javac -cp '.:/opt/axis2/lib/*' if4030/soap/RandomServiceStub.java`
  * `javac -cp '.:/opt/axis2/lib/*' if4030/soap/RandomServiceClient.java`

* Exécuter le client
  * `java -cp '.:/opt/axis2/lib/*' if4030.soap.RandomServiceClient localhost`
  * `java -cp '.:/opt/axis2/lib/*' if4030.soap.RandomServiceClient localhost 10 20`
