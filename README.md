PersonalRestAPI is a Spring Boot REST API for learning purpose. Have the capabilities to run both on embedded tomcat and on external tomcat.

Dependencies: Maven will takecare of all the JAR/Library dependecies but you need to install MySQL DB for database. You can also change the configuration DB for other external or in memeory DB.

After installation of MySQL DB you need to have Person table on your DB.

Here is the create query: 
CREATE TABLE Person (PersonId varchar(255), FirstName varchar(255), MiddleName varchar(255), LastName varchar(255), Age int, Gender varchar(255));

Run this maven command to create a jar artifact <b> mvn clean package -Pjar </b>
Run this maven command to create a war artifact <b> mvn clean package -Pwar </b>

To run the jar file navigate to the targat folder in command prompt then run this command <b> java - jar PersonalInformationRestAPI-0.0.1-SNAPSHOT.jar </b>
Hit this URL <b> http://localhost:8080/welcomemessage </b>after the successful start of embbeded tomcat. You everything goes well you will get this message <b> Welcome to Personal Information Portal </b>

To run the war file, deploye it on the external tomcat.
Hit this URL <b> http://localhost:8080/<applicationcontext>/welcomemessage </b>after the successful start of embbeded tomcat. You everything goes well you will get this message <b> Welcome to Personal Information Portal </b>
Here applicationcontext is PersonalInformationRestAPI-0.0.1-SNAPSHOT

war: Web Application Archive     
jar: Java Archive

Steps to test the war file
1. To test PersonalInformationRestAPI-0.0.1-SNAPSHOT.war file deploy the war file on external Tomcat (I used Tomcat Version 11)
2. My ClientApplication will give you a war. Deploy the war on tomcat. Before doing the build read the readme file on ClientApplication repository.
3. Hit the URL, You will have a page tab to create record and other tab to view the record.
4. Any issue you can message me. 

Docker Deployment Instruction. (Prerequiste you need to have docker installed in your machine)
1. If you have a single docker file then use this command
	docker build -t <tag name> .	( for example: docker build -t dockerrestapi . )
		
2. If you have multiple docker file then use 		
	docker build -f <file name> -t <tag name> .		( for example: docker build -f Dockerfile_jar -t dockerrestapi . )
		
3. To run you application on docker use this command
	i. docker run --add-host=<host name> : <IP Address of host PC> -d -p <containers port:host port> <docker image name>
		for example: docker run --add-host=Satya:170.30.148.1 -d -p 8080:8080 dockerrestapi
		
	ii. docker run --add-host=<host name> : <IP Address of host PC> -d -p <containers port:host port> --name <name of the docker container> <docker image name>
		for example: docker run --add-host=Satya:172.26.160.1 -d -p 8080:8080 --name restapiwar dockerrestapiwar
		
4. Now you can check the application on your browser for this particular application the URL is
	i. http://localhost:8080/welcomemessage (for jar deployed application)
	ii. http://localhost:8080/PersonalInformationRestAPI-0.0.1-SNAPSHOT/welcomemessage (for war deployed application)


5. Table Creation

	CREATE TABLE Person (
		PersonID varchar(255),
		FirstName varchar(255),
		MiddleName varchar(255),
		LastName varchar(255),
		Age int,
		Gender varchar(255),
		PRIMARY KEY (PersonID),
	);

	ALTER TABLE Person ADD PRIMARY KEY (PersonID);   

	ALTER TABLE Person MODIFY FirstName varchar(255) NOT NULL;  
	ALTER TABLE Person MODIFY LastName varchar(255) NOT NULL;  
	ALTER TABLE Person MODIFY Gender varchar(255) NOT NULL;  
	ALTER TABLE Person MODIFY Age int NOT NULL;  


	CREATE TABLE Address (
		AddressId varchar(255),
		PersonId Varchar(255) NOT NULL,
		AddressLine1 varchar(255) NOT NULL,
		AddressLine2 varchar(255),
		PinZipcode varchar(255) NOT NULL,
		Country varchar(255) NOT NULL,
		City varchar(255) NOT NULL, 
		DistrictCounty varchar(255) NOT NULL,
		AddressType varchar(255) NOT NULL,
		PRIMARY KEY (AddressId),
		CONSTRAINT FK_PersonTab FOREIGN KEY (PersonId)
		REFERENCES Person(PersonId)
	);
