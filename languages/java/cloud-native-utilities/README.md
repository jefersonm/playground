# Cloud-Native utilities

[![Build Status](https://travis-ci.org/jefersonm/cloud-native-utilities.svg?branch=master)](https://travis-ci.org/jefersonm/cloud-native-utilities)

Creating cloud-native applications is challenging. The cloud environment consists of machines running all over the world. It’s very sensitive and different issues could happen, such as network partitions, instances that goes down or even entire regions that disappear.

This repository has utility code to deal with specific cloud-native issues.

# Calling remote services
Cloud-native applications are composed of many services that are not in the same machine, making it normal to call remote services all the time.

When calling remote services, add *timeout* and *retry* to the code in order to deal with the possibility of that other services being unresponsive or malfunctioning, so that your application won’t be impacted by it.

Below you'll find some examples of *Retry* and *Timeout* commands:

## Retry command

[RetryCommand.java](https://github.com/jefersonm/cloud-native-utilities/blob/master/src/main/java/com/jefersonm/cloudnative/retry/RetryCommand.java)

Calling external services may result in a bad response from it. Maybe when calling it, the service wasn't working properly and it just needs some time to be working again.

RetryCommand helps to retry the call to the service in an incremental way. It's going to try three times and wait for one more second each time it doesn't receive a good response from the remote server. If any call is successful, a RemoteCallException will be throw, meaning that the call wasn't successful.

### Example of how to use the RetryCommand.java

There is a unit testing showing how to use RetryCommand.java: [RetryCommandTest.java](https://github.com/jefersonm/cloud-native-utilities/blob/master/src/test/java/com/jefersonm/cloudnative/retry/RetryCommandTest.java)

## Timeout command

[TimeoutCommand.java](https://github.com/jefersonm/cloud-native-utilities/blob/master/src/main/java/com/jefersonm/cloudnative/timeout/TimeoutCommand.java)

Sometimes remote services may take more time than expected to respond. Your service must not wait forever, it's a good practice to know how much time your service's API should take to respond and ensure that the time is respected. In order to do that, you must control how much time your remote call is expected to wait.

TimeoutCommand lets you specify the timeout value in milliseconds and the command you want to run. If the command spends more time than the timeout parameter, the execution will be aborted.

### Example of how to use the TimeoutCommand.java

There is a unit testing showing how to use TimeoutCommand.java: [RetryCommandTest.java](https://github.com/jefersonm/cloud-native-utilities/blob/master/src/test/java/com/jefersonm/cloudnative/timeout/TimeoutCommandTest.java)
