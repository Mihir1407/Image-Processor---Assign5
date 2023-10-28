package Model;

import java.io.IOException;

public interface IImageModel {

  /**
   * Loads an image into the model.
   *
   * @param imageName The name assigned to the loaded image.
   * @param imagePath The path to the image.
   * @throws IOException If an error occurs during the reading process.
   */
  void loadImage(String imageName, String imagePath) throws IOException;

  /**
   * Saves the image to a specified location.
   *
   * @param imageName The name of the image to save.
   * @param savePath The path where the image should be saved.
   * @throws IOException If an error occurs during the saving process.
   */
  void saveImage(String imageName, String savePath) throws IOException;

  /**
   * Extracts the red component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the red component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void redComponent(String imageName, String destImageName) throws IOException;

}
