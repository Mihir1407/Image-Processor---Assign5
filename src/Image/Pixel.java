package Image;

import Image.IPixel;

public class  Pixel implements IPixel {
  private int red;
  private int green;
  private int blue;

  public Pixel(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public int getRed() {
    return red;
  }

  @Override
  public int getGreen() {
    return green;
  }

  @Override
  public int getBlue() {
    return blue;
  }

  @Override
  public void setRed(int value) {
    this.red = value;
  }

  @Override
  public void setGreen(int value) {
    this.green = value;
  }

  @Override
  public void setBlue(int value) {
    this.blue = value;
  }
}
