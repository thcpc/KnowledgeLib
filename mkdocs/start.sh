#!/bin/sh
nohup mkdocs serve -a 0.0.0.0:9999 >mkdocs.log 2>&1 &

pids=$(ps -ef | grep 'mkdocs' | grep -v grep  | awk '{print $2}')
for pid in $pids
do
 echo  $pid
done