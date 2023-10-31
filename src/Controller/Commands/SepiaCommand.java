package Controller.Commands;

import Model.IImageModel;

public class SepiaCommand extends AbstractTransformCommand {

  public SepiaCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.sepia(this.imageName, this.destImageName);
  }
}