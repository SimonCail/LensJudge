# Projet SAE 3.A.01

## Répartition des rôles
    - Mathias Morel : Project manager
    - Benjamin Cornet : Team member
    - Mathéo Dalmasso : Team member
    - Simon Caillieret : Team member

---

## Répartition des tâches

| Fonctionnalité                              | Patron(s) de conception utilisé(s) | Auteur(s)         |
| ------------------------------------------- |-----------------------------------|--------------------|
| Représentation d'un cas de test             | Composite                         |                    |
| Représentation d'un problème                | Composite                         |                    |
| Configuration d'un problème                 | Constructeur                      |                    |
| Représentation d'un processus               | Composite                         |                    |
| Limitation du temps d'exécution d'un processus| /                               |                    |
| Limitation de la mémoire d'un processus     | /                                 |                    |
| Compilation d'un programme C                | Stratégie                         |                    |
| Compilation d'un programme C++              | Stratégie                         |                    |
| Compilation d'un programme Java             | Stratégie                         |                    |
| Compilation d'un programme Python           | Stratégie                         |                    |
| Exécution d'un programme C compilé          | Patron de méthode                 |                    |
| Exécution d'un programme C++ compilé        | Patron de méthode                 |                    |
| Exécution d'un programme Java compilé       | Patron de méthode                 |                    |
| Vérification stricte de la solution         | Décorateur                        |                    |
| Vérification avec tolérance sur les réels   | Décorateur                        |                    |
| Vérification avec tolérance de la casse     | Décorateur                        |                    |
| Vérification avec tolérance sur les espaces | Décorateur                        |                    |
| Vérification avec tolérance sur l'ordre     | Décorateur                        |                    |
| Vérification d'une solution parmi plusieurs | Décorateur                        |                    |
| Vérification déléguée à un programme externe|                                   |                    |
| Configuration de l'exécution sur un cas de test| Constructeur                   |                    |
| Programme principal de juge automatique     | Singleton                         |                    |

---

## Exemples de commit

#### Pour fermer une issue
    - git commit -m "Fixes #? - Description de l'issue"

#### Pour un commit de correction de bugs / changements dans le programme
    - git commit -m "Description du commit"

    
---

