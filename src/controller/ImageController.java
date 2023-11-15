package controller;

import java.util.List;
import java.util.Optional;

import controller.commands.AdjustLevelsCommand;
import controller.commands.BlueComponentCommand;
import controller.commands.BlurCommand;
import controller.commands.BrightenCommand;
import controller.commands.ColorCorrectCommand;
import controller.commands.CompressCommand;
import controller.commands.GreenComponentCommand;
import controller.commands.HistogramCommand;
import controller.commands.HorizontalFlipCommand;
import controller.commands.ICommand;
import controller.commands.IntensityComponentCommand;
import controller.commands.LoadCommand;
import controller.commands.LumaComponentCommand;
import controller.commands.RGBCombineCommand;
import controller.commands.RGBSplitCommand;
import controller.commands.RedComponentCommand;
import controller.commands.SaveCommand;
import controller.commands.SepiaCommand;
import controller.commands.SharpenCommand;
import controller.commands.ValueComponentCommand;
import controller.commands.VerticalFlipCommand;
import model.IImageModel;
import view.IView;

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
   * Parses a script file and executes a list of commands.
   * This method allows batch processing of multiple commands.
   *
   * @param filePath Path to the script file containing a list of commands.
   */
  @Override
  public void runScript(String filePath) {
    try {
      IScriptParser scriptParser = new ScriptParser();
      List<String> commands = scriptParser.parse(filePath);
      for (String command : commands) {
        executeCommand(command);
      }
    } catch (Exception e) {
      view.showError("Error running the script file.");
    }

  }

  /**
   * Parses the given command and delegates it to the corresponding
   * command implementation.
   * After executing the command, it provides feedback about the
   * operation's success or failure.
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
          Optional<Integer> splitPercentage = parts.length > 3 && parts[3].equals("split")
                  ? Optional.of(Integer.parseInt(parts[4])) : Optional.empty();
          newCommand = new SepiaCommand(parts[1], parts[2], model, splitPercentage);
          commandSuccessful = newCommand.execute();
          break;
        case "compress":
          int cr = Integer.parseInt(parts[1]);
          newCommand = new CompressCommand(cr, parts[2], parts[3], model);
          commandSuccessful = newCommand.execute();
          break;
        case "histogram":
          newCommand = new HistogramCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "color-correct":
          newCommand = new ColorCorrectCommand(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "levels-adjust":
          int b = Integer.parseInt(parts[1]);
          int m = Integer.parseInt(parts[2]);
          int w = Integer.parseInt(parts[3]);
          newCommand = new AdjustLevelsCommand(b, m, w, parts[4], parts[5], model);
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
      view.showError("Error executing command: " + e.getMessage());
      commandSuccessful = false;
    }
    if (commandSuccessful) {
      view.showMessage(parts[0] + " operation successful.");
    } else {
      view.showError(parts[0] + " operation failed.");
    }
  }
}
