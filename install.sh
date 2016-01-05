#!/bin/bash

prof="dev"

while getopts "P" arg
do
    case $arg in
        P)
            prof="$OPTARG"
            ;;
        ?)
            echo "unknown arguments"
    exit 1
    ;;
    esac
done

mvn clean
mvn -P $prof install