package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the IScriptParser interface.
 * Parses the script files and retrieves the commands listed in the file.
 */
public class ScriptParser implements IScriptParser {

  /**
   * Parses the script file provided by the given file path and
   * retrieves a list of commands.
   * Lines starting with "#" or empty lines are ignored.
   *
   * @param scriptFilePath Path to the script file to be parsed.
   * @return A list of commands found in the script file.
   * @throws RuntimeException If an error occurs while reading the script file.
   */
  @Override
  public List<String> parse(String scriptFilePath) {
    List<String> commands = new ArrayList<>();

    try {
      List<String> lines = Files.readAllLines(Paths.get(scriptFilePath));

      for (String line : lines) {
        line = line.trim();

        if (!line.startsWith("#") && !line.isEmpty()) {
          commands.add(line);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException("Error reading the script file: "
              + e.getMessage());
    }

    return commands;
  }
}
