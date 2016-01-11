#!/bin/sh

echo
echo "New event: ${SERF_EVENT}. Data follows..."
while read line; do
    printf "${line}\n"
done
