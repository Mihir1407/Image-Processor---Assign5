package controller.commands;

import model.IImageModel;

public class ColorCorrectCommand extends AbstractTransformCommand {

  public ColorCorrectCommand(String imageName,
                             String destImageName, IImageModel model) {
    super(imageName, destImageName, model);
  }

  @Override
  protected void processImage() throws Exception {
    this.model.colorCorrect(this.imageName, this.destImageName);
  }
}