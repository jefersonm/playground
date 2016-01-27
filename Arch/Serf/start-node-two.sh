#!/bin/sh

serf agent -node=node-two -bind=127.0.0.1:5001 -rpc-addr=127.0.0.1:7374 -log-level=debug -event-handler=./event-handler.sh