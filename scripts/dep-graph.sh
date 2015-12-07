#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/../.."

if [ ! -d neo4j-shell-tools ]; then
  git clone https://github.com/jexp/neo4j-shell-tools
fi
cd neo4j-shell-tools
git checkout 2.2
mvn clean install -DskipTests
cd ..