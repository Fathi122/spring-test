# simple spring boot server connecting to GCP datastore and pushing docker image with Jib


## As a pre-requisite create project id on GCP console

```
gcloud config set project <YOUR PROJECT ID>
gcloud auth login
```

## For local testing login with app engine default service account

```
gcloud auth application-default login
```

## For building and pushing docker image to registry

```
mvn clean compile jib:build
```

## For deploying server on Kubernetes

- First create a Kubernetes secret from the app engine default service account obtained from GCP APIs portal

```
kubectl create secret generic ggsecret --from-file=api-cred=$PWD/sec.json
```

- Then create a Kubernetes ClusterIP service

```
kubectl create -f test/k8s-spring-deployment.yaml
kubectl create -f test/k8s-spring-svc.yaml
```

## For testing deployment from host

- Create Port forwarding in order to access spring-test-gcp K8s service

```
kubectl get pod
kubectl port-forward spring-test-gcp-xxxxx 7000:8080
```

- Then issue curl commands to create/update/read objects on GCP datastore

```
curl -H "Content-Type: application/json" -XPOST -d '{"id": 1225,"name":"user1","address":"15 Colomb Avenue"}' http://localhost:7000/api/user
curl -XGET  http://localhost:7000/api/user/1225
```
