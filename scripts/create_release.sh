#!/usr/bin/env bash
set -euo pipefail

VERSION="${1:-0.1.0}"

if [ ! -f ./gradlew ]; then
  echo "[info] Gradle wrapper absent, génération..."
  gradle wrapper
fi

./gradlew clean build
mkdir -p releases
JAR_PATH=$(find build/libs -maxdepth 1 -type f -name "*.jar" ! -name "*-sources.jar" | head -n 1)

if [ -z "${JAR_PATH}" ]; then
  echo "[error] Aucun JAR compilé trouvé dans build/libs" >&2
  exit 1
fi

cp "$JAR_PATH" "releases/shadowcore-${VERSION}.jar"
echo "[ok] Release créée: releases/shadowcore-${VERSION}.jar"
