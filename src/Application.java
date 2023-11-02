import controller.ImageController;
import model.IImageModel;
import model.ImageModel;
import view.ConsoleView;
import view.IView;

/**
 * The main application class that initiates and
 * starts the Image processing program.
 * This class initializes the Image model, a console-based view,
 * and the Image controller.
 * After setting up these components, it triggers the controller's execution.
 */
public class Application {

  /**
   * The main entry point for the Image processing program.
   *
   * @param args Command-line arguments. Currently not used in this application.
   */
  public static void main(String[] args) {
    IImageModel model = new ImageModel();
    IView view = new ConsoleView();
    ImageController controller = new ImageController(model, view);
    controller.execute();
  }
}
