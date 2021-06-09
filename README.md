# SNS Lambda Integration Test (Java+Quarkus+GraalVM+AWS Cloud)

**LAST UPDATE:** 06/2021

Follow me: https://www.linkedin.com/in/vitor-cordeiro-921a5697/

---

### 1. Introduction

This project main objective is provide a simple example of SNS and LAMBDA integration using Java Quarkus thecnology.

---

### 2. How it works


TO DO

## 3. Technologies

* Quakus Framework (https://quarkus.io/);
* GraalVM;
* Swagger;
* Java 11 (Amazon Distribution);
* AWS: SNS, Lambda;

## 4. Executing and Deploying

#### 4.1 Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

#### 4.2 Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-google-books-integration-api-1.0.0-SNAPSHOT-runner.jar` file in the `/build` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar build/quarkus-google-books-integration-api-1.0.0-SNAPSHOT-runner.jar`.

#### 4.3 Send to AWS

To deploy the application throw cloudformation, use the script: 
```shell script
./infra/deploy-samcli.sh dev
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/quarkus-google-books-integration-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.


## 5. TO DO:

* Missing some tests.

## 6. References:
* Reference for studies: https://quarkus.io/guides/
