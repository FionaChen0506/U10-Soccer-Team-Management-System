package team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The SoccerTeamModelImpl class is an implementation of the SoccerTeamModel interface. It provides
 * methods to add players to the team, set up the team lineup, and retrieve player information.
 * It also includes constants for the minimum and maximum team sizes.
 */
public class SoccerTeamModelImpl implements SoccerTeamModel {
  private static final int MIN_SIZE = 10;
  private static final int MAX_SIZE = 20;
  private List<Player> playerList;
  private List<Player> lineupList;

  /**
   * This is the constructor for the soccer team model.
   */
  public SoccerTeamModelImpl() {
    this.playerList = new ArrayList<>();
    this.lineupList = new ArrayList<>();

  }

  @Override public void createTeam()  {
    if (playerList.size() < MIN_SIZE) {
      throw new IllegalArgumentException(
          "The team cannot be created unless more players are added.");
    }
    if (playerList.size() > MAX_SIZE) {
      //let the player list keep the first 20 players with higher skill level.
      this.playerList.sort(Comparator.comparing(Player::getSkillLevel).reversed());
      this.playerList = playerList.subList(0, MAX_SIZE);
    }
    // assign Jersey number for each member in the player list.
    for (Player player : playerList) {
      assignJersey(player);
    }

    createLineup();
  }

  /**
   * creates the lineup team choosing the 7 players in the playerList with highest skill level.
   */
  private void createLineup() {
    List<Player> copyPlayerList = new ArrayList<>(this.playerList);
    // creates a comparator that compares the players based on their skillLevel in reverse order
    // So Comparator sorts the players by skillLevel in descending order.
    copyPlayerList.sort(Comparator.comparing(Player::getSkillLevel).reversed());
    // choose the first 7 players from the sorted list.
    this.lineupList = copyPlayerList.subList(0, 7);
    assignPosition(this.lineupList);
  }

  @Override public void addPlayer(String firstName, String lastName, LocalDate dateOfBirth,
      Position preferredPosition, int skillLevel) throws IllegalArgumentException {
    // LocalDate.now().minusYears(10) is a date exactly 10 years ago.
    if (LocalDate.now().minusYears(10).isAfter(dateOfBirth)) {
      throw new IllegalArgumentException("The player must be under ten years old.");
    }
    // create the player and add him/her to the playerList
    Player player = new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
    this.playerList.add(player);

  }
  /**
   * assign the position for each player in the lineup list.
   * @param lineupList current lineup list of the team.
   */

  private void assignPosition(List<Player> lineupList) {
    List<Position> positionList = new ArrayList<>(
        //convert an array into a fixed-size list
        Arrays.asList(Position.GOALIE, Position.DEFENDER, Position.DEFENDER, Position.MIDFIELDER,
            Position.MIDFIELDER, Position.MIDFIELDER, Position.FORWARD));

    for (Player player : this.lineupList) {
      Position preferredPosition = player.getPreferredPosition();
      if (positionList.contains(preferredPosition)) {
        player.setFinalPosition(preferredPosition);
        // Removes the first occurrence of the specified element from the list, if it is present.
        positionList.remove(preferredPosition);
      }
    }
    for (Player player : this.lineupList) {
      if (player.getFinalPosition() == null) {
        //Position firstPosition = positionList.get(0);
        // set the first position in the remaining positionList to the remaining players.
        player.setFinalPosition(positionList.get(0));
        positionList.remove(0);
      }
    }
  }

  /**
   * assign the Jersey number for the player.
   * @param player one player in the team
   */
  private void assignJersey(Player player) {
    int jerseyNumber = generateJerseyNumber();
    player.setJerseyNumber(jerseyNumber);
  }

  /**
   * generate an unique random Jersey number.
   * @return a unique and random generated Jersey number.
   */
  private int generateJerseyNumber() {
    int jerseyNumber;
    //Random random = new Random();
    Random random = new Random();
    do {
      jerseyNumber = random.nextInt(MAX_SIZE) + 1;
    } while (isJerseyNumberUsed(jerseyNumber));
    return jerseyNumber;
  }

  /**
   * checks if the Jersey number is already used in the players.
   * @param jerseyNumber the Jersey number of a player.
   * @return a boolean indicating if the Jersey number is used.
   */
  private boolean isJerseyNumberUsed(int jerseyNumber) {
    // iterate over the player list, to see if the jersey number is used by a player in the list.
    for (Player player : this.playerList) {
      if (player.getJerseyNumber() == jerseyNumber) {
        return true;
      }
    }
    return false;
  }

  @Override public void removePlayer(Player player) {
    this.playerList.remove(player);
    // if the player is not in the lineupList, the remove() will simply return false
    this.lineupList.remove(player);
  }

  @Override public List<Player> getPlayerList() {
    // Player::getLastName is a method reference that refers to the getLastName() method.
    this.playerList.sort(Comparator.comparing(Player::getLastName));
    return this.playerList;
  }

  @Override public int getTeamSize() {
    return this.playerList.size();
  }

  @Override public List<Player> getLineupList() {
    // use a Comparator that compares players based on their position in the enum.
    // create a Map that maps each position to its corresponding index in the enum, and then
    // using this map to compare the positions of two players.
    Map<Position, Integer> positionMap = new EnumMap<>(Position.class);
    positionMap.put(Position.GOALIE, 0);
    positionMap.put(Position.DEFENDER, 1);
    positionMap.put(Position.MIDFIELDER, 2);
    positionMap.put(Position.FORWARD, 3);

    Comparator<Player> positionComparator = Comparator.comparing(
        player -> positionMap.get(player.getFinalPosition()));

    this.lineupList.sort(positionComparator.thenComparing(Player::getLastName));
    return this.lineupList;

  }

  @Override public List<Player> getBenchList() {
    List<Player> benchList = new ArrayList<>();
    for (Player player : playerList) {
      if (!lineupList.contains(player)) {
        benchList.add(player);
      }
    }
    return benchList;
  }
}
