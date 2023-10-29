package Image;

import java.util.Arrays;
import java.util.List;

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

  @Override
  public IImage brightenCommand(int increment) {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] brightenPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);
        int red = originalPixel.getRed() + increment > 255 ? 255 :
                Math.max(originalPixel.getRed() + increment, 0);
        int green = originalPixel.getGreen() + increment > 255 ? 255 :
                Math.max(originalPixel.getGreen() + increment, 0);
        int blue = originalPixel.getBlue() + increment > 255 ? 255 :
                Math.max(originalPixel.getBlue() + increment, 0);

        brightenPixels[y][x] = new Pixel(red,green,blue);
      }
    }
    return new Image(brightenPixels);
  }

  @Override
  public IImage sepia() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] sepiaPixels = new IPixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel originalPixel = getPixel(x, y);

        int originalRed = originalPixel.getRed();
        int originalGreen = originalPixel.getGreen();
        int originalBlue = originalPixel.getBlue();

        int newRed = (int) (0.393 * originalRed + 0.769 * originalGreen + 0.189 * originalBlue);
        int newGreen = (int) (0.349 * originalRed + 0.686 * originalGreen + 0.168 * originalBlue);
        int newBlue = (int) (0.272 * originalRed + 0.534 * originalGreen + 0.131 * originalBlue);

        newRed = Math.min(255, newRed);
        newGreen = Math.min(255, newGreen);
        newBlue = Math.min(255, newBlue);

        sepiaPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
      }
    }

    return new Image(sepiaPixels);
  }

  @Override
  public IImage sharpen() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] sharpenedPixels = new IPixel[height][width];

    double[][] kernel = {
            {-1.0/8, -1.0/8, -1.0/8, -1.0/8, -1.0/8},
            {-1.0/8, 1.0/4, 1.0/4, 1.0/4, -1.0/8},
            {-1.0/8, 1.0/4, 1, 1.0/4, -1.0/8},
            {-1.0/8, 1.0/4, 1.0/4, 1.0/4, -1.0/8},
            {-1.0/8, -1.0/8, -1.0/8, -1.0/8, -1.0/8}
    };

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        double redSum = 0;
        double greenSum = 0;
        double blueSum = 0;

        for (int i = -2; i <= 2; i++) {
          for (int j = -2; j <= 2; j++) {

            if (x + i < 0 || x + i >= width || y + j < 0 || y + j >= height) continue;

            IPixel neighboringPixel = getPixel(x + i, y + j);
            redSum += neighboringPixel.getRed() * kernel[i + 2][j + 2];
            greenSum += neighboringPixel.getGreen() * kernel[i + 2][j + 2];
            blueSum += neighboringPixel.getBlue() * kernel[i + 2][j + 2];
          }
        }

        int newRed = Math.min(255, Math.max(0, (int) Math.round(redSum)));
        int newGreen = Math.min(255, Math.max(0, (int) Math.round(greenSum)));
        int newBlue = Math.min(255, Math.max(0, (int) Math.round(blueSum)));

        sharpenedPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
      }
    }

    return new Image(sharpenedPixels);
  }

  @Override
  public IImage blur() {
    int height = getHeight();
    int width = getWidth();
    IPixel[][] blurredPixels = new IPixel[height][width];

    double[][] kernel = {
            {1.0/16, 1.0/8, 1.0/16},
            {1.0/8, 1.0/4, 1.0/8},
            {1.0/16, 1.0/8, 1.0/16}
    };

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        double redSum = 0;
        double greenSum = 0;
        double blueSum = 0;

        for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {

            if (x + i < 0 || x + i >= width || y + j < 0 || y + j >= height) continue;

            IPixel neighboringPixel = getPixel(x + i, y + j);
            redSum += neighboringPixel.getRed() * kernel[i + 1][j + 1];
            greenSum += neighboringPixel.getGreen() * kernel[i + 1][j + 1];
            blueSum += neighboringPixel.getBlue() * kernel[i + 1][j + 1];
          }
        }
        int newRed = (int) Math.round(redSum);
        int newGreen = (int) Math.round(greenSum);
        int newBlue = (int) Math.round(blueSum);

        blurredPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
      }
    }

    return new Image(blurredPixels);
  }

}
