package model;

import java.io.IOException;

import model.image.Image;

public class mockModel implements IImageModel{

  private static StringBuilder log = new StringBuilder();
  public mockModel() {
  }
  @Override
  public void addImage(Image image, String imagePath) throws IOException {
    log.append("Add Image method called.");
  }

  @Override
  public Image getImage(String imageName) throws IOException {
    log.append("Get Image method called.");
    return null;
  }

  @Override
  public void redComponent(String imageName, String destImageName) throws IOException {
    log.append("Red Component method called.");
  }

  @Override
  public void greenComponent(String imageName, String destImageName) throws IOException {
    log.append("Green Component method called.");
  }

  @Override
  public void blueComponent(String imageName, String destImageName) throws IOException {
    log.append("Blue Component method called.");
  }

  @Override
  public void valueComponent(String imageName, String destImageName) throws IOException {
    log.append("Value Component method called.");
  }

  @Override
  public void lumaComponent(String imageName, String destImageName) throws IOException {
    log.append("Luma Component method called.");
  }

  @Override
  public void intensityComponent(String imageName, String destImageName) throws IOException {
    log.append("Intensity Component method called.");
  }

  @Override
  public void horizontalFlip(String imageName, String destImageName) throws IOException {
    log.append("Horizontal Flip method called.");
  }

  @Override
  public void brightenCommand(int increment, String imageName, String destImageName) throws IOException {
    log.append("Brighten method called.");
  }

  @Override
  public void blur(String imageName, String destImageName) throws IOException {
    log.append("Blur method called.");
  }

  @Override
  public void sharpen(String imageName, String destImageName) throws IOException {
    log.append("Sharpen method called.");
  }

  @Override
  public void verticalFlip(String imageName, String destImageName) throws IOException {
    log.append("Vertical Flip method called.");
  }

  @Override
  public void sepia(String imageName, String destImageName) throws IOException {
    log.append("Sepia Component method called.");
  }

  @Override
  public void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen, String destImageNameBlue) throws IOException {
    log.append("RGB Split method called.");
  }

  @Override
  public void rgbCombine(String redImageName, String greenImageName, String blueImageName, String destImageName) throws IOException {
    log.append("RGB Combine method called.");
  }

  public static String getLog() {
    return log.toString();
  }
}
