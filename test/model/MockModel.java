package model;

import java.io.IOException;
import java.util.Optional;

import model.image.Image;
import model.image.Pixel;

/**
 * Represents the mock model class for images, responsible for
 * managing and processing images.
 * Provides methods to extract color components, apply filters,
 * and perform various image processing operations.
 * Images are stored with a String identifier in a map.
 */
public class MockModel implements IImageModel {

  private final StringBuilder log = new StringBuilder();

  private final Image dummyImage;

  /**
   * Constructs a new mockModel instance. Initializes the log and creates a
   * dummy image with a single red pixel to be used as a return value for image
   * retrieval methods.
   */
  public MockModel() {
    Pixel[][] pixels = new Pixel[1][1];
    pixels[0][0] = new Pixel(255, 0, 0);
    dummyImage = new Image(pixels);
  }

  /**
   * Logs the call to add an image to the model.
   *
   * @param image     the image to be added
   * @param imagePath the path where the image is to be stored
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void addImage(Image image, String imagePath) throws IOException {
    log.append("Add Image method called.");
  }

  /**
   * Logs the call to retrieve an image from the model and returns a dummy image.
   *
   * @param imageName the name of the image to retrieve
   * @return a dummy {@code Image} object
   * @throws IOException if an I/O error occurs
   */
  @Override
  public Image getImage(String imageName) throws IOException {
    log.append("Get Image method called.");
    return dummyImage;
  }

  /**
   * Logs the call to extract the red color component from the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void redComponent(String imageName, String destImageName) throws IOException {
    log.append("Red Component method called.");
  }

  /**
   * Logs the extraction of the green color component from the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void greenComponent(String imageName, String destImageName) throws IOException {
    log.append("Green Component method called.");
  }

  /**
   * Logs the extraction of the blue color component from the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void blueComponent(String imageName, String destImageName) throws IOException {
    log.append("Blue Component method called.");
  }

  /**
   * Logs the extraction of the value component.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void valueComponent(String imageName, String destImageName) throws IOException {
    log.append("Value Component method called.");
  }

  /**
   * Logs the extraction of the luma component.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void lumaComponent(String imageName, String destImageName) throws IOException {
    log.append("Luma Component method called.");
  }

  /**
   * Logs the extraction of the intensity component.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void intensityComponent(String imageName, String destImageName) throws IOException {
    log.append("Intensity Component method called.");
  }

  @Override
  public void sepia(String imageName, String destImageName, Optional<Integer> splitPercentageOpt) throws IOException {

  }

  /**
   * Logs the operation to perform a horizontal flip on the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void horizontalFlip(String imageName, String destImageName) throws IOException {
    log.append("Horizontal Flip method called.");
  }

  /**
   * Logs the operation to brighten the specified image by a given increment.
   *
   * @param increment     the amount by which the brightness is to be increased
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void brightenCommand(int increment, String imageName,
                              String destImageName) throws IOException {
    log.append("Brighten method called.");
  }

  /**
   * Logs the operation to apply a blur effect to the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void blur(String imageName, String destImageName) throws IOException {
    log.append("Blur method called.");
  }

  /**
   * Logs the operation to apply a sharpening effect to the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void sharpen(String imageName, String destImageName) throws IOException {
    log.append("Sharpen method called.");
  }

  /**
   * Logs the operation to perform a vertical flip on the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void verticalFlip(String imageName, String destImageName) throws IOException {
    log.append("Vertical Flip method called.");
  }

  /**
   * Logs the operation to apply a sepia tone effect to the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void sepia(String imageName, String destImageName) {
    log.append("Sepia Component method called.");
  }

  /**
   * Logs the operation to split the RGB components of
   * the specified image into separate images.
   *
   * @param imageName          the name of the source image
   * @param destImageNameRed   the name of the destination
   *                           image for the red component
   * @param destImageNameGreen the name of the destination
   *                           image for the green component
   * @param destImageNameBlue  the name of the destination
   *                           image for the blue component
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void rgbSplit(String imageName, String destImageNameRed, String
          destImageNameGreen, String destImageNameBlue) throws IOException {
    log.append("RGB Split method called.");
  }

  /**
   * Logs the operation to combine separate red, green, and blue
   * images into a single image.
   *
   * @param redImageName   the name of the red component image
   * @param greenImageName the name of the green component image
   * @param blueImageName  the name of the blue component image
   * @param destImageName  the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void rgbCombine(String redImageName, String greenImageName,
                         String blueImageName, String destImageName) throws IOException {
    log.append("RGB Combine method called.");
  }

  /**
   * Logs the operation to generate a histogram representation of the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void histogram(String imageName, String destImageName) throws IOException {
    log.append("Histogram method called.");
  }

  /**
   * Logs the operation to perform color correction on the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void colorCorrect(String imageName, String destImageName) throws IOException {
    log.append("Color Correct method called.");
  }

  /**
   * Logs the operation to adjust the brightness levels of the specified image.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @param b             the black point value for level adjustment
   * @param m             the mid-point value for level adjustment
   * @param w             the white point value for level adjustment
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void adjustLevels(String imageName, String destImageName, int b, int m, int w) throws IOException {
    log.append("Adjust Levels method called.");
  }

  /**
   * Logs the operation to compress the specified image using a percentage.
   *
   * @param imageName     the name of the source image
   * @param destImageName the name of the destination image
   * @param percentage    the percentage by which the image will be compressed
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void compressImage(String imageName, String destImageName, int percentage) throws IOException {
    log.append("Compress method called.");
  }

  /**
   * Retrieves the accumulated log of operations performed by the mock model.
   *
   * @return a string representation of the log
   */
  public String getLog() {
    return log.toString();
  }
}
