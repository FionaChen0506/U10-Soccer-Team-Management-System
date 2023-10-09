package team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.stream.IntStream;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * This class implements the SoccerTeamView interface to create a graphical user interface using
 * Swing for displaying and interacting with the soccer team creator. It contains various Swing
 * components such as buttons, text fields, labels, and panels to enable the user to interact with
 * the application.
 */
public class SwingSoccerTeamView implements SoccerTeamView {
  private SoccerTeamController controller;
  private JPanel mainPanel;
  private JButton addPlayerButton;
  private JButton createTeamButton;
  private JButton showPlayerListButton;
  private JButton showLineupButton;
  private JTextPane listTextPane;
  private final JLabel warning = new JLabel();
  private final JLabel successMessage = new JLabel();
  private final JLabel sizeLabel = new JLabel();
  private JFrame frame;

  public SwingSoccerTeamView() {
    showMainView();
  }

  // add the controller to the view
  @Override public void setController(SoccerTeamController controller) {
    this.controller = controller;
  }

  //the frame instance variable will be used consistently throughout view class for
  // managing the main window of GUI application.
  @Override public void showMainView() {
    frame = new JFrame("Soccer Team Creator");
    frame.setPreferredSize(new Dimension(500, 450));
    frame.setLocation(450, 200);
    // Set the default close operation to exit the application when the window is closed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create player list text pane
    listTextPane = new JTextPane();
    listTextPane.setEditable(false);
    listTextPane.setText("Welcome to the U10 Soccer Team Creator!\n"
        + "Please add players to create the soccer team.\n"
        + "Your selected player list will be displayed in this area.\n"
        + "Note that you can't add players after the team is created.\n"
        + "Good luck, and have fun creating your U10 soccer team!");
    listTextPane.setFont(new Font("Geneva", Font.PLAIN, 16));

    // Set the line spacing and alignment
    StyledDocument doc = listTextPane.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    StyleConstants.setLineSpacing(center, 0.5f);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);

    // Wrap the text pane in a scroll pane and set its viewport view to the text pane
    JScrollPane scrollPane = new JScrollPane(listTextPane);
    JViewport viewport = scrollPane.getViewport();
    viewport.setOpaque(false);

    scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    // set all the buttons.
    setupButtons();

    JPanel showButtonPanel = new JPanel();
    showButtonPanel.setLayout(new BoxLayout(showButtonPanel, BoxLayout.X_AXIS));
    showButtonPanel.add(showPlayerListButton);
    showButtonPanel.add(Box.createHorizontalGlue());
    showButtonPanel.add(showLineupButton);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.add(addPlayerButton);
    buttonPanel.add(createTeamButton);

    JPanel messagePanel = new JPanel();
    messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
    messagePanel.add(warning);
    messagePanel.add(successMessage);

    //arrange the warning and successMessage components vertically and center them horizontally.
    successMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
    successMessage.setFont(new Font("Geneva", Font.PLAIN, 14));
    successMessage.setForeground(Color.blue);
    warning.setAlignmentX(Component.CENTER_ALIGNMENT);
    warning.setForeground(Color.red);
    warning.setFont(new Font("Geneva", Font.PLAIN, 14));

    sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    sizeLabel.setText("Current players added: 0");
    JPanel sizePanel = new JPanel();
    sizePanel.setLayout(new FlowLayout());
    sizePanel.add(sizeLabel);

    JPanel upperPanel = new JPanel();
    upperPanel.setLayout(new BorderLayout());
    upperPanel.add(sizePanel, BorderLayout.NORTH);
    upperPanel.add(buttonPanel, BorderLayout.CENTER);
    upperPanel.add(messagePanel, BorderLayout.SOUTH);

    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // Add panels to the mainPanel in the desired order
    mainPanel.add(upperPanel, BorderLayout.NORTH);
    mainPanel.add(scrollPane, BorderLayout.CENTER);
    mainPanel.add(showButtonPanel, BorderLayout.SOUTH);

    // Add the mainPanel to the frame
    frame.setContentPane(mainPanel);

    // Pack and set the size of the frame
    frame.pack();

