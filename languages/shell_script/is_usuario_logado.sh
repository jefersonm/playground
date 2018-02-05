#!/bin/bash
# Test if an user is logged or not
#
if (who | tr -s " " | cut -f1 -d " " | grep "^$1$" > /dev/null) 
then
	echo User "$1" is logged
else
	echo User "$1" is not logged
fi
