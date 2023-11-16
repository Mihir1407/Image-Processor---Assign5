import org.junit.After;
import org.junit.Test;

import model.HaarWaveletTransform;

import static org.junit.Assert.*;

/**
 * Test class for HaarWaveletTransform class to test all its methods.
 */
public class HaarWaveletTransformTest {

  private HaarWaveletTransform hwt;

  /**
   * Tests the haar method for a 2x2 matrix.
   */
  @Test
  public void testHaarTransform() {
    hwt = new HaarWaveletTransform();
    double[][] input = {
            {1.0, 2.0},
            {3.0, 4.0}
    };
    double[][] expected = {
            {5.0, -1.0},
            {-2.0, 0.0}
    };

    double[][] result = hwt.haar(input);

    for (int i = 0; i < expected.length; i++) {
      assertArrayEquals(expected[i], result[i], 0.001);
    }
  }

  /**
   * Tests the inverse haar method for a 2x2 matrix.
   */
  @Test
  public void testInvHaarTransform() {
    hwt = new HaarWaveletTransform();
    double[][] transformed = {
            {5.0, -1.0},
            {-2.0, 0.0}
    };

    double[][] expected = {
            {1.0, 2.0},
            {3.0, 4.0}
    };

    double[][] result = hwt.invHaar(transformed, expected.length, expected[0].length);

    for (int i = 0; i < expected.length; i++) {
      assertArrayEquals(expected[i], result[i], 0.001);
    }
  }

  /**
   * Tests the haar method for a 4x2 matrix.
   */
  @Test
  public void testHaarTransform4x2() {
    hwt = new HaarWaveletTransform();
    double[][] input = {
            {1.0, 2.0, 3.0, 4.0},
            {5.0, 6.0, 7.0, 8.0}
    };

    double[][] expected = {
            {7.0, 11.0, -0.71, -0.71},
            {0.0, 0.0, -0.71, -0.71},
            {-5.66, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0}
    };

    double[][] result = hwt.haar(input);

    for (int i = 0; i < expected.length; i++) {
      assertArrayEquals(expected[i], result[i], 0.001);
    }
  }

  /**
   * Tests the inverse haar method for a 4x2 matrix.
   */
  @Test
  public void testInvHaarTransform4x2() {
    hwt = new HaarWaveletTransform();
    double[][] transformed = {
            {7.0, 11.0, -0.71, -0.71},
            {0.0, 0.0, -0.71, -0.71},
            {-5.66, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0}
    };

    double[][] expected = {
            {1.0, 2.0, 3.0, 4.0},
            {5.0, 6.0, 7.0, 8.0}
    };

    double[][] result = hwt.invHaar(transformed, expected.length, expected[0].length);

    for (int i = 0; i < expected.length; i++) {
      assertArrayEquals(expected[i], result[i], 0.001);
    }
  }

  /**
   * Tests the calculate threshold method for the given three channels.
   */
  @Test
  public void testCalThreshold() {
    hwt = new HaarWaveletTransform();

    double[][] redChannel = {
            {1.0, -2.0},
            {3.0, -4.0}
    };
    double[][] greenChannel = {
            {-1.0, 2.0},
            {-3.0, 4.0}
    };
    double[][] blueChannel = {
            {0.5, -0.5},
            {1.5, -1.5}
    };

    double actual50PercentThreshold = hwt.calThreshold(redChannel, greenChannel, blueChannel, 50.0);
    double actual80PercentThreshold = hwt.calThreshold(redChannel, greenChannel, blueChannel, 80.0);

    double expected50PercentThreshold = 2.0;
    double expected80PercentThreshold = 3.0;

    assertEquals(expected50PercentThreshold, actual50PercentThreshold, 0.001);
    assertEquals(expected80PercentThreshold, actual80PercentThreshold, 0.001);
  }
}