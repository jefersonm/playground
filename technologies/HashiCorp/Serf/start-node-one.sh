#!/bin/sh

serf agent -node=node-one -bind=127.0.0.1:5000 -rpc-addr=127.0.0.1:7373 -log-level=debug -event-handler=./event-handler.sh