#!/bin/bash
# Edit file
#

#check if a parameter was send
if [ "$#" -ne 1 ]
then
	echo "Erro -> Use: $0 <file>"
	exit 1
fi

if [ -e $1 ] > /dev/null
then
	cp $1 $1"~"
	vim $1
else
	echo File "$1" doesnt exist
fi
