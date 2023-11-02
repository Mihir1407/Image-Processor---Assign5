import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import controller.IScriptParser;
import controller.ScriptParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the ScriptParser class.
 * These tests ensure that the script parser is correctly parsing
 * script files.
 */
public class ScriptParserTest {

  private IScriptParser parser;
  public TemporaryFolder testFolder = new TemporaryFolder();

  /**
   * Sets up the testing environment before each test.
   * This method initializes the parser and creates a
   * temporary folder for test files.
   *
   * @throws IOException if an I/O error occurs
   */
  @Before
  public void setUp() throws IOException {
    parser = new ScriptParser();
    testFolder.create();
  }

  /**
   * Tests the parser with a valid script containing simple commands.
   *
   * @throws IOException if an I/O error occurs when writing
   *                     to the test file
   */
  @Test
  public void testParseValidScript() throws IOException {
    Path scriptFile = testFolder.newFile("validScript.txt").toPath();
    List<String> lines = List.of("command1", "command2", "command3");
    Files.write(scriptFile, lines);
    List<String> commands = parser.parse(scriptFile.toString());
    assertEquals(3, commands.size());
    assertTrue("command1", commands.contains("command1"));
    assertTrue("command2", commands.contains("command2"));
    assertTrue("command3", commands.contains("command3"));
  }

  /**
   * Tests the parser with an invalid script containing simple commands.
   *
   * @throws IOException if an I/O error occurs when writing
   *                     to the test file
   */
  @Test
  public void testParseScriptWithCommentsAndEmptyLines() throws IOException {
    Path scriptFile = testFolder.newFile("scriptWithComments.txt").toPath();
    List<String> lines = List.of("# This is a comment", "", "command1",
            " # Another comment", "command2", "");
    Files.write(scriptFile, lines);
    List<String> commands = parser.parse(scriptFile.toString());
    assertEquals(2, commands.size());
    assertTrue("command1", commands.contains("command1"));
    assertTrue("command2", commands.contains("command2"));
  }

  /**
   * Tests the parser with non-existent script.
   */
  @Test(expected = RuntimeException.class)
  public void testParseNonExistentScript() {
    parser.parse("nonExistentScript.txt");
  }
}
