import org.junit.Test;

import java.io.File;
import java.io.IOException;

import controller.IImageFileParser;
import controller.PPMParser;
import model.image.Image;
import model.image.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test class for the PPMParser implementation of the
 * IImageFileParser interface.
 */
public class PPMParserTest {

  private final String testPath = "res/images/film_original.ppm";
  private final String outputPath = "res/images/film_output_ppm.ppm";

  /**
   * Test case for the loadImage() method of the PPMParser class.
   */
  @Test
  public void testLoad() {
    IImageFileParser parser = new PPMParser();
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
   * Test case for the saveImage() method of the PPMParser class.
   */
  @Test
  public void testSave() {
    IImageFileParser parser = new PPMParser();
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
   * Test case for the loadImage() method of the PPMParser class
   * when a non-existent file path is given.
   *
   * @throws IOException if filepath is incorrect
   */
  @Test(expected = IOException.class)
  public void testLoadImageWithNonExistentFile() throws IOException {
    IImageFileParser parser = new PPMParser();
    parser.loadImage("nonexistent_file.ppm");
  }

  /**
   * Test case for the saveImage() method of the PPMParser class
   * when a non-existent file path is given.
   *
   * @throws IOException if filepath is incorrect
   */
  @Test(expected = IOException.class)
  public void testSaveImageWithNullImage() throws IOException {
    IImageFileParser parser = new PPMParser();
    Image image = parser.loadImage(testPath);
    parser.saveImage("res/image/save_incorrect.ppm", image);
  }

}