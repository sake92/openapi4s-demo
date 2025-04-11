#!/usr/bin/env bash

# copy the openapi.json from main branch to a temp file
git show origin/main:api/resources/public/openapi.json > main_openapi.json

# compare them and exit with error if there are breaking changes
cs launch org.openapitools.openapidiff:openapi-diff-cli:2.1.0-beta.12 \
  -M org.openapitools.openapidiff.cli.Main \
  -- --fail-on-incompatible main_openapi.json ./api/resources/public/openapi.json
[ $? -eq 0 ]  || exit 1

rm main_openapi.json
