import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import team.Player;
import team.Position;
import team.SoccerTeamModelImpl;


/**
 * Test cases for the SoccerTeamModelImpl class. Verifying that all methods for creating a soccer
 * team can work.
 */
public class SoccerTeamModelImplTest {
  private final SoccerTeamModelImpl soccerTeam = new SoccerTeamModelImpl();

  /**
   * test createTeam() with invalid number of players.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testCreateTeamWithNotEnoughPlayers() {
    // add 9 players.
    soccerTeam.addPlayer("John", "Aaron", LocalDate.of(2015, 1, 1), Position.MIDFIELDER, 2);
    soccerTeam.addPlayer("Jane", "Doe", LocalDate.of(2018, 2, 2), Position.FORWARD, 5);
    soccerTeam.addPlayer("Bob", "Smith", LocalDate.of(2017, 3, 3), Position.DEFENDER, 1);
    soccerTeam.addPlayer("Jack", "Babel", LocalDate.of(2015, 4, 4), Position.GOALIE, 2);
    soccerTeam.addPlayer("Dave", "Jones", LocalDate.of(2016, 5, 5), Position.MIDFIELDER, 4);
    soccerTeam.addPlayer("Mary", "Lee", LocalDate.of(2014, 6, 6), Position.FORWARD, 5);
    soccerTeam.addPlayer("Mike", "Williams", LocalDate.of(2013, 8, 7), Position.DEFENDER, 1);
    soccerTeam.addPlayer("Sarah", "Finkle", LocalDate.of(2014, 8, 8), Position.MIDFIELDER, 2);
    soccerTeam.addPlayer("Tom", "Carling", LocalDate.of(2015, 9, 9), Position.FORWARD, 5);

    soccerTeam.createTeam();
  }

  /**
   * test addPlayer with player age more than 10 years old.
   */
  @Test
      (expected = IllegalArgumentException.class) public void testAddPlayerWithInvalidAge() {
    soccerTeam.addPlayer("Mike", "Will", LocalDate.of(2013, 4, 1), Position.DEFENDER, 1);
  }

  /**
   * test addPlayer with less than 1 skill level.
   */
  @Test
      (expected = IllegalArgumentException.class)
  public void testAddPlayerWithInvalidSkillLevel1() {
    soccerTeam.addPlayer("Mike", "Will",
        LocalDate.of(2014, 4, 1), Position.DEFENDER, 0);
  }

  /**
   * test addPlayer with more than 5 skill level.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerWithInvalidSkillLevel2() {
    soccerTeam.addPlayer("Mike", "Will",
        LocalDate.of(2014, 4, 1), Position.DEFENDER, 6);
  }

  /**
   * helper method for adding 20 players.
   */
  public void add20PlayersHelper() {
    // add 20 players, 3 of them have skill level of 5.
    soccerTeam.addPlayer("John", "Aaron", LocalDate.of(2015, 1, 1), Position.MIDFIELDER, 2);
    soccerTeam.addPlayer("Jane", "Doe", LocalDate.of(2018, 2, 2), Position.FORWARD, 5);
    soccerTeam.addPlayer("Bob", "Smith", LocalDate.of(2017, 3, 3), Position.DEFENDER, 1);
    soccerTeam.addPlayer("Jack", "Babel", LocalDate.of(2015, 4, 4), Position.GOALIE, 2);
    soccerTeam.addPlayer("Dave", "Jones", LocalDate.of(2016, 5, 5), Position.MIDFIELDER, 4);
    soccerTeam.addPlayer("Mary", "Lee", LocalDate.of(2014, 6, 6), Position.FORWARD, 3);
    soccerTeam.addPlayer("Mike", "Williams", LocalDate.of(2013, 8, 7), Position.DEFENDER, 1);
    soccerTeam.addPlayer("Sarah", "Finkle", LocalDate.of(2014, 8, 8), Position.MIDFIELDER, 2);
    soccerTeam.addPlayer("Tom", "Carling", LocalDate.of(2015, 9, 9), Position.FORWARD, 3);
    soccerTeam.addPlayer("Kate", "Brown", LocalDate.of(2018, 10, 10), Position.GOALIE, 4);
    soccerTeam.addPlayer("Alex", "Johnson", LocalDate.of(2017, 11, 11), Position.DEFENDER, 3);
    soccerTeam.addPlayer("Olivia", "Johnson", LocalDate.of(2014, 12, 12), Position.MIDFIELDER, 1);
    soccerTeam.addPlayer("Chris", "Davis", LocalDate.of(2015, 1, 13), Position.FORWARD, 2);
    soccerTeam.addPlayer("Lily", "Davis", LocalDate.of(2014, 2, 14), Position.DEFENDER, 5);
    soccerTeam.addPlayer("Matt", "Miller", LocalDate.of(2015, 3, 15), Position.MIDFIELDER, 3);
    soccerTeam.addPlayer("Abby", "Camidge", LocalDate.of(2014, 4, 16), Position.GOALIE, 2);
    soccerTeam.addPlayer("Jason", "Wilson", LocalDate.of(2016, 5, 17), Position.FORWARD, 1);
    soccerTeam.addPlayer("Lucy", "Wilson", LocalDate.of(2018, 6, 18), Position.DEFENDER, 3);
    soccerTeam.addPlayer("Sam", "Elson", LocalDate.of(2017, 7, 19), Position.MIDFIELDER, 5);
    soccerTeam.addPlayer("Grace", "Taylor", LocalDate.of(2013, 8, 20), Position.GOALIE, 4);

  }

  /**
   * test when more than 20 players are added. test addPlayer, createTeam(), getTeamSize(),
   * getBenchList().
   */
  @Test public void testCreateTeamWithMoreThan20Players() {
    // add 20 players, there are 3 of them have skill level of 5.
    add20PlayersHelper();
    // add 4 more players after 20, 2 of them have skill level of 5.
    soccerTeam.addPlayer("Harry", "Gwen", LocalDate.of(2014, 4, 20), Position.GOALIE, 5);
    soccerTeam.addPlayer("Grace", "Fendley", LocalDate.of(2014, 8, 20), Position.GOALIE, 5);
    soccerTeam.addPlayer("Kevin", "Brown", LocalDate.of(2015, 5, 5), Position.DEFENDER, 3);
    soccerTeam.addPlayer("Lily", "Smith", LocalDate.of(2015, 6, 6), Position.GOALIE, 2);

    soccerTeam.createTeam();

    // Test that PlayerList only has 20 players
    assertEquals(20, soccerTeam.getTeamSize());

    List<Player> lineupList = soccerTeam.getLineupList();
    // Test that lineupList has 7 players
    assertEquals(7, lineupList.size());

    // Test that all 7 players have been assigned a position
    for (Player player : lineupList) {
      assertNotNull(player.getFinalPosition());
    }

    // test that 3 + 2 players who have skill level of 5 are all in the lineup team.
    int counter = 0;
    for (Player player : lineupList) {
      if (player.getSkillLevel() == 5) {
        counter++;
      }
    }
    assertEquals(5, counter);

    // test that there are 13 people in the bench list.
    List<Player> benchList = soccerTeam.getBenchList();
    assertEquals(13, benchList.size());

  }

  /**
   * test that the playerList is sorted by last name.
   */
  @Test public void testSortPlayersByLastName() {
    add20PlayersHelper();
    soccerTeam.createTeam();

    List<Player> playerList = soccerTeam.getPlayerList();
    List<Player> lineupList = soccerTeam.getLineupList();

    // Check that the list is sorted by last name
    // compare each player's last name with the last name of the next player in the list.
    // If lastName1 is less than lastName2, the method returns a negative integer.
    for (int i = 0; i < playerList.size() - 1; i++) {
      String lastName1 = playerList.get(i).getLastName();
      String lastName2 = playerList.get(i + 1).getLastName();
      assertTrue(lastName1.compareToIgnoreCase(lastName2) <= 0);
    }
  }

