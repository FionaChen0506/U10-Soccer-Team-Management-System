package team;

import java.time.LocalDate;
import java.util.List;

/**
 * The SoccerTeamController interface defines the methods of a controller for a soccer team. It
 * provides a way to set a view and to interact with the model by adding players and creating the
 * team. It also provides methods to display the lineup list and the player list.
 */

public interface SoccerTeamController {
  /**
   * Sets the view that the controller is responsible for.
   *
   * @param v the view to be set
   */
  void setView(SoccerTeamView v);

  /**
   * Adds a player to the team with the given parameters.
   *
   * @param firstName         the first name of the player
   * @param lastName          the last name of the player
   * @param dateOfBirth       the date of birth of the player
   * @param preferredPosition the preferred position of the player
   * @param skillLevel        the skill level of the player
   */

  void addPlayer(String firstName, String lastName, LocalDate dateOfBirth,
      Position preferredPosition, int skillLevel);

  /**
   * Creates the team based on the added players.
   */
  void createTeam();

  /**
   * Displays the lineup list.
   */
  void showLineupList();

  /**
   * Displays the player list.
   */
  void showPlayerList();

}
