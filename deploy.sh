#!/bin/bash
echo "Building Maven Project..."
mvn clean package -DskipTests

echo "Building Docker Image..."
docker build -t basicgamearena .

echo "Restarting Kubernetes Deployment..."
kubectl rollout restart deployment basicgamearena

echo "Done!"