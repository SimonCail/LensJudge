# Projet SAE 3.A.01

## Répartition des rôles
    - Mathias Morel : Project manager
    - Benjamin Cornet : Team member
    - Mathéo Dalmasso : Team member
    - Simon Caillieret : Team member

---

## Répartition des tâches 

| Fonctionnalité                              | Patron(s) de conception utilisé(s) | Auteur(s)                     |
| ------------------------------------------- |------------------------------------|-------------------------------|
| Représentation d'un cas de test             |                                    | Mathéo                        |
| Représentation d'un problème                | Constructeur                       | Benjamin                      |
| Configuration d'un problème                 | Constructeur                       | Benjamin                      |
| Représentation d'un processus               | Adaptateur                         | Benjamin                      |
| Limitation du temps d'exécution d'un processus| Décorateur                         | Benjamin                      |
| Limitation de la mémoire d'un processus     | Décorateur                         | Benjamin                      |
| Compilation d'un programme C                | Stratégie                          | Mathias                       |
| Compilation d'un programme C++              | Stratégie                          | Mathias                       |
| Compilation d'un programme Java             | Stratégie                          | Mathias                       |
| Compilation d'un programme Python           | Stratégie                          | Mathias                       |
| Exécution d'un programme C compilé          | Stratégie                          | Simon                         |
| Exécution d'un programme C++ compilé        | Stratégie                          | Simon                         |
| Exécution d'un programme Java compilé       | Stratégie                          | Simon                         |
| Vérification stricte de la solution         | Décorateur et Stratégie            | Matheo                        |
| Vérification avec tolérance sur les réels   | Décorateur et Stratégie            | Matheo                        |
| Vérification avec tolérance de la casse     | Décorateur et Stratégie            | Matheo                        |
| Vérification avec tolérance sur les espaces | Décorateur et Stratégie            | Matheo                        |
| Vérification avec tolérance sur l'ordre     | Décorateur et Stratégie            | Matheo                        |
| Vérification d'une solution parmi plusieurs | Décorateur et Stratégie            | Matheo                        |
| Vérification déléguée à un programme externe|                                    |                               |
| Configuration de l'exécution sur un cas de test| Constructeur                       | Mathias/Matheo                |
| Programme principal de juge automatique     | Singleton                          | Mathias/Matheo/Simon/Benjamin |

---

### Bibliothèques supplémentaires utilisées
    - AnsiConsole
    - Apache Commons CLI

Nous avons utilisé la bibliothèque AnsiConsole pour mettre en couleur les messages affichés dans la console.
Nous avons utilisé la bibliothèque Apache Commons CLI pour gérer les arguments passés en ligne de commande.

### IA Utilisée
    - Copilot
    - Chatgpt

Nous avons utilisé Copilot notamment pour la correction des erreurs et la génération de code.

Nous avons utilisé Chatgpt pour comprendre plus précisément comment fonctionne les différents patrons de conception et des informations sur notre code.

## Exemples de commit

### Pour fermer une issue
    - git commit -m "Fixes #? - Description de l'issue"

### Pour un commit de correction de bugs / changements dans le programme
    - git commit -m "Description du commit"

### Pour mentionner une issue
    - git commit -m "#? - Description du commit"
    
---

