# Swivel-Code-Challenge

This project includes the swivel code challenge source files.

## Functional and Non Functional Requirements

```
1. Extensibility - separation of concerns.
2. Simplicity - aim for the simplest solution that gets the job done
whilst remaining readable, extensible and testable.
3. Test Coverage - breaking changes should break your tests. We prefer
Unit Test without testing the json file, please mock them.
4. Performance - should gracefully handle a significant increase in
amount of data provided (e.g 10000+ users).
5. Robustness - should handle and report errors. If you have any
questions about this criterion please ask.
6. Use of appropriate design patterns and data structures
7. Proper exception handling
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Before up and run the system on your local machine for development or testing, you need following things,

```
JRE 1.8 or greater
Gradle buildship
Command Line Tool
Internet Connectivity
```

### Installing

Following steps will be helping you to up and run the system on your local machine.

Step 1

Clone the repository

```
git clone "git clone https://github.com/vishvarodrigo/swivel-code-challenge.git"
```

Step 2

Change the directory

```
cd swivel-code-challenge
```

Step 3

Build the source code. (Please make sure you are in the root folder)

```
./gradlew build -x test
```

Once you completed the built process, you can access the jar file inside ./build/libs/*.jar.

## Running the application

Step 1

Change the working directory via terminal (Please make sure you are in the root folder)

```
cd ./build/libs
```

Step 2

Download, extract and copy json-simple-1.1.jar into the build/libs folder

```
http://www.java2s.com/Code/JarDownload/json-simple/json-simple-1.1.jar.zip
```

Step 3

Copy users.json/tickets.json/organizations.json files to build/libs folder


Step 4

Run the application on terminal (Please make sure you are in the libs folder)

```
java -cp swivel-code-challenge.jar:json-simple-1.1.jar com.swivel.codechallenge.Application
```

## Running the tests

Following command will be executing the test cases of the application

```
./gradlew build
```

### And coding style tests

Code styles and quality analyzed with the sonarQube.

## Deployment

Since this is sample application deplpyment steps not required.

## Built With

* [Gradle](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md]() for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](). 

## Authors

* **Vishva Rodrigo** - *Initial work* *Development*

## License

This project is not yet licensed under any organization

## Acknowledgments

* This project was developed to Swivel Group

