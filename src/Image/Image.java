package Image;

public class Image implements IImage {
  private IPixel[][] pixels;

  public Image(IPixel[][] pixels) {
    this.pixels = pixels;
  }

  @Override
  public IPixel[][] getPixels() {
    return pixels;
  }

  @Override
  public IPixel getPixel(int x, int y) {
    return pixels[y][x];
  }

  @Override
  public int getWidth() {
    return pixels[0].length;
  }

  @Override
  public int getHeight() {
    return pixels.length;
  }

  @Override
  public void setPixel(int x, int y, IPixel pixel) {
    pixels[y][x] = pixel;
  }

  @Override
  public IImage redComponent() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] redPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);
        redPixels[y][x] = new Pixel(originalPixel.getRed(), 0, 0);
      }
    }
    return new Image(redPixels);
  }

  @Override
  public IImage greenComponent() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] greenPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);
        greenPixels[y][x] = new Pixel(0, originalPixel.getGreen(), 0);
      }
    }
    return new Image(greenPixels);
  }

  @Override
  public IImage blueComponent() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] bluePixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);
        bluePixels[y][x] = new Pixel(0, 0, originalPixel.getBlue());
      }
    }
    return new Image(bluePixels);
  }


}
