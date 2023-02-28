"Ctrl+Shift+V" ou "⇧⌘V" pour afficher la prévisualisation (mais pas sur MyDocker...).

# 3IF4030 : Intégration applicative

## RMI en Java

* Ouvrir le dossier `workspace/integration/2_rmi`.

* Ouvrir un terminal.

* Implémenter les méthodes du serveur `if4030/rmi/RandomServer.java`.

* Compléter le client `if4030/xmlrpc/RandomClient.java` pour appeler soit `setBounds()`,
  soit 10 fois `nextRandom()`selon le nombre d'arguments sur la ligne de commande. 

* Compiler le serveur et le client :
  * `javac if4030/rmi/*.java`

* Lancer le serveur :
  * `java if4030.rmi.RandomServer`

* Dans un autre terminal, lancer le client :
  * `java if4030.rmi.RandomClient localhost`
  * `java if4030.rmi.RandomClient localhost 10 20`

