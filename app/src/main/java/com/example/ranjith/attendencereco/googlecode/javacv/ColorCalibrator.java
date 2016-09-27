package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import java.awt.Color;
import java.io.PrintStream;

public class ColorCalibrator
{
  private ProjectiveDevice device;
  
  static
  {
    if (!ColorCalibrator.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ColorCalibrator(ProjectiveDevice paramProjectiveDevice)
  {
    this.device = paramProjectiveDevice;
  }
  
  public double calibrate(Color[] paramArrayOfColor1, Color[] paramArrayOfColor2)
  {
    assert (paramArrayOfColor1.length == paramArrayOfColor2.length);
    int[] arrayOfInt = this.device.getRGBColorOrder();
    opencv_core.CvMat localCvMat1 = opencv_core.CvMat.create(3 * paramArrayOfColor1.length, 12);
    opencv_core.CvMat localCvMat2 = opencv_core.CvMat.create(3 * paramArrayOfColor1.length, 1);
    opencv_core.CvMat localCvMat3 = opencv_core.CvMat.create(12, 1);
    double d1 = this.device.getSettings().getResponseGamma();
    for (int i = 0;; i++)
    {
      int j = paramArrayOfColor1.length;
      if (i >= j) {
        break;
      }
      float[] arrayOfFloat1 = paramArrayOfColor2[i].getRGBColorComponents(null);
      float[] arrayOfFloat2 = paramArrayOfColor1[i].getRGBColorComponents(null);
      double d9 = Math.pow(arrayOfFloat1[arrayOfInt[0]], d1);
      double d10 = Math.pow(arrayOfFloat1[arrayOfInt[1]], d1);
      double d11 = Math.pow(arrayOfFloat1[arrayOfInt[2]], d1);
      for (int m = 0; m < 3; m++)
      {
        int n = i * 36 + m * 16;
        localCvMat1.put(n, d9);
        localCvMat1.put(n + 1, d10);
        localCvMat1.put(n + 2, d11);
        localCvMat1.put(n + 3, 1.0D);
        if (m < 2) {
          for (int i1 = 0; i1 < 12; i1++) {
            localCvMat1.put(i1 + (n + 4), 0.0D);
          }
        }
      }
      localCvMat2.put(i * 3, arrayOfFloat2[arrayOfInt[0]]);
      localCvMat2.put(1 + i * 3, arrayOfFloat2[arrayOfInt[1]]);
      localCvMat2.put(2 + i * 3, arrayOfFloat2[arrayOfInt[2]]);
    }
    if (opencv_core.cvSolve(localCvMat1, localCvMat2, localCvMat3, 1) != 1.0D) {
      System.out.println("Error solving.");
    }
    opencv_core.CvMat localCvMat4 = opencv_core.CvMat.create(localCvMat2.rows(), 1);
    opencv_core.cvMatMul(localCvMat1, localCvMat3, localCvMat4);
    double d2 = opencv_core.cvNorm(localCvMat2, localCvMat4) * opencv_core.cvNorm(localCvMat2, localCvMat4) / localCvMat2.rows();
    double d3 = Math.sqrt(d2);
    opencv_core.CvScalar localCvScalar1 = new opencv_core.CvScalar();
    opencv_core.CvScalar localCvScalar2 = new opencv_core.CvScalar();
    opencv_core.cvAvgSdv(localCvMat2, localCvScalar1, localCvScalar2, null);
    double d4 = 1.0D - d2 / (localCvScalar2.val(0) * localCvScalar2.val(0));
    this.device.colorMixingMatrix = opencv_core.CvMat.create(3, 3);
    this.device.additiveLight = opencv_core.CvMat.create(3, 1);
    for (int k = 0; k < 3; k++)
    {
      double d5 = localCvMat3.get(k * 4);
      double d6 = localCvMat3.get(1 + k * 4);
      double d7 = localCvMat3.get(2 + k * 4);
      double d8 = localCvMat3.get(3 + k * 4);
      this.device.colorMixingMatrix.put(k * 3, d5);
      this.device.colorMixingMatrix.put(1 + k * 3, d6);
      this.device.colorMixingMatrix.put(2 + k * 3, d7);
      this.device.additiveLight.put(k, d8);
    }
    this.device.colorR2 = d4;
    this.device.avgColorErr = d3;
    return d3;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ColorCalibrator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */