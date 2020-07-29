# simple spring boot server connecting to GCP datastore and pushing docker image with Jib


## create project id on GCP console

```
gcloud config set project <YOUR PROJECT ID>
gcloud auth login
```

## For local testing login for app engine default service account
```
gcloud auth application-default login
```

## For building and pushing docker image to registry
```
mvn clean compile jib:build
```