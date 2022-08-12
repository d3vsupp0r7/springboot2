# Springboot2 with Apache Kafka

# Project

To runt this application remember to start Apache Kafka server architecture based on docker, refer to **docker/docker-apache-kafka** to test this application.

# Kafka commands

Path: */bin*

## Exceute Kafka CLI commansds inside the same Kafka docker container

```
unset JMX_PORT;kafka-topics --bootstrap-server kafka0:9092 --list
```

## Create topic

```
kafka-topics --bootstrap-server kafka0:9092 --create --if-not-exists --topic my-topic-1 --replication-factor 1 --partitions 1
```

### Create topic with multiple partitions

```
kafka-topics --bootstrap-server kafka0:9092 --create --if-not-exists --topic my-topic-1 --replication-factor 1 --partitions 3
```

## List all topics on kafka server

```
kafka-topics --bootstrap-server kafka0:9092 --list
```

## Modify existing topic partition

```
kafka-topics --bootstrap-server kafka0:9092 --alter --topic <topic-name> --partitions <num_partitions>
```

Example:  

```
kafka-topics --bootstrap-server kafka0:9092 --alter --topic employee-topic --partitions 4
```

## Print topic info

```
kafka-topics --bootstrap-server kafka0:9092 --describe --topic my-topic-1
```


# Git commands

```
git reset --hard HEAD~1
git push --force
```