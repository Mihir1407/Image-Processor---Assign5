package Controller.Commands;

import Model.IImageModel;

public class GreenComponentCommand extends AbstractTransformCommand {

  public GreenComponentCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.greenComponent(this.imageName, this.destImageName);
  }
}