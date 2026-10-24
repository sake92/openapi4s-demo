#!/usr/bin/env bash
set -euo pipefail

# The sbt task always runs the generator; no spec modification is needed.
sbt 'api/openApi4sGenerate'

git diff --exit-code -- api/src/main/scala
if [[ -n "$(git ls-files --others --exclude-standard -- api/src/main/scala)" ]]; then
  echo "Generation produced untracked sources; commit them before running this check." >&2
  exit 1
fi
