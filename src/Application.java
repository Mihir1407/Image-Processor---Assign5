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

    controller.execute();
  }
}
