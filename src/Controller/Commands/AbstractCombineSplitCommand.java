package Controller.Commands;

import Model.IImageModel;

abstract class AbstractCombineSplitCommand extends AbstractCommand{
  protected final String redImageName;
  protected final String greenImageName;
  protected final String blueImageName;

  public AbstractCombineSplitCommand(String imageName, String redImageName, String greenImageName, String blueImageName, IImageModel model) {
    super(imageName, model);
    this.redImageName = redImageName;
    this.greenImageName = greenImageName;
    this.blueImageName = blueImageName;
  }
}