    // Make the frame visible on the screen
    frame.setVisible(true);
  }

  /**
   * Sets up the buttons in the view. This method initializes the add player button, create team
   * button, show player list button, and show lineup button with their respective labels and font
   * styles. The show lineup and show player list buttons are disabled until the team is created.
   */

  private void setupButtons() {
    addPlayerButton = new JButton("Add A Player");
    createTeamButton = new JButton("Create Soccer Team");
    showPlayerListButton = new JButton("Show Player List");
    showLineupButton = new JButton("Show Lineup List");

    addPlayerButton.setFont(new Font("Arial", Font.BOLD, 16));
    createTeamButton.setFont(new Font("Arial", Font.BOLD, 16));
    showPlayerListButton.setFont(new Font("Arial", Font.BOLD, 16));
    showLineupButton.setFont(new Font("Arial", Font.BOLD, 16));

    // the 2 buttons should not be available until the team is created
    showLineupButton.setEnabled(false);
    showPlayerListButton.setEnabled(false);

    // Add action listener to the "Add Player" button
    addPlayerButton.addActionListener(e -> {
      handleAddPlayerButtonClick(); // Call the specific method to handle the button click
    });

    createTeamButton.addActionListener(e -> {
      // Invoke controller method to create team
      controller.createTeam();

    });

    showPlayerListButton.addActionListener(e -> {
      // Invoke controller method to show player list
      controller.showPlayerList();
    });

    showLineupButton.addActionListener(e -> {
      // Invoke controller method to show lineup list
      controller.showLineupList();
    });
  }

  /**
   * Handles the button click event for adding a player to the soccer team. It creates a custom
   * dialog box with input fields to enter the player's information. Once the user enters the
   * information and clicks the OK button, the method retrieves the values from the input fields and
   * passes them to the corresponding method in the controller to add the player to the team.
   */
  // Method to handle "Add Player" button click
  private void handleAddPlayerButtonClick() {
    // Create the custom dialog box
    JPanel inputPanel = new JPanel(new GridLayout(0, 2));

    //Image img = ImageIO.read(getClass().getResource("/res/icon.png"));
    JTextField firstNameField = new JTextField();
    inputPanel.add(new JLabel("First Name:"));
    inputPanel.add(firstNameField);

    JTextField lastNameField = new JTextField();
    inputPanel.add(new JLabel("Last Name:"));
    inputPanel.add(lastNameField);

    // Create combo boxes for year, month, and day
    Integer[] years = IntStream.range(2000, LocalDate.now().getYear() + 1).boxed()
        .toArray(Integer[]::new);
    JComboBox<Integer> yearComboBox = new JComboBox<>(years);
    inputPanel.add(new JLabel("Year of Birth:"));
    inputPanel.add(yearComboBox);

    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December" };
    JComboBox<String> monthComboBox = new JComboBox<>(months);
    inputPanel.add(new JLabel("Month of Birth:"));
    inputPanel.add(monthComboBox);

    Integer[] days = IntStream.rangeClosed(1, 31).boxed().toArray(Integer[]::new);
    JComboBox<Integer> dayComboBox = new JComboBox<>(days);
    inputPanel.add(new JLabel("Day of Birth:"));
    inputPanel.add(dayComboBox);

    JComboBox<Position> positionComboBox = new JComboBox<>(Position.values());
    inputPanel.add(new JLabel("Preferred Position:"));
    inputPanel.add(positionComboBox);

    Integer[] skillLevels = { 1, 2, 3, 4, 5 };
    JComboBox<Integer> skillLevelComboBox = new JComboBox<>(skillLevels);
    inputPanel.add(new JLabel("Skill Level:"));
    inputPanel.add(skillLevelComboBox);

    int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Enter the Player's Information",
        JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
      // Get the values from the input fields and call the corresponding method in the controller
      String firstName = firstNameField.getText();
      String lastName = lastNameField.getText();
      int year = (int) yearComboBox.getSelectedItem();
      int month = monthComboBox.getSelectedIndex() + 1; // adjust for 0-based index
      int day = (int) dayComboBox.getSelectedItem();
      LocalDate dateOfBirth;
      try {
        dateOfBirth = LocalDate.of(year, month, day);
      } catch (DateTimeException e) {
        // Catch the exception and display an error message to the user
        showErrorMessage("Invalid date selected. Please select a valid date.");
        return;
      }

      //LocalDate dateOfBirth = LocalDate.of(year, month, day);
      Position preferredPosition = (Position) positionComboBox.getSelectedItem();
      int skillLevel = (int) skillLevelComboBox.getSelectedItem();

      controller.addPlayer(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
    }

  }

  //display player list in the view
  @Override public void displayPlayerList(String playerListText) {
    listTextPane.setText(playerListText);
  }

  @Override public void showLineupList(String lineupListText) {
    listTextPane.setText(lineupListText);
  }

  @Override public void showCurrentSize(int size) {
    String sizeStr = String.valueOf(size);
    sizeLabel.setText("Current players added: " + sizeStr);
  }

  @Override public void showSuccessMessage(String message) {
    successMessage.setText(message);
  }

  @Override public void showErrorMessage(String message) {
    warning.setText("Error: " + message);
  }

  @Override public void clearPreviousMessage() {
    //clearing the previous success or warning message.
    warning.setText("");
    successMessage.setText("");
  }

  @Override public void setShowResultsButton() {
    showLineupButton.setEnabled(true);
    showPlayerListButton.setEnabled(true);
  }

  @Override public void setCreateAndAddButtonUnavailable() {
    addPlayerButton.setEnabled(false);
    createTeamButton.setEnabled(false);

  }
}