  /**
   * test that the lineupList is sorted by position and then last name.
   */
  @Test public void testSortLineupPlayersByPosition() {
    add20PlayersHelper();
    soccerTeam.createTeam();

    List<Player> lineupList = soccerTeam.getLineupList();

    // test that the lineupList is sorted by position
    assertEquals(lineupList.get(0).getFinalPosition(), Position.GOALIE);
    assertEquals(lineupList.get(1).getFinalPosition(), Position.DEFENDER);
    assertEquals(lineupList.get(2).getFinalPosition(), Position.DEFENDER);
    assertEquals(lineupList.get(3).getFinalPosition(), Position.MIDFIELDER);
    assertEquals(lineupList.get(4).getFinalPosition(), Position.MIDFIELDER);
    assertEquals(lineupList.get(5).getFinalPosition(), Position.MIDFIELDER);
    assertEquals(lineupList.get(6).getFinalPosition(), Position.FORWARD);

    // test that the lineupList is sorted by last name when in same position.
    assertEquals(lineupList.get(0).getLastName(), "Brown");
    assertEquals(lineupList.get(1).getLastName(), "Davis");
    assertEquals(lineupList.get(2).getLastName(), "Taylor");
    assertEquals(lineupList.get(3).getLastName(), "Elson");
    assertEquals(lineupList.get(4).getLastName(), "Jones");
    assertEquals(lineupList.get(5).getLastName(), "Lee");
    assertEquals(lineupList.get(6).getLastName(), "Doe");

  }

  /**
   * test that each Jersey number is unique.
   */
  @Test public void testUniqueJerseyNumber() {
    add20PlayersHelper();
    soccerTeam.createTeam();

    List<Player> playerList = soccerTeam.getPlayerList();
    List<Integer> jerseyNumbers = new ArrayList<>();
    // use a counter to count the duplicate jersey number.
    int counter = 0;
    for (Player player : playerList) {
      int number = player.getJerseyNumber();
      if (jerseyNumbers.contains(number)) {
        // a player with this jersey number already exists, we increment the counter.
        counter++;
      } else {
        jerseyNumbers.add(number);
      }
    }
    // counter = 0 means all the jersey numbers are unique.
    assertEquals(0, counter);
  }

  /**
   * test the Jersey number and finalPosition cannot be changed after the team is created.
   */
  @Test
  public void testJerseyAndPositionUnchanged() {
    add20PlayersHelper();
    soccerTeam.createTeam();
    List<Player> playerList = soccerTeam.getPlayerList();

    int preJersey = playerList.get(1).getJerseyNumber();
    // assign the player with the Jersey Number that is impossible in the team.
    playerList.get(1).setJerseyNumber(25);
    int afterJersey = playerList.get(1).getJerseyNumber();
    // the two Jersey numbers should be equal because the change should be unsuccessful.
    assertEquals(preJersey, afterJersey);

    List<Player> lineupList = soccerTeam.getLineupList();
    // the 0th player in the lineupList position should be "Goalie".
    Position prePosition = lineupList.get(0).getFinalPosition();
    lineupList.get(0).setFinalPosition(Position.MIDFIELDER);

    Position afterPosition = lineupList.get(0).getFinalPosition();
    assertEquals(afterPosition, Position.GOALIE);

  }

  /**
   * test removePlayer().
   */
  @Test public void testRemovePlayers() {
    add20PlayersHelper();
    soccerTeam.createTeam();

    List<Player> playerList = soccerTeam.getPlayerList();
    assertEquals(20, soccerTeam.getTeamSize());

    soccerTeam.removePlayer(playerList.get(1));
    assertEquals(19, soccerTeam.getTeamSize());

    List<Player> lineupList = soccerTeam.getLineupList();
    soccerTeam.removePlayer(lineupList.get(1));
    assertEquals(18, soccerTeam.getTeamSize());
    assertEquals(6, lineupList.size());

  }

}

