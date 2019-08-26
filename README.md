# Quickchat Rsocket

Sample app that demonstrates how to use spring-boot-starter-rsocket in a client/server scenario.

## Building
Navigate to each project, server/client, and run

`./mvnw package`

## Running
The quickchat-server app can be run with `java -jar <binary>`. The quickchat-client should be run with `java -jar -Dquickchat.server.port=<port of running server> <binary>`, which should be 7000 in most cases.

## Testing
You can test app connectivity by sending `curl -XPOST -H 'Accept: application/json' -H 'Content-Type: application/json' http://localhost:8081/chat -d 'Hello'`.
