package team;

/**
 * This interface defines the contract for the view of the Soccer Team Creator application. The view
 * is responsible for displaying the user interface and handling user interactions. The controller
 * communicates with the view via this interface to update the display and handle user input.
 */
public interface SoccerTeamView {
  /**
   * Sets the controller for this view.
   *
   * @param controller the controller to be set for this view
   */
  void setController(SoccerTeamController controller);

  /**
   * Displays the main view of the application. This method sets up the main window with the
   * appropriate UI elements, including the player list text area, the player list text pane, all
   * the buttons, and the warning and success message panels.
   */

  void showMainView();

  /**
   * Shows the player list in the view. This method displays the player text pane in the main
   * window, depending on which UI element is currently selected.
   * @param playerListText the text to be displayed in the player list
   */

  void displayPlayerList(String playerListText);

  /**
   * Shows the lineup list in the view. This method displays the lineup list text pane.
   *
   * @param lineupListText the text to be displayed in the lineup list
   */
  void showLineupList(String lineupListText);

  /**
   * Shows the current size of the player list in the view. This method displays the current size of
   * the player list in the size label.
   *
   * @param size the current size of the player list
   */

  void showCurrentSize(int size);

  /**
   * Shows a success message in the view.
   *
   * @param message the success message to be displayed
   */
  void showSuccessMessage(String message);

  /**
   * Shows an error message in the view.
   *
   * @param message the error message to be displayed
   */
  void showErrorMessage(String message);

  /**
   * Clears the previous message in the view.
   */
  void clearPreviousMessage();

  /**
   * Sets the two show results button to be available in the view.
   */
  void setShowResultsButton();

  /**
   * Sets the createTeam and addPlayer button to be unavailable in the view.
   */
  void setCreateAndAddButtonUnavailable();

}
