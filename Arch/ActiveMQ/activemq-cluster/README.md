ActiveMQ Cluster configuration
=============

This repository has an example of ActiveMQ Cluster configuration.

###There are three projects:

<b>1. apache-activemq-5.13.2-one</b>

  Broker one (tcp://localhost:61617)

<b>2. apache-activemq-5.13.2-two</b>

  Broker two (tcp://localhost:61618)

<b>3. apache-activemq-5.13.2-three</b>

  This is the central Broker (tcp://localhost:61619). The client application should use it's address to use the ActiveMQ cluster.

