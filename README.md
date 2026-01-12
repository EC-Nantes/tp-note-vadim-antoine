Projet MEDEV - Jeu du Pendu 

Binôme
Développeur 1 : Vadim Digonnet

Développeur 2 : Antoine Gachet

Présentation du jeu :
Le pendu est un jeu de devinette où un joueur doit retrouver un mot secret en proposant successivement des lettres.

Mode 1 joueur : Le mot est tiré aléatoirement depuis un dictionnaire externe.

Mode 2 joueurs : Un joueur choisit le mot, l'autre devine.

Règles : Le nombre d'erreurs est paramétrable (par défaut 7), les lettres sont insensibles à la casse et seules les entrées alphabétiques sont validées.


 Architecture et Conception:
Le projet respecte une séparation stricte entre :

L'implémentation du jeu (JeuPendu) : Gère les règles, l'état global (en cours, gagné, perdu) et les transitions.
L'Interface Utilisateur (Interface) : Gère uniquement les entrées/sorties texte.
La classe main (tpnotemedev)
