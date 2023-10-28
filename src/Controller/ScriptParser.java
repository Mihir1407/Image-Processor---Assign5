package Controller;

import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller.IScriptParser;

public class ScriptParser implements IScriptParser {

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
      throw new RuntimeException("Error reading the script file: " + e.getMessage());
    }

    return commands;
  }
}
