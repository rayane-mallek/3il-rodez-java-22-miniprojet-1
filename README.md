Projet Java

J'ai réalisé toutes les questions qui ne sont pas des bonus (sauf SuperBruitPerlin2D que j'ai réalisé).

Quelques tests unitaires ont été faits.

Ce qui m'a paru difficile a surtout été les mathmétiques car ce n'est pas mon fort.

Mes réponses aux questions :
### Question : pourquoi l'attribut graine est-il en final ? 
Réponse : pour être sûr qu'elle ne soit pas modifiable dans les classes filles.

### Question : Réaliser l'architecture que prendrait la forme d'une telle modélisation sous forme d'un diagramme UML. Quelle serait la différence d'attributs et de méthodes entre ces classes ? Expliquer, en s'appuyant sur un exercice vu en cours, pourquoi c'est une mauvaise idée. Quelle est la solution qu'il faudrait préférer (et que l'on va préférer) ?
Voir uml.PNG. Mauvaise pratique car dur à maintenir, on va préférer une énumération.

### Question : quel type utilisez-vous ?
double, car ce sont des nombres à virgule. Pas float car ils sont codés seulement en 32 bits.

### Question : pourquoi sortir, selon vous, ce bout d'algorithme de la classe ?
Pour la maintenabilité : si on modifie l'algorithme, alors on ne le fera qu'à un endroit.