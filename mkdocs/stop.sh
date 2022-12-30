#!/bin/sh
pids=$(ps -ef | grep 'mkdocs' | grep -v grep  | awk '{print $2}')
for pid in $pids
do
 echo  $pid
 sudo kill -9  $pid
done