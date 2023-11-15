package model.image;

import model.strategy.FilterStrategy;

/**
 * Represents a 2D image composed of pixels.
 * Provides methods to get pixel data, retrieve the width and
 * height of the image, and set pixel values.
 */
public class Image implements IImage {
  private Pixel[][] pixels;

  /**
   * Constructs a new Image with the specified 2D array of pixels.
   *
   * @param pixels a 2D array of Pixel objects representing the image data
   */
  public Image(Pixel[][] pixels) {
    this.pixels = pixels;
  }

  /**
   * Returns the 2D array of pixels that make up this image.
   *
   * @return the 2D array of Pixel objects
   */
  @Override
  public Pixel[][] getPixels() {
    return pixels;
  }

  /**
   * Retrieves the pixel at the specified (x, y) position.
   * Throws an IllegalArgumentException if the x and y coordinates are outside
   * the bounds of the image dimensions.
   *
   * @param x the x-coordinate of the desired pixel
   * @param y the y-coordinate of the desired pixel
   * @return the Pixel object at the specified position
   * @throws IllegalArgumentException if x or y coordinates are out of bounds
   */
  @Override
  public Pixel getPixel(int x, int y) throws IllegalArgumentException {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException("Coordinates out of bounds!");
    }
    return pixels[y][x];
  }

  /**
   * Returns the width of this image.
   *
   * @return the width of the image in pixels
   */
  @Override
  public int getWidth() {
    return pixels[0].length;
  }

  /**
   * Returns the height of this image.
   *
   * @return the height of the image in pixels
   */
  @Override
  public int getHeight() {
    return pixels.length;
  }

  /**
   * Sets the pixel value at the specified (x, y) position.
   * Throws an IllegalArgumentException if the x and y
   * coordinates are outside the bounds of the image dimensions.
   *
   * @param x     the x-coordinate of the pixel to be set
   * @param y     the y-coordinate of the pixel to be set
   * @param pixel the new Pixel object to be placed at the specified position
   * @throws IllegalArgumentException if x or y coordinates are out of bounds
   */
  @Override
  public void setPixel(int x, int y, Pixel pixel) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException("Coordinates out of bounds!");
    }
    pixels[y][x] = pixel;
  }

  public Image horizontalFlip() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] hFlipPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        hFlipPixels[y][x] = this.getPixel(width - 1 - x, y);
      }
    }
    return new Image(hFlipPixels);
  }

  public Image verticalFlip() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] vFlipPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        vFlipPixels[y][x] = this.getPixel(x, height - 1 - y);
      }
    }
    return new Image(vFlipPixels);
  }

  public Image brighten(int increment) {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] brightenPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        int red = Math.min(Math.max(originalPixel.getRed() + increment, 0), 255);
        int green = Math.min(Math.max(originalPixel.getGreen() + increment, 0), 255);
        int blue = Math.min(Math.max(originalPixel.getBlue() + increment, 0), 255);
        brightenPixels[y][x] = new Pixel(red, green, blue);
      }
    }
    return new Image(brightenPixels);
  }

  private Image applyKernel(double[][] kernel) {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] newPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        double redSum = 0, greenSum = 0, blueSum = 0;
        int kernelRadius = kernel.length / 2;

        for (int i = -kernelRadius; i <= kernelRadius; i++) {
          for (int j = -kernelRadius; j <= kernelRadius; j++) {
            int kernelX = i + kernelRadius;
            int kernelY = j + kernelRadius;

            if (x + i >= 0 && x + i < width && y + j >= 0 && y + j < height) {
              Pixel neighboringPixel = this.getPixel(x + i, y + j);
              redSum += neighboringPixel.getRed() * kernel[kernelY][kernelX];
              greenSum += neighboringPixel.getGreen() * kernel[kernelY][kernelX];
              blueSum += neighboringPixel.getBlue() * kernel[kernelY][kernelX];
            }
          }
        }

        int newRed = Math.min(255, Math.max(0, (int) Math.round(redSum)));
        int newGreen = Math.min(255, Math.max(0, (int) Math.round(greenSum)));
        int newBlue = Math.min(255, Math.max(0, (int) Math.round(blueSum)));

        newPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return new Image(newPixels);
  }

  public Image blur() {
    double[][] blurKernel = {
            {1.0 / 16, 1.0 / 8, 1.0 / 16},
            {1.0 / 8, 1.0 / 4, 1.0 / 8},
            {1.0 / 16, 1.0 / 8, 1.0 / 16}
    };
    return applyKernel(blurKernel);
  }

  public Image sharpen() {
    double[][] sharpenKernel = {
            {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1, 1.0 / 4, -1.0 / 8},
            {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
            {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8}
    };
    return applyKernel(sharpenKernel);
  }

  public static Image combineColorChannels(Image redChannel, Image greenChannel
          , Image blueChannel) {
    int height = redChannel.getHeight();
    int width = redChannel.getWidth();
    Pixel[][] combinedPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int red = redChannel.getPixel(x, y).getRed();
        int green = greenChannel.getPixel(x, y).getGreen();
        int blue = blueChannel.getPixel(x, y).getBlue();

        combinedPixels[y][x] = new Pixel(red, green, blue);
      }
    }
    return new Image(combinedPixels);
  }

  public Image extractRedComponent() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] redPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        redPixels[y][x] = new Pixel(originalPixel.getRed(), 0, 0);
      }
    }
    return new Image(redPixels);
  }

  public Image extractGreenComponent() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] greenPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        greenPixels[y][x] = new Pixel(0, originalPixel.getGreen(), 0);
      }
    }
    return new Image(greenPixels);
  }

  public Image extractBlueComponent() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] bluePixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        bluePixels[y][x] = new Pixel(0, 0, originalPixel.getBlue());
      }
    }
    return new Image(bluePixels);
  }

  public Image toValueComponent() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] valuePixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        int maxValue = Math.max(Math.max(originalPixel.getRed(), originalPixel.getGreen())
                , originalPixel.getBlue());
        valuePixels[y][x] = new Pixel(maxValue, maxValue, maxValue);
      }
    }
    return new Image(valuePixels);
  }

  public Image toLumaComponent() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] lumaPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        int lumaValue = (int) Math.round(0.2126 * originalPixel.getRed()
                + 0.7152 * originalPixel.getGreen()
                + 0.0722 * originalPixel.getBlue());
        lumaPixels[y][x] = new Pixel(lumaValue, lumaValue, lumaValue);
      }
    }
    return new Image(lumaPixels);
  }

  public Image toIntensityComponent() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] intensityPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        int intensityValue = (originalPixel.getRed() + originalPixel.getGreen()
                + originalPixel.getBlue()) / 3;
        intensityPixels[y][x] = new Pixel(intensityValue, intensityValue, intensityValue);
      }
    }
    return new Image(intensityPixels);
  }

  public Image toSepia() {
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel[][] sepiaPixels = new Pixel[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = this.getPixel(x, y);
        int originalRed = originalPixel.getRed();
        int originalGreen = originalPixel.getGreen();
        int originalBlue = originalPixel.getBlue();

        int newRed = Math.min(255, (int) (0.393 * originalRed + 0.769 * originalGreen
                + 0.189 * originalBlue));
        int newGreen = Math.min(255, (int) (0.349 * originalRed + 0.686 * originalGreen
                + 0.168 * originalBlue));
        int newBlue = Math.min(255, (int) (0.272 * originalRed + 0.534 * originalGreen
                + 0.131 * originalBlue));
        sepiaPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return new Image(sepiaPixels);
  }

  public int[][] calculateHistograms() {
    int[] redHistogram = new int[256];
    int[] greenHistogram = new int[256];
    int[] blueHistogram = new int[256];

    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        Pixel pixel = getPixel(x, y);
        redHistogram[pixel.getRed()]++;
        greenHistogram[pixel.getGreen()]++;
        blueHistogram[pixel.getBlue()]++;
      }
    }
    return new int[][]{redHistogram, greenHistogram, blueHistogram};
  }

  public static int findMaxFrequency(int[]... histograms) {
    int max = 0;
    for (int[] histogram : histograms) {
      for (int freq : histogram) {
        max = Math.max(max, freq);
      }
    }
    return max;
  }

  public static void normalizeHistogram(int[] histogram, int maxFrequency) {
    for (int i = 0; i < histogram.length; i++) {
      histogram[i] = (histogram[i] * 255) / maxFrequency;
    }
  }

  public Image colorCorrect() {

    int[][] histograms = this.calculateHistograms();

    int[] redHistogram = histograms[0];
    int[] greenHistogram = histograms[1];
    int[] blueHistogram = histograms[2];

    int redPeak = findMeaningfulPeak(redHistogram);
    int greenPeak = findMeaningfulPeak(greenHistogram);
    int bluePeak = findMeaningfulPeak(blueHistogram);
    int averagePeak = (redPeak + greenPeak + bluePeak) / 3;

    return applyColorCorrection(redPeak, greenPeak, bluePeak, averagePeak);
  }

  private int findMeaningfulPeak(int[] histogram) {
    int peak = 0;
    int peakValue = 0;
    for (int i = 10; i < 245; i++) {
      if (histogram[i] > peak) {
        peak = histogram[i];
        peakValue = i;
      }
    }
    return peakValue;
  }

  private Image applyColorCorrection(int redPeak, int greenPeak, int bluePeak, int averagePeak) {
    Pixel[][] correctedPixels = new Pixel[this.getHeight()][this.getWidth()];
    int redOffset = averagePeak - redPeak;
    int greenOffset = averagePeak - greenPeak;
    int blueOffset = averagePeak - bluePeak;

    for (int y = 0; y < this.getHeight(); y++) {
      for (int x = 0; x < this.getWidth(); x++) {
        Pixel pixel = this.getPixel(x, y);
        int correctedRed = clamp(pixel.getRed() + redOffset);
        int correctedGreen = clamp(pixel.getGreen() + greenOffset);
        int correctedBlue = clamp(pixel.getBlue() + blueOffset);
        correctedPixels[y][x] = new Pixel(correctedRed, correctedGreen, correctedBlue);
      }
    }

    return new Image(correctedPixels);
  }

  private int clamp(int value) {
    return Math.max(0, Math.min(255, value));
  }

  public Image adjustLevels(int b, int m, int w) {
    if (b < 0 || b > 255 || m < 0 || m > 255 || w < 0 || w > 255) {
      throw new IllegalArgumentException("Level values must be between 0 and 255.");
    }

    if (!(b <= m && m <= w)) {
      throw new IllegalArgumentException("Level values must be in ascending order (b <= m <= w).");
    }

    Pixel[][] pixels = new Pixel[getHeight()][getWidth()];

    double A = b * b * (m - w) - b * (m * m - w * w) + w * m * m - m * w * w;
    double A_a = -b * (128 - 255) + 128 * w - 255 * m;
    double A_b = b * b * (128 - 255) + 255 * m * m - 128 * w * w;
    double A_c = b * b * (255 * m - 128 * w) - b * (255 * m * m - 128 * w * w);

    double a = A_a / A;
    double bb = A_b / A;
    double c = A_c / A;

    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        Pixel pixel = getPixel(x, y);

        int newRed = clamp((int) (a * pixel.getRed() * pixel.getRed()
                + bb * pixel.getRed() + c));
        int newGreen = clamp((int) (a * pixel.getGreen() * pixel.getGreen()
                + bb * pixel.getGreen() + c));
        int newBlue = clamp((int) (a * pixel.getBlue() * pixel.getBlue()
                + bb * pixel.getBlue() + c));

        pixels[y][x] = new Pixel(newRed, newGreen, newBlue);
      }
    }

    return new Image(pixels);
  }

  public Image applyFilter(FilterStrategy filterStrategy) {
    return filterStrategy.apply(this);
  }

}
