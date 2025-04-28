#!/bin/bash
echo "Building Maven Project..."
mvn clean install
mvn clean package -DskipTests

echo "Building Docker Image..."
docker build --no-cache -t basicgamearena .

echo "Pushing Docker Image to DockerHub..."
docker tag basicgamearena hemanthkumarmachani/basicgamearena:latest
docker push hemanthkumarmachani/basicgamearena:latest

echo "Restarting Kubernetes Deployment..."
kubectl rollout restart deployment basicgamearena

echo "Done!"