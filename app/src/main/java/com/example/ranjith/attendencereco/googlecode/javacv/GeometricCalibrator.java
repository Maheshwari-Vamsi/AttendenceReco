package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_calib3d;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GeometricCalibrator
{
  private LinkedList<Marker[]> allImageMarkers = new LinkedList();
  private LinkedList<Marker[]> allObjectMarkers = new LinkedList();
  private Marker[] lastDetectedMarkers = null;
  private opencv_core.CvMat lastWarp = opencv_core.CvMat.create(3, 3);
  private MarkedPlane markedPlane;
  MarkerDetector markerDetector;
  private opencv_core.CvMat prevWarp = opencv_core.CvMat.create(3, 3);
  private ProjectiveDevice projectiveDevice;
  private Settings settings;
  private opencv_core.IplImage tempImage = null;
  private opencv_core.CvMat tempPts = opencv_core.CvMat.create(1, 4, 6, 2);
  private opencv_core.CvMat warp = opencv_core.CvMat.create(3, 3);
  private opencv_core.CvMat warpDstPts = opencv_core.CvMat.create(1, 4, 6, 2);
  private opencv_core.CvMat warpSrcPts = opencv_core.CvMat.create(1, 4, 6, 2);
  
  static
  {
    if (!GeometricCalibrator.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GeometricCalibrator(Settings paramSettings, MarkerDetector.Settings paramSettings1, MarkedPlane paramMarkedPlane, ProjectiveDevice paramProjectiveDevice)
  {
    this.settings = paramSettings;
    this.markerDetector = new MarkerDetector(paramSettings1);
    this.markedPlane = paramMarkedPlane;
    this.projectiveDevice = paramProjectiveDevice;
    opencv_core.cvSetIdentity(this.prevWarp);
    opencv_core.cvSetIdentity(this.lastWarp);
    if (paramMarkedPlane != null)
    {
      int i = paramMarkedPlane.getImage().width();
      int j = paramMarkedPlane.getImage().height();
      opencv_core.CvMat localCvMat = this.warpSrcPts;
      double[] arrayOfDouble = new double[8];
      arrayOfDouble[0] = 0.0D;
      arrayOfDouble[1] = 0.0D;
      arrayOfDouble[2] = i;
      arrayOfDouble[3] = 0.0D;
      arrayOfDouble[4] = i;
      arrayOfDouble[5] = j;
      arrayOfDouble[6] = 0.0D;
      arrayOfDouble[7] = j;
      localCvMat.put(arrayOfDouble);
    }
  }
  
  public static double[] computeReprojectionError(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8)
  {
    opencv_core.CvMat localCvMat1 = opencv_core.CvMat.create(paramCvMat2.rows(), paramCvMat2.cols(), paramCvMat2.type());
    int i = paramCvMat6.rows();
    int j = 0;
    double d1 = 0.0D;
    double d2 = 0.0D;
    opencv_core.CvMat localCvMat2 = new opencv_core.CvMat();
    opencv_core.CvMat localCvMat3 = new opencv_core.CvMat();
    opencv_core.CvMat localCvMat4 = new opencv_core.CvMat();
    IntBuffer localIntBuffer = paramCvMat3.getIntBuffer();
    opencv_core.CvMat localCvMat5 = new opencv_core.CvMat();
    opencv_core.CvMat localCvMat6 = new opencv_core.CvMat();
    for (int k = 0; k < i; k++)
    {
      localCvMat2.reset();
      localCvMat3.reset();
      localCvMat4.reset();
      int m = localIntBuffer.get(k);
      int n = j + m;
      opencv_core.cvGetCols(paramCvMat1, localCvMat2, j, n);
      int i1 = j + m;
      opencv_core.cvGetCols(paramCvMat2, localCvMat3, j, i1);
      int i2 = j + m;
      opencv_core.cvGetCols(localCvMat1, localCvMat4, j, i2);
      j += m;
      int i3 = k + 1;
      opencv_core.cvGetRows(paramCvMat6, localCvMat5, k, i3, 1);
      int i4 = k + 1;
      opencv_core.cvGetRows(paramCvMat7, localCvMat6, k, i4, 1);
      opencv_calib3d.cvProjectPoints2(localCvMat2, localCvMat5, localCvMat6, paramCvMat4, paramCvMat5, localCvMat4);
      double d3 = opencv_core.cvNorm(localCvMat3, localCvMat4);
      double d4 = d3 * d3;
      if (paramCvMat8 != null)
      {
        double d12 = Math.sqrt(d4 / m);
        paramCvMat8.put(k, d12);
      }
      d1 += d4;
      for (int i5 = 0; i5 < m; i5++)
      {
        double d5 = localCvMat3.get(0, i5, 0);
        double d6 = localCvMat3.get(0, i5, 1);
        double d7 = localCvMat4.get(0, i5, 0);
        double d8 = localCvMat4.get(0, i5, 1);
        double d9 = d5 - d7;
        double d10 = d6 - d8;
        double d11 = Math.sqrt(d9 * d9 + d10 * d10);
        if (d11 > d2) {
          d2 = d11;
        }
      }
    }
    double[] arrayOfDouble = new double[2];
    arrayOfDouble[0] = Math.sqrt(d1 / j);
    arrayOfDouble[1] = d2;
    return arrayOfDouble;
  }
  
  public static double[] computeStereoError(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7)
  {
    int i = paramCvMat1.cols();
    opencv_core.CvMat localCvMat1 = opencv_core.CvMat.create(1, i, 5, 3);
    opencv_core.CvMat localCvMat2 = opencv_core.CvMat.create(1, i, 5, 3);
    opencv_imgproc.cvUndistortPoints(paramCvMat1, paramCvMat1, paramCvMat3, paramCvMat4, null, paramCvMat3);
    opencv_imgproc.cvUndistortPoints(paramCvMat2, paramCvMat2, paramCvMat5, paramCvMat6, null, paramCvMat5);
    opencv_calib3d.cvComputeCorrespondEpilines(paramCvMat1, 1, paramCvMat7, localCvMat1);
    opencv_calib3d.cvComputeCorrespondEpilines(paramCvMat2, 2, paramCvMat7, localCvMat2);
    double d1 = 0.0D;
    double d2 = 0.0D;
    for (int j = 0; j < i; j++)
    {
      double d3 = paramCvMat1.get(0, j, 0) * localCvMat2.get(0, j, 0) + paramCvMat1.get(0, j, 1) * localCvMat2.get(0, j, 1) + localCvMat2.get(0, j, 2);
      double d4 = paramCvMat2.get(0, j, 0) * localCvMat1.get(0, j, 0) + paramCvMat2.get(0, j, 1) * localCvMat1.get(0, j, 1) + localCvMat1.get(0, j, 2);
      double d5 = d3 * d3 + d4 * d4;
      d1 += d5;
      double d6 = Math.sqrt(d5);
      if (d6 > d2) {
        d2 = d6;
      }
    }
    double[] arrayOfDouble = new double[2];
    arrayOfDouble[0] = Math.sqrt(d1 / i);
    arrayOfDouble[1] = d2;
    return arrayOfDouble;
  }
  
  private opencv_core.CvMat[] getPoints(boolean paramBoolean)
  {
    assert (this.allObjectMarkers.size() == this.allImageMarkers.size());
    Iterator localIterator1 = this.allObjectMarkers.iterator();
    Iterator localIterator2 = this.allImageMarkers.iterator();
    opencv_core.CvMat localCvMat1 = opencv_core.CvMat.create(1, this.allImageMarkers.size(), 4, 1);
    IntBuffer localIntBuffer = localCvMat1.getIntBuffer();
    int i = 0;
    if ((localIterator1.hasNext()) && (localIterator2.hasNext()))
    {
      Marker[] arrayOfMarker3 = (Marker[])localIterator1.next();
      Marker[] arrayOfMarker4 = (Marker[])localIterator2.next();
      assert (arrayOfMarker3.length == arrayOfMarker4.length);
      int m = arrayOfMarker3.length;
      if (paramBoolean) {}
      for (int n = 1;; n = 4)
      {
        int i1 = m * n;
        localIntBuffer.put(i1);
        i += i1;
        break;
      }
    }
    Iterator localIterator3 = this.allObjectMarkers.iterator();
    Iterator localIterator4 = this.allImageMarkers.iterator();
    opencv_core.CvMat localCvMat2 = opencv_core.CvMat.create(1, i, 5, 3);
    opencv_core.CvMat localCvMat3 = opencv_core.CvMat.create(1, i, 5, 2);
    FloatBuffer localFloatBuffer1 = localCvMat2.getFloatBuffer();
    FloatBuffer localFloatBuffer2 = localCvMat3.getFloatBuffer();
    if ((localIterator3.hasNext()) && (localIterator4.hasNext()))
    {
      Marker[] arrayOfMarker1 = (Marker[])localIterator3.next();
      Marker[] arrayOfMarker2 = (Marker[])localIterator4.next();
      int j = 0;
      label277:
      if (j < arrayOfMarker1.length)
      {
        if (!paramBoolean) {
          break label366;
        }
        double[] arrayOfDouble1 = arrayOfMarker1[j].getCenter();
        localFloatBuffer1.put((float)arrayOfDouble1[0]);
        localFloatBuffer1.put((float)arrayOfDouble1[1]);
        localFloatBuffer1.put(0.0F);
        double[] arrayOfDouble2 = arrayOfMarker2[j].getCenter();
        localFloatBuffer2.put((float)arrayOfDouble2[0]);
        localFloatBuffer2.put((float)arrayOfDouble2[1]);
      }
      for (;;)
      {
        j++;
        break label277;
        break;
        label366:
        for (int k = 0; k < 4; k++)
        {
          localFloatBuffer1.put((float)arrayOfMarker1[j].corners[(k * 2)]);
          localFloatBuffer1.put((float)arrayOfMarker1[j].corners[(1 + k * 2)]);
          localFloatBuffer1.put(0.0F);
          localFloatBuffer2.put((float)arrayOfMarker2[j].corners[(k * 2)]);
          localFloatBuffer2.put((float)arrayOfMarker2[j].corners[(1 + k * 2)]);
        }
      }
    }
    return new opencv_core.CvMat[] { localCvMat2, localCvMat3, localCvMat1 };
  }
  
  public void addMarkers()
  {
    addMarkers(this.markedPlane.getMarkers(), this.lastDetectedMarkers);
  }
  
  public void addMarkers(Marker[] paramArrayOfMarker)
  {
    addMarkers(this.markedPlane.getMarkers(), paramArrayOfMarker);
  }
  
  public void addMarkers(Marker[] paramArrayOfMarker1, Marker[] paramArrayOfMarker2)
  {
    int i = Math.min(paramArrayOfMarker1.length, paramArrayOfMarker2.length);
    Marker[] arrayOfMarker1 = new Marker[i];
    Marker[] arrayOfMarker2 = new Marker[i];
    int j = 0;
    int k = paramArrayOfMarker1.length;
    int m = 0;
    if (m < k)
    {
      Marker localMarker1 = paramArrayOfMarker1[m];
      int n = paramArrayOfMarker2.length;
      for (int i1 = 0;; i1++) {
        if (i1 < n)
        {
          Marker localMarker2 = paramArrayOfMarker2[i1];
          if (localMarker1.id == localMarker2.id)
          {
            arrayOfMarker1[j] = localMarker1;
            arrayOfMarker2[j] = localMarker2;
            j++;
          }
        }
        else
        {
          m++;
          break;
        }
      }
    }
    if (j < i)
    {
      arrayOfMarker1 = (Marker[])Arrays.copyOf(arrayOfMarker1, j);
      arrayOfMarker2 = (Marker[])Arrays.copyOf(arrayOfMarker2, j);
    }
    this.allObjectMarkers.add(arrayOfMarker1);
    this.allImageMarkers.add(arrayOfMarker2);
    opencv_core.cvCopy(this.prevWarp, this.lastWarp);
  }
  
  public double[] calibrate(boolean paramBoolean)
  {
    ProjectiveDevice localProjectiveDevice = this.projectiveDevice;
    ProjectiveDevice.CalibrationSettings localCalibrationSettings = (ProjectiveDevice.CalibrationSettings)localProjectiveDevice.getSettings();
    if (localProjectiveDevice.cameraMatrix == null)
    {
      localProjectiveDevice.cameraMatrix = opencv_core.CvMat.create(3, 3);
      opencv_core.cvSetZero(localProjectiveDevice.cameraMatrix);
      if ((0x2 & localCalibrationSettings.flags) != 0)
      {
        localProjectiveDevice.cameraMatrix.put(0, localCalibrationSettings.initAspectRatio);
        localProjectiveDevice.cameraMatrix.put(4, 1.0D);
      }
    }
    if (localCalibrationSettings.isFixK3()) {}
    for (int i = 4;; i = 5)
    {
      if ((localCalibrationSettings.isRationalModel()) && (!localCalibrationSettings.isFixK4()) && (!localCalibrationSettings.isFixK4()) && (!localCalibrationSettings.isFixK5())) {
        i = 8;
      }
      if ((localProjectiveDevice.distortionCoeffs == null) || (localProjectiveDevice.distortionCoeffs.cols() != i))
      {
        localProjectiveDevice.distortionCoeffs = opencv_core.CvMat.create(1, i);
        opencv_core.cvSetZero(localProjectiveDevice.distortionCoeffs);
      }
      opencv_core.CvMat localCvMat1 = new opencv_core.CvMat();
      opencv_core.CvMat localCvMat2 = new opencv_core.CvMat();
      localProjectiveDevice.extrParams = opencv_core.CvMat.create(this.allImageMarkers.size(), 6);
      opencv_core.cvGetCols(localProjectiveDevice.extrParams, localCvMat1, 0, 3);
      opencv_core.cvGetCols(localProjectiveDevice.extrParams, localCvMat2, 3, 6);
      opencv_core.CvMat[] arrayOfCvMat = getPoints(paramBoolean);
      opencv_calib3d.cvCalibrateCamera2(arrayOfCvMat[0], arrayOfCvMat[1], arrayOfCvMat[2], opencv_core.cvSize(localProjectiveDevice.imageWidth, localProjectiveDevice.imageHeight), localProjectiveDevice.cameraMatrix, localProjectiveDevice.distortionCoeffs, localCvMat1, localCvMat2, localCalibrationSettings.flags);
      if ((opencv_core.cvCheckArr(localProjectiveDevice.cameraMatrix, 2, 0.0D, 0.0D) == 0) || (opencv_core.cvCheckArr(localProjectiveDevice.distortionCoeffs, 2, 0.0D, 0.0D) == 0) || (opencv_core.cvCheckArr(localProjectiveDevice.extrParams, 2, 0.0D, 0.0D) == 0)) {
        break;
      }
      localProjectiveDevice.reprojErrs = opencv_core.CvMat.create(1, this.allImageMarkers.size());
      double[] arrayOfDouble = computeReprojectionError(arrayOfCvMat[0], arrayOfCvMat[1], arrayOfCvMat[2], localProjectiveDevice.cameraMatrix, localProjectiveDevice.distortionCoeffs, localCvMat1, localCvMat2, localProjectiveDevice.reprojErrs);
      localProjectiveDevice.avgReprojErr = arrayOfDouble[0];
      localProjectiveDevice.maxReprojErr = arrayOfDouble[1];
      return arrayOfDouble;
    }
    localProjectiveDevice.cameraMatrix = null;
    localProjectiveDevice.avgReprojErr = -1.0D;
    localProjectiveDevice.maxReprojErr = -1.0D;
    return null;
  }
  
  public double[] calibrateStereo(boolean paramBoolean, GeometricCalibrator paramGeometricCalibrator)
  {
    ProjectiveDevice localProjectiveDevice1 = this.projectiveDevice;
    ProjectiveDevice localProjectiveDevice2 = paramGeometricCalibrator.projectiveDevice;
    ((ProjectiveDevice.CalibrationSettings)localProjectiveDevice1.getSettings());
    ProjectiveDevice.CalibrationSettings localCalibrationSettings = (ProjectiveDevice.CalibrationSettings)localProjectiveDevice2.getSettings();
    opencv_core.CvMat[] arrayOfCvMat1 = getPoints(paramBoolean);
    opencv_core.CvMat[] arrayOfCvMat2 = paramGeometricCalibrator.getPoints(paramBoolean);
    FloatBuffer localFloatBuffer1 = arrayOfCvMat1[0].getFloatBuffer();
    FloatBuffer localFloatBuffer2 = arrayOfCvMat1[1].getFloatBuffer();
    IntBuffer localIntBuffer1 = arrayOfCvMat1[2].getIntBuffer();
    FloatBuffer localFloatBuffer3 = arrayOfCvMat2[0].getFloatBuffer();
    FloatBuffer localFloatBuffer4 = arrayOfCvMat2[1].getFloatBuffer();
    IntBuffer localIntBuffer2 = arrayOfCvMat2[2].getIntBuffer();
    assert (localIntBuffer1.capacity() == localIntBuffer2.capacity());
    opencv_core.CvMat localCvMat1 = opencv_core.CvMat.create(1, Math.min(localFloatBuffer1.capacity(), localFloatBuffer3.capacity()), 5, 3);
    opencv_core.CvMat localCvMat2 = opencv_core.CvMat.create(1, Math.min(localFloatBuffer2.capacity(), localFloatBuffer4.capacity()), 5, 2);
    opencv_core.CvMat localCvMat3 = opencv_core.CvMat.create(1, Math.min(localFloatBuffer2.capacity(), localFloatBuffer4.capacity()), 5, 2);
    opencv_core.CvMat localCvMat4 = opencv_core.CvMat.create(1, localIntBuffer1.capacity(), 4, 1);
    FloatBuffer localFloatBuffer5 = localCvMat1.getFloatBuffer();
    FloatBuffer localFloatBuffer6 = localCvMat2.getFloatBuffer();
    FloatBuffer localFloatBuffer7 = localCvMat3.getFloatBuffer();
    IntBuffer localIntBuffer3 = localCvMat4.getIntBuffer();
    int i = 0;
    int j = 0;
    for (int k = 0;; k++)
    {
      int m = localIntBuffer1.capacity();
      if (k >= m) {
        break;
      }
      int n = i;
      int i1 = j;
      i = n + localIntBuffer1.get(k);
      j = i1 + localIntBuffer2.get(k);
      int i2 = 0;
      int i3 = n;
      if (i3 < i)
      {
        float f1 = localFloatBuffer1.get(i3 * 3);
        float f2 = localFloatBuffer1.get(1 + i3 * 3);
        float f3 = localFloatBuffer1.get(2 + i3 * 3);
        for (int i4 = i1;; i4++) {
          if (i4 < j)
          {
            float f4 = localFloatBuffer3.get(i4 * 3);
            float f5 = localFloatBuffer3.get(1 + i4 * 3);
            float f6 = localFloatBuffer3.get(2 + i4 * 3);
            if ((f1 == f4) && (f2 == f5) && (f3 == f6))
            {
              localFloatBuffer5.put(f1);
              localFloatBuffer5.put(f2);
              localFloatBuffer5.put(f3);
              localFloatBuffer6.put(localFloatBuffer2.get(i3 * 2));
              localFloatBuffer6.put(localFloatBuffer2.get(1 + i3 * 2));
              localFloatBuffer7.put(localFloatBuffer4.get(i4 * 2));
              localFloatBuffer7.put(localFloatBuffer4.get(1 + i4 * 2));
              i2++;
            }
          }
          else
          {
            i3++;
            break;
          }
        }
      }
      if (i2 > 0) {
        localIntBuffer3.put(i2);
      }
    }
    localCvMat1.cols(localFloatBuffer5.position() / 3);
    localCvMat2.cols(localFloatBuffer6.position() / 2);
    localCvMat3.cols(localFloatBuffer7.position() / 2);
    localCvMat4.cols(localIntBuffer3.position());
    localProjectiveDevice1.R = opencv_core.CvMat.create(3, 3);
    localProjectiveDevice1.R.put(new double[] { 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D, 1.0D });
    localProjectiveDevice1.T = opencv_core.CvMat.create(3, 1);
    localProjectiveDevice1.T.put(new double[] { 0.0D, 0.0D, 0.0D });
    localProjectiveDevice1.E = opencv_core.CvMat.create(3, 3);
    opencv_core.cvSetZero(localProjectiveDevice1.E);
    localProjectiveDevice1.F = opencv_core.CvMat.create(3, 3);
    opencv_core.cvSetZero(localProjectiveDevice1.F);
    localProjectiveDevice2.R = opencv_core.CvMat.create(3, 3);
    localProjectiveDevice2.T = opencv_core.CvMat.create(3, 1);
    localProjectiveDevice2.E = opencv_core.CvMat.create(3, 3);
    localProjectiveDevice2.F = opencv_core.CvMat.create(3, 3);
    opencv_calib3d.cvStereoCalibrate(localCvMat1, localCvMat2, localCvMat3, localCvMat4, localProjectiveDevice1.cameraMatrix, localProjectiveDevice1.distortionCoeffs, localProjectiveDevice2.cameraMatrix, localProjectiveDevice2.distortionCoeffs, opencv_core.cvSize(localProjectiveDevice1.imageWidth, localProjectiveDevice1.imageHeight), localProjectiveDevice2.R, localProjectiveDevice2.T, localProjectiveDevice2.E, localProjectiveDevice2.F, opencv_core.cvTermCriteria(3, 100, 1.0E-6D), localCalibrationSettings.flags);
    localProjectiveDevice1.avgEpipolarErr = 0.0D;
    localProjectiveDevice1.maxEpipolarErr = 0.0D;
    double[] arrayOfDouble = computeStereoError(localCvMat2, localCvMat3, localProjectiveDevice1.cameraMatrix, localProjectiveDevice1.distortionCoeffs, localProjectiveDevice2.cameraMatrix, localProjectiveDevice2.distortionCoeffs, localProjectiveDevice2.F);
    localProjectiveDevice2.avgEpipolarErr = arrayOfDouble[0];
    localProjectiveDevice2.maxEpipolarErr = arrayOfDouble[1];
    return arrayOfDouble;
  }
  
  public void drawMarkers(opencv_core.IplImage paramIplImage)
  {
    this.markerDetector.draw(paramIplImage, this.lastDetectedMarkers);
  }
  
  public LinkedList<Marker[]> getAllImageMarkers()
  {
    return this.allImageMarkers;
  }
  
  public LinkedList<Marker[]> getAllObjectMarkers()
  {
    return this.allObjectMarkers;
  }
  
  public int getImageCount()
  {
    assert (this.allObjectMarkers.size() == this.allImageMarkers.size());
    return this.allObjectMarkers.size();
  }
  
  public MarkedPlane getMarkedPlane()
  {
    return this.markedPlane;
  }
  
  public MarkerDetector getMarkerDetector()
  {
    return this.markerDetector;
  }
  
  public ProjectiveDevice getProjectiveDevice()
  {
    return this.projectiveDevice;
  }
  
  public Marker[] processImage(opencv_core.IplImage paramIplImage)
  {
    this.projectiveDevice.imageWidth = paramIplImage.width();
    this.projectiveDevice.imageHeight = paramIplImage.height();
    boolean bool;
    if (this.markedPlane.getForegroundColor().magnitude() > this.markedPlane.getBackgroundColor().magnitude())
    {
      bool = true;
      if (paramIplImage.depth() <= 8) {
        break label176;
      }
      if ((this.tempImage == null) || (this.tempImage.width() != paramIplImage.width()) || (this.tempImage.height() != paramIplImage.height())) {
        this.tempImage = opencv_core.IplImage.create(paramIplImage.width(), paramIplImage.height(), 8, 1, paramIplImage.origin());
      }
      opencv_core.cvConvertScale(paramIplImage, this.tempImage, 0.00390625D, 0.0D);
    }
    label176:
    for (this.lastDetectedMarkers = this.markerDetector.detect(this.tempImage, bool);; this.lastDetectedMarkers = this.markerDetector.detect(paramIplImage, bool))
    {
      if (this.lastDetectedMarkers.length >= this.markedPlane.getMarkers().length * this.settings.detectedBoardMin) {
        break label192;
      }
      return null;
      bool = false;
      break;
    }
    label192:
    this.markedPlane.getTotalWarp(this.lastDetectedMarkers, this.warp);
    opencv_core.cvPerspectiveTransform(this.warpSrcPts, this.warpDstPts, this.warp);
    opencv_core.cvPerspectiveTransform(this.warpSrcPts, this.tempPts, this.prevWarp);
    double d1 = opencv_core.cvNorm(this.warpDstPts, this.tempPts);
    opencv_core.cvPerspectiveTransform(this.warpSrcPts, this.tempPts, this.lastWarp);
    double d2 = opencv_core.cvNorm(this.warpDstPts, this.tempPts);
    opencv_core.cvCopy(this.warp, this.prevWarp);
    int i = (paramIplImage.width() + paramIplImage.height()) / 2;
    if ((d1 < this.settings.patternSteadySize * i) && (d2 > this.settings.patternMovedSize * i)) {
      return this.lastDetectedMarkers;
    }
    return null;
  }
  
  public void setAllImageMarkers(LinkedList<Marker[]> paramLinkedList)
  {
    this.allImageMarkers = paramLinkedList;
  }
  
  public void setAllObjectMarkers(LinkedList<Marker[]> paramLinkedList)
  {
    this.allObjectMarkers = paramLinkedList;
  }
  
  public static class Settings
    extends BaseChildSettings
  {
    double detectedBoardMin = 0.5D;
    double patternMovedSize = 0.05D;
    double patternSteadySize = 0.005D;
    
    public double getDetectedBoardMin()
    {
      return this.detectedBoardMin;
    }
    
    public double getPatternMovedSize()
    {
      return this.patternMovedSize;
    }
    
    public double getPatternSteadySize()
    {
      return this.patternSteadySize;
    }
    
    public void setDetectedBoardMin(double paramDouble)
    {
      this.detectedBoardMin = paramDouble;
    }
    
    public void setPatternMovedSize(double paramDouble)
    {
      this.patternMovedSize = paramDouble;
    }
    
    public void setPatternSteadySize(double paramDouble)
    {
      this.patternSteadySize = paramDouble;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\GeometricCalibrator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */