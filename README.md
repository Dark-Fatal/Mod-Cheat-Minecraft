# ShadowCore Quick Admin Panel (Fabric 1.21.x)

Petit mod client-side Fabric ajoutant une interface pour exécuter rapidement des commandes admin via des boutons.

## Fonctionnalités
- Touche `P` pour ouvrir le panneau.
- Boutons de commandes préconfigurées (gamemode, weather, time, etc.).
- Fermeture rapide du menu avec `ESC`.

## Build
```bash
./gradlew build
```

## Installation
1. Copier le JAR généré dans `build/libs`.
2. Le placer dans le dossier `mods` de Minecraft Fabric 1.21.x.
3. Lancer le jeu.

## Personnalisation
Les commandes sont définies dans `AdminPanelScreen#createButtons()`. 
Tu peux changer les commandes selon ton serveur.
