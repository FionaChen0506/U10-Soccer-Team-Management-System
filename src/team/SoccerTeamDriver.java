package team;

import java.time.LocalDate;
import java.util.List;

/**
 * This is the main driver class to run the Soccer Team Model implementation.
 */
public class SoccerTeamDriver {
  /**
   * This is the main method that initializes the Soccer Team Model implementation and
   * runs various functions on it.
   * @param args the command line arguments passed in as an array of strings.
   */
  public static void main(String[] args) {
    SoccerTeamModelImpl team = new SoccerTeamModelImpl();

    // Adding 20 players to the team
    team.addPlayer("John", "Aaron", LocalDate.of(2015, 1, 1), Position.MIDFIELDER, 2);
    team.addPlayer("Jane", "Doe", LocalDate.of(2018, 2, 2), Position.FORWARD, 5);
    team.addPlayer("Bob", "Smith", LocalDate.of(2017, 3, 3), Position.DEFENDER, 1);
    team.addPlayer("Jack", "Babel", LocalDate.of(2015, 4, 4), Position.GOALIE, 2);
    team.addPlayer("Dave", "Jones", LocalDate.of(2016, 5, 5), Position.MIDFIELDER, 4);
    team.addPlayer("Mary", "Lee", LocalDate.of(2014, 6, 6), Position.FORWARD, 5);
    team.addPlayer("Mike", "Williams", LocalDate.of(2013, 8, 7), Position.DEFENDER, 1);
    team.addPlayer("Sarah", "Finkle", LocalDate.of(2014, 8, 8), Position.MIDFIELDER, 2);
    team.addPlayer("Tom", "Carling", LocalDate.of(2015, 9, 9), Position.FORWARD, 5);
    team.addPlayer("Kate", "Brown", LocalDate.of(2018, 10, 10), Position.GOALIE, 4);
    team.addPlayer("Alex", "Johnson", LocalDate.of(2017, 11, 11), Position.DEFENDER, 3);
    team.addPlayer("Olivia", "Johnson", LocalDate.of(2014, 12, 12), Position.MIDFIELDER, 1);
    team.addPlayer("Chris", "Davis", LocalDate.of(2015, 1, 13), Position.FORWARD, 2);
    team.addPlayer("Lily", "Davis", LocalDate.of(2014, 2, 14), Position.DEFENDER, 4);
    team.addPlayer("Matt", "Miller", LocalDate.of(2015, 3, 15), Position.MIDFIELDER, 3);
    team.addPlayer("Abby", "Camidge", LocalDate.of(2014, 4, 16), Position.GOALIE, 2);
    team.addPlayer("Jason", "Wilson", LocalDate.of(2016, 5, 17), Position.FORWARD, 1);
    team.addPlayer("Lucy", "Wilson", LocalDate.of(2018, 6, 18), Position.DEFENDER, 3);
    team.addPlayer("Sam", "Elson", LocalDate.of(2017, 7, 19), Position.MIDFIELDER, 5);
    team.addPlayer("Grace", "Taylor", LocalDate.of(2013, 8, 20), Position.GOALIE, 4);

    // Creating the team and assigning positions
    try {
      team.createTeam();
    } catch (IllegalArgumentException e) {
      System.out.println("Error creating team: " + e.getMessage());
    }
    System.out.println("Player List:");
    List<Player> players = team.getPlayerList();
    for (Player player : players) {
      System.out.println(player.toString());
    }
    System.out.println();
    System.out.println("Lineup List:");
    List<Player> lineupPlayers = team.getLineupList();
    for (Player player : lineupPlayers) {
      System.out.println(player.toString()
          + " Position: " + player.getFinalPosition());
    }
  }
}
