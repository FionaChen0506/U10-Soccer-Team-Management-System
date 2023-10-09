# Soccer Team Creator Program
## Overview
The program is a soccer team creator application that allows users to create a U10 soccer team, add players to the team, and view the team's list and the lineup list. This program uses the MVC (Model-View-Controller) design pattern and has a graphical user interface (GUI) built using Swing. 

This program allows the user to add many candidates that are under 10 years old to the soccer team. After the user finishes adding the players, the user can create the soccer team by clicking the button. The program checks that the team has between 10 and 20 players; if it has less than 10 players, the team cannot be created successfully. If there are more than 20 players, the program selects the 20 players with the highest skill levels and assigns a unique jersey number (1-20) to each player in the team.

Once the team is created, the program creates a lineup team by selecting the 7 players with the highest skill level and assigning final positions to them based on their skill levels and preferred positions.

Finally, the user can view the team list in alphabetical order and the lineup list in the order of positions and alphabetical order.

## List of features
- Provide a user-friendly graphical interface using Swing.
- Add new players that are under 10 years old to the team.
- Validate player information(first name, last name, date of birth, preferred position, skill level).
- Show how many players the user already added.
- Create a U10 soccer team.
- Show list of all players in the team.
- Show list of the lineup team.
- Show success or error messages to the user.
- Set buttons to be available or unavailable based on the state of the program.
- Contain private methods that support the above features, such as setting the jersey number, creating the lineup team, and assigning the final positions, etc.

## How To Run
### How to run the jar file
Open the finalProject.jar, and the program starts running.
For this jar file, no argument are needed when running the program. 

### How to Use the Program
When running the program, the user will see in the middle of the interface of a short introduction of this program. Then there are four buttons in the window, which are "Add a player", "Create Soccer Team", "Show Player List" and "Show Lineup List". Note that the "Show Player List" and "Show Lineup List" won't be availble until the team is created successfully.

To interacte with the program, the user should first click “Add a player” button, then there will show up a window for the user to input one player’s information. After the information is entered, the user can click “OK” to submit this player’s information, and in the main interface, the user can see if this player is added successfully. If yes, the success message will show, if no, then the specific error message will show. The possible error messages are: the player is older than 10 years old, the player’s first name or last name is empty, the date is invalid, etc. 

During this process, there is a message in the upper side of the panel that keeps updating how many players the user already added. Then, after all the candidates are added to the team, the user can click “Create Soccer Team” button to finally create the team. Similar to above, the interface will show if the team is created successfully by showing the success message or the error message. The possible error message is that the number of added players are less than 10.

If the success message of creating the team show up, then congratulations! The U10 soccer team has been created. So now the user can see that the "Show Player List" and "Show Lineup List"  button is lighted up, meaning that they are available now. Then, user can click either one of the two buttons to see the list that they want. There will be a scroll pane showing the list of the team or the list of the lineup, the user can see the players' name, Jersey number, and final position(in lineup list).

This is how the whole program runs, to exit the program, the user can just click the "close" button at upper left.

## Design/Model Changes

From design model v1 to v2, I made the following changes:
a) I showed the Multiplicities in the v2 version.
b) I added createTeam() method in the Interface.
c) I added some private methods in the SoccerTeamModelImpl, like assignPosition(), assignJersey(), generateJerseyNumber(), isJerseyNumberUsed() and createLineup().
d) I added two fields in the Player class, which are "finalPositionSet" and "jerseyNumberSet" to make sure that the final position and jersey number cannot be changed after the team is created.

After implementing the model, I didn’t add or delete methods after the model is done when implementing the view and controller. There are some small changes to the model though, for example, I changed original getFirstName() and getLastName() methods in “Player” class. I make the first letter of first name or last name always be capital, no matter what user inputs. Also, I added some condition check for the “Player” constructor, I checked that the first name and last name cannot be null and the name must only contain letters. I also move the skill level check from the SoccerTeamModelImpl’s addPlayer() method to the Player class’s constructor.


## Assumptions
I assume that if the user adds two players with exactly the same information(name, date of birth, skill level, preferred position), they are still two players, just with total same information. We don’t consider two players with same information as one person.

I also assume that the players’ name only contains letters. If a player’s name contains some numbers or other symbols, the player cannot be added and there will show an error message about the format of name.

I also assume that, all the players the user want to add are born after 2000, so in the GUI, the year combo box only provides year of birth after 2000.

## Limitations
One limitation is that it cannot reset or restart. In my application, once the soccer team is created, the user cannot add any other players or reset the whole GUI to start creating a new soccer team. The user can only exit the program by closing the window, and then run the program again to create a new team. 

Another limitation is that, in the interface where the user can input the player’s information, I use 3 combo boxes to represent the year, month, and date. However, I didn’t make the date combo box to adjust automatically to the month. For example, when the user choose month of “February”, the date choices are still from “1” to “31”, while a better implementation should be “1” to “28”. But I did do some checks for that, if the user choose “February” and date “31”, I will catch the DateTimeException and show user the error message to suggest the user to re-enter the player’s information again. 

## Citations
1. Java Swing Tutorial - Java Swing BoxLayout. (n.d.). Retrieved April 18, 2023, from http://www.java2s.com/Tutorials/Java/Java_Swing/0540__Java_Swing_BoxLayout.htm 
2. Java swing tutorial - java swing layout managers. (n.d.). Retrieved April 17, 2023, from http://www.java2s.com/Tutorials/Java/Java_Swing/0500__Java_Swing_Layout.htm 
3. Java Swing Tutorial - javatpoint. www.javatpoint.com. (n.d.). Retrieved April 20, 2023, from https://www.javatpoint.com/java-swing 
4. Staff, D. (2022, March 24). How to create dialog boxes in Java. Developer.com. Retrieved April 21, 2023, from https://www.developer.com/java/create-java-dialog-boxes/ 
5. Swing - controls. Tutorials Point. (n.d.). Retrieved April 20, 2023, from https://www.tutorialspoint.com/swing/swing_controls.htm 
6. YouTube. (2020, June 29). Java GUI tutorial - output result on dialog box using joptionpane.showmessagedialog() method. YouTube. Retrieved April 16, 2023, from https://www.youtube.com/watch?v=oQJFeUBOljM 
