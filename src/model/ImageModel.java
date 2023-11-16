package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import model.image.Image;
import model.strategy.AdjustLevelsFilterStrategy;
import model.strategy.BlurFilterStrategy;
import model.strategy.ColorCorrectFilterStrategy;
import model.strategy.FilterStrategy;
import model.strategy.IntensityFilterStrategy;
import model.strategy.LumaFilterStrategy;
import model.strategy.SepiaFilterStrategy;
import model.strategy.SharpenFilterStrategy;
import model.strategy.SplitFilterDecorator;
import model.strategy.ValueFilterStrategy;

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
   * @param imageName          The name of the image.
   * @param destImageName      The path where the green component image should be saved.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void valueComponent(String imageName, String destImageName,
                             Optional<Double> splitPercentageOpt) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy valueStrategy = new ValueFilterStrategy();

      if (splitPercentageOpt.isPresent()) {
        valueStrategy = new SplitFilterDecorator(valueStrategy, splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(valueStrategy);
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Extracts the luma component of the image.
   *
   * @param imageName          The name of the image.
   * @param destImageName      The path where the green component image should be saved.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void lumaComponent(String imageName, String destImageName,
                            Optional<Double> splitPercentageOpt) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy lumaStrategy = new LumaFilterStrategy();

      if (splitPercentageOpt.isPresent()) {
        lumaStrategy = new SplitFilterDecorator(lumaStrategy, splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(lumaStrategy);
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Extracts the intensity component of the image.
   *
   * @param imageName          The name of the image.
   * @param destImageName      The path where the green component image should be saved.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void intensityComponent(String imageName, String destImageName,
                                 Optional<Double> splitPercentageOpt) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy intensityStrategy = new IntensityFilterStrategy();

      if (splitPercentageOpt.isPresent()) {
        intensityStrategy = new SplitFilterDecorator(intensityStrategy, splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(intensityStrategy);
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Extracts the sepia version of the image.
   *
   * @param imageName          The name of the image.
   * @param destImageName      The path where the sepia image should be saved.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void sepia(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
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
  public void brightenCommand(int increment, String imageName, String destImageName)
          throws IOException {
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
   * @param imageName          The name of the image.
   * @param destImageName      The path where the intensity component image should be saved.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void blur(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
          throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy blurStrategy = new BlurFilterStrategy();

      if (splitPercentageOpt.isPresent()) {
        blurStrategy = new SplitFilterDecorator(blurStrategy, splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(blurStrategy);
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Applies sharpening effect on the image.
   *
   * @param imageName          The name of the image.
   * @param destImageName      The path where the intensity component
   *                           image should be saved.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If an error occurs during the process.
   */
  @Override
  public void sharpen(String imageName, String destImageName,
                      Optional<Double> splitPercentageOpt) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy sharpenStrategy = new SharpenFilterStrategy();

      if (splitPercentageOpt.isPresent()) {
        sharpenStrategy = new SplitFilterDecorator(sharpenStrategy, splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(sharpenStrategy);
      imageMap.put(destImageName, resultImage);
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

  /**
   * Generates a histogram for the specified image and saves it as a new image.
   *
   * @param imageName The name of the source image.
   * @return A two-dimensional array representing the histograms of the red, green, and blue
   * color channels.
   * Each channel's histogram is an integer array with 256 values.
   * Index 0 to 255 of each array corresponds to the frequency of color intensity at that
   * level.
   * @throws IOException If the specified image is not found in the image map.
   */
  @Override
  public int[][] histogram(String imageName) throws IOException {
    Image image = imageMap.get(imageName);
    if (image == null) {
      throw new IOException("Image not found.");
    } else {
      int[][] histograms = image.calculateHistograms();
      return histograms;
    }
  }

  /**
   * Applies color correction to the specified image and saves the result as a new image.
   *
   * @param imageName          The name of the source image to apply color correction to.
   * @param destImageName      The name under which the color-corrected image will be saved.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If the specified image is not found in the image map.
   */
  @Override
  public void colorCorrect(String imageName, String destImageName,
                           Optional<Double> splitPercentageOpt) throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy colorCorrectStrategy = new ColorCorrectFilterStrategy();

      if (splitPercentageOpt.isPresent()) {
        colorCorrectStrategy = new SplitFilterDecorator(colorCorrectStrategy,
                splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(colorCorrectStrategy);
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Adjusts the levels of the specified image and saves the result as a new image.
   *
   * @param imageName          The name of the source image to adjust levels for.
   * @param destImageName      The name under which the adjusted image will be saved.
   * @param b                  The black point value for level adjustment.
   * @param m                  The mid point value for level adjustment.
   * @param w                  The white point value for level adjustment.
   * @param splitPercentageOpt an optional split percentage for value extraction
   * @throws IOException If the specified image is not found in the image map.
   */
  @Override
  public void adjustLevels(String imageName, String destImageName, int b, int m, int w,
                           Optional<Double> splitPercentageOpt)
          throws IOException {
    Image image = imageMap.get(imageName);
    if (image != null) {
      FilterStrategy adjustLevelsStrategy = new AdjustLevelsFilterStrategy(b, m, w);

      if (splitPercentageOpt.isPresent()) {
        adjustLevelsStrategy = new SplitFilterDecorator(adjustLevelsStrategy,
                splitPercentageOpt.get());
      }

      Image resultImage = image.applyFilter(adjustLevelsStrategy);
      imageMap.put(destImageName, resultImage);
    } else {
      throw new IOException("Image not found.");
    }
  }

  /**
   * Compresses the specified image by a percentage using the Haar Wavelet Transform
   * and saves the result as a new image.
   *
   * @param imageName     The name of the source image to compress.
   * @param destImageName The name under which the compressed image will be saved.
   * @param percentage    The percentage by which the image is to be compressed.
   * @throws IOException If the specified image is not found in the image map.
   */
  @Override
  public void compressImage(String imageName, String destImageName, int percentage)
          throws IOException {
    if (percentage < 0 || percentage > 100) {
      throw new IllegalArgumentException("Percentage must be between 0 and 100.");
    }
    Image image = imageMap.get(imageName);
    if (image == null) {
      throw new IOException("Image not found.");
    }
    Image compressedImage = image.compress(percentage);
    imageMap.put(destImageName, compressedImage);
  }
}
