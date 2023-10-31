package Controller;

import java.util.List;

import Controller.Commands.BlueComponentCommand;
import Controller.Commands.BlurCommand;
import Controller.Commands.BrightenCommand;
import Controller.Commands.GreenComponentCommand;
import Controller.Commands.HorizontalFlipCommand;
import Controller.Commands.ICommand;
import Controller.Commands.IntensityComponentCommand;
import Controller.Commands.LoadCommand;
import Controller.Commands.LumaComponentCommand;
import Controller.Commands.RGBCombineCommand;
import Controller.Commands.RGBSplitCommand;
import Controller.Commands.RedComponentCommand;
import Controller.Commands.SaveCommand;
import Controller.Commands.SepiaCommand;
import Controller.Commands.SharpenCommand;
import Controller.Commands.ValueComponentCommand;
import Controller.Commands.VerticalFlipCommand;
import Model.IImageModel;
import View.IView;

/**
 * Implementation of the IController interface for image manipulation.
 * This controller takes user input commands from a given view and processes
 * them using an image model to perform various image operations.
 */
public class ImageController implements IController {
  /**
   * The model responsible for performing image manipulations.
   */
  private final IImageModel model;
  /**
   * The view through which user input is received and feedback is given.
   */
  private final IView view;

  /**
   * Constructs an ImageController with a given image model and view.
   *
   * @param model The model to be used for image manipulations.
   * @param view  The view to be used for user interaction.
   */
  public ImageController(IImageModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * Waits for user input, processes commands until the user decides to exit.
   * For each command, it delegates the task to a corresponding command implementation
   * and then provides feedback to the user through the view.
   */
  @Override
  public void execute() {
    while (true) {
      String command = this.view.getInput();
      if ("exit".equals(command)) {
        break;
      }
      try {
        executeCommand(command);
      } catch (Exception e) {
        view.showError("Error: " + e.getMessage());
      }
    }
  }

  /**
   * Parses the given command and delegates it to the corresponding command implementation.
   * After executing the command, it provides feedback about the operation's success or failure.
   *
   * @param command The command string input by the user.
   */
  private void executeCommand(String command) {
    String[] parts = command.split(" ");
    boolean commandSuccessful;
    ICommand newCommand;
    try {
      commandSuccessful = true;
      switch (parts[0]) {
        case "load":
          newCommand = new LoadCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "save":
          newCommand = new SaveCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "red-component":
          newCommand = new RedComponentCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "green-component":
          newCommand = new GreenComponentCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "blue-component":
          newCommand = new BlueComponentCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "value-component":
          newCommand = new ValueComponentCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "luma-component":
          newCommand = new LumaComponentCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "intensity-component":
          newCommand = new IntensityComponentCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "horizontal-flip":
          newCommand = new HorizontalFlipCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "vertical-flip":
          newCommand = new VerticalFlipCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "brighten":
          int inc = Integer.parseInt(parts[1]);
          newCommand = new BrightenCommand(inc, parts[2], parts[3], model);
          commandSuccessful = newCommand.execute();
          break;
        case "rgb-split":
          newCommand = new RGBSplitCommand(parts[1], parts[2], parts[3], parts[4], model);
          commandSuccessful = newCommand.execute();
          break;
        case "rgb-combine":
          newCommand = new RGBCombineCommand(parts[1], parts[2], parts[3], parts[4], model);
          commandSuccessful = newCommand.execute();
          break;
        case "blur":
          newCommand = new BlurCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "sharpen":
          newCommand = new SharpenCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "sepia":
          newCommand = new SepiaCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "run":
          runScript(parts[1]);
          break;
        default:
          view.showError("Unknown command " + parts[0]);
          commandSuccessful = false;
          break;
      }
    } catch (Exception e) {
      commandSuccessful = false;
    }
    if (commandSuccessful == true) {
      view.showMessage(parts[0] + " operation successful.");
    } else {
      view.showError(parts[0] + " operation failed.");
    }
  }

  /**
   * Parses a script file and executes a list of commands.
   * This method allows batch processing of multiple commands.
   *
   * @param filePath Path to the script file containing a list of commands.
   */
  private void runScript(String filePath) {
    IScriptParser scriptParser = new ScriptParser();
    List<String> commands = scriptParser.parse(filePath);

    for (String command : commands) {
      executeCommand(command);
    }
  }
}
