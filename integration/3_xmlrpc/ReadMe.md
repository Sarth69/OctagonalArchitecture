"Ctrl+Shift+V" ou "⇧⌘V" pour afficher la prévisualisation (mais pas sur MyDocker...).

# 3IF4030 : Intégration applicative

## xmlrpc en Python et Java

* Ouvrir le dossier `workspace/integration/3_xmlrpc`.

* Ouvrir un terminal.

* En utilisant la [documention du module xmlrpc.server](https://docs.python.org/fr/3/library/xmlrpc.server.html),
  compléter le serveur `if4030/xmlrpc/RandomServer.py`.

* En utilisant cette [documention de XmlRpcClient](https://ws.apache.org/xmlrpc/client.html), 
  compléter le client `if4030/xmlrpc/RandomClient.java`. 

* Compiler le client Java :
  * `javac -cp '.:lib/*' if4030/xmlrpc/RandomClient.java`

* Lancer le serveur Python :
  * `python3 -m if4030.xmlrpc.RandomServer`

* Dans un autre terminal, lancer le client Java :
  * `java -cp '.:lib/*' if4030.xmlrpc.RandomClient localhost`
  * `java -cp '.:lib/*' if4030.xmlrpc.RandomClient localhost 10 20`

