#!/usr/bin/env bash

project_name="forest"
version=1.0-SNAPSHOT

mkdir tmpdir logs

WORKDIR=`pwd`
tmpdir=$WORKDIR/tmpdir
log_dir=$WORKDIR/logs

#不影响dolphin deploy的情况下，保证本地docker启动正常（读jar内部的配置文件）。
config_file="/app/config/application.yml"
config_params=""
if [ ! -f "$config_file" ];then
  config_params="--spring.config.location=$config_file"
fi

java -version

java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$log_dir -Djava.io.tmpdir=tmpdir -Duser.timezone=GMT+08 -jar ${project_name}.jar $config_params
