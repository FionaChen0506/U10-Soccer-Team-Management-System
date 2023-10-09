package team;

import java.time.LocalDate;
import java.util.List;

/**
 * The SoccerTeamModel interface represents the Model component of the Model-View-Controller design
 * pattern for a soccer team.
 */
public interface SoccerTeamModel {
  /**
   * adds the player to the team.
   *
   * @param firstName         the first name of the player.
   * @param lastName          the last name of the player.
   * @param dateOfBirth       the date of birth of the player, the player should be under 10 years
   *                          old.
   * @param preferredPosition the preferred position of the player.
   * @param skillLevel        the skill level of the player.
   * @throws IllegalArgumentException if the player is older than 10 years or if the skill level is
   *                                  not from 1 to 5.
   */
  void addPlayer(String firstName, String lastName, LocalDate dateOfBirth,
      Position preferredPosition, int skillLevel) throws IllegalArgumentException;

  /**
   * creates the soccer team with the added players.
   *
   * @throws IllegalArgumentException if the team is less than 10 players.
   */
  void createTeam() throws IllegalArgumentException;

  /**
   * remove the player from the player list (and lineup list).
   *
   * @param player one player in the team.
   */
  void removePlayer(Player player);

  /**
   * returns the player list in alphabetically order of the last names.
   *
   * @return the player list.
   */
  List<Player> getPlayerList();

  /**
   * returns the team size of the soccer team.
   *
   * @return the integer team size of the soccer team.
   */
  int getTeamSize();

  /**
   * returns the lineup list in the same order of the positions, also in alphabetically order of the
   * last names.
   *
   * @return the lineup list.
   */
  List<Player> getLineupList();

  /**
   * returns the bench list of the team, which is all the players besides the lineup list.
   *
   * @return the bench list of the team.
   */
  List<Player> getBenchList();
}
