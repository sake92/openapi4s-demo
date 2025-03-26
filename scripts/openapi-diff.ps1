
git show main:api/resources/public/openapi.json > main_openapi.json

cs launch org.openapitools.openapidiff:openapi-diff-cli:2.1.0-beta.12 -M org.openapitools.openapidiff.cli.Main -- --fail-on-incompatible main_openapi.json .\api\resources\public\openapi.json

rm main_openapi.json
