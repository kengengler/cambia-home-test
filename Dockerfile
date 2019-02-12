# Builds and runs the application. There is one build-arg, INPUT, which selects the input file from the samples
# directory to be run. The value of INPUT should be the name of the file and not the .csv extension (for example,
# "input1")
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jre-alpine
ARG INPUT=input1
WORKDIR /tmp/
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/codingchallenge3-0.1.jar codingchallenge3-0.1.jar
COPY samples/${INPUT}.csv input.csv
RUN java -jar codingchallenge3-0.1.jar
