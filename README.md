# ABC-analysis

## Description
Web application that provides ABC-analysis of company’s product range by three parameters: quantity of sales, revenue and margin rate. Application automatically creates work recommendations for each product in accordance of its category.

## Tools and technologies used in project
- Java 11
- Spring Boot 2.7.0
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL
- HTML
- Thymeleaf
- Gradle

## Tools needed for launching project
- Open Server or another server
- Java 11 or higher
- Gradle 7.5
- PostgreSQL

## Instruction for launching project
- download project from GitHub
- open project folder by IntelliJ IDEA
- launch Open Server
- execute statement in file model-module/src/main/resources/static/ddl.sql
- execute statement in file model-module/src/main/resources/static/test-data.sql
- run model-module/src/main/java/ru/gb/modelmodule/ModelModuleApplication.java
- run src/main/java/ru/gb/analysis/AnalysisApplication.java
- open internet browser and enter url http://localhost:8080/abc

## Описание
Веб-приложение для автоматического проведения ABC-анализа ассортимента компании по трем факторам: продажи в единицах, товарооборот в рублях и уровень торговой наценки. Приложение автоматически формирует рекомендации для дальнейшей работы по каждому товару в зависимости от присвоенной ему категории.

## Инструменты и технологии, использованные при создании проекта
- Java 11
- Spring Boot 2.7.0
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL
- HTML
- Thymeleaf
- Gradle

## Инструменты, необходимые для запуска проекта
- Open Server или другой сервер
- Java 11 или выше
- Gradle 7.5
- PostgreSQL

## Инструкция по запуску проекта
- скачать архив проекта с GitHub
- распаковать архив
- открыть папку проекта в IntelliJ IDEA
- запустить сервер
- выполнить в базе данных запрос из файла model-module/src/main/resources/static/ddl.sql
- выполнить в базе данных запросы из файла model-module/src/main/resources/static/test-data.sql
- запустить файл model-module/src/main/java/ru/gb/modelmodule/ModelModuleApplication.java
- запустить файл src/main/java/ru/gb/analysis/AnalysisApplication.java
- открыть интернет-браузер и ввести строку http://localhost:8080/abc
