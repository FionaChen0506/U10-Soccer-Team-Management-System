package team;

import java.time.LocalDate;

/**
 * The Player class represents a player in a soccer team. A player has a first name, last name, date
 * of birth, skill level, jersey number, preferred position, and final position.
 */

public class Player {
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private int skillLevel;
  private int jerseyNumber;
  private Position preferredPosition;
  private Position finalPosition;
  private boolean finalPositionSet = false;
  private boolean jerseyNumberSet = false;

  /**
   * This is the constructor for a player.
   *
   * @param firstName         the first name of the player.
   * @param lastName          the last name of the player.
   * @param dateOfBirth       the date of birth of the player.
   * @param skillLevel        the skill lever(1-5) of the player.
   * @param preferredPosition the preferred position of the players
   * @throws IllegalArgumentException if the player's name is invalid or if the skill level is not
   *                                  from 1 to 5.
   */
  public Player(String firstName, String lastName, LocalDate dateOfBirth,
      Position preferredPosition, int skillLevel) throws IllegalArgumentException {
    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("First name and last name cannot be empty.");
    }
    if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")) {
      throw new IllegalArgumentException("First name and last name must contain only letters.");
    }
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("The skill level should be 1 - 5.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;

    this.skillLevel = skillLevel;
    this.preferredPosition = preferredPosition;
    // initially, every player's final position is null
    this.finalPosition = null;
    // set each player's jersey number to be -1 to indicate that this is not created here.
    this.jerseyNumber = -1;

  }

  /**
   * returns the first name of the player.
   *
   * @return firstName of the player.
   */
  public String getFirstName() {
    //return this.firstName;
    String firstLetter = this.firstName.substring(0, 1).toUpperCase();
    String restOfFirstName = this.firstName.substring(1);
    return firstLetter + restOfFirstName;
  }

  /**
   * returns the last name of the player.
   *
   * @return lastName of the person.
   */
  public String getLastName() {
    String firstLetter = this.lastName.substring(0, 1).toUpperCase();
    String restOfLastName = this.lastName.substring(1);
    return firstLetter + restOfLastName;
    //return this.lastName;
  }

  /**
   * returns the date of birth of the player.
   *
   * @return dateOfBirth of the person.
   */
  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  /**
   * returns the preferred position of the player.
   *
   * @return preferredPosition of the person.
   */
  public Position getPreferredPosition() {
    return this.preferredPosition;
  }

  /**
   * returns the skill level of the player.
   *
   * @return skill level of the person.
   */
  public int getSkillLevel() {
    return this.skillLevel;
  }

  /**
   * returns the jersey number of the player.
   *
   * @return jersey number of the person.
   */
  public int getJerseyNumber() {
    return this.jerseyNumber;
  }

  /**
   * returns the final position of the player.
   *
   * @return finalPosition of the person.
   */
  public Position getFinalPosition() {
    return this.finalPosition;
  }

  /**
   * sets the final position for a player.
   *
   * @param assignedPosition the assigned position for the player.
   */
  public void setFinalPosition(Position assignedPosition) {
    // after setting the position for the player, it cannot be changed.
    if (!finalPositionSet) {
      this.finalPosition = assignedPosition;
      finalPositionSet = true;
    }

  }

  /**
   * sets the Jersey number for a player.
   *
   * @param jerseyNumber the Jersey number for the player.
   */
  public void setJerseyNumber(int jerseyNumber) {
    // after setting the Jersey number for the player, it cannot be changed.
    if (!jerseyNumberSet) {
      this.jerseyNumber = jerseyNumber;
      jerseyNumberSet = true;
    }
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getLastName()).append(", ").append(this.getFirstName()).append(". ")
        .append("Jersey Number: ").append(this.getJerseyNumber()).append(" ");
    String str = sb.toString();
    //String str = this.getLastName() + ", " + this.getFirstName() + ". " + "Jersey Number: "
    //  + this.getJerseyNumber() + " ";
    return str;
  }

}
