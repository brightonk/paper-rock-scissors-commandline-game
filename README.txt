Paper Rock Scissors Game

Overview
    This is a project to illustrate a well designed solution for a paper rock scissors game. The classes are separated based on their responsibilities i.e. the domain model, to the services, command line parsers, launcher and game's main loop. Suppose the system grows into a bigger project, then the packages can be split into component based sub modules that will follow separate sprint cycles, separate testing and integration.
	A test driven development approach was used. Unit tests were created first followed by the implementation of the logic.
	The code was scanned using sonarqube for any known quality or security issues.
	Java 8 was used to build and compile. Third party libraries were kept at a minimum.
	
    The system runs as a standalone console application. On start up the user is asked to choose the number of games he/she would like to play in the current round. A result is displayed at the end of each game. At the end of the round an overal outcome is displayed as won or lost.
	
Starting the System

    The system comes precompiled. You are welcome to open the open the project in your favourite browser and compile. It is a maven based project.
    
	1. To start game open the project folder, double click the start-game.sh or start-game.cmd file. If you changed the jar location remember to update the start scripts.
	
To Play the Game
	
	Follow the on-screen instructions to play against the computer
