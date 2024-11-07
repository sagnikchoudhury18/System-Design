# Design Patterns in Java

This repository contains implementations of various **design patterns** in Java, categorized into **Creational**, **Structural**, and **Behavioral** patterns. The project demonstrates the usage, benefits, and applications of each pattern, helping developers understand when and why to use them to solve specific software design challenges.

## Table of Contents
- [Introduction](#introduction)
- [Patterns Implemented](#patterns-implemented)
  - [Creational Patterns](#creational-patterns)
  - [Structural Patterns](#structural-patterns)
  - [Behavioral Patterns](#behavioral-patterns)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction
Design patterns are solutions to common problems in software design. By implementing these patterns, developers can create systems that are more flexible, scalable, and easier to maintain. This project showcases Java implementations of various design patterns, categorized based on their purpose and application.

## Patterns Implemented

### Creational Patterns
Creational design patterns abstract the process of object creation, enabling more flexibility and reusability. Implemented patterns include:

- **Singleton**: Ensures a class has only one instance and provides a global point of access to it.
- **Factory Method**: Defines an interface for creating objects but lets subclasses alter the type of objects that will be created.
- **Abstract Factory**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Builder**: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
- **Prototype**: Creates new objects by copying an existing object, rather than creating from scratch.

### Structural Patterns
Structural patterns deal with the composition of classes or objects, making it easier to structure applications. Implemented patterns include:

- **Adapter**: Allows incompatible interfaces to work together by acting as a bridge.
- **Composite**: Composes objects into tree structures to represent part-whole hierarchies.
- **Decorator**: Adds responsibilities to objects dynamically.
- **Facade**: Provides a simplified interface to a complex subsystem.
- **Flyweight**: Reduces the cost of creating and managing large numbers of similar objects.
- **Proxy**: Provides a surrogate or placeholder for another object to control access to it.

### Behavioral Patterns
Behavioral patterns focus on communication between objects, enhancing flexibility and communication. Implemented patterns include:

- **Chain of Responsibility**: Allows multiple objects to handle a request, with each object in the chain having a chance to process it.
- **Command**: Encapsulates a request as an object, allowing parameterization of clients with queues, requests, and operations.
- **Interpreter**: Defines a representation for a grammar and an interpreter to interpret the sentences.
- **Iterator**: Provides a way to access elements of an aggregate object sequentially without exposing its underlying representation.
- **Mediator**: Defines an object that encapsulates how a set of objects interact.
- **Memento**: Captures and restores an object’s state, enabling undo operations.
- **Observer**: Establishes a subscription mechanism to notify multiple objects about any events happening to the object they observe.
- **State**: Allows an object to alter its behavior when its internal state changes.
- **Strategy**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
- **Template Method**: Defines the skeleton of an algorithm, deferring some steps to subclasses.
- **Visitor**: Adds further operations to objects without having to modify them.


## Project Structure
	
The project is organized into three main packages:

creational: Contains creational design patterns.
structural: Contains structural design patterns.
behavioral: Contains behavioral design patterns.
Each pattern has its own sub-package containing the necessary classes and a main class to demonstrate its usage.


## Contributing

Contributions are welcome! Please create an issue or pull request if you'd like to add more patterns, improve documentation, or enhance existing implementations.


## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
