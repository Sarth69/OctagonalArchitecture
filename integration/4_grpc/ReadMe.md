"Ctrl+Shift+V" ou "⇧⌘V" pour afficher la prévisualisation (mais pas sur MyDocker...).

# 3IF4030 : Intégration applicative

## gRPC en C++ et en Python

* Ouvrir le dossier `workspace/integration/4_grpc`.

* Ouvrir un terminal.

### C++
* Taper `make`.

* Ouvrir le fichier `random_server.cc` et compléter les méthodes en vous aidant de
   [la documentation](https://www.grpc.io/docs/languages/cpp/quickstart/#update-the-server).
  
* Ouvrir le fichier `random_client.cc` et compléter le code de `main()` en vous aidant de
   [la documentation](https://www.grpc.io/docs/languages/cpp/quickstart/#update-the-client).

* Taper `make` de nouveau.

### Python

* Ouvrir le fichier `random_server.py` et compléter les méthodes en vous aidant de
   [la documentation](https://www.grpc.io/docs/languages/python/quickstart/#update-the-server).
  
* Ouvrir le fichier `random_client.py` et écrire les deux fonctions en vous aidant de
   [la documentation](https://www.grpc.io/docs/languages/python/quickstart/#update-the-client).


### Exécution

* Lancer le serveur C++ :
  * `./random_server`
>ou le serveur Python :
>  * `python3 random_server.py`

* Dans un autre terminal, lancer le client C++ :
  * `./random_client localhost`
  * `./random_client localhost 10 20`
>ou le client Python :
>  * `python3 random_client.py localhost`
>  * `python3 random_client.py localhost 10 20`
