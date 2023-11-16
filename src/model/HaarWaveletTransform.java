package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides methods to perform the Haar Wavelet Transform and its inverse on image data.
 * It includes utility methods for padding, truncating, and threshold calculations.
 */
public class HaarWaveletTransform {

  /**
   * Calculates the average and difference of adjacent pairs in the list.
   *
   * @param s The input list of Double values.
   * @return A list of transformed values containing averages and differences.
   */
  private List<Double> avgAndDiff(List<Double> s) {
    List<Double> average = new ArrayList<>();
    List<Double> difference = new ArrayList<>();
    double sqrtTwo = Math.sqrt(2);
    for (int i = 0; i < s.size(); i += 2) {
      double first = s.get(i);
      double second = (i + 1 < s.size()) ? s.get(i + 1) : 0;
      double roundedAvg = Math.round(((first + second) / sqrtTwo) * 100.0) / 100.0;
      double roundedDiff = Math.round(((first - second) / sqrtTwo) * 100.0) / 100.0;
      average.add(roundedAvg);
      difference.add(roundedDiff);
    }
    average.addAll(difference);
    return average;
  }

  /**
   * Performs the inverse operation of avgAndDiff to reconstruct the original list of values.
   *
   * @param s The list of transformed values containing averages and differences.
   * @return The original list of Double values before the transformation.
   */
  private List<Double> invAvgAndDiff(List<Double> s) {
    List<Double> originalSequence = new ArrayList<>();
    int halfSize = s.size() / 2;
    double sqrtTwo = Math.sqrt(2);
    for (int i = 0; i < halfSize; i++) {
      double first = s.get(i);
      double second = s.get(i + halfSize);
      double roundedAvg = Math.round(((first + second) / sqrtTwo) * 100.0) / 100.0;
      double roundedDiff = Math.round(((first - second) / sqrtTwo) * 100.0) / 100.0;
      originalSequence.add(roundedAvg);
      originalSequence.add(roundedDiff);
    }
    return originalSequence;
  }

  /**
   * Pads the input 2D array with zeros to make it a square matrix in powers of two.
   *
   * @param X The original 2D array of doubles.
   * @return A new padded 2D array with dimensions that are powers of two.
   */
  private double[][] padArr(double[][] X) {
    int width = X.length;
    int height = X[0].length;
    int newDim = powerOfTwo(Math.max(width, height));
    double[][] paddedArray = new double[newDim][newDim];
    for (int i = 0; i < width; i++) {
      System.arraycopy(X[i], 0, paddedArray[i], 0, height);
    }
    return paddedArray;
  }

  /**
   * Finds the next power of two greater than or equal to the given number.
   *
   * @param number The number to find the next power of two for.
   * @return The next power of two.
   */
  private static int powerOfTwo(int number) {
    int power = 1;
    while (power < number) {
      power = power << 1;
    }
    return power;
  }

  /**
   * Removes padding from the array to get back to the original dimensions.
   * This method is typically used after the inverse Haar transform.
   *
   * @param X              The padded 2D array.
   * @param originalWidth  The width of the original array before padding.
   * @param originalHeight The height of the original array before padding.
   * @return The 2D array with padding removed.
   */
  private double[][] unpadArr(double[][] X, int originalWidth, int originalHeight) {
    double[][] unpaddedArray = new double[originalWidth][originalHeight];
    for (int i = 0; i < originalWidth; i++) {
      System.arraycopy(X[i], 0, unpaddedArray[i], 0, originalHeight);
    }
    return unpaddedArray;
  }

  /**
   * Applies the Haar Wavelet Transform to a given list of values.
   * The transformation is applied recursively, breaking down the list
   * into smaller parts and applying the avgAndDiff method.
   *
   * @param s The list of Double values to be transformed.
   * @param l The length of the part of the list to be transformed.
   * @return The list of transformed values.
   */
  private List<Double> transform(List<Double> s, int l) {
    List<Double> transformedSequence = new ArrayList<>(s);
    int m = l;
    while (m > 1) {
      List<Double> temp = avgAndDiff(transformedSequence.subList(0, m));
      for (int i = 0; i < m; i++) {
        transformedSequence.set(i, temp.get(i));
      }
      m /= 2;
    }
    return transformedSequence;
  }

