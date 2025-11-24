# Quel SGBD ?

MariaDB, qui est la suite libre de MySQL après le rachat de SUN par Oracle.
En Bonus, Adminer permet d’avoir une interface Web pour gérer la base de données.

# Faire tourner le SGBD en local :

1. Installer docker et docker-compose
2. Modifier les mots de passes dans le fichier `docker-compose.yml` et lancer la commande :`$ sudo docker compose up`
3. Ouvrir un navigateur web et se connecter à http://localhost:8080/
4. Se connecter avec comme nom `root` et le mot de passe dans le fichier `docker-compose.yml`
5. Créer une base de donnée `MemoryRace`
6. Importer init_db.sql
7. Exéctuer
8. Enjoy

# Premiers pas dans le SGBD

Vous avez 2 scripts à votre disposition en plus du init_db.sql :

1. reset_db.sql : remet à 0 la base de donnée : supprime les tables puis les réinitialisent vides.
2. micro_dataset.sql : ajoute les données relatives aux 30 photos de tests de la micro db initiale
