package controller.commands;

import model.IImageModel;

public abstract class AbstractTransformCommand extends AbstractCommand {
  protected final String destImageName;

  public AbstractTransformCommand(String imageName, String destImageName, IImageModel model) {
    super(imageName, model);
    this.destImageName = destImageName;
  }
}
