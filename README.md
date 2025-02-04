# openapi4s-demo

Petstore spec is downloaded on 26.12.2024 from https://petstore3.swagger.io/api/v3/openapi.json


Here is a small video demo: https://youtu.be/kf0vGrlKNb8

# First time generating
```shell
./mill -i -j 1 api.regenerate

# git commit files..
```

By default, all endpoints will return 501 NotImplemented status.  
You just need to fill in the details. :) 

# Second time generating

Same as above!  
OpenApi4s will only overwrite definitions that it wrote (not expressions!).  
Meaning that any class/method/val generated by it can be overwritten if you changed it manually!  
Other code (e.g. business logic in controller), *that you wrote* will not be touched. :)

The dev loop is essentially:
- change openapi.yaml
- regenerate
- see git diff
- implement necessary changes
- git commit



