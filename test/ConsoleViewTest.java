import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import view.ConsoleView;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for the ConsoleView class.
 */
public class ConsoleViewTest {

  /**
   * The ConsoleView instance to be used for testing.
   */
  private ConsoleView view;

  /**
   * The stream to capture the console output.
   */
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  /**
   * The stream to capture the error console output.
   */
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  /**
   * Sets up a ConsoleView instance with specific input stream for testing.
   */
  @Before
  public void setUp() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  /**
   * Tests the showMessage() method of the ConsoleView class.
   * Ensures it displays the correct message to the console.
   */
  @Test
  public void testShowMessage() {
    view = new ConsoleView();
    view.showMessage("Test Message");
    assertEquals("Test Message" + System.lineSeparator(), outContent.toString());
  }

  /**
   * Tests the getInput() method of the ConsoleView class.
   * Ensures it correctly reads and returns the input from the console.
   */
  @Test
  public void testGetInput() {
    String inputData = "Test Input";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    view = new ConsoleView();
    assertEquals("Test Input", view.getInput());
  }

  /**
   * Tests the showError() method of the ConsoleView class.
   * Ensures it displays the correct error message to the console.
   */
  @Test
  public void testShowError() {
    view = new ConsoleView();
    view.showError("Test Error");
    assertEquals("ERROR: Test Error"
            + System.lineSeparator(), errContent.toString());
  }
}
