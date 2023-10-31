package Controller.Commands;

import Model.IImageModel;

public class ValueComponentCommand extends AbstractTransformCommand {

  public ValueComponentCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.valueComponent(this.imageName, this.destImageName);
  }
}