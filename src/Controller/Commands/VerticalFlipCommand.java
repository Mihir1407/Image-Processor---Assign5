package Controller.Commands;

import Model.IImageModel;

public class VerticalFlipCommand extends AbstractTransformCommand {

  public VerticalFlipCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.verticalFlip(this.imageName, this.destImageName);
  }
}