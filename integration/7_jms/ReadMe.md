"Ctrl+Shift+V" ou "⇧⌘V" pour afficher la prévisualisation (mais pas sur MyDocker...).

# 3IF4030 : Intégration applicative

## JMS en Java avec Apache ActiveMQ

* Ouvrir le dossier `workspace/integration/7_jms`.

* Ouvrir un terminal.

* Compiler les fichiers fournis :
  * `javac -cp '.:/opt/activemq/lib/*' if4030/jms/*.java`

* Lancer ActiveMQ :
  * `activemq start`

* Lancer le client :
  * `java -cp '.:/opt/activemq/lib/*' if4030.jms.RandomClient`

* Dans un autre terminal, lancer le serveur :
  * `java -cp '.:/opt/activemq/lib/*' if4030.jms.RandomServer`

* Vérifier que le client reçoit les messages envoyés par le serveur.

* Recommencer en commençant par le serveur et en arrêtant et relançant ActiveMQ avant d'exécuter le client :
  * `java -cp '.:/opt/activemq/lib/*' if4030.jms.RandomServer`
  * `activemq stop`
  * `activemq start`
  * `java -cp '.:/opt/activemq/lib/*' if4030.jms.RandomClient`

* Lancer le serveur en lui demandant de produire 20 messages :
  * `java -cp '.:/opt/activemq/lib/*' if4030.jms.RandomServer 1 20`
> puis lancer 2 clients en parallèle :
  * `java -cp '.:/opt/activemq/lib/*' if4030.jms.RandomClient 1 & java -cp '.:/opt/activemq/lib/*' if4030.jms.RandomClient 2 &`

* Modifier le serveur et le client pour qu'ils utilisent un [`Topic`](https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createTopic-java.lang.String-) au lieu d'une `Queue`,
  et essayer ces 3 variantes :
  * lancer le serveur puis le client ;
  * lancer le client puis le serveur dans un autre terminal ;
  * lancer 2 clients en parallèle, puis le serveur.

* Modifier le client pour qu'il installe un `ClientListener` avant la boucle :
```
            RandomClientListener listener = new RandomClientListener( name );
            consumer.setMessageListener( listener );
```
            
> et modifier la boucle pour attendre que nb messages aient été reçus par l'écouteur, tester.

* Modifier le type du consommateur pour que ce soit un [souscripteur durable](https://docs.oracle.com/javaee/7/api/javax/jms/TopicSession.html#createDurableSubscriber-javax.jms.Topic-java.lang.String-),
  ajouter un [identifiant](https://docs.oracle.com/javaee/7/api/javax/jms/Connection.html#setClientID-java.lang.String-) à la connexion.

* Lancer le client puis l'arrêter, lancer le serveur, puis lancer de nouveau le client.
