## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

---------

inside the `src` folder, inside this folder we have some folders called 

- `controller`: which owns the __main__

- `dao`: is the DAO model whose classes are interfaces

- `model`: your classes similar to tables in our database

---------

inside `dao` we have a folder called

- `Implementation`:that implements the DAO model

---------

and in `model` we have

- `util`: which has a class name "connect" which makes the connection to the postgres database


Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
