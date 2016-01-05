#!/bin/bash

prof="dev"
port="8888"
debug="false"
mvnexe="mvn"

while getopts "p:dP:" arg
do
    case $arg in
        p)
            port="$OPTARG"
            ;;
        d)
            mvnexe="mvnDebug"
            ;;
        P)
            prof="$OPTARG"
            ;;
        ?)
            echo "unknown arguments"
    exit 1
    ;;
    esac
done

set MAVEN_OPTS="-Xmx128M -Xms64M"  # 传递给JVM的参数
mvn clean
$mvnexe jetty:run-exploded -P $prof -Djetty.port=$port
