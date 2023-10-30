package Controller;

import java.util.List;

import Controller.Commands.BlueComponent;
import Controller.Commands.BlurCommand;
import Controller.Commands.BrightenCommand;
import Controller.Commands.GreenComponent;
import Controller.Commands.HorizontalFlip;
import Controller.Commands.ICommand;
import Controller.Commands.IntensityComponent;
import Controller.Commands.LoadCommand;
import Controller.Commands.LumaComponent;
import Controller.Commands.RGBCombine;
import Controller.Commands.RGBSplit;
import Controller.Commands.RedComponent;
import Controller.Commands.SaveCommand;
import Controller.Commands.SepiaCommand;
import Controller.Commands.SharpenCommand;
import Controller.Commands.ValueComponent;
import Controller.Commands.VerticalFlip;
import Model.IImageModel;
import View.IView;

public class ImageController implements IController {
  private final IImageModel model;
  private final IView view;

  public ImageController(IImageModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void execute(){
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
          newCommand = new RedComponent(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "green-component":
          newCommand = new GreenComponent(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "blue-component":
          newCommand = new BlueComponent(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "value":
          newCommand = new ValueComponent(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "luma":
          newCommand = new LumaComponent(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "intensity":
          newCommand = new IntensityComponent(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "horizontal-flip":
          newCommand = new HorizontalFlip(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "vertical-flip":
          newCommand = new VerticalFlip(parts[1], parts[2], model);
          commandSuccessful = newCommand.execute();
          break;
        case "brighten":
          int inc = Integer.parseInt(parts[1]);
          newCommand = new BrightenCommand(inc, parts[2], parts[3], model);
          commandSuccessful = newCommand.execute();
          break;
        case "rgb-split":
          newCommand = new RGBSplit(parts[1], parts[2], parts[3], parts[4],model);
          commandSuccessful = newCommand.execute();
          break;
        case "rgb-combine":
          newCommand = new RGBCombine(parts[1], parts[2], parts[3], parts[4],model);
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
          view.showError("Unknown command.");
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

  private void runScript(String filePath) {
    IScriptParser scriptParser = new ScriptParser();
    List<String> commands = scriptParser.parse(filePath);

    for (String command : commands) {
      executeCommand(command);
    }
  }
}
