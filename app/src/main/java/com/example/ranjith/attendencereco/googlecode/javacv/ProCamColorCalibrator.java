package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.awt.Color;

public class ProCamColorCalibrator
{
  private static ThreadLocal<opencv_core.CvMat> H3x3;
  private static ThreadLocal<opencv_core.CvMat> R3x3;
  private static ThreadLocal<opencv_core.CvMat> n3x1;
  private static ThreadLocal<opencv_core.CvMat> t3x1;
  private static ThreadLocal<opencv_core.CvMat> z3x1;
  private opencv_core.CvMat boardDstPts;
  private MarkedPlane boardPlane = null;
  private opencv_core.CvMat boardSrcPts;
  private opencv_core.CvMat camKinv;
  private CameraDevice camera = null;
  private Color[] cameraColors = null;
  private int counter = 0;
  private MarkerDetector markerDetector = null;
  private opencv_core.IplImage mask;
  private opencv_core.IplImage mask2;
  private opencv_core.CvMat projDstPts;
  private opencv_core.CvMat projSrcPts;
  private ProjectorDevice projector = null;
  private Color[] projectorColors = null;
  private Settings settings;
  private opencv_core.IplImage undistImage;
  
  static
  {
    if (!ProCamColorCalibrator.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      R3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      t3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      n3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      z3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      return;
    }
  }
  
  public ProCamColorCalibrator(Settings paramSettings, MarkerDetector.Settings paramSettings1, MarkedPlane paramMarkedPlane, CameraDevice paramCameraDevice, ProjectorDevice paramProjectorDevice)
  {
    this.settings = paramSettings;
    this.markerDetector = new MarkerDetector(paramSettings1);
    this.boardPlane = paramMarkedPlane;
    this.camera = paramCameraDevice;
    this.projector = paramProjectorDevice;
    Marker[] arrayOfMarker = paramMarkedPlane.getMarkers();
    this.boardSrcPts = opencv_core.CvMat.create(4 + 4 * arrayOfMarker.length, 1, 6, 2);
    this.boardDstPts = opencv_core.CvMat.create(4 + 4 * arrayOfMarker.length, 1, 6, 2);
    opencv_core.CvMat localCvMat1 = this.boardSrcPts;
    double[] arrayOfDouble1 = new double[8];
    arrayOfDouble1[0] = 0.0D;
    arrayOfDouble1[1] = 0.0D;
    arrayOfDouble1[2] = paramMarkedPlane.getWidth();
    arrayOfDouble1[3] = 0.0D;
    arrayOfDouble1[4] = paramMarkedPlane.getWidth();
    arrayOfDouble1[5] = paramMarkedPlane.getHeight();
    arrayOfDouble1[6] = 0.0D;
    arrayOfDouble1[7] = paramMarkedPlane.getHeight();
    localCvMat1.put(arrayOfDouble1);
    for (int i = 0; i < arrayOfMarker.length; i++) {
      this.boardSrcPts.put(8 + i * 8, arrayOfMarker[i].corners);
    }
    this.projSrcPts = opencv_core.CvMat.create(4, 1, 6, 2);
    this.projDstPts = opencv_core.CvMat.create(4, 1, 6, 2);
    opencv_core.CvMat localCvMat2 = this.projSrcPts;
    double[] arrayOfDouble2 = new double[8];
    arrayOfDouble2[0] = 0.0D;
    arrayOfDouble2[1] = 0.0D;
    arrayOfDouble2[2] = (-1 + paramProjectorDevice.imageWidth);
    arrayOfDouble2[3] = 0.0D;
    arrayOfDouble2[4] = (-1 + paramProjectorDevice.imageWidth);
    arrayOfDouble2[5] = (-1 + paramProjectorDevice.imageHeight);
    arrayOfDouble2[6] = 0.0D;
    arrayOfDouble2[7] = (-1 + paramProjectorDevice.imageHeight);
    localCvMat2.put(arrayOfDouble2);
    this.camKinv = opencv_core.CvMat.create(3, 3);
    opencv_core.cvInvert(paramCameraDevice.cameraMatrix, this.camKinv);
  }
  
  public void addCameraColor()
  {
    this.counter = (1 + this.counter);
  }
  
  public void addCameraColor(Color paramColor)
  {
    Color[] arrayOfColor = this.cameraColors;
    int i = this.counter;
    this.counter = (i + 1);
    arrayOfColor[i] = paramColor;
  }
  
