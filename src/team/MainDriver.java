package team;

/**
 * The entry point of the U10 Soccer Team Creator application.
 * Creates instances of the model, view, and controller, and sets the view on the controller.
 */
public class MainDriver {
  /**
   * The main method of the U10 Soccer Team Creator application.
   * Creates instances of the model, view, and controller, and sets the view on the controller.
   *
   * @param args The command line arguments passed to the application.
   */
  public static void main(String[] args) {
    SoccerTeamModel m = new SoccerTeamModelImpl();
    SoccerTeamView v = new SwingSoccerTeamView();
    SoccerTeamController c = new SoccerTeamSwingController(m, v);

    c.setView(v);

  }
}