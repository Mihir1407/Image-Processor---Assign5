package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.image.Image;
import model.image.Pixel;

/**
 * Represents the model class for images, responsible for
 * managing and processing images.
 * Provides methods to extract color components, apply filters,
 * and perform various image processing operations.
 * Images are stored with a String identifier in a map.
 */
public class ImageModel implements IImageModel {

  private final Map<String, Image> imageMap;

  /**
   * Constructs a new instance of the ImageModel.
   * Initializes an empty map to store images.
   */
  public ImageModel() {
    this.imageMap = new HashMap<>();
  }

  /**
   * Processes an image based on a given command and returns the processed image.
   * The method retrieves the image from the map using the provided imageName,
   * then applies operation based on the command.
   * Supported commands include: "red", "green", "blue", "value", "luma",
   * "intensity", and "sepia".
   *
   * @param imageName The name or identifier of the image to be processed.
   * @param command   The image processing operation to apply.
   * @return The processed image.
   * @throws IOException If the image with the provided imageName is not found in the map.
   */
  private Image processImage(String imageName, String command) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      Pixel[][] processedPixels = new Pixel[height][width];
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          Pixel originalPixel = image.getPixel(x, y);
          switch (command) {
            case "red":
              processedPixels[y][x] = new Pixel(originalPixel.getRed(), 0, 0);
              break;
            case "green":
              processedPixels[y][x] = new Pixel(0, originalPixel.getGreen(), 0);
              break;
            case "blue":
              processedPixels[y][x] = new Pixel(0, 0, originalPixel.getBlue());
              break;
            case "value":
              int maxPixelVal = Math.max(originalPixel.getRed(),
                      Math.max(originalPixel.getGreen(), originalPixel.getBlue()));
              processedPixels[y][x] = new Pixel(maxPixelVal, maxPixelVal, maxPixelVal);
              break;
            case "luma":
              int lumaPixelVal = (int) (0.2126 * originalPixel.getRed()
                      + 0.7152 * originalPixel.getGreen() + 0.0722 * originalPixel.getBlue());
              processedPixels[y][x] = new Pixel(lumaPixelVal, lumaPixelVal, lumaPixelVal);
              break;
            case "intensity":
              int intensityPixelVal = ((originalPixel.getRed() + originalPixel.getGreen()
                      + originalPixel.getBlue()) / 3);
              processedPixels[y][x] = new Pixel(intensityPixelVal,
                      intensityPixelVal, intensityPixelVal);
              break;
            case "sepia":
              int originalRed = originalPixel.getRed();
              int originalGreen = originalPixel.getGreen();
              int originalBlue = originalPixel.getBlue();

              int newRed = Math.min(255, (int) (0.393 * originalRed
                      + 0.769 * originalGreen + 0.189 * originalBlue));
              int newGreen = Math.min(255, (int) (0.349 * originalRed
                      + 0.686 * originalGreen + 0.168 * originalBlue));
              int newBlue = Math.min(255, (int) (0.272 * originalRed
                      + 0.534 * originalGreen + 0.131 * originalBlue));

              processedPixels[y][x] = new Pixel(newRed, newGreen, newBlue);
              break;
          }
        }
      }
      return new Image(processedPixels);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Loads an image into the model.
   *
   * @param image     The name assigned to the loaded image.
   * @param imageName The path to the image.
   * @throws IOException If an error occurs during the reading process.
   */

  @Override
  public void addImage(Image image, String imageName) throws IOException {
    if (image != null) {
      imageMap.put(imageName, image);
    } else {
      throw new IOException("Model.Image not loaded.");
    }
  }

  /**
   * Saves the image to a specified location.
   *
   * @param imageName The name of the image to save.
   * @throws IOException If an error occurs during the saving process.
   */
  @Override
  public Image getImage(String imageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      return image;
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Extracts the red component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the red component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void redComponent(String imageName, String destImageName) throws IOException {
    imageMap.put(destImageName, processImage(imageName, "red"));
  }

  /**
   * Extracts the green component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the green component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void greenComponent(String imageName, String destImageName) throws IOException {
    imageMap.put(destImageName, processImage(imageName, "green"));
  }

  /**
   * Extracts the blue component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the green component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void blueComponent(String imageName, String destImageName) throws IOException {
    imageMap.put(destImageName, processImage(imageName, "blue"));
  }

  /**
   * Extracts the value component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the green component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void valueComponent(String imageName, String destImageName) throws IOException {
    imageMap.put(destImageName, processImage(imageName, "value"));
  }

  /**
   * Extracts the luma component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the green component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void lumaComponent(String imageName, String destImageName) throws IOException {
    imageMap.put(destImageName, processImage(imageName, "luma"));
  }

  /**
   * Extracts the intensity component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the green component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void intensityComponent(String imageName, String destImageName) throws IOException {
    imageMap.put(destImageName, processImage(imageName, "intensity"));
  }

  /**
   * Extracts the sepia component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void sepia(String imageName, String destImageName) throws IOException {
    imageMap.put(destImageName, processImage(imageName, "sepia"));
  }

  /**
   * Applies horizontal flip effect on the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void horizontalFlip(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      Pixel[][] hFlipPixels = new Pixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          hFlipPixels[y][x] = image.getPixel(width - 1 - x, y);
        }
      }
      Image hFlipComponentImage = new Image(hFlipPixels);
      imageMap.put(destImageName, hFlipComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Applies vertical flip effect on the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void verticalFlip(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      Pixel[][] vFlipPixels = new Pixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          vFlipPixels[y][x] = image.getPixel(x, height - 1 - y);
        }
      }
      Image vFlipComponentImage = new Image(vFlipPixels);
      imageMap.put(destImageName, vFlipComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Applies brightening(increment/decrement) effect on the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void brightenCommand(int increment, String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      Pixel[][] brightenPixels = new Pixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          Pixel originalPixel = image.getPixel(x, y);
          int red = originalPixel.getRed() + increment > 255 ? 255 :
                  Math.max(originalPixel.getRed() + increment, 0);
          int green = originalPixel.getGreen() + increment > 255 ? 255 :
                  Math.max(originalPixel.getGreen() + increment, 0);
          int blue = originalPixel.getBlue() + increment > 255 ? 255 :
                  Math.max(originalPixel.getBlue() + increment, 0);
          brightenPixels[y][x] = new Pixel(red, green, blue);
        }
      }
      Image brightenComponentImage = new Image(brightenPixels);
      imageMap.put(destImageName, brightenComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Applies blur effect on the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void blur(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      Pixel[][] blurredPixels = new Pixel[height][width];

      double[][] kernel = {
              {1.0 / 16, 1.0 / 8, 1.0 / 16},
              {1.0 / 8, 1.0 / 4, 1.0 / 8},
              {1.0 / 16, 1.0 / 8, 1.0 / 16}
      };

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          double redSum = 0;
          double greenSum = 0;
          double blueSum = 0;

          for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

              if (x + i < 0 || x + i >= width || y + j < 0 || y + j >= height) continue;

              Pixel neighboringPixel = image.getPixel(x + i, y + j);
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
      Image blurredComponentImage = new Image(blurredPixels);
      imageMap.put(destImageName, blurredComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Applies sharpening effect on the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void sharpen(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      int height = image.getHeight();
      int width = image.getWidth();
      Pixel[][] sharpenedPixels = new Pixel[height][width];

      double[][] kernel = {
              {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
              {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
              {-1.0 / 8, 1.0 / 4, 1, 1.0 / 4, -1.0 / 8},
              {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
              {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8}
      };

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          double redSum = 0;
          double greenSum = 0;
          double blueSum = 0;

          for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {

              if (x + i < 0 || x + i >= width || y + j < 0 || y + j >= height) continue;

              Pixel neighboringPixel = image.getPixel(x + i, y + j);
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
      Image sharpenedComponentImage = new Image(sharpenedPixels);
      imageMap.put(destImageName, sharpenedComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Splits the RGB components of an image into three separate images
   * Red, Green, and Blue channels.
   *
   * @param imageName          The name of the source image to be split.
   * @param destImageNameRed   The name of the destination image for the Red channel.
   * @param destImageNameGreen The name of the destination image for the Green channel.
   * @param destImageNameBlue  The name of the destination image for the Blue channel.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen,
                       String destImageNameBlue) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      redComponent(imageName, destImageNameRed);
      blueComponent(imageName, destImageNameBlue);
      greenComponent(imageName, destImageNameGreen);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }

  /**
   * Combines three images representing the Red, Green, and Blue channels
   * into a single RGB image.
   *
   * @param redImageName   The name of the source image for the Red channel.
   * @param greenImageName The name of the source image for the Green channel.
   * @param blueImageName  The name of the source image for the Blue channel.
   * @param destImageName  The name of the combined destination RGB image.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void rgbCombine(String destImageName, String redImageName, String greenImageName, String blueImageName) throws IOException {
    Image redImage = imageMap.get(redImageName);
    Image greenImage = imageMap.get(greenImageName);
    Image blueImage = imageMap.get(blueImageName);
    if (redImage != null || greenImage != null || blueImage != null) {
      int height = blueImage.getHeight();
      int width = blueImage.getWidth();
      Pixel[][] combinePixels = new Pixel[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          int red = redImage.getPixel(x, y).getRed();
          int green = greenImage.getPixel(x, y).getGreen();
          int blue = blueImage.getPixel(x, y).getBlue();

          combinePixels[y][x] = new Pixel(red, green, blue);
        }
      }
      Image combineComponentImage = new Image(combinePixels);
      imageMap.put(destImageName, combineComponentImage);
    } else {
      throw new IOException("Model.Image not found.");
    }
  }
}
