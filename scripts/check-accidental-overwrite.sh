#!/usr/bin/env bash

echo " " >> api/resources/openapi.json      # append a space at end of openapi.json
./mill api.compile                          # trigger OpenApi4s
truncate -s -1 api/resources/openapi.json   # remove the space at end of openapi.json

git diff --exit-code                        # check if there are any accidental diffs
[ $? -eq 0 ]  || exit 1                     # abort if there are
