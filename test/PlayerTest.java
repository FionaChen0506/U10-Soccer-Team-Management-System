import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import org.junit.Test;
import team.Player;
import team.Position;

/**
 * Test cases for the Player class. Verifying that all methods for creating a player can work.
 */
public class PlayerTest {
  private final Player player1 = new Player("John", "Doe", LocalDate.of(2000, 1, 1),
      Position.FORWARD, 3);
  private final Player player2 = new Player("Jane", "Smith", LocalDate.of(1999, 5, 15),
      Position.MIDFIELDER, 4);

  /**
   * test for the constructor.
   */
  @Test public void testConstructor() {
    // test that the object is created correctly
    assertNotNull(player1);
    assertEquals("John", player1.getFirstName());
    assertEquals("Doe", player1.getLastName());
    assertEquals(LocalDate.of(2000, 1, 1), player1.getDateOfBirth());
    assertEquals(Position.FORWARD, player1.getPreferredPosition());
    assertEquals(3, player1.getSkillLevel());
    assertEquals(-1, player1.getJerseyNumber());
    assertNull(player1.getFinalPosition());
  }

  /**
   * test cases for getFirstName().
   */
  @Test public void testGetFirstName() {
    assertEquals("John", player1.getFirstName());
    assertEquals("Jane", player2.getFirstName());
  }

  /**
   * Test cases for getLastName() method.
   */
  @Test public void testGetLastName() {
    assertEquals("Doe", player1.getLastName());
    assertEquals("Smith", player2.getLastName());
  }

  /**
   * Test cases for getDateOfBirth() method.
   */
  @Test public void testGetDateOfBirth() {
    assertEquals(LocalDate.of(2000, 1, 1), player1.getDateOfBirth());
    assertEquals(LocalDate.of(1999, 5, 15), player2.getDateOfBirth());
  }

  /**
   * Test cases for getPreferredPosition() method.
   */
  @Test public void testGetPreferredPosition() {
    assertEquals(Position.FORWARD, player1.getPreferredPosition());
    assertEquals(Position.MIDFIELDER, player2.getPreferredPosition());
  }

  /**
   * Test cases for getSkillLevel() method.
   */
  @Test public void testGetSkillLevel() {
    assertEquals(3, player1.getSkillLevel());
    assertEquals(4, player2.getSkillLevel());
  }

  /**
   * Test cases for getJerseyNumber() method.
   */
  @Test public void testGetJerseyNumber() {
    assertEquals(-1, player1.getJerseyNumber());
    assertEquals(-1, player2.getJerseyNumber());
  }

  /**
   * Test cases for getFinalPosition() method.
   */
  @Test public void testGetFinalPosition() {
    assertNull(player1.getFinalPosition());
    assertNull(player2.getFinalPosition());
  }

  /**
   * test for setJerseyNumber().
   */
  @Test public void testSetJerseyNumber() {
    player1.setJerseyNumber(10);
    assertEquals(10, player1.getJerseyNumber());

    player2.setJerseyNumber(7);
    assertEquals(7, player2.getJerseyNumber());

  }

  /**
   * test for setFinalPosition().
   */
  @Test public void testFinalPosition() {
    player1.setFinalPosition(Position.DEFENDER);
    assertEquals(Position.DEFENDER, player1.getFinalPosition());

    player2.setFinalPosition(Position.MIDFIELDER);
    assertEquals(Position.MIDFIELDER, player2.getFinalPosition());

  }

  /**
   * test toString() method.
   */
  @Test public void testToString() {
    player1.setJerseyNumber(10);
    assertEquals("Doe, John. Jersey Number: 10 ", player1.toString());

    player2.setJerseyNumber(7);
    assertEquals("Smith, Jane. Jersey Number: 7 ", player2.toString());
  }

}
