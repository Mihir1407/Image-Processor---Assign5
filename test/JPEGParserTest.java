import org.junit.Test;

import java.io.File;
import java.io.IOException;

import controller.IImageFileParser;
import controller.JPEGParser;
import model.image.Image;
import model.image.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test class for the JPEGParser implementation of the
 * IImageFileParser interface.
 */
public class JPEGParserTest {

  private final String testPath = "res/images/film_original.jpeg";
  private final String outputPath = "res/images/film_output_jpeg.jpeg";

  /**
   * Test case for the loadImage() method of the JPEGParser class.
   */
  @Test
  public void testLoad() {
    IImageFileParser parser = new JPEGParser();
    try {
      Image image = parser.loadImage(testPath);
      assertNotNull(image);
      assertTrue(image.getHeight() > 0);
      assertTrue(image.getWidth() > 0);
      Pixel pixel = image.getPixel(0, 0);
      assertNotNull(pixel);
    } catch (IOException e) {
      fail("Should not throw exception while loading image");
    }
  }

  /**
   * Test case for the saveImage() method of the JPEGParser class.
   */
  @Test
  public void testSave() {
    IImageFileParser parser = new JPEGParser();
    try {
      Image image = parser.loadImage(testPath);
      parser.saveImage(outputPath, image);

      File outputFile = new File(outputPath);
      assertTrue(outputFile.exists());

      Image savedImage = parser.loadImage(outputPath);
      assertEquals(image.getHeight(), savedImage.getHeight());
      assertEquals(image.getWidth(), savedImage.getWidth());


    } catch (IOException e) {
      fail("Should not throw exception while saving/loading image");
    }
  }

  /**
   * Test case for the loadImage() method of the JPEGParser class
   * when a non-existent file path is given.
   *
   * @throws IOException if filepath is incorrect
   */
  @Test(expected = IOException.class)
  public void testLoadImageWithNonExistentFile() throws IOException {
    IImageFileParser parser = new JPEGParser();
    parser.loadImage("nonexistent_file.jpeg");
  }

  /**
   * Test case for the saveImage() method of the JPEGParser class
   * when a non-existent file path is given.
   *
   * @throws IOException if filepath is incorrect
   */
  @Test(expected = IOException.class)
  public void testSaveImageWithNullImage() throws IOException {
    IImageFileParser parser = new JPEGParser();
    Image image = parser.loadImage(testPath);
    parser.saveImage("res/image/save_incorrect.jpeg", image);
  }

}