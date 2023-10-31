package Controller.Commands;

import Model.IImageModel;

public class RedComponentCommand extends AbstractTransformCommand {

  public RedComponentCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.redComponent(this.imageName, this.destImageName);
  }
}