# Algorithme-genetique

Pour un problème de minimisation J, un algorithme génétique simple de la manière suivante :<br> 
(1) Génération aléatoire d’une population de N individus ; <br>
(2) Evaluation de la qualité du phénotype de chaque individu ;<br>
(3) Sélection d’un couple de parents au moyen d’une procédure appropriée ; <br>
(4) Croisement des deux individus avec une probabilité Pc pour générer deux enfants ; <br>
(5) Mutation des deux enfants avec une probabilité Pm ; <br>
(6) Répéter les étapes 3, 4, et 5 jusqu’à ce que la nouvelle population contienne N individus<br>

 Initialisation:<hr> comme DE est une méthode d'optimisation continue, la population de vecteurs solutions  est en général initialisée.<br>

Mutation :<hr> la mutation est une phase importante pour DE car elle permet la génération d'un vecteur variant qui est généré pour chaque vecteur Xj de la population. Ce vecteur est une perturbation du vecteur Xi à partir de trois autres vecteurs de la population.
<br>
Croisement: <hr>  le   croisement   permet   dans   le   cadre   de   l'évolution   différentielle   de conserver un certain taux de diversité dans la population. Dans cette étape de la boucle évolutionnaire, un vecteur d'essai est créé et l'opérateur de croisement garantit qu'au minimum un des éléments du vecteur variant sera conservé.

<br>Sélection:<hr> l'étape de sélection permet de remplacer le vecteur Xi(t) par le vecteur d'essai Ui(t+1) dans la population si sa fitness est meilleure
