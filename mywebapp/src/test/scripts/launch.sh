#!/bin/bash
if [ ! $# == 2 ]; then
    echo "missing arguments"
    echo "usage: $0 <port> <daemon-flag>"
    exit;
fi
echo "running $0 $@"
if [ ! $2 == "true" ]; then
    echo "daemon mode disabled. Exiting..."
    exit;
fi
echo "starting jetty server on port=$1"
mvn jetty:stop
mvn jetty:run -Djetty.port=$1 &