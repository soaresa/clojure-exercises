# Clojure Exercises

This project contains solutions developed in Clojure for algorithm problems.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
Leiningen must be installed in order to run this application. Check the steps based on your environment at https://leiningen.org/#install

Run the following command to clone the project:
```
git clone https://github.com/soaresa/clojure-exercises.git
```

## About this Project
In other to practice and learn Clojure deeply I will use this project to solve algorithm problems and 4clojure exercises.

## Building Tests
Unit tests were implemented to run with clojure.test framework.

All tests are located at /test folder.

## Running Tests
The project has the plugin lein-test-refresh that automatically refreshes and then runs all clojure.test tests when a file in the project changes. Run the following command in a new terminal window at the project root directory to start it:
```
lein test-refresh
```