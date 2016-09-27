package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacv.cpp.opencv_calib3d;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvAttrList;
import com.googlecode.javacv.cpp.opencv_core.CvFileNode;
import com.googlecode.javacv.cpp.opencv_core.CvFileStorage;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSize;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class ProjectiveDevice
{
  private static ThreadLocal<opencv_core.CvMat> B4x3;
  private static ThreadLocal<opencv_core.CvMat> P13x4;
  private static ThreadLocal<opencv_core.CvMat> P23x4;
  private static ThreadLocal<opencv_core.CvMat> R13x3;
  private static ThreadLocal<opencv_core.CvMat> R23x3;
  private static ThreadLocal<opencv_core.CvMat> a4x1;
  private static ThreadLocal<opencv_core.CvMat> relativeR3x3;
  private static ThreadLocal<opencv_core.CvMat> relativeT3x1;
  private static ThreadLocal<opencv_core.CvMat> t3x1;
  private static ThreadLocal<opencv_core.CvMat> temp3x3;
  public opencv_core.CvMat E = null;
  public opencv_core.CvMat F = null;
  public opencv_core.CvMat R = null;
  public opencv_core.CvMat T = null;
  public opencv_core.CvMat additiveLight = null;
  public double avgColorErr;
  public double avgEpipolarErr;
  public double avgReprojErr;
  public opencv_core.CvMat cameraMatrix = null;
  public opencv_core.CvMat colorMixingMatrix = null;
  public String colorOrder = "BGR";
  public double colorR2 = 1.0D;
  private opencv_core.IplImage[] distortMaps1 = { null };
  private opencv_core.IplImage[] distortMaps2 = { null };
  public opencv_core.CvMat distortionCoeffs = null;
  public opencv_core.CvMat extrParams = null;
  private boolean fixedPointMaps = false;
  public int imageHeight = 0;
  public int imageWidth = 0;
  private int mapsPyramidLevel = 0;
  public double maxEpipolarErr;
  public double maxReprojErr;
  public opencv_core.CvMat reprojErrs = null;
  private Settings settings;
  private opencv_core.IplImage tempImage = null;
  private opencv_core.IplImage[] undistortMaps1 = { null };
  private opencv_core.IplImage[] undistortMaps2 = { null };
  
  static
  {
    if (!ProjectiveDevice.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      temp3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      B4x3 = opencv_core.CvMat.createThreadLocal(4, 3);
      a4x1 = opencv_core.CvMat.createThreadLocal(4, 1);
      t3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      relativeR3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      relativeT3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      R13x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      P13x4 = opencv_core.CvMat.createThreadLocal(3, 4);
      R23x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      P23x4 = opencv_core.CvMat.createThreadLocal(3, 4);
      return;
    }
  }
  
  public ProjectiveDevice(Settings paramSettings)
    throws Exception
  {
    setSettings(paramSettings);
    if ((paramSettings instanceof CalibratedSettings)) {
      readParameters(((CalibratedSettings)paramSettings).parametersFile);
    }
  }
  
  public ProjectiveDevice(String paramString)
  {
    Settings localSettings = new Settings();
    localSettings.name = paramString;
    setSettings(localSettings);
  }
  
  public ProjectiveDevice(String paramString, opencv_core.CvFileStorage paramCvFileStorage)
    throws Exception
  {
    this(paramString);
    readParameters(paramCvFileStorage);
  }
  
  public ProjectiveDevice(String paramString, File paramFile)
    throws Exception
  {
    this(paramString);
    readParameters(paramFile);
  }
  
  public ProjectiveDevice(String paramString1, String paramString2)
    throws Exception
  {
    this(paramString1);
    readParameters(paramString2);
  }
  
  public static double[] distort(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d1 = paramArrayOfDouble2[0];
    double d2 = paramArrayOfDouble2[1];
    double d3;
    if (paramArrayOfDouble2.length > 4)
    {
      d3 = paramArrayOfDouble2[4];
      if (paramArrayOfDouble2.length <= 5) {
        break label249;
      }
      paramArrayOfDouble2[5];
      label30:
      if (paramArrayOfDouble2.length <= 6) {
        break label252;
      }
      paramArrayOfDouble2[6];
      label42:
      if (paramArrayOfDouble2.length <= 7) {
        break label255;
      }
      paramArrayOfDouble2[7];
    }
    double[] arrayOfDouble;
    label249:
    label252:
    label255:
    for (;;)
    {
      double d4 = paramArrayOfDouble2[2];
      double d5 = paramArrayOfDouble2[3];
      arrayOfDouble = (double[])paramArrayOfDouble1.clone();
      for (int i = 0; i < paramArrayOfDouble1.length / 2; i++)
      {
        double d6 = paramArrayOfDouble1[(i * 2)];
        double d7 = paramArrayOfDouble1[(1 + i * 2)];
        double d8 = d6 * d6 + d7 * d7;
        double d9 = 1.0D + d1 * d8 + d8 * (d2 * d8) + d8 * (d8 * (d3 * d8));
        double d10 = d7 * (d6 * (2.0D * d4)) + d5 * (d8 + d6 * (2.0D * d6));
        double d11 = d4 * (d8 + d7 * (2.0D * d7)) + d7 * (d6 * (2.0D * d5));
        arrayOfDouble[(i * 2)] = (d10 + d6 * d9);
        arrayOfDouble[(1 + i * 2)] = (d11 + d7 * d9);
      }
      d3 = 0.0D;
      break;
      break label30;
      break label42;
    }
    return arrayOfDouble;
  }
  
  private void initDistortMaps()
  {
    int i = this.mapsPyramidLevel;
    opencv_core.IplImage localIplImage1;
    opencv_core.IplImage localIplImage2;
    if ((this.distortMaps1[i] == null) || (this.distortMaps2[i] == null))
    {
      localIplImage1 = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
      localIplImage2 = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
      FloatBuffer localFloatBuffer1 = localIplImage1.getFloatBuffer();
      FloatBuffer localFloatBuffer2 = localIplImage2.getFloatBuffer();
      int j = localIplImage1.width();
      int k = localIplImage1.height();
      for (int m = 0; m < k; m++) {
        for (int i2 = 0; i2 < j; i2++)
        {
          double[] arrayOfDouble1 = new double[2];
          arrayOfDouble1[0] = i2;
          arrayOfDouble1[1] = m;
          double[] arrayOfDouble2 = undistort(arrayOfDouble1);
          localFloatBuffer1.put((float)arrayOfDouble2[0]);
          localFloatBuffer2.put((float)arrayOfDouble2[1]);
        }
      }
      if (!this.fixedPointMaps) {
        break label340;
      }
      this.distortMaps1[i] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, -2147483632, 2);
      this.distortMaps2[i] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 16, 1);
      opencv_imgproc.cvConvertMaps(localIplImage1, localIplImage2, this.distortMaps1[i], this.distortMaps2[i]);
      localIplImage1.release();
      localIplImage2.release();
    }
    for (;;)
    {
      if (this.mapsPyramidLevel > 0)
      {
        opencv_core.IplImage localIplImage3 = this.distortMaps1[i];
        opencv_core.IplImage localIplImage4 = this.distortMaps2[i];
        int n = this.imageWidth >> i;
        int i1 = this.imageHeight >> i;
        this.distortMaps1[i] = opencv_core.IplImage.create(n, i1, localIplImage3.depth(), localIplImage3.nChannels());
        this.distortMaps2[i] = opencv_core.IplImage.create(n, i1, localIplImage4.depth(), localIplImage4.nChannels());
        opencv_imgproc.cvResize(localIplImage3, this.distortMaps1[i], 0);
        opencv_imgproc.cvResize(localIplImage4, this.distortMaps2[i], 0);
      }
      return;
      label340:
      this.distortMaps1[i] = localIplImage1;
      this.distortMaps2[i] = localIplImage2;
    }
  }
  
  private void initUndistortMaps()
  {
    int i = this.mapsPyramidLevel;
    if ((this.undistortMaps1[i] == null) || (this.undistortMaps2[i] == null))
    {
      if (!this.fixedPointMaps) {
        break label195;
      }
      this.undistortMaps1[i] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, -2147483632, 2);
      this.undistortMaps2[i] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 16, 1);
    }
    for (;;)
    {
      opencv_imgproc.cvInitUndistortMap(this.cameraMatrix, this.distortionCoeffs, this.undistortMaps1[i], this.undistortMaps2[i]);
      if (this.mapsPyramidLevel > 0)
      {
        opencv_core.IplImage localIplImage1 = this.undistortMaps1[i];
        opencv_core.IplImage localIplImage2 = this.undistortMaps2[i];
        int j = this.imageWidth >> i;
        int k = this.imageHeight >> i;
        this.undistortMaps1[i] = opencv_core.IplImage.create(j, k, localIplImage1.depth(), localIplImage1.nChannels());
        this.undistortMaps2[i] = opencv_core.IplImage.create(j, k, localIplImage2.depth(), localIplImage2.nChannels());
        opencv_imgproc.cvResize(localIplImage1, this.undistortMaps1[i], 0);
        opencv_imgproc.cvResize(localIplImage2, this.undistortMaps2[i], 0);
      }
      return;
      label195:
      this.undistortMaps1[i] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
      this.undistortMaps2[i] = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 32, 1);
    }
  }
  
  public static double[] normalize(double[] paramArrayOfDouble, opencv_core.CvMat paramCvMat)
  {
    double[] arrayOfDouble = (double[])paramArrayOfDouble.clone();
    double d1 = paramCvMat.get(0) / paramCvMat.get(8);
    double d2 = paramCvMat.get(4) / paramCvMat.get(8);
    double d3 = paramCvMat.get(2) / paramCvMat.get(8);
    double d4 = paramCvMat.get(5) / paramCvMat.get(8);
    double d5 = paramCvMat.get(1) / paramCvMat.get(8);
    for (int i = 0; i < paramArrayOfDouble.length / 2; i++)
    {
      arrayOfDouble[(i * 2)] = ((paramArrayOfDouble[(i * 2)] - d3) / d1 - d5 * (d4 + paramArrayOfDouble[(1 + i * 2)]) / (d1 * d2));
      arrayOfDouble[(1 + i * 2)] = ((paramArrayOfDouble[(1 + i * 2)] - d4) / d2);
    }
    return arrayOfDouble;
  }
  
  public static ProjectiveDevice[] read(String paramString)
    throws Exception
  {
    opencv_core.CvFileStorage localCvFileStorage = opencv_core.CvFileStorage.open(paramString, null, 0);
    CameraDevice[] arrayOfCameraDevice = CameraDevice.read(localCvFileStorage);
    ProjectorDevice[] arrayOfProjectorDevice = ProjectorDevice.read(localCvFileStorage);
    ProjectiveDevice[] arrayOfProjectiveDevice = new ProjectiveDevice[arrayOfCameraDevice.length + arrayOfProjectorDevice.length];
    int i = arrayOfCameraDevice.length;
    int j = 0;
    int i2;
    for (int k = 0; j < i; k = i2)
    {
      CameraDevice localCameraDevice = arrayOfCameraDevice[j];
      i2 = k + 1;
      arrayOfProjectiveDevice[k] = localCameraDevice;
      j++;
    }
    int m = arrayOfProjectorDevice.length;
    int n = 0;
    while (n < m)
    {
      ProjectorDevice localProjectorDevice = arrayOfProjectorDevice[n];
      int i1 = k + 1;
      arrayOfProjectiveDevice[k] = localProjectorDevice;
      n++;
      k = i1;
    }
    localCvFileStorage.release();
    return arrayOfProjectiveDevice;
  }
  
  public static double[] undistort(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d1 = paramArrayOfDouble2[0];
    double d2 = paramArrayOfDouble2[1];
    double d3;
    label30:
    label42:
    label54:
    double d4;
    double d5;
    double[] arrayOfDouble;
    if (paramArrayOfDouble2.length > 4)
    {
      d3 = paramArrayOfDouble2[4];
      if (paramArrayOfDouble2.length <= 5) {
        break label267;
      }
      paramArrayOfDouble2[5];
      if (paramArrayOfDouble2.length <= 6) {
        break label270;
      }
      paramArrayOfDouble2[6];
      if (paramArrayOfDouble2.length <= 7) {
        break label273;
      }
      paramArrayOfDouble2[7];
      d4 = paramArrayOfDouble2[2];
      d5 = paramArrayOfDouble2[3];
      arrayOfDouble = (double[])paramArrayOfDouble1.clone();
    }
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfDouble1.length / 2) {
        break label302;
      }
      double d6 = arrayOfDouble[(i * 2)];
      double d7 = arrayOfDouble[(1 + i * 2)];
      double d8 = paramArrayOfDouble1[(i * 2)];
      double d9 = paramArrayOfDouble1[(1 + i * 2)];
      int j = 0;
      for (;;)
      {
        if (j < 20)
        {
          double d10 = d6 * d6 + d7 * d7;
          double d11 = 1.0D + d1 * d10 + d10 * (d2 * d10) + d10 * (d10 * (d3 * d10));
          double d12 = d7 * (d6 * (2.0D * d4)) + d5 * (d10 + d6 * (2.0D * d6));
          double d13 = d4 * (d10 + d7 * (2.0D * d7)) + d7 * (d6 * (2.0D * d5));
          d6 = (d8 - d12) / d11;
          d7 = (d9 - d13) / d11;
          j++;
          continue;
          d3 = 0.0D;
          break;
          label267:
          break label30;
          label270:
          break label42;
          label273:
          break label54;
        }
      }
      arrayOfDouble[(i * 2)] = d6;
      arrayOfDouble[(1 + i * 2)] = d7;
    }
    label302:
    return arrayOfDouble;
  }
  
  public static double[] unnormalize(double[] paramArrayOfDouble, opencv_core.CvMat paramCvMat)
  {
    double[] arrayOfDouble = (double[])paramArrayOfDouble.clone();
    double d1 = paramCvMat.get(0) / paramCvMat.get(8);
    double d2 = paramCvMat.get(4) / paramCvMat.get(8);
    double d3 = paramCvMat.get(2) / paramCvMat.get(8);
    double d4 = paramCvMat.get(5) / paramCvMat.get(8);
    double d5 = paramCvMat.get(1) / paramCvMat.get(8);
    for (int i = 0; i < paramArrayOfDouble.length / 2; i++)
    {
      arrayOfDouble[(i * 2)] = (d3 + d1 * paramArrayOfDouble[(i * 2)] + d5 * paramArrayOfDouble[(1 + i * 2)]);
      arrayOfDouble[(1 + i * 2)] = (d4 + d2 * paramArrayOfDouble[(1 + i * 2)]);
    }
    return arrayOfDouble;
  }
  
  public static void write(String paramString, ProjectiveDevice... paramVarArgs)
  {
    opencv_core.CvFileStorage localCvFileStorage = opencv_core.CvFileStorage.open(paramString, null, 1);
    opencv_core.CvAttrList localCvAttrList = opencv_core.cvAttrList();
    opencv_core.cvStartWriteStruct(localCvFileStorage, "Cameras", 5, null, localCvAttrList);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      ProjectiveDevice localProjectiveDevice2 = paramVarArgs[j];
      if ((localProjectiveDevice2 instanceof CameraDevice)) {
        opencv_core.cvWriteString(localCvFileStorage, null, localProjectiveDevice2.getSettings().getName(), 0);
      }
    }
    opencv_core.cvEndWriteStruct(localCvFileStorage);
    opencv_core.cvStartWriteStruct(localCvFileStorage, "Projectors", 5, null, localCvAttrList);
    int k = paramVarArgs.length;
    for (int m = 0; m < k; m++)
    {
      ProjectiveDevice localProjectiveDevice1 = paramVarArgs[m];
      if ((localProjectiveDevice1 instanceof ProjectorDevice)) {
        opencv_core.cvWriteString(localCvFileStorage, null, localProjectiveDevice1.getSettings().getName(), 0);
      }
    }
    opencv_core.cvEndWriteStruct(localCvFileStorage);
    int n = paramVarArgs.length;
    for (int i1 = 0; i1 < n; i1++) {
      paramVarArgs[i1].writeParameters(localCvFileStorage);
    }
    localCvFileStorage.release();
  }
  
  public static void write(String paramString, ProjectiveDevice[]... paramVarArgs)
  {
    int i = 0;
    int j = paramVarArgs.length;
    for (int k = 0; k < j; k++) {
      i += paramVarArgs[k].length;
    }
    ProjectiveDevice[] arrayOfProjectiveDevice1 = new ProjectiveDevice[i];
    int m = 0;
    int n = paramVarArgs.length;
    int i1 = 0;
    while (i1 < n)
    {
      ProjectiveDevice[] arrayOfProjectiveDevice2 = paramVarArgs[i1];
      int i2 = arrayOfProjectiveDevice2.length;
      int i3 = 0;
      int i5;
      for (int i4 = m; i3 < i2; i4 = i5)
      {
        ProjectiveDevice localProjectiveDevice = arrayOfProjectiveDevice2[i3];
        i5 = i4 + 1;
        arrayOfProjectiveDevice1[i4] = localProjectiveDevice;
        i3++;
      }
      i1++;
      m = i4;
    }
    write(paramString, arrayOfProjectiveDevice1);
  }
  
  public opencv_core.IplImage distort(opencv_core.IplImage paramIplImage)
  {
    if (paramIplImage != null)
    {
      initDistortMaps();
      this.tempImage = opencv_core.IplImage.createIfNotCompatible(this.tempImage, paramIplImage);
      opencv_imgproc.cvRemap(paramIplImage, this.tempImage, this.distortMaps1[this.mapsPyramidLevel], this.distortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
      return this.tempImage;
    }
    return null;
  }
  
  public void distort(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2)
  {
    if ((paramIplImage1 != null) && (paramIplImage2 != null))
    {
      initDistortMaps();
      opencv_imgproc.cvRemap(paramIplImage1, paramIplImage2, this.distortMaps1[this.mapsPyramidLevel], this.distortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
    }
  }
  
  public double[] distort(double... paramVarArgs)
  {
    return unnormalize(distort(normalize(paramVarArgs, this.cameraMatrix), this.distortionCoeffs.get()), this.cameraMatrix);
  }
  
  public opencv_core.CvMat getBackProjectionMatrix(opencv_core.CvMat paramCvMat1, double paramDouble, opencv_core.CvMat paramCvMat2)
  {
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)temp3x3.get();
    localCvMat.cols(1);
    localCvMat.step(localCvMat.step() / 3);
    paramCvMat2.rows(3);
    opencv_core.cvGEMM(this.R, this.T, -1.0D, null, 0.0D, localCvMat, 1);
    opencv_core.cvGEMM(localCvMat, paramCvMat1, 1.0D, null, 0.0D, paramCvMat2, 2);
    double d = paramDouble + opencv_core.cvDotProduct(paramCvMat1, localCvMat);
    paramCvMat2.put(0, paramCvMat2.get(0) - d);
    paramCvMat2.put(4, paramCvMat2.get(4) - d);
    paramCvMat2.put(8, paramCvMat2.get(8) - d);
    paramCvMat2.rows(4);
    localCvMat.cols(3);
    localCvMat.step(3 * localCvMat.step());
    paramCvMat2.put(9, paramCvMat1.get());
    opencv_core.cvMatMul(this.cameraMatrix, this.R, localCvMat);
    opencv_core.cvInvert(localCvMat, localCvMat, 0);
    opencv_core.cvMatMul(paramCvMat2, localCvMat, paramCvMat2);
    opencv_core.cvConvertScale(paramCvMat2, paramCvMat2, 1.0D / paramCvMat2.get(11), 0.0D);
    return paramCvMat2;
  }
  
  public opencv_core.IplImage getDistortMap1()
  {
    initDistortMaps();
    return this.distortMaps1[this.mapsPyramidLevel];
  }
  
  public opencv_core.IplImage getDistortMap2()
  {
    initDistortMaps();
    return this.distortMaps2[this.mapsPyramidLevel];
  }
  
  public opencv_core.CvMat getFrontoParallelH(double[] paramArrayOfDouble, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)B4x3.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)a4x1.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)t3x1.get();
    double d1 = Math.signum(paramCvMat1.get(2));
    double[] arrayOfDouble1 = JavaCV.unitize(-d1 * paramCvMat1.get(1), d1 * paramCvMat1.get(0));
    double d2 = Math.acos(d1 * paramCvMat1.get(2) / JavaCV.norm(paramCvMat1.get()));
    double[] arrayOfDouble2 = new double[3];
    arrayOfDouble2[0] = (d2 * arrayOfDouble1[0]);
    arrayOfDouble2[1] = (d2 * arrayOfDouble1[1]);
    arrayOfDouble2[2] = 0.0D;
    localCvMat3.put(arrayOfDouble2);
    opencv_calib3d.cvRodrigues2(localCvMat3, paramCvMat2, null);
    opencv_core.cvMatMul(this.R, paramCvMat2, paramCvMat2);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (paramArrayOfDouble != null)
    {
      double d5 = paramArrayOfDouble[0];
      double d6 = paramArrayOfDouble[1];
      double d7 = paramArrayOfDouble[4];
      double d8 = paramArrayOfDouble[5];
      double d9 = paramArrayOfDouble[2];
      double d10 = paramArrayOfDouble[3];
      double d11 = paramArrayOfDouble[6];
      double d12 = paramArrayOfDouble[7];
      double d13 = ((d11 - d9) * (d6 - d10) - (d12 - d10) * (d5 - d9)) / ((d12 - d10) * (d7 - d5) - (d11 - d9) * (d8 - d6));
      d3 = d5 + d13 * (d7 - d5);
      d4 = d6 + d13 * (d8 - d6);
    }
    getBackProjectionMatrix(paramCvMat1, -1.0D, localCvMat1);
    localCvMat3.put(new double[] { d3, d4, 1.0D });
    opencv_core.cvMatMul(localCvMat1, localCvMat3, localCvMat2);
    paramCvMat2.put(2, localCvMat2.get(0) / localCvMat2.get(3));
    paramCvMat2.put(5, localCvMat2.get(1) / localCvMat2.get(3));
    paramCvMat2.put(8, localCvMat2.get(2) / localCvMat2.get(3));
    return paramCvMat2;
  }
  
  public int getMapsPyramidLevel()
  {
    return this.mapsPyramidLevel;
  }
  
  public int[] getRGBColorOrder()
  {
    int[] arrayOfInt = new int[3];
    int i = 0;
    if (i < 3)
    {
      switch (Character.toUpperCase(this.colorOrder.charAt(i)))
      {
      default: 
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
        break;
      case 'B': 
        arrayOfInt[i] = 2;
      }
      for (;;)
      {
        i++;
        break;
        arrayOfInt[i] = 1;
        continue;
        arrayOfInt[i] = 0;
      }
    }
    return arrayOfInt;
  }
  
  public opencv_core.CvMat getRectifyingHomography(ProjectiveDevice paramProjectiveDevice, opencv_core.CvMat paramCvMat)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)relativeR3x3.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)relativeT3x1.get();
    opencv_core.cvGEMM(this.R, paramProjectiveDevice.R, 1.0D, null, 0.0D, localCvMat1, 2);
    opencv_core.cvGEMM(localCvMat1, paramProjectiveDevice.T, -1.0D, this.T, 1.0D, localCvMat2, 0);
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)R13x3.get();
    opencv_core.CvMat localCvMat4 = (opencv_core.CvMat)P13x4.get();
    opencv_core.CvMat localCvMat5 = (opencv_core.CvMat)R23x3.get();
    opencv_core.CvMat localCvMat6 = (opencv_core.CvMat)P23x4.get();
    opencv_core.CvSize localCvSize = opencv_core.cvSize((paramProjectiveDevice.imageWidth + this.imageWidth) / 2, (paramProjectiveDevice.imageHeight + this.imageHeight) / 2);
    opencv_calib3d.cvStereoRectify(paramProjectiveDevice.cameraMatrix, this.cameraMatrix, paramProjectiveDevice.distortionCoeffs, this.distortionCoeffs, localCvSize, localCvMat1, localCvMat2, localCvMat3, localCvMat5, localCvMat4, localCvMat6, null, 0, -1.0D, opencv_core.CvSize.ZERO, null, null);
    opencv_core.cvMatMul(this.cameraMatrix, localCvMat5, localCvMat5);
    opencv_core.cvInvert(this.cameraMatrix, localCvMat3);
    opencv_core.cvMatMul(localCvMat5, localCvMat3, paramCvMat);
    return paramCvMat;
  }
  
  public Settings getSettings()
  {
    return this.settings;
  }
  
  public opencv_core.IplImage getUndistortMap1()
  {
    initUndistortMaps();
    return this.undistortMaps1[this.mapsPyramidLevel];
  }
  
  public opencv_core.IplImage getUndistortMap2()
  {
    initUndistortMaps();
    return this.undistortMaps2[this.mapsPyramidLevel];
  }
  
  public boolean isFixedPointMaps()
  {
    return this.fixedPointMaps;
  }
  
  public void readParameters(opencv_core.CvFileStorage paramCvFileStorage)
    throws Exception
  {
    if (paramCvFileStorage == null) {
      throw new Exception("Error: CvFileStorage is null, cannot read parameters for device " + getSettings().getName() + ". Is the parametersFile correct?");
    }
    opencv_core.CvAttrList localCvAttrList = opencv_core.cvAttrList();
    opencv_core.CvFileNode localCvFileNode = opencv_core.cvGetFileNodeByName(paramCvFileStorage, null, getSettings().getName());
    if (localCvFileNode == null) {
      throw new Exception("Error: CvFileNode is null, cannot read parameters for device " + getSettings().getName() + ". Is the name correct?");
    }
    this.imageWidth = opencv_core.cvReadIntByName(paramCvFileStorage, localCvFileNode, "imageWidth", this.imageWidth);
    this.imageHeight = opencv_core.cvReadIntByName(paramCvFileStorage, localCvFileNode, "imageHeight", this.imageHeight);
    getSettings().setResponseGamma(opencv_core.cvReadRealByName(paramCvFileStorage, localCvFileNode, "gamma", getSettings().getResponseGamma()));
    Pointer localPointer1 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "cameraMatrix", localCvAttrList);
    opencv_core.CvMat localCvMat1;
    Pointer localPointer2;
    opencv_core.CvMat localCvMat2;
    label203:
    Pointer localPointer3;
    opencv_core.CvMat localCvMat3;
    label228:
    Pointer localPointer4;
    opencv_core.CvMat localCvMat4;
    label253:
    Pointer localPointer5;
    opencv_core.CvMat localCvMat5;
    label310:
    Pointer localPointer6;
    opencv_core.CvMat localCvMat6;
    label335:
    Pointer localPointer7;
    opencv_core.CvMat localCvMat7;
    label360:
    Pointer localPointer8;
    opencv_core.CvMat localCvMat8;
    label385:
    Pointer localPointer9;
    opencv_core.CvMat localCvMat9;
    label458:
    Pointer localPointer10;
    opencv_core.CvMat localCvMat10;
    if (localPointer1 == null)
    {
      localCvMat1 = null;
      this.cameraMatrix = localCvMat1;
      localPointer2 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "distortionCoeffs", localCvAttrList);
      if (localPointer2 != null) {
        break label536;
      }
      localCvMat2 = null;
      this.distortionCoeffs = localCvMat2;
      localPointer3 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "extrParams", localCvAttrList);
      if (localPointer3 != null) {
        break label550;
      }
      localCvMat3 = null;
      this.extrParams = localCvMat3;
      localPointer4 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "reprojErrs", localCvAttrList);
      if (localPointer4 != null) {
        break label564;
      }
      localCvMat4 = null;
      this.reprojErrs = localCvMat4;
      this.avgReprojErr = opencv_core.cvReadRealByName(paramCvFileStorage, localCvFileNode, "avgReprojErr", this.avgReprojErr);
      this.maxReprojErr = opencv_core.cvReadRealByName(paramCvFileStorage, localCvFileNode, "maxReprojErr", this.maxReprojErr);
      localPointer5 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "R", localCvAttrList);
      if (localPointer5 != null) {
        break label578;
      }
      localCvMat5 = null;
      this.R = localCvMat5;
      localPointer6 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "T", localCvAttrList);
      if (localPointer6 != null) {
        break label592;
      }
      localCvMat6 = null;
      this.T = localCvMat6;
      localPointer7 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "E", localCvAttrList);
      if (localPointer7 != null) {
        break label606;
      }
      localCvMat7 = null;
      this.E = localCvMat7;
      localPointer8 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "F", localCvAttrList);
      if (localPointer8 != null) {
        break label620;
      }
      localCvMat8 = null;
      this.F = localCvMat8;
      this.avgEpipolarErr = opencv_core.cvReadRealByName(paramCvFileStorage, localCvFileNode, "avgEpipolarErr", this.avgEpipolarErr);
      this.maxEpipolarErr = opencv_core.cvReadRealByName(paramCvFileStorage, localCvFileNode, "maxEpipolarErr", this.maxEpipolarErr);
      this.colorOrder = opencv_core.cvReadStringByName(paramCvFileStorage, localCvFileNode, "colorOrder", this.colorOrder);
      localPointer9 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "colorMixingMatrix", localCvAttrList);
      if (localPointer9 != null) {
        break label634;
      }
      localCvMat9 = null;
      this.colorMixingMatrix = localCvMat9;
      localPointer10 = opencv_core.cvReadByName(paramCvFileStorage, localCvFileNode, "additiveLight", localCvAttrList);
      localCvMat10 = null;
      if (localPointer10 != null) {
        break label648;
      }
    }
    for (;;)
    {
      this.additiveLight = localCvMat10;
      this.avgColorErr = opencv_core.cvReadRealByName(paramCvFileStorage, localCvFileNode, "avgColorErr", this.avgColorErr);
      this.colorR2 = opencv_core.cvReadRealByName(paramCvFileStorage, localCvFileNode, "colorR2", this.colorR2);
      return;
      localCvMat1 = new opencv_core.CvMat(localPointer1);
      break;
      label536:
      localCvMat2 = new opencv_core.CvMat(localPointer2);
      break label203;
      label550:
      localCvMat3 = new opencv_core.CvMat(localPointer3);
      break label228;
      label564:
      localCvMat4 = new opencv_core.CvMat(localPointer4);
      break label253;
      label578:
      localCvMat5 = new opencv_core.CvMat(localPointer5);
      break label310;
      label592:
      localCvMat6 = new opencv_core.CvMat(localPointer6);
      break label335;
      label606:
      localCvMat7 = new opencv_core.CvMat(localPointer7);
      break label360;
      label620:
      localCvMat8 = new opencv_core.CvMat(localPointer8);
      break label385;
      label634:
      localCvMat9 = new opencv_core.CvMat(localPointer9);
      break label458;
      label648:
      localCvMat10 = new opencv_core.CvMat(localPointer10);
    }
  }
  
  public void readParameters(File paramFile)
    throws Exception
  {
    readParameters(paramFile.getAbsolutePath());
  }
  
  public void readParameters(String paramString)
    throws Exception
  {
    opencv_core.CvFileStorage localCvFileStorage = opencv_core.CvFileStorage.open(paramString, null, 0);
    readParameters(localCvFileStorage);
    localCvFileStorage.release();
  }
  
  public void rescale(int paramInt1, int paramInt2)
  {
    if (((paramInt1 != this.imageWidth) || (paramInt2 != this.imageHeight)) && (this.cameraMatrix != null))
    {
      double d1 = paramInt1 / this.imageWidth;
      double d2 = paramInt2 / this.imageHeight;
      this.cameraMatrix.put(0, d1 * this.cameraMatrix.get(0));
      this.cameraMatrix.put(1, d1 * this.cameraMatrix.get(1));
      this.cameraMatrix.put(2, d1 * this.cameraMatrix.get(2));
      this.cameraMatrix.put(3, d2 * this.cameraMatrix.get(3));
      this.cameraMatrix.put(4, d2 * this.cameraMatrix.get(4));
      this.cameraMatrix.put(5, d2 * this.cameraMatrix.get(5));
      this.imageWidth = paramInt1;
      this.imageHeight = paramInt2;
      int i = this.mapsPyramidLevel;
      opencv_core.IplImage[] arrayOfIplImage1 = this.undistortMaps1;
      opencv_core.IplImage[] arrayOfIplImage2 = this.undistortMaps2;
      opencv_core.IplImage[] arrayOfIplImage3 = this.distortMaps1;
      this.distortMaps2[i] = null;
      arrayOfIplImage3[i] = null;
      arrayOfIplImage2[i] = null;
      arrayOfIplImage1[i] = null;
    }
  }
  
  public void setFixedPointMaps(boolean paramBoolean)
  {
    if (this.fixedPointMaps != paramBoolean)
    {
      this.fixedPointMaps = paramBoolean;
      int i = this.mapsPyramidLevel;
      opencv_core.IplImage[] arrayOfIplImage1 = this.undistortMaps1;
      opencv_core.IplImage[] arrayOfIplImage2 = this.undistortMaps2;
      opencv_core.IplImage[] arrayOfIplImage3 = this.distortMaps1;
      this.distortMaps2[i] = null;
      arrayOfIplImage3[i] = null;
      arrayOfIplImage2[i] = null;
      arrayOfIplImage1[i] = null;
    }
  }
  
  public void setMapsPyramidLevel(int paramInt)
  {
    if (this.mapsPyramidLevel != paramInt)
    {
      this.mapsPyramidLevel = paramInt;
      if ((paramInt >= this.undistortMaps1.length) || (paramInt >= this.undistortMaps2.length) || (paramInt >= this.distortMaps1.length) || (paramInt >= this.distortMaps2.length))
      {
        this.undistortMaps1 = ((opencv_core.IplImage[])Arrays.copyOf(this.undistortMaps1, paramInt + 1));
        this.undistortMaps2 = ((opencv_core.IplImage[])Arrays.copyOf(this.undistortMaps2, paramInt + 1));
        this.distortMaps1 = ((opencv_core.IplImage[])Arrays.copyOf(this.distortMaps1, paramInt + 1));
        this.distortMaps2 = ((opencv_core.IplImage[])Arrays.copyOf(this.distortMaps2, paramInt + 1));
      }
    }
  }
  
  public void setSettings(Settings paramSettings)
  {
    this.settings = paramSettings;
  }
  
  public String toString()
  {
    String str1 = getSettings().getName() + " (" + this.imageWidth + " x " + this.imageHeight + ")\n";
    for (int i = 0; i < getSettings().getName().length(); i++) {
      str1 = str1 + "=";
    }
    StringBuilder localStringBuilder1 = new StringBuilder().append(str1).append("\nIntrinsics\n----------\ncamera matrix = ");
    String str2;
    Object localObject;
    label158:
    String str3;
    label237:
    String str4;
    label270:
    String str5;
    label368:
    StringBuilder localStringBuilder6;
    if (this.cameraMatrix == null)
    {
      str2 = "null";
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("\n").append("distortion coefficients = ");
      if (this.distortionCoeffs != null) {
        break label466;
      }
      localObject = "null";
      StringBuilder localStringBuilder3 = localStringBuilder2.append(localObject).append("\n").append("reprojection RMS/max error (pixels) = ").append((float)this.avgReprojErr).append(" / ").append((float)this.maxReprojErr).append("\n\n").append("Extrinsics\n").append("----------\n").append("rotation = ");
      if (this.R != null) {
        break label475;
      }
      str3 = "null";
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append("\n").append("translation = ");
      if (this.T != null) {
        break label489;
      }
      str4 = "null";
      StringBuilder localStringBuilder5 = localStringBuilder4.append(str4).append("\n").append("epipolar RMS/max error (pixels) = ").append((float)this.avgEpipolarErr).append(" / ").append((float)this.maxEpipolarErr).append("\n\n").append("Color\n").append("-----\n").append("order = ").append(this.colorOrder).append("\n").append("mixing matrix = ");
      if (this.colorMixingMatrix != null) {
        break label503;
      }
      str5 = "null";
      localStringBuilder6 = localStringBuilder5.append(str5).append("\n").append("additive light = ");
      if (this.additiveLight != null) {
        break label517;
      }
    }
    label466:
    label475:
    label489:
    label503:
    label517:
    for (String str6 = "null";; str6 = this.additiveLight.toString(17))
    {
      return str6 + "\n" + "normalized RMSE (intensity) = " + (float)this.avgColorErr + "\n" + "R^2 (intensity) = " + (float)this.colorR2;
      str2 = this.cameraMatrix.toString(16);
      break;
      localObject = this.distortionCoeffs;
      break label158;
      str3 = this.R.toString(11);
      break label237;
      str4 = this.T.toString(14);
      break label270;
      str5 = this.colorMixingMatrix.toString(16);
      break label368;
    }
  }
  
  public opencv_core.IplImage undistort(opencv_core.IplImage paramIplImage)
  {
    if (paramIplImage != null)
    {
      initUndistortMaps();
      this.tempImage = opencv_core.IplImage.createIfNotCompatible(this.tempImage, paramIplImage);
      opencv_core.cvResetImageROI(this.tempImage);
      opencv_imgproc.cvRemap(paramIplImage, this.tempImage, this.undistortMaps1[this.mapsPyramidLevel], this.undistortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
      return this.tempImage;
    }
    return null;
  }
  
  public void undistort(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2)
  {
    if ((paramIplImage1 != null) && (paramIplImage2 != null))
    {
      initUndistortMaps();
      opencv_imgproc.cvRemap(paramIplImage1, paramIplImage2, this.undistortMaps1[this.mapsPyramidLevel], this.undistortMaps2[this.mapsPyramidLevel], 9, opencv_core.CvScalar.ZERO);
    }
  }
  
  public double[] undistort(double... paramVarArgs)
  {
    return unnormalize(undistort(normalize(paramVarArgs, this.cameraMatrix), this.distortionCoeffs.get()), this.cameraMatrix);
  }
  
  public void writeParameters(opencv_core.CvFileStorage paramCvFileStorage)
  {
    opencv_core.CvAttrList localCvAttrList = opencv_core.cvAttrList();
    opencv_core.cvStartWriteStruct(paramCvFileStorage, getSettings().getName(), 6, null, localCvAttrList);
    opencv_core.cvWriteInt(paramCvFileStorage, "imageWidth", this.imageWidth);
    opencv_core.cvWriteInt(paramCvFileStorage, "imageHeight", this.imageHeight);
    opencv_core.cvWriteReal(paramCvFileStorage, "responseGamma", getSettings().getResponseGamma());
    if (this.cameraMatrix != null) {
      opencv_core.cvWrite(paramCvFileStorage, "cameraMatrix", this.cameraMatrix, localCvAttrList);
    }
    if (this.distortionCoeffs != null) {
      opencv_core.cvWrite(paramCvFileStorage, "distortionCoeffs", this.distortionCoeffs, localCvAttrList);
    }
    if (this.extrParams != null) {
      opencv_core.cvWrite(paramCvFileStorage, "extrParams", this.extrParams, localCvAttrList);
    }
    if (this.reprojErrs != null) {
      opencv_core.cvWrite(paramCvFileStorage, "reprojErrs", this.reprojErrs, localCvAttrList);
    }
    opencv_core.cvWriteReal(paramCvFileStorage, "avgReprojErr", this.avgReprojErr);
    opencv_core.cvWriteReal(paramCvFileStorage, "maxReprojErr", this.maxReprojErr);
    if (this.R != null) {
      opencv_core.cvWrite(paramCvFileStorage, "R", this.R, localCvAttrList);
    }
    if (this.T != null) {
      opencv_core.cvWrite(paramCvFileStorage, "T", this.T, localCvAttrList);
    }
    if (this.E != null) {
      opencv_core.cvWrite(paramCvFileStorage, "E", this.E, localCvAttrList);
    }
    if (this.F != null) {
      opencv_core.cvWrite(paramCvFileStorage, "F", this.F, localCvAttrList);
    }
    opencv_core.cvWriteReal(paramCvFileStorage, "avgEpipolarErr", this.avgEpipolarErr);
    opencv_core.cvWriteReal(paramCvFileStorage, "maxEpipolarErr", this.maxEpipolarErr);
    opencv_core.cvWriteString(paramCvFileStorage, "colorOrder", this.colorOrder, 0);
    if (this.colorMixingMatrix != null) {
      opencv_core.cvWrite(paramCvFileStorage, "colorMixingMatrix", this.colorMixingMatrix, localCvAttrList);
    }
    if (this.additiveLight != null) {
      opencv_core.cvWrite(paramCvFileStorage, "additiveLight", this.additiveLight, localCvAttrList);
    }
    opencv_core.cvWriteReal(paramCvFileStorage, "avgColorErr", this.avgColorErr);
    opencv_core.cvWriteReal(paramCvFileStorage, "colorR2", this.colorR2);
    opencv_core.cvEndWriteStruct(paramCvFileStorage);
  }
  
  public void writeParameters(File paramFile)
  {
    writeParameters(paramFile.getAbsolutePath());
  }
  
  public void writeParameters(String paramString)
  {
    opencv_core.CvFileStorage localCvFileStorage = opencv_core.CvFileStorage.open(paramString, null, 1);
    writeParameters(localCvFileStorage);
    localCvFileStorage.release();
  }
  
  public static class CalibratedSettings
    extends Settings
  {
    File parametersFile = new File("calibration.yaml");
    
    public CalibratedSettings() {}
    
    public CalibratedSettings(CalibratedSettings paramCalibratedSettings)
    {
      super();
      this.parametersFile = paramCalibratedSettings.parametersFile;
    }
    
    public File getParametersFile()
    {
      return this.parametersFile;
    }
    
    public String getParametersFilename()
    {
      if (this.parametersFile == null) {
        return "";
      }
      return this.parametersFile.getPath();
    }
    
    public void setParametersFile(File paramFile)
    {
      this.parametersFile = paramFile;
    }
    
    public void setParametersFilename(String paramString)
    {
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (File localFile = null;; localFile = new File(paramString))
      {
        this.parametersFile = localFile;
        return;
      }
    }
  }
  
  public static class CalibrationSettings
    extends Settings
  {
    int flags = 14720;
    double initAspectRatio = 1.0D;
    
    public CalibrationSettings() {}
    
    public CalibrationSettings(CalibrationSettings paramCalibrationSettings)
    {
      super();
      this.initAspectRatio = paramCalibrationSettings.initAspectRatio;
      this.flags = paramCalibrationSettings.flags;
    }
    
    public double getInitAspectRatio()
    {
      return this.initAspectRatio;
    }
    
    public boolean isFixAspectRatio()
    {
      return (0x2 & this.flags) != 0;
    }
    
    public boolean isFixFocalLength()
    {
      return (0x10 & this.flags) != 0;
    }
    
    public boolean isFixK1()
    {
      return (0x20 & this.flags) != 0;
    }
    
    public boolean isFixK2()
    {
      return (0x40 & this.flags) != 0;
    }
    
    public boolean isFixK3()
    {
      return (0x80 & this.flags) != 0;
    }
    
    public boolean isFixK4()
    {
      return (0x800 & this.flags) != 0;
    }
    
    public boolean isFixK5()
    {
      return (0x1000 & this.flags) != 0;
    }
    
    public boolean isFixK6()
    {
      return (0x2000 & this.flags) != 0;
    }
    
    public boolean isFixPrincipalPoint()
    {
      return (0x4 & this.flags) != 0;
    }
    
    public boolean isRationalModel()
    {
      return (0x4000 & this.flags) != 0;
    }
    
    public boolean isStereoFixIntrinsic()
    {
      return (0x100 & this.flags) != 0;
    }
    
    public boolean isStereoSameFocalLength()
    {
      return (0x200 & this.flags) != 0;
    }
    
    public boolean isUseIntrinsicGuess()
    {
      return (0x1 & this.flags) != 0;
    }
    
    public boolean isZeroTangentDist()
    {
      return (0x8 & this.flags) != 0;
    }
    
    public void setFixAspectRatio(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x2 | this.flags);
        return;
      }
      this.flags = (0xFFFFFFFD & this.flags);
    }
    
    public void setFixFocalLength(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x10 | this.flags);
        return;
      }
      this.flags = (0xFFFFFFEF & this.flags);
    }
    
    public void setFixK1(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x20 | this.flags);
        return;
      }
      this.flags = (0xFFFFFFDF & this.flags);
    }
    
    public void setFixK2(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x40 | this.flags);
        return;
      }
      this.flags = (0xFFFFFFBF & this.flags);
    }
    
    public void setFixK3(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x80 | this.flags);
        return;
      }
      this.flags = (0xFF7F & this.flags);
    }
    
    public void setFixK4(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x800 | this.flags);
        return;
      }
      this.flags = (0xF7FF & this.flags);
    }
    
    public void setFixK5(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x1000 | this.flags);
        return;
      }
      this.flags = (0xEFFF & this.flags);
    }
    
    public void setFixK6(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x2000 | this.flags);
        return;
      }
      this.flags = (0xDFFF & this.flags);
    }
    
    public void setFixPrincipalPoint(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x4 | this.flags);
        return;
      }
      this.flags = (0xFFFFFFFB & this.flags);
    }
    
    public void setInitAspectRatio(double paramDouble)
    {
      this.initAspectRatio = paramDouble;
    }
    
    public void setRationalModel(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x4000 | this.flags);
        return;
      }
      this.flags = (0xBFFF & this.flags);
    }
    
    public void setStereoFixIntrinsic(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x100 | this.flags);
        return;
      }
      this.flags = (0xFEFF & this.flags);
    }
    
    public void setStereoSameFocalLength(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x200 | this.flags);
        return;
      }
      this.flags = (0xFDFF & this.flags);
    }
    
    public void setUseIntrinsicGuess(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x1 | this.flags);
        return;
      }
      this.flags = (0xFFFFFFFE & this.flags);
    }
    
    public void setZeroTangentDist(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.flags = (0x8 | this.flags);
        return;
      }
      this.flags = (0xFFFFFFF7 & this.flags);
    }
  }
  
  public static class Exception
    extends Exception
  {
    public Exception(String paramString)
    {
      super();
    }
    
    public Exception(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static class Settings
    extends BaseChildSettings
  {
    String name = "";
    double responseGamma = 0.0D;
    
    public Settings() {}
    
    public Settings(Settings paramSettings)
    {
      this.name = paramSettings.name;
      this.responseGamma = paramSettings.responseGamma;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public double getResponseGamma()
    {
      return this.responseGamma;
    }
    
    public void setName(String paramString)
    {
      String str = this.name;
      this.name = paramString;
      firePropertyChange("name", str, paramString);
    }
    
    public void setResponseGamma(double paramDouble)
    {
      this.responseGamma = paramDouble;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProjectiveDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */