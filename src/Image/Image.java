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

  @Override
  public IImage valueComponent() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] valuePixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);
        int maxPixelVal = Math.max(originalPixel.getRed(),Math.max(originalPixel.getGreen(),originalPixel.getBlue()));
        valuePixels[y][x] = new Pixel(maxPixelVal, maxPixelVal, maxPixelVal);
      }
    }
    return new Image(valuePixels);
  }

  @Override
  public IImage lumaComponent() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] lumaPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);
        int maxPixelVal = Math.max(originalPixel.getRed(),Math.max(originalPixel.getGreen(),originalPixel.getBlue()));
        lumaPixels[y][x] = new Pixel(maxPixelVal, maxPixelVal, maxPixelVal);
      }
    }
    return new Image(lumaPixels);
  }

  @Override
  public IImage intensityComponent() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] intensityPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);
        int intensityPixelVal = ((originalPixel.getRed() + originalPixel.getGreen() + originalPixel.getBlue()) / 3);
        intensityPixels[y][x] = new Pixel(intensityPixelVal, intensityPixelVal, intensityPixelVal);
      }
    }
    return new Image(intensityPixels);
  }

  @Override
  public IImage horizontalFlip() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] hFlipPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        hFlipPixels[y][x] = getPixel(width-1-x,y);
      }
    }
    return new Image(hFlipPixels);
  }

  @Override
  public IImage verticalFlip() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] vFlipPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        vFlipPixels[y][x] = getPixel(x,height-1-y);
      }
    }
    return new Image(vFlipPixels);
  }

}
