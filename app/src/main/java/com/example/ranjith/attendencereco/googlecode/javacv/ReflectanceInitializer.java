package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.logging.Logger;

public class ReflectanceInitializer
{
  private static ThreadLocal<opencv_core.CvMat> mat3x1;
  private static ThreadLocal<opencv_core.CvMat> mat3x3;
  private static ThreadLocal<opencv_core.CvMat> mat4x4;
  private GNImageAligner.Settings alignerSettings;
  private CameraDevice cameraDevice;
  private ProjectorDevice projectorDevice;
  private opencv_core.IplImage[] projectorImages;
  private double reflectanceMin;
  private int smoothingSize;
  
  static
  {
    if (!ReflectanceInitializer.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      mat3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      mat3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      mat4x4 = opencv_core.CvMat.createThreadLocal(4, 4);
      return;
    }
  }
  
  public ReflectanceInitializer(CameraDevice paramCameraDevice, ProjectorDevice paramProjectorDevice, int paramInt, GNImageAligner.Settings paramSettings)
  {
    this(paramCameraDevice, paramProjectorDevice, paramInt, paramSettings, 51, 0.01D);
  }
  
  public ReflectanceInitializer(CameraDevice paramCameraDevice, ProjectorDevice paramProjectorDevice, int paramInt1, GNImageAligner.Settings paramSettings, int paramInt2, double paramDouble)
  {
    this.alignerSettings = paramSettings;
    this.smoothingSize = paramInt2;
    this.reflectanceMin = paramDouble;
    this.cameraDevice = paramCameraDevice;
    this.projectorDevice = paramProjectorDevice;
    this.projectorImages = new opencv_core.IplImage[3];
    for (int i = 0; i < this.projectorImages.length; i++) {
      this.projectorImages[i] = opencv_core.IplImage.create(paramProjectorDevice.imageWidth, paramProjectorDevice.imageHeight, 32, paramInt1);
    }
    opencv_core.cvSetZero(this.projectorImages[0]);
    opencv_core.cvSet(this.projectorImages[1], opencv_core.CvScalar.ONE);
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)mat3x3.get();
    paramProjectorDevice.getRectifyingHomography(paramCameraDevice, localCvMat);
    JavaCV.fractalTriangleWave(this.projectorImages[2], localCvMat);
  }
  
  public opencv_core.IplImage[] getProjectorImages()
  {
    return this.projectorImages;
  }
  
  public opencv_core.CvMat initializePlaneParameters(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
  {
    ProCamTransformer localProCamTransformer = new ProCamTransformer(paramArrayOfDouble1, this.cameraDevice, this.projectorDevice, null);
    localProCamTransformer.setProjectorImage(this.projectorImages[2], 0, this.alignerSettings.pyramidLevelMax);
    ProCamTransformer.Parameters localParameters1 = localProCamTransformer.createParameters();
    int i = localParameters1.size() - paramArrayOfDouble3.length;
    int j = localParameters1.size();
    for (int k = i; k < j; k++) {
      localParameters1.set(k, paramArrayOfDouble3[(k - i)]);
    }
    GNImageAligner localGNImageAligner = new GNImageAligner(localProCamTransformer, localParameters1, paramIplImage1, paramArrayOfDouble2, paramIplImage2, this.alignerSettings);
    double[] arrayOfDouble = new double[1 + localParameters1.size()];
    boolean bool = false;
    long l = System.currentTimeMillis();
    for (int m = 0; (!bool) && (m < 100); m++) {
      bool = localGNImageAligner.iterate(arrayOfDouble);
    }
    ProCamTransformer.Parameters localParameters2 = (ProCamTransformer.Parameters)localGNImageAligner.getParameters();
    Logger.getLogger(ReflectanceInitializer.class.getName()).info("iteratingTime = " + (System.currentTimeMillis() - l) + "  iterations = " + m + "  objectiveRMSE = " + (float)localGNImageAligner.getRMSE());
    return localParameters2.getN0();
  }
  
  public opencv_core.IplImage initializeReflectance(opencv_core.IplImage[] paramArrayOfIplImage, opencv_core.IplImage paramIplImage, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i = paramArrayOfIplImage[0].width();
    int j = paramArrayOfIplImage[0].height();
    int k = paramArrayOfIplImage[0].nChannels();
    opencv_core.IplImage localIplImage1 = opencv_core.IplImage.create(i, j, 8, 1);
    opencv_core.cvSetZero(localIplImage1);
    opencv_core.cvFillConvexPoly(localIplImage1, new opencv_core.CvPoint((byte)(16 - this.cameraDevice.getMapsPyramidLevel()), paramArrayOfDouble1), 4, opencv_core.CvScalar.WHITE, 8, 16);
    opencv_core.IplImage localIplImage2 = paramArrayOfIplImage[0];
    opencv_core.IplImage localIplImage3 = paramArrayOfIplImage[1];
    opencv_core.cvCopy(localIplImage3, paramIplImage);
    opencv_imgproc.cvSmooth(localIplImage2, localIplImage2, 2, this.smoothingSize, 0, 0.0D, 0.0D);
    opencv_imgproc.cvSmooth(localIplImage3, localIplImage3, 2, this.smoothingSize, 0, 0.0D, 0.0D);
    opencv_core.cvSub(localIplImage3, localIplImage2, localIplImage3, null);
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)mat3x1.get();
    localCvMat1.put(new double[] { 1.0D, 1.0D, 1.0D });
    opencv_core.cvMatMul(this.projectorDevice.colorMixingMatrix, localCvMat1, localCvMat1);
    opencv_core.CvMat localCvMat2;
    if (localIplImage3.nChannels() == 4)
    {
      localCvMat2 = (opencv_core.CvMat)mat4x4.get();
      double[] arrayOfDouble2 = new double[16];
      arrayOfDouble2[0] = (1.0D / localCvMat1.get(0));
      arrayOfDouble2[1] = 0.0D;
      arrayOfDouble2[2] = 0.0D;
      arrayOfDouble2[3] = 0.0D;
      arrayOfDouble2[4] = 0.0D;
      arrayOfDouble2[5] = (1.0D / localCvMat1.get(1));
      arrayOfDouble2[6] = 0.0D;
      arrayOfDouble2[7] = 0.0D;
      arrayOfDouble2[8] = 0.0D;
      arrayOfDouble2[9] = 0.0D;
      arrayOfDouble2[10] = (1.0D / localCvMat1.get(2));
      arrayOfDouble2[11] = 0.0D;
      arrayOfDouble2[12] = 0.0D;
      arrayOfDouble2[13] = 0.0D;
      arrayOfDouble2[14] = 0.0D;
      arrayOfDouble2[15] = 1.0D;
      localCvMat2.put(arrayOfDouble2);
    }
    FloatBuffer localFloatBuffer1;
    FloatBuffer localFloatBuffer2;
    ByteBuffer localByteBuffer;
    for (;;)
    {
      opencv_core.cvTransform(localIplImage3, localIplImage3, localCvMat2, null);
      localFloatBuffer1 = localIplImage2.getFloatBuffer();
      localFloatBuffer2 = localIplImage3.getFloatBuffer();
      localByteBuffer = localIplImage1.getByteBuffer();
      if (($assertionsDisabled) || (localFloatBuffer1.capacity() == localFloatBuffer2.capacity() / 3)) {
        break;
      }
      throw new AssertionError();
      localCvMat2 = (opencv_core.CvMat)mat3x3.get();
      double[] arrayOfDouble1 = new double[9];
      arrayOfDouble1[0] = (1.0D / localCvMat1.get(0));
      arrayOfDouble1[1] = 0.0D;
      arrayOfDouble1[2] = 0.0D;
      arrayOfDouble1[3] = 0.0D;
      arrayOfDouble1[4] = (1.0D / localCvMat1.get(1));
      arrayOfDouble1[5] = 0.0D;
      arrayOfDouble1[6] = 0.0D;
      arrayOfDouble1[7] = 0.0D;
      arrayOfDouble1[8] = (1.0D / localCvMat1.get(2));
      localCvMat2.put(arrayOfDouble1);
    }
    assert (localFloatBuffer1.capacity() == localByteBuffer.capacity() / 3);
    int[] arrayOfInt = new int[k];
    int m = 0;
    int n = 0;
    for (;;)
    {
      int i1 = localFloatBuffer1.capacity();
      if (n >= i1) {
        break;
      }
      int i5 = 0;
      if (i5 < k)
      {
        float f1 = localFloatBuffer1.get(n + i5);
        float f2 = localFloatBuffer2.get(n + i5);
        if (f2 == 0.0F) {}
        for (float f3 = 0.0F;; f3 = f1 / f2)
        {
          localFloatBuffer1.put(n + i5, f3);
          if ((localByteBuffer.get(m) != 0) && (f2 > this.reflectanceMin))
          {
            arrayOfInt[i5] = (1 + arrayOfInt[i5]);
            int i6 = i5 + 1;
            paramArrayOfDouble2[i6] += f3;
          }
          i5++;
          break;
        }
      }
      m++;
      n += k;
    }
    paramArrayOfDouble2[0] = 1.0D;
    int i2 = 0;
    int i3 = -1 + paramArrayOfDouble2.length;
    if (i2 < i3)
    {
      int i4 = i2 + 1;
      if (arrayOfInt[i2] == 0) {}
      for (double d = 0.0D;; d = paramArrayOfDouble2[(i2 + 1)] / arrayOfInt[i2])
      {
        paramArrayOfDouble2[i4] = d;
        i2++;
        break;
      }
    }
    opencv_core.cvAddS(localIplImage2, opencv_core.cvScalar(localCvMat1.get(0), localCvMat1.get(1), localCvMat1.get(2), 0.0D), localIplImage2, null);
    opencv_core.cvDiv(paramIplImage, localIplImage2, paramIplImage, 1.0D);
    opencv_core.cvNot(localIplImage1, localIplImage1);
    opencv_imgproc.cvErode(localIplImage1, localIplImage1, null, 15);
    opencv_core.cvSet(paramIplImage, opencv_core.CvScalar.ZERO, localIplImage1);
    return paramIplImage;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ReflectanceInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */