# PRO3600-25-TRA-24 : MemoryRace

Une application facilitant l’identification et l’accès aux photos de course grâce à la reconnaissance des numéros de dossard.

## Auteurs

- Nicolas GASCA
- Nicolas NÈBLE
- Hugo KENNEDY--MARTINEZ
- Alexandre NAIZONDARD

## Contexte du projet

Lors d’événements sportifs comme les marathons, semi-marathons ou triathlons, les photographes professionnels et amateurs jouent un rôle clé en immortalisant les moments forts des coureurs. Ces photos sont non seulement des souvenirs précieux pour les participants, mais elles sont aussi utilisées par les organisateurs pour promouvoir leurs événements.
Actuellement, ces clichés sont souvent mis en ligne sur le site officiel de la compétition, où les participants peuvent les consulter après l’événement. Cependant, ces photos sont généralement stockées sans organisation spécifique, obligeant les coureurs à parcourir de longues galeries d’images pour retrouver celles où ils apparaissent. Ce processus est fastidieux et peut décourager de nombreux participants de récupérer leurs souvenirs.
Pour pallier ce problème, certaines courses ont commencé à implémenter des systèmes permettant d’identifier automatiquement les photos d’un coureur en utilisant son numéro de dossard. Cette approche simplifie considérablement la recherche d’images et améliore l’expérience utilisateur. Toutefois, ces solutions restent peu démocratisées et ne sont disponibles que sur un nombre limité d’événements.
Ainsi, il existe un réel besoin d’une solution simple, accessible et efficace permettant aux coureurs de retrouver rapidement leurs photos sans effort. Le projet MemoryRace s’inscrit dans cette démarche en offrant une solution locale et automatisée pour l’identification et l’accès aux photos de course.

## Objectifs du projet

Le projet MemoryRace vise à améliorer l’expérience des coureurs en facilitant la recherche de leurs photos après un événement sportif. Plutôt que de devoir parcourir manuellement des centaines d’images, les participants pourront simplement entrer leur numéro de dossard dans l’application pour obtenir immédiatement les photos dans lesquelles ils apparaissent.
L'objectif est double :

1. Offrir un gain de temps aux coureurs en automatisant la recherche de leurs photos.
2. Aider les photographes et les organisateurs en simplifiant la gestion et la distribution
   des images prises lors de l’événement.

## Technologies utilisées :

- Python
  - CV2
  - Pytesseract
- Java
  - Swing
  - Java Archive
- MariaDB

## Structure du projet

### Gestion des données

Le projet possède une base de données de photos sur lesquelles faire les tests des différentes fonctionnalités qui seront listées ci-dessous. Cette base de données contient des photos réelles de courses, avec toute la complexité que cela peut entraîner pour pouvoir simuler une situation d'utilisation réelle.

### Extraction des numéros de dossard

Le projet fait appel à un OCR (optical character recognition) incorporé dans python nommé pytesseract. Ce programme Python extrait les numéros de dossard des images et de les mettre dans une liste pour qu'à chaque image soit associés les numéros de dossards présents dessus. Les numéros extraits seront stockés dans la base de données pour être exploités ultérieurement.

### Association des dossards aux photos

Une fois les numéros extraits des images, un programme Java associera chaque participant à une liste contenant les références des photos où apparaît son numéro de dossard. Cette action, effectuée en amont de la demande du participant d'accès à ses photos, permettra un temps de réponse optimal à la requête du participant.

### Interface graphique utilisateur (GUI)

L'objectif étant une utilisation à grande échelle de l'outil, l'interface graphique est un élément crucial du projet et se doit d'être simple et accessible. Son but est de minimiser les actions requises de l'utilisateur pour avoir accès le plus rapidement possible à ses photos. Le choix technologique a été fait d'utiliser la bibliothèque Swing de Java pour constituer cette interface.
