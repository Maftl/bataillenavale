Backlog
=======

Préparation de la partie
------------------------

Présélectionner le joueur 1, lui afficher ses deux grilles : celle du positionnement de ses propres bateaux et celle de ses attaques.
Il sera stipulé au joueur quelles commandes lui sont demandées pour la suite du jeu : 
**Exemple :**
Un bateau se positionne 
* Selon une orientation horizontale (saisir h) ou verticale (saisir v).
* Selon des coordonnées de départ, il s’agit du coin supérieur gauche (saisir la lettre de la ligne suivi du numéro de la colonne, sans espace).
* Le positionnement sera répété 5 fois pour les 5 bateaux de sa flotte.
* Les bateaux sont affichés sur la grille par un ensemble de « O ».
A chaque saisie, le positionnement sera vérifié : chevauchement d’un autre bateau précédemment posé et/ou dépassement de la grille.
Après chaque positionnement de bateau, l’interface est rafraichie.
En cas d’erreur de saisie, il sera demandé au joueur de saisir à nouveau une valeur jusqu’à ce qu’elle soit correcte.
Lorsque le joueur 1 a fini de positionner sa flotte, le joueur 2 pourra positionner la sienne.

Début de la partie
------------------

Quand les bateaux des deux joueurs sont positionnés, la partie peut commencer.
Le joueur 1 effectue une attaque en saisissant les coordonnées de la case voulu (la saisie d’une coordonnée est expliquée précédemment).

Si son attaque échoue, la case visée affiche un «@ », en cas de réussite, la case visée affiche « X », sur sa grille d’attaque

Si les coordonnées de l’attaque ne sont pas bonnes (hors de la grille par exemple), il sera demandé à l’utilisateur de les ressaisir,  jusqu’à ce qu’elles soient correctes.

A la fin de chaque attaque d’un joueur, afficher un message signalant que son tour est fini et que s’est au tour de son adversaire de jouer. 
Ce message doit être validé par la touche  « entrée », cela permet de laisser un temps d’attente entre chaque attaque.

Suite de la partie
------------------

Lorsque l’attaque a été exécutée,  le joueur 2 pourra à son tour faire une attaque, sa propre grille sera affichée et ainsi de suite.
Quand un joueur a réussit à couler un bateau, un message l’avertira.
Le premier joueur à avoir coulé toute la flotte de son adversaire à gagné.
Un message l'avertit de sa réussite

Fin de la partie
----------------