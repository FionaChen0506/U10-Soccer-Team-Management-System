package team;

import java.time.LocalDate;
import java.util.List;
/**
 * This class is the controller that manages the interactions between the model and view of
 * the Soccer Team Creator program. It implements the SoccerTeamController interface.
 */

public class SoccerTeamSwingController implements SoccerTeamController {
  private SoccerTeamModel model;
  private SoccerTeamView view;

  /**
   * Constructs a new SoccerTeamSwingController object with the specified model and view components.
   * @param soccerTeamModel the model component for this controller
   * @param soccerTeamView the view component for this controller
   */
  public SoccerTeamSwingController(SoccerTeamModel soccerTeamModel, SoccerTeamView soccerTeamView) {
    this.model = soccerTeamModel;
    this.view = soccerTeamView;
  }

  @Override public void setView(SoccerTeamView v) {
    v.setController(this);
  }

  @Override public void addPlayer(String firstName, String lastName, LocalDate dateOfBirth,
      Position preferredPosition, int skillLevel) {
    view.clearPreviousMessage();
    try {
      model.addPlayer(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      view.showSuccessMessage("One player added successfully!");
      int size = model.getTeamSize();
      view.showCurrentSize(size);
    } catch (IllegalArgumentException e) {
      view.showErrorMessage(e.getMessage());
    }

  }

  @Override public void createTeam() {
    view.clearPreviousMessage();
    try {
      model.createTeam();
      view.showSuccessMessage("The soccer team is created successfully!");
      view.setCreateAndAddButtonUnavailable();
      view.setShowResultsButton();
    } catch (IllegalArgumentException e) {
      //if (e.getMessage().equals("The team cannot be created unless more players are added.")) {
      //view.showErrorMessage("Not enough players to create a team.");
      //}else {
      view.showErrorMessage(e.getMessage());
      //}
    }

  }

  //  convert the List<Player> objects to string representations,
  @Override public void showPlayerList() {
    List<Player> playerList = model.getPlayerList();
    String playerListText = "";
    for (Player player : playerList) {
      playerListText += player.toString() + "\n";
    }
    view.displayPlayerList(playerListText);
  }

  @Override public void showLineupList() {
    List<Player> lineupList = model.getLineupList();
    String lineupListText = "";
    for (Player player : lineupList) {
      lineupListText += player.toString() + " Position: " + player.getFinalPosition() + "\n";
    }
    view.showLineupList(lineupListText);
  }

}
