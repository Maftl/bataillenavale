Procédure
=========

Windows
-------

* sauvegarde projet

* Dans NetBeans, sur le pom clic droit, clean compile

* Copier l'adresse du jar, aller en console, executer :
java

* compilation
java -jar adreseDuJar

Mac
---

* maven test
mvn test

* efface le répertoire cible
mvn clean

* maven compilation en jar
mvn compile
mvn compile jar:jar

* execution du fichier jar
java -jar /Users/mariealine/Code/ACPI/bataille_navale_mazardo/target/bataillenavale-1.0-SNAPSHOT.jar
