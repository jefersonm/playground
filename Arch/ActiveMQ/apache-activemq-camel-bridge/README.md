ActiveMQ + Oracle AQ Bridge + Apache Camel with XMLJSON conversion + Jasypt
=============

This repository has an example of ActiveMQ + Oracle AQ Bridge + Apache Camel with XMLJSON conversion + Jasypt

This project has an Apache ActiveMQ 5.13.3 as base. Inside it, there are two frameworks / configurations:

##Oracle AQ Bridge:

The bridge between ActiveMQ and Oracle AQ is configured inside these files:

conf/
- bridge-config.xml
- bridge-connection-core.xml
- bridge-connection.xml
- bridge-credentials.properties
- bridge-routes.properties
- bridge-routes.xml

###Needed libraries:

- ojdbc7-12.1.0.2.jar
- mqtt-client-1.12.jar

##Jasypt (http://www.jasypt.org/)

To criptograph the password used to make the connection to Oracle, Jasypt framework was used, it's configuration can be found inside this file:

- conf/bridge-connection-core.xml

###Needed libraries:

- jasypt-1.9.2.jar
- jasypt-spring31-1.9.2.jar

##Apache Camel with XMLJSON (http://camel.apache.org/xmljson.html)

Two routes were created inside Apache Camel, one connecting to Oracle AQ, getting the XML message and sending it to the Second route, where the XML message is converted to JSON format.

###Needed libraries:

- camel-xmljson-2.16.2.jar
- ezmorph-1.0.6.jar
- groovy-all-2.4.6.jar
- json-lib-2.4-jdk15.jar
- xom-1.2.10.jar

