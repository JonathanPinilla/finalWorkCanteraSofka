# finalWorkCanteraSofka
This is the repository for the final work for "Cantera nivel 2" Sofka University

The application was divided in three main elements:
  - First the users manage with noSQL using MonogDB atlas, which will automatically connect via NodeJs
  - Seccond the Spring with java Back end which is the one that manage the game itself and storages it's information in a MySQL DB locally, it should be configured
  in url localhost:3306 with root user and password 1234567890 otherwise this data could be updated in the application.properties in the spring project: 
  https://github.com/JonathanPinilla/finalWorkCanteraSofka/blob/master/bingo_game_springBack/src/main/resources/application.properties
  - Finally the Front End where maded with the help of AngularJS Framework, which is the one that make the requests to either NodeJs and SpringBoot
  
To run the project first is mandatory to create the local DB MySQL in the url mentioned early, or update the credentials and url, then open the three projects in the IDE or
code editor of your preference and follow the following instructions: 
  - Run the NodeJs back end with with terminal and using the command "npm start" without the quotation marks (to run this command you should be located in: 
  https://github.com/JonathanPinilla/finalWorkCanteraSofka/tree/master/bingo_users_NodeJsback/bingo_users_node) this application will run by default at localhost:3000
  - Run the SpringBoot application with right click on the BingoGameApplication.java
  (https://github.com/JonathanPinilla/finalWorkCanteraSofka/blob/master/bingo_game_springBack/src/main/java/com/sofka/bingo_game/BingoGameApplication.java) this will be 
  launched at localhost:8080
  - In the third place run the FrontEnd application using the command "ng serve -o" in the terminal and it will automatically launch your default browser at localhost:4200
  
Notice that you will have to install previuslly the java version 18 jdk, nodejs, npm and angular in the machine in order to everything to work as it should.

Finally thank you for reviewing this application

And last but not least I wish to give Sofka, Sofka University and the coaches, spetially Julian Lasso <julian.lasso@sofka.com.co> for their teachings and guidance in this
journey across the "Cantera" lvl one and two.

@author Jonathan Daniel Pinilla Forero
