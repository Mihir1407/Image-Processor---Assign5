import Controller.ImageController;
import Model.IImageModel;
import Model.ImageModel;
import View.ConsoleView;
import View.IView;

public class Application {

  public static void main(String[] args) {
    IImageModel model = new ImageModel();
    IView view = new ConsoleView();
    ImageController controller = new ImageController(model, view);

    while (true) {
      String command = view.getInput();
      if ("exit".equals(command)) {
        break;
      }
      try {
        controller.executeCommand(command);
      } catch (Exception e) {
        view.showError("Error: " + e.getMessage());
      }
    }
  }
}
