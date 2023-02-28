"Ctrl+Shift+V" ou "⇧⌘V" pour afficher la prévisualisation (mais pas sur MyDocker...).

# 3IF4030 : Intégration applicative

## RPC en C

* Ouvrir le dossier `workspace/integration/1_rpc`.

* Ouvrir un terminal.

* Taper `make` (ignorer les éventuels avertissements).

### Ouvrir le fichier `random_server.c` :
* Définir en variables globales les 2 bornes de l'intervalle, initialisées à 1 et 100.

* Dans la fonction `set_bounds_1_svc()`, les nouvelles bornes sont à récupérer dans 
    l'agrégat pointé par `argp` ; mémoriser et afficher ces nouvelles bornes.

* Dans la fonction `next_random_1_svc()`, mettre dans la variable `result`
    un nombre généré aléatoirement entre les deux bornes (utilisez [`rand()`](http://man7.org/linux/man-pages/man3/rand.3.html)).
  
### Ouvrir le fichier `random_client.c` :

* Remplacer la fonction `main()` par :

      int main( int argc, char* argv[] )
      {
          if( argc == 2 ) random_get_next_10( argv[1] );
          if( argc == 4 ) random_set_bounds( argv[1], atoi( argv[2] ), atoi( argv[3] ));
      }
* En vous basant sur le code de la fonction `random_1()` :
  * définir la fonction de signature :

        void random_set_bounds( char * host, int min, int max );
     qui réalise un appel distant au service `set_bounds()` du serveur ;

  * définir la fonction de signature :

        void random_get_next_10( char * host );

     qui réalise 10 appels distants au service `next_random()` du serveur.

### Exécution
* Taper `make` de nouveau.

* Lancer le serveur :
  * `./random_server`

* Dans un autre terminal, lancer le client :
  * `./random_client localhost`
  * `./random_client localhost 10 20`

