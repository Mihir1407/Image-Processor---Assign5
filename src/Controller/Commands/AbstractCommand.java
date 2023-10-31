package Controller.Commands;

import Model.IImageModel;

abstract class AbstractCommand implements ICommand {
  protected final IImageModel model;
  protected final String imageName;

  public AbstractCommand(String imageName, IImageModel model) {
    this.model = model;
    this.imageName = imageName;
  }

  @Override
  public boolean execute() {
    boolean success = true;
    try {
      processImage();
    } catch (Exception e) {
      success = false;
    }
    return success;
  }

  protected abstract void processImage() throws Exception;
}