  public double calibrate()
  {
    Color[] arrayOfColor1 = getCameraColors();
    Color[] arrayOfColor2 = getProjectorColors();
    assert (this.counter == arrayOfColor2.length);
    ColorCalibrator localColorCalibrator = new ColorCalibrator(this.projector);
    this.projector.avgColorErr = localColorCalibrator.calibrate(arrayOfColor1, arrayOfColor2);
    this.camera.colorMixingMatrix = opencv_core.CvMat.create(3, 3);
    this.camera.additiveLight = opencv_core.CvMat.create(3, 1);
    opencv_core.cvSetIdentity(this.camera.colorMixingMatrix);
    opencv_core.cvSetZero(this.camera.additiveLight);
    this.counter = 0;
    return this.projector.avgColorErr;
  }
  
  public Color getCameraColor()
  {
    return getCameraColors()[this.counter];
  }
  
  public Color[] getCameraColors()
  {
    return this.cameraColors;
  }
  
  public int getColorCount()
  {
    return this.counter;
  }
  
  public opencv_core.IplImage getMaskImage()
  {
    return this.mask;
  }
  
  public Color getProjectorColor()
  {
    return getProjectorColors()[this.counter];
  }
  
  public Color[] getProjectorColors()
  {
    double d1 = 1.0D / this.projector.getSettings().getResponseGamma();
    int i = this.settings.samplesPerChannel;
    if (this.projectorColors == null)
    {
      this.projectorColors = new Color[i * (i * i)];
      this.cameraColors = new Color[i * (i * i)];
      for (int j = 0; j < this.projectorColors.length; j++)
      {
        int k = j / i;
        int m = k / i;
        double d2 = Math.pow(j % i / (i - 1), d1);
        double d3 = Math.pow(k % i / (i - 1), d1);
        double d4 = Math.pow(m % i / (i - 1), d1);
        this.projectorColors[j] = new Color((float)d2, (float)d3, (float)d4);
      }
    }
    return this.projectorColors;
  }
  
  public opencv_core.IplImage getUndistortedCameraImage()
  {
    return this.undistImage;
  }
  
