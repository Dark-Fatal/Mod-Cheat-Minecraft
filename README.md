# ShadowCore Quick Admin Panel (Fabric 1.21.x)

ShadowCore est un petit mod **client-side** pour Minecraft Java (Fabric) qui ajoute un panneau rapide pour exécuter des commandes admin via des boutons.

> ⚠️ Important : ce mod n’accorde **aucun** droit admin automatiquement. Les commandes ne fonctionneront que si ton compte a déjà les permissions sur le serveur (OP, permissions plugin, etc.).

---

## Fonctionnalités

- Ouverture du panneau avec la touche **`P`**.
- Boutons de commandes prêtes à l’emploi (gamemode, weather, time…).
- Exécution instantanée des commandes en un clic.
- Message de confirmation dans le chat.
- Fermeture rapide avec **`ESC`** ou bouton **Close**.

---

## Prérequis

Avant d’installer ShadowCore, vérifie :

1. **Minecraft Java Edition 1.21.1**
2. **Fabric Loader** installé pour la version 1.21.1
3. **Fabric API** présent dans le dossier `mods`
4. **Java 21** (recommandé/nécessaire pour ce projet)

---

## Téléchargement

Tu as 2 options.

### Option A — Télécharger un JAR déjà compilé

1. Récupère le fichier `shadowcore-<version>.jar` depuis la section Releases (ou depuis la source qui te l’a fourni).
2. Vérifie que la version du mod correspond bien à **Minecraft 1.21.1**.
3. Vérifie que tu as aussi un JAR de **Fabric API** compatible 1.21.1.

### Option B — Compiler toi-même depuis le code source

1. Clone le repo :
   ```bash
   git clone <url-du-repo>
   cd Mod-Cheat-Minecraft
   ```
2. Génère (ou utilise) le wrapper Gradle si nécessaire :
   ```bash
   gradle wrapper
   ```
3. Compile :
   ```bash
   ./gradlew build
   ```
4. Récupère le JAR dans :
   ```
   build/libs/
   ```

---

## Installation (client)

### Étape 1 — Installer Fabric Loader

- Lance l’installateur Fabric.
- Sélectionne la version **Minecraft 1.21.1**.
- Termine l’installation.

### Étape 2 — Ouvrir le dossier Minecraft

- **Windows** : `%appdata%\.minecraft`
- **Linux** : `~/.minecraft`
- **macOS** : `~/Library/Application Support/minecraft`

### Étape 3 — Ajouter les mods

Copie dans le dossier `mods` :

- `shadowcore-<version>.jar`
- `fabric-api-<version>.jar`

Si le dossier `mods` n’existe pas, crée-le manuellement.

### Étape 4 — Lancer le jeu

1. Ouvre le launcher Minecraft.
2. Sélectionne le profil **Fabric 1.21.1**.
3. Lance le jeu.

---

## Vérifier que l’installation a réussi

En jeu :

1. Va en monde solo ou sur un serveur où tu as les permissions.
2. Appuie sur **`P`**.
3. Le panneau **ShadowCore - Admin Panel** doit apparaître.
4. Clique une commande (ex: `Set Day`) pour tester.

Si rien ne s’ouvre :

- vérifie que tu es bien sur le profil Fabric,
- vérifie la présence de Fabric API,
- vérifie la version Java (21),
- vérifie qu’un autre mod n’a pas déjà pris la touche `P`.

---

## Utilisation

- Ouvrir panneau : **`P`**
- Cliquer un bouton pour exécuter la commande associée.
- Fermer : **ESC** ou **Close**.

Le mod envoie la commande comme si tu l’avais tapée dans le chat.

---

## Personnaliser les commandes

Les commandes sont définies dans :

- `src/main/java/com/shadowcore/client/AdminPanelScreen.java`

Modifie la liste `COMMANDS` pour ajouter, retirer ou renommer des actions.

Exemple :

```java
new CommandEntry("Heal", "/heal")
```

Puis recompile avec `./gradlew build`.

---

## Dépannage

### 1) Le jeu crash au lancement

- version Minecraft/Fabric/Fabric API incompatible,
- Java non compatible (utiliser Java 21),
- conflit avec un autre mod client.

### 2) Les boutons ne font rien

- ton compte n’a pas les permissions de commande,
- la commande n’existe pas sur ce serveur (plugins différents),
- la syntaxe de la commande est différente sur ton serveur.

### 3) Le mod n’apparaît pas

- JAR placé au mauvais endroit,
- mauvais profil (vanilla au lieu de Fabric),
- JAR du mod corrompu ou compilé pour une autre version.

---

## Sécurité et scope

- ShadowCore est un **outil d’interface** pour accélérer l’exécution de commandes.
- Il ne contourne pas les permissions serveur.
- Il n’inclut pas de fonctionnalités de bypass/cheat.

---

## Développement rapide

Commandes utiles :

```bash
./gradlew build      # compile le mod
./gradlew runClient  # lance un client de dev Fabric
./gradlew clean      # nettoie les artefacts
```

---

## Licence

Projet distribué sous licence **MIT** (voir `fabric.mod.json` pour la métadonnée actuelle de licence).
