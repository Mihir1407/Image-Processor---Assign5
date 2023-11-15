package model;

import java.io.IOException;
import java.util.Optional;

import model.image.Image;

/**
 * Represents an interface for image processing operations.
 * This interface provides methods for loading, saving, and
 * applying various transformations and effects on images.
 */
public interface IImageModel {

  /**
   * Loads an image into the model.
   *
   * @param image     The name assigned to the loaded image.
   * @param imagePath The path to the image.
   * @throws IOException If an error occurs during the reading process.
   */
  void addImage(Image image, String imagePath) throws IOException;

  /**
   * Saves the image to a specified location.
   *
   * @param imageName The name of the image to save.
   * @throws IOException If an error occurs during the saving process.
   */
  Image getImage(String imageName) throws IOException;

  void redComponent(String imageName, String destImageName) throws IOException;

  void greenComponent(String imageName, String destImageName) throws IOException;

  void blueComponent(String imageName, String destImageName) throws IOException;

  void valueComponent(String imageName, String destImageName) throws IOException;

  void lumaComponent(String imageName, String destImageName) throws IOException;

  void intensityComponent(String imageName, String destImageName) throws IOException;

  void sepia(String imageName, String destImageName, Optional<Integer> splitPercentageOpt)
          throws IOException;

  void sepia(String imageName, String destImageName) throws IOException;


  void horizontalFlip(String imageName, String destImageName) throws IOException;

  void verticalFlip(String imageName, String destImageName) throws IOException;

  void brightenCommand(int increment, String imageName, String destImageName) throws IOException;

  void blur(String imageName, String destImageName) throws IOException;

  void sharpen(String imageName, String destImageName) throws IOException;

  void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen,
                String destImageNameBlue) throws IOException;

  void rgbCombine(String destImageName, String redImageName,
                  String greenImageName, String blueImageName) throws IOException;

  void histogram(String imageName, String destImageName) throws IOException;

  void colorCorrect(String imageName, String destImageName) throws IOException;

  void adjustLevels(String imageName, String destImageName, int b, int m, int w) throws IOException;

  void compressImage(String imageName, String destImageName, int percentage) throws IOException;
}