  public boolean processCameraImage(opencv_core.IplImage paramIplImage)
  {
    if ((this.undistImage == null) || (this.undistImage.width() != paramIplImage.width()) || (this.undistImage.height() != paramIplImage.height()) || (this.undistImage.depth() != paramIplImage.depth())) {
      this.undistImage = paramIplImage.clone();
    }
    if ((this.mask == null) || (this.mask2 == null) || (this.mask.width() != paramIplImage.width()) || (this.mask2.width() != paramIplImage.width()) || (this.mask.height() != paramIplImage.height()) || (this.mask2.height() != paramIplImage.width()))
    {
      this.mask = opencv_core.IplImage.create(paramIplImage.width(), paramIplImage.height(), 8, 1, paramIplImage.origin());
      this.mask2 = opencv_core.IplImage.create(paramIplImage.width(), paramIplImage.height(), 8, 1, paramIplImage.origin());
    }
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)H3x3.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)R3x3.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)t3x1.get();
    opencv_core.CvMat localCvMat4 = (opencv_core.CvMat)n3x1.get();
    opencv_core.CvMat localCvMat5 = (opencv_core.CvMat)z3x1.get();
    localCvMat5.put(new double[] { 0.0D, 0.0D, 1.0D });
    this.camera.undistort(paramIplImage, this.undistImage);
    Marker[] arrayOfMarker = this.markerDetector.detect(this.undistImage, false);
    if (arrayOfMarker.length >= this.boardPlane.getMarkers().length * this.settings.detectedBoardMin)
    {
      this.boardPlane.getTotalWarp(arrayOfMarker, localCvMat1);
      opencv_core.cvPerspectiveTransform(this.boardSrcPts, this.boardDstPts, localCvMat1);
      double[] arrayOfDouble1 = this.boardDstPts.get();
      opencv_core.cvMatMul(this.camKinv, localCvMat1, localCvMat2);
      JavaCV.HnToRt(localCvMat2, localCvMat5, localCvMat2, localCvMat3);
      opencv_core.cvMatMul(localCvMat2, localCvMat5, localCvMat4);
      double d1 = opencv_core.cvDotProduct(localCvMat3, localCvMat5);
      opencv_core.cvGEMM(this.projector.T, localCvMat4, -1.0D / d1, this.projector.R, 1.0D, localCvMat1, 2);
      opencv_core.cvMatMul(this.projector.cameraMatrix, localCvMat1, localCvMat1);
      opencv_core.cvMatMul(localCvMat1, this.camKinv, localCvMat1);
      opencv_core.cvConvertScale(localCvMat1, localCvMat1, 1.0D / localCvMat1.get(8), 0.0D);
      opencv_core.cvInvert(localCvMat1, localCvMat1);
      opencv_core.cvConvertScale(localCvMat1, localCvMat1, 1.0D / localCvMat1.get(8), 0.0D);
      opencv_core.cvPerspectiveTransform(this.projSrcPts, this.projDstPts, localCvMat1);
      double[] arrayOfDouble2 = this.projDstPts.get();
      opencv_core.cvSetZero(this.mask);
      double d2 = 0.0D;
      double d3 = 0.0D;
      for (int i = 0; i < 4; i++)
      {
        d2 += arrayOfDouble1[(i * 2)];
        d3 += arrayOfDouble1[(1 + i * 2)];
      }
      double d4 = d2 / 4.0D;
      double d5 = d3 / 4.0D;
      for (int j = 0; j < 4; j++)
      {
        int i4 = j * 2;
        arrayOfDouble1[i4] -= (arrayOfDouble1[(j * 2)] - d4) * this.settings.trimmingFraction;
        int i5 = 1 + j * 2;
        arrayOfDouble1[i5] -= (arrayOfDouble1[(1 + j * 2)] - d5) * this.settings.trimmingFraction;
      }
      opencv_core.cvFillConvexPoly(this.mask, new opencv_core.CvPoint((byte)16, arrayOfDouble1, 0, 8), 4, opencv_core.CvScalar.WHITE, 8, 16);
      for (int k = 0;; k++)
      {
        int m = (-8 + arrayOfDouble1.length) / 8;
        if (k >= m) {
          break;
        }
        opencv_core.cvFillConvexPoly(this.mask, new opencv_core.CvPoint((byte)16, arrayOfDouble1, 8 + k * 8, 8), 4, opencv_core.CvScalar.BLACK, 8, 16);
      }
      opencv_core.cvSetZero(this.mask2);
      double d6 = 0.0D;
      double d7 = 0.0D;
      for (int n = 0; n < 4; n++)
      {
        d6 += arrayOfDouble2[(n * 2)];
        d7 += arrayOfDouble2[(1 + n * 2)];
      }
      double d8 = d6 / 4.0D;
      double d9 = d7 / 4.0D;
      for (int i1 = 0; i1 < 4; i1++)
      {
        int i2 = i1 * 2;
        arrayOfDouble2[i2] -= (arrayOfDouble2[(i1 * 2)] - d8) * this.settings.trimmingFraction;
        int i3 = 1 + i1 * 2;
        arrayOfDouble2[i3] -= (arrayOfDouble2[(1 + i1 * 2)] - d9) * this.settings.trimmingFraction;
      }
      opencv_core.cvFillConvexPoly(this.mask2, new opencv_core.CvPoint((byte)16, arrayOfDouble2, 0, 8), 4, opencv_core.CvScalar.WHITE, 8, 16);
      opencv_core.cvAnd(this.mask, this.mask2, this.mask, null);
      opencv_imgproc.cvErode(this.mask, this.mask, null, 1);
      opencv_core.CvScalar localCvScalar = opencv_core.cvAvg(this.undistImage, this.mask);
      int[] arrayOfInt = this.camera.getRGBColorOrder();
      double d10 = paramIplImage.highValue();
      this.cameraColors[this.counter] = new Color((float)(localCvScalar.val(arrayOfInt[0]) / d10), (float)(localCvScalar.val(arrayOfInt[1]) / d10), (float)(localCvScalar.val(arrayOfInt[2]) / d10));
      return true;
    }
    return false;
  }
  
  public static class Settings
    extends BaseChildSettings
  {
    double detectedBoardMin = 0.5D;
    int samplesPerChannel = 4;
    double trimmingFraction = 0.01D;
    
    public double getDetectedBoardMin()
    {
      return this.detectedBoardMin;
    }
    
    public int getSamplesPerChannel()
    {
      return this.samplesPerChannel;
    }
    
    public void setDetectedBoardMin(double paramDouble)
    {
      this.detectedBoardMin = paramDouble;
    }
    
    public void setSamplesPerChannel(int paramInt)
    {
      this.samplesPerChannel = paramInt;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProCamColorCalibrator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */