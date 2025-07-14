#!/bin/bash

 BB_PID=$(ps -ef | grep java | grep backboard | awk '{print $2}')

 if [ -z "$BB_PID" ];
 then
    echo "BACKBOARD is not running"
 else
    kill -9 $BB_PID
    echo "BACKBOARD terminated!"
 fi