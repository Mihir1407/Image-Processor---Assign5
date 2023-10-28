package Controller;

import java.util.List;

import Commands.BlueComponent;
import Commands.GreenComponent;
import Commands.ICommand;
import Commands.LoadCommand;
import Commands.RedComponent;
import Commands.SaveCommand;
import Model.IImageModel;
import View.IView;

public class ImageController implements IController {
  private IImageModel model;
  private IView view;

  public ImageController(IImageModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void executeCommand(String command) {
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
        case "run":
          runScript(parts[1]);
          break;
        default:
          view.showMessage("Unknown command.");
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
