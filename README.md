CommentWidget
=============

Comment Widget lets you see previous comments and allows you to add a comment yourself


Table of content
----------------

- [Components](#components)
    - [data](#data)
    - [service](#service)
    - [web](#web)
    - [sql] (#sql)
- [Installation](#installation)
    - [Requirements](#requirements)
        - [Java JDK](#java-jdk)
        - [Maven](#maven)
        - [Database](#database)
        - [IDE] (#ide)
- [Running WEB application](#running-web-application)
- [Running REST application](#running-rest-application)
- [Liquibase](#liquibase)
- [Issue Tracking & GIT Rules](#issue-tracking--git-rules)
    - [Labels](#labels)
    - [Code push to Github](#code-push-to-github)
- [Working on Issuses](#working-on-issues)
    - [Naming Rules](#naming-rules)


Components
----------

#### data

Data layer has data access objects, model objects and repositories.

#### service

Service layer - business logic. This module consists of service methods used by the web app to obtain, update and save and the data.

#### web

Web application. Controllers use businesses to create and display comments.

#### sql

SQL queries for creating the database and tables.

Installation
------------

This section outlines requirements and environment setup to run CommentWidget on a local machine.


###Requirements

The requirements below are optimal for the proper setup

####Java JDK

Version: Java 7uX

Setting up JAVA_HOME variable is required


####Maven
Version: 3+

Setting up M2_HOME environment variable is required


####Database

PostgreSQL is used, but it would work with almost any database out there

A database schema named **public**

####IDE

Any IDE works fine as this is a maven project.

###Running WEB application

Following mvn commands should be triggered from the command line or IDE.

 - Installation  run a **mvn clean install** command from the root of the project

 - Run the web application on Tomcat the following Maven command should be executed: **mvn tomcat:run** from context root

 - Health page is available on the following URL   [http://localhost:8080/commentWidget/health](http://localhost:8080/commentWidget/health)