  /**
   * Applies the inverse Haar Wavelet Transform to reconstruct the original list
   * from the transformed values.
   *
   * @param transformedSequence The list of transformed values.
   * @param l                   The length of the part of the list to be reverted.
   * @return The original list of values before transformation.
   */
  private List<Double> invert(List<Double> transformedSequence, int l) {
    List<Double> originalSequence = new ArrayList<>(transformedSequence);
    int m = 2;
    while (m <= l) {
      List<Double> temp = invAvgAndDiff(originalSequence.subList(0, m));
      for (int i = 0; i < m; i++) {
        originalSequence.set(i, temp.get(i));
      }
      m *= 2;
    }
    return originalSequence;
  }

  /**
   * Performs the Haar Wavelet Transform on a 2D matrix.
   *
   * @param mat The 2D matrix of doubles to be transformed.
   * @return The transformed 2D matrix.
   */
  public double[][] haar(double[][] mat) {
    mat = padArr(mat);
    int currentLen = mat.length;
    while (currentLen > 1) {
      for (int i = 0; i < currentLen; i++) {
        List<Double> row = new ArrayList<>();
        for (int j = 0; j < currentLen; j++) {
          row.add(mat[i][j]);
        }
        List<Double> transformedRow = transform(row, currentLen);
        for (int j = 0; j < currentLen; j++) {
          mat[i][j] = transformedRow.get(j);
        }
      }
      for (int j = 0; j < currentLen; j++) {
        List<Double> col = new ArrayList<>();
        for (int i = 0; i < currentLen; i++) {
          col.add(mat[i][j]);
        }
        List<Double> transformedCol = transform(col, currentLen);
        for (int i = 0; i < currentLen; i++) {
          mat[i][j] = transformedCol.get(i);
        }
      }
      currentLen = currentLen / 2;
    }
    return mat;
  }

  /**
   * Reverts the Haar Wavelet Transform on a 2D matrix to its original state.
   *
   * @param mat            The 2D matrix of transformed values.
   * @param originalWidth  The original width of the matrix before padding and transformation.
   * @param originalHeight The original height of the matrix before padding and transformation.
   * @return The original 2D matrix before any transformations.
   */
  public double[][] invHaar(double[][] mat, int originalWidth, int originalHeight) {
    int c = 2;
    int s = mat.length;
    while (c <= s) {
      for (int j = 0; j < c; j++) {
        List<Double> col = new ArrayList<>();
        for (int i = 0; i < c; i++) {
          col.add(mat[i][j]);
        }
        List<Double> invertedCol = invert(col, c);
        for (int i = 0; i < c; i++) {
          mat[i][j] = invertedCol.get(i);
        }
      }
      for (int i = 0; i < c; i++) {
        List<Double> row = new ArrayList<>();
        for (int j = 0; j < c; j++) {
          row.add(mat[i][j]);
        }
        List<Double> invertedRow = invert(row, c);
        for (int j = 0; j < c; j++) {
          mat[i][j] = invertedRow.get(j);
        }
      }
      c = c * 2;
    }
    return unpadArr(mat, originalWidth, originalHeight);
  }

  /**
   * Calculates the threshold for truncating values based on the percentage specified.
   * This threshold is used to zero out small coefficients in the transformed matrix.
   *
   * @param redChannel   The 2D array representing the red channel of an image.
   * @param greenChannel The 2D array representing the green channel of an image.
   * @param blueChannel  The 2D array representing the blue channel of an image.
   * @param percentage   The percentage of coefficients to keep.
   * @return The calculated threshold value.
   */
  public double calThreshold(double[][] redChannel, double[][] greenChannel, double[][] blueChannel,
                             double percentage) {
    if (percentage == 100.0) {
      return Double.MAX_VALUE;
    }
    Set<Double> distinctValues = new HashSet<>();
    for (double[][] channel : new double[][][]{redChannel, greenChannel, blueChannel}) {
      for (double[] array : channel) {
        for (double val : array) {
          distinctValues.add(Math.abs(val));
        }
      }
    }
    List<Double> orderedValues = new ArrayList<>(distinctValues);
    Collections.sort(orderedValues);

    int thresholdIndex = (int) (orderedValues.size() * (percentage / 100.0));
    thresholdIndex = Math.min(thresholdIndex, orderedValues.size() - 1);

    return orderedValues.get(thresholdIndex);
  }
}