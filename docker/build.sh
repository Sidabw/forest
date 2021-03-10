#!/usr/bin/env bash

project_name="forest"
version=1.0-SNAPSHOT
tag="hub.zenki.cn/dataplus/${project_name}"

cd ..
mvn clean -U package -DskipTests
cd docker

if [ $# -ge 1 ]; then
    tag=$1
fi

if [ $# -eq 0 ]; then
    tag="${tag}:${version}_$(git rev-parse --short HEAD)"
    this_images_num=$(docker images | grep "${tag:47:60}" -c)
    
    if [ $this_images_num -ge 1 ]; then
    tag=${tag}_${this_images_num}
    fi
 
fi

echo build tag $tag
mkdir config
cp -r ../src/main/resources/config/* ./config
cp  ../target/${project_name}.jar .

docker build -t $tag .
rm "${project_name}.jar"
rm -rf config
