#!/bin/sh

echo
echo " --- Custom Event Handler ---"
echo
echo "New event: ${SERF_EVENT} is occured"
echo

if [ "${SERF_EVENT}" = "member-failed" ];
then
	echo "STARTING APACHE"
fi

if [ "${SERF_QUERY_NAME}" = "status" ];
then
	echo "APACHE STATUS"
fi

if [ "${SERF_USER_EVENT}" == "restart" ];
then
	echo "BEGIN event data"
	while read line; do
		echo "RESTARTING: " $line
	done
fi