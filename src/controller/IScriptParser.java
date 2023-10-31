package controller;

import java.util.List;

/**
 * Interface for parsing scripts.
 * Provides methods to parse scripts into a list of commands.
 */
public interface IScriptParser {

  /**
   * Parses the given script into a list of commands.
   *
   * @param script The script to be parsed.
   * @return A list of string commands derived from the script.
   */
  List<String> parse(String script);
}
