# Clojure: Scramble Task

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This project it's a simple backend service that receive two strings and apply the scramble function that check if a of the strings can be rearranged with another

### Libraries

Scramble Task use some open source libraries:

* [Leininger] - A build automation and dependency management tool for Clojure
* [Ring] - A libray for web applications
* [Cheshire] - Json encode/decode
* [Midje] - Great framework to create tests for Clojure

### Install

Scramble Task require Leininger, you can download it here [Leininger](https://leiningen.org/). You will need it to run the project, the installation is super simple, if you are using windows there is an installer here [Leininger Windows Install ](https://djpowell.github.io/leiningen-win-installer/) 

After install Leininger, you can go to your project root path and run the command below, Leining will install all dependecies.

```sh
$ lein deps
```

We are almost ready to run the project. If everything is ok, run the command below to start the service!

```sh
$ lein ring server-headless
```

### Registred Services

There is a lot of tools to connect with the services, but I recommend [Insomnia](https://insomnia.rest/) it's a great Rest client and you will love it. 

| Name | Endpoint |
| ------ | ------ |
| Scramble |[POST] localhost:3000\scramble |

How you can use that services.

```sh
[POST] localhost:3000\scramble
{
	"str1" : "choco", 
	"str2": "cocho"	
}
```

### Tests

Scramble Task was built using TDD(Test Driven Development), all development was guided by the tests, we have units tests and acceptance tests that can be easily executed running with midje.

Running all tests:
```sh
$ lein midje
```
Running only acceptance tests
```sh
$ lein midje :filter acceptance
```
Running only unit tests
```sh
$ lein midje :filter unit
```

### Project Structure

The project was divided as follows:

* [src/scramble_backend/handler.clj] - This is our main file, where all requests are packed and the routes are created.
* [src/scramble_backend/libs/string_library.clj] - This file contains the scramble functions.
* [test/scramble_backend/auxiliary.clj] - File with some help functions for the tests
* [test/scramble_backend/acceptance_test.clj] -  This file realize all acceptence tests
* [test/scramble_backend/unit_test.clj] -  This file realize all unit tests










