# Comic Management Desktop Client

Comic management cliente (Desktop version) made with Java Swing. This project was a final school project to create a desktop app that communicates with a backend,
(Springboot in this case) to perform basic CRUD operations and being able to generate few simple reports created with JasperReports.
I personally love Java Swing even though it's outdated so i decided to modify few stuffs in this old school project and also create this Readme file to practice
the Markdown language a bit.

## Entities

- Comic (Each comic must belong to a collection)
- Collection (Each collection can have 0 or N comics)

## Tools needed to set it up
By installing XAMPP, we basically have the necessary tools to get it running. You can choose to use other tools that can replicate the
same functionality.

- XAMPP : [Download it from here](https://www.apachefriends.org/download.html)
  - MYSQL (To manage the database)
  - Filezilla (To manage the FTP server used to upload the images of each comic o collection)
  - Apache (to simulate a web server that will be used to retrieve the stored images)
 
- Desktop Client :

  ![Captura](https://user-images.githubusercontent.com/90214727/212780225-1e88385d-c0ff-4452-b84f-06a4b4753cc3.PNG)


  It can be found in the release section.
  The Client jar file (ComicManagement.jar) must be in a Folder with the Reports folder(where the reports for each language can be found), app.properties 
  file to configure user values but a shortcut can be
  created for the jar file.
  ![structure](https://user-images.githubusercontent.com/90214727/212724442-3b5410e0-87b4-4ff6-a274-4152550b1498.PNG)   
  The app.properties values can be configured for the app (Connection > Configure connection values) o directly editing the file.

- Backend

   A very simple Springboot backend is used to serve the client, the project can be downloaded here : 
   [comic_management_server.zip](https://github.com/daumienebi/cm_client_pc/files/10427656/comic_management_server.zip).  
  After getting the project you only need to configure the application.properties file in the **Springboot project** to fill in your database values and
  any necessary values like this then run the project :
  
  ![Captura](https://user-images.githubusercontent.com/90214727/212725897-d78e41c7-07d5-43af-9c21-086057c927a1.PNG)   
  Api Endpoints :
  - /comics
  - /collections
  - Example : http://192.168.56.102:8081/comics/ or http://localhost:8081/comics/
  
  Make your you have the MYSQL database running in XAMPP(from the panel) or any other way you wish to run it.
  The database script to create the database tables can be found here : [comicdb_createTables.txt](https://github.com/daumienebi/cm_client_pc/files/10427696/comicdb_createTables.txt)
  
  The server can be on a virtual machine with XAMPP running on it or both the client and server running on the same machine. The only tricky aspect is creating the "image server" to store the images using Apache(Already integrated in XAMPP) to simulate a web server that we use to obtain the images.
  The full configuration can be found in this file : [Como configurar la aplicacion.pdf (Spanish)](https://github.com/daumienebi/cm_client_pc/files/10427798/Como.configurar.la.aplicacion.pdf)
  
  TODO : Create a file on how to configure the app in English.
  
 ## Modification
 
   If by any chance anyone decides to clone this project for modification or any other use, you are free to do absolutely whatever you want with it,
   Goodluck ! 😶 
   
   Tip : change the debug_mode value to "true" in the Configuration.java file (src/es/daumienebi/comicmanagement/utils/Configuration.java) if you are modifying the project to avoid waitng for the Loading screen everytime you complie the project
   then set it back to "false" before generating the jar file to view the shitty loading screen later on.
   
   ![Captura](https://user-images.githubusercontent.com/90214727/212779303-5c848f69-b61a-4f9d-89b7-6994a1e1fb21.PNG)
 
 ## Todo :
 
   - File on how to configure the project in English too.
