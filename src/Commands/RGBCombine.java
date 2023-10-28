//package Commands;
//
//import Model.IImageModel;
//
//public class RGBCombine implements ICommand{
//  private final IImageModel model;
//  private final String destImageName;
//
//  private final String redImageName;
//
//  private final String greenImageName;
//
//  private final String blueImageName;
//
//  public RGBCombine(IImageModel model, String destImageName, String redImageName, String greenImageName, String blueImageName) {
//    this.model = model;
//    this.destImageName = destImageName;
//    this.redImageName = redImageName;
//    this.greenImageName = greenImageName;
//    this.blueImageName = blueImageName;
//
//  }
//
//  @Override
//  public boolean execute() {
//    boolean success = true;
//    try {
//      this.model.rgbCombine(redImageName, greenImageName, blueImageName, this.destImageName);
//    } catch (Exception e) {
//      success = false;
//    }
//    return success;
//  }
//}
