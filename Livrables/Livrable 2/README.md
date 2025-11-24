# Explication du livrable

Voici le rendu du livrable 2 : le prototype. Comme présenté dans le livrable 1, notre projet se décompose en trois parties : la base de données, l'application et l'IA. Vous trouverez ci-dessous une brève explication de ces différentes parties au stade actuel du prototype.

## Partie 1 : Base de données

Un fichier docker-compose.yml a été créé pour exécuter la base de données en local. Les instructions d'installation et d'utilisation sont détaillées dans le fichier README.md spécifique au dossier Database.

Trois scripts SQL sont actuellement disponibles :

- init_db.sql : crée les tables (vides) conformément au schéma présenté dans le livrable 1.

- reset_db.sql : supprime et recrée les tables, facilitant ainsi les tests et le développement de scripts.

- micro_dataset.sql : initialise un petit jeu de données dans la base. Ce script ajoute 30 photos dans la table Photos, réparties sur trois courses (inscrites dans Courses). De plus, les détections des numéros de dossard ont été ajoutées manuellement dans la table Detections, en attendant l'intégration du script Python avec la base de données.

## Partie 2 : Application

L'application communique avec la base de données et propose une interface graphique permettant :

1. De sélectionner une course via un menu déroulant.

2. D’entrer un numéro de dossard à rechercher.

3. D’afficher la photo associée à ce numéro, si elle existe.

À ce stade, l’application ne prend pas encore en charge le cas où un dossard est associé à plusieurs photos. L’amélioration de cette fonctionnalité ainsi que l’optimisation de l’interface graphique figurent parmi les prochaines étapes de développement.

## Partie 3 : IA

Cette partie est constituée d'un script python permettant d'extraire le numéro des brassards. Elle utilise notamment Tesseract qui permet l'extraction du numéro.

1. le script vérifie l'existence de l'image.

2. le script ajuste la couleur et la dimension de l'image.

3. le script renvoie la valeur.

A ce stade, l'algorithme fonctionne avec des images simples. Il faut néanmoins maintenant l'améliorer avec une détection des visages pour mieux cibler la recherche de numéro.

De plus, une partie traitement du numéro avant la transmission à la base est à prévoir.









