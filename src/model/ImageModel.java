package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import model.image.Image;
import model.image.Pixel;
import model.strategy.FilterStrategy;
import model.strategy.SepiaFilterStrategy;
import model.strategy.SplitFilterDecorator;

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
   * Adds a new image into the model.
   *
   * @param image     The image to be added into the model.
   * @param imageName The name by which the image should be stored.
   * @throws IOException If the image to be added to the model is null.
   */

  @Override
  public void addImage(Image image, String imageName) throws IOException {
    if (image != null) {
      imageMap.put(imageName, image);
    } else {
      throw new IOException("Image not loaded.");
    }
  }

  /**
   * Retrieves an image with provided name from the model.
   *
   * @param imageName The name of the image to be retrieved.
   * @throws IOException If the image to be retrieved does not exist in the model.
   */
  @Override
  public Image getImage(String imageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      return image;
    } else {
      throw new IOException("Image not found.");
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
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image redComponentImage = image.extractRedComponent();
      imageMap.put(destImageName, redComponentImage);
    } else {
      throw new IOException("Image not found.");
    }
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
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image greenComponentImage = image.extractGreenComponent();
      imageMap.put(destImageName, greenComponentImage);
    } else {
      throw new IOException("Image not found.");
    }
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
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image blueComponentImage = image.extractBlueComponent();
      imageMap.put(destImageName, blueComponentImage);
    } else {
      throw new IOException("Image not found.");
    }
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
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image valueComponentImage = image.toValueComponent();
      imageMap.put(destImageName, valueComponentImage);
    } else {
      throw new IOException("Image not found.");
    }
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
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image lumaComponentImage = image.toLumaComponent();
      imageMap.put(destImageName, lumaComponentImage);
    } else {
      throw new IOException("Image not found.");
    }
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
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image intensityComponentImage = image.toIntensityComponent();
      imageMap.put(destImageName, intensityComponentImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Extracts the sepia component of the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void sepia(String imageName, String destImageName, Optional<Integer> splitPercentageOpt)
          throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy sepiaStrategy = new SepiaFilterStrategy();

      if (splitPercentageOpt.isPresent()) {
        sepiaStrategy = new SplitFilterDecorator(sepiaStrategy, splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(sepiaStrategy);
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void sepia(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image resultImage = image.toSepia();
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
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
      imageMap.put(destImageName, image.horizontalFlip());
    } else {
      throw new IOException("Image not found.");
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
      imageMap.put(destImageName, image.verticalFlip());
    } else {
      throw new IOException("Image not found.");
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
      imageMap.put(destImageName, image.brighten(increment));
    } else {
      throw new IOException("Image not found.");
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
      imageMap.put(destImageName, image.blur());
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Applies sharpening effect on the image.
   *
   * @param imageName     The name of the image.
   * @param destImageName The path where the intensity component
   *                      image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void sharpen(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      imageMap.put(destImageName, image.sharpen());
    } else {
      throw new IOException("Image not found.");
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
      imageMap.put(destImageNameRed, image.extractRedComponent());
      imageMap.put(destImageNameGreen, image.extractGreenComponent());
      imageMap.put(destImageNameBlue, image.extractBlueComponent());
    } else {
      throw new IOException("Image not found.");
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
  public void rgbCombine(String destImageName, String redImageName,
                         String greenImageName, String blueImageName) throws IOException {
    Image redImage = imageMap.get(redImageName);
    Image greenImage = imageMap.get(greenImageName);
    Image blueImage = imageMap.get(blueImageName);
    if (redImage != null && greenImage != null && blueImage != null) {
      Image combinedImage = Image.combineColorChannels(redImage, greenImage, blueImage);
      imageMap.put(destImageName, combinedImage);
    } else {
      throw new IOException("One or more source images not found.");
    }
  }

  @Override
  public void histogram(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image == null) {
      throw new IOException("Image not found.");
    } else {
      Image histogramImage = image.histogram();
      imageMap.put(destImageName, histogramImage);
    }
  }

  @Override
  public void colorCorrect(String imageName, String destImageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image correctedImage = image.colorCorrect();
      imageMap.put(destImageName, correctedImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  @Override
  public void adjustLevels(String imageName, String destImageName, int b, int m, int w)
          throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      Image adjustedImage = image.adjustLevels(b, m, w);
      imageMap.put(destImageName, adjustedImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Compression functions.
   */
  @Override
  public void compressImage(String imageName, String destImageName, int percentage) throws IOException {
    if (percentage < 0 || percentage > 100) {
      throw new IllegalArgumentException("Percentage value should be between 0 and 100.");
    }
    Image image = imageMap.get(imageName);
    if (image != null) {

      int width = image.getWidth();
      int height = image.getHeight();

      double[][] redChannel = new double[height][width];
      double[][] greenChannel = new double[height][width];
      double[][] blueChannel = new double[height][width];

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          Pixel pixel = image.getPixel(x, y);
          redChannel[y][x] = pixel.getRed();
          greenChannel[y][x] = pixel.getGreen();
          blueChannel[y][x] = pixel.getBlue();
        }
      }
      redChannel = HaarWaveletTransform.transpose(redChannel);
      greenChannel = HaarWaveletTransform.transpose(greenChannel);
      blueChannel = HaarWaveletTransform.transpose(blueChannel);

      redChannel = HaarWaveletTransform.haar(redChannel);
      greenChannel = HaarWaveletTransform.haar(greenChannel);
      blueChannel = HaarWaveletTransform.haar(blueChannel);

      double threshold = HaarWaveletTransform.calThreshold(redChannel, greenChannel, blueChannel, percentage);
      redChannel = HaarWaveletTransform.truncate(redChannel, threshold);
      greenChannel = HaarWaveletTransform.truncate(greenChannel, threshold);
      blueChannel = HaarWaveletTransform.truncate(blueChannel, threshold);

      redChannel = HaarWaveletTransform.invHaar(redChannel, width, height);
      greenChannel = HaarWaveletTransform.invHaar(greenChannel, width, height);
      blueChannel = HaarWaveletTransform.invHaar(blueChannel, width, height);

      redChannel = HaarWaveletTransform.transpose(redChannel);
      greenChannel = HaarWaveletTransform.transpose(greenChannel);
      blueChannel = HaarWaveletTransform.transpose(blueChannel);

      Pixel[][] compressedPixels = new Pixel[height][width];
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          int red = (int) Math.round(Math.max(0, Math.min(255, redChannel[y][x])));
          int green = (int) Math.round(Math.max(0, Math.min(255, greenChannel[y][x])));
          int blue = (int) Math.round(Math.max(0, Math.min(255, blueChannel[y][x])));
          compressedPixels[y][x] = new Pixel(red, green, blue);
        }
      }
      Image compressedImage = new Image(compressedPixels);
      imageMap.put(destImageName, compressedImage);
    } else {
      throw new IOException("Image not found.");
    }
  }
}
