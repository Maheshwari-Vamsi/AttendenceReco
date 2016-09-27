package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvArr;
import com.googlecode.javacv.cpp.opencv_core.CvContour;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import com.googlecode.javacv.cpp.opencv_imgproc.CvMoments;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class HandMouse
{
  private opencv_core.IplImage binaryImage = null;
  private double centerX = 0.0D;
  private double centerY = 0.0D;
  private opencv_core.CvPoint contourPoints = null;
  private IntBuffer contourPointsBuffer = null;
  private int contourPointsSize = 0;
  private double edgeX = 0.0D;
  private double edgeY = 0.0D;
  private double imageTipX = -1.0D;
  private double imageTipY = -1.0D;
  private boolean imageUpdateNeeded = false;
  private opencv_imgproc.CvMoments moments = new opencv_imgproc.CvMoments();
  private long prevTipTime = 0L;
  private double prevTipX = -1.0D;
  private double prevTipY = -1.0D;
  private opencv_core.CvPoint pt1 = new opencv_core.CvPoint();
  private opencv_core.CvPoint pt2 = new opencv_core.CvPoint();
  private opencv_core.IplImage relativeResidual = null;
  private opencv_core.CvRect roi = null;
  private Settings settings;
  private opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();
  private long tipTime = 0L;
  private double tipX = -1.0D;
  private double tipY = -1.0D;
  
  public HandMouse()
  {
    this(new Settings());
  }
  
  public HandMouse(Settings paramSettings)
  {
    setSettings(paramSettings);
  }
  
  public opencv_core.IplImage getRelativeResidual()
  {
    return this.relativeResidual;
  }
  
  public opencv_core.IplImage getResultImage()
  {
    if (this.imageUpdateNeeded)
    {
      opencv_core.cvSetZero(this.binaryImage);
      opencv_core.IplImage localIplImage = this.binaryImage;
      opencv_core.CvPoint localCvPoint1 = this.contourPoints;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.contourPointsSize;
      opencv_core.cvFillPoly(localIplImage, localCvPoint1, arrayOfInt, 1, opencv_core.CvScalar.WHITE, 8, 0);
      opencv_core.CvPoint localCvPoint2 = this.pt1;
      double[] arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = this.edgeX;
      arrayOfDouble1[1] = this.edgeY;
      localCvPoint2.put((byte)16, arrayOfDouble1);
      opencv_core.cvCircle(this.binaryImage, this.pt1, 327680, opencv_core.CvScalar.GRAY, 2, 8, 16);
      opencv_core.CvPoint localCvPoint3 = this.pt1;
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = (this.centerX - 5.0D);
      arrayOfDouble2[1] = (this.centerY - 5.0D);
      localCvPoint3.put((byte)16, arrayOfDouble2);
      opencv_core.CvPoint localCvPoint4 = this.pt2;
      double[] arrayOfDouble3 = new double[2];
      arrayOfDouble3[0] = (5.0D + this.centerX);
      arrayOfDouble3[1] = (5.0D + this.centerY);
      localCvPoint4.put((byte)16, arrayOfDouble3);
      opencv_core.cvRectangle(this.binaryImage, this.pt1, this.pt2, opencv_core.CvScalar.GRAY, 2, 8, 16);
      opencv_core.CvPoint localCvPoint5 = this.pt1;
      double[] arrayOfDouble4 = new double[2];
      arrayOfDouble4[0] = (this.imageTipX - 5.0D);
      arrayOfDouble4[1] = (this.imageTipY - 5.0D);
      localCvPoint5.put((byte)16, arrayOfDouble4);
      opencv_core.CvPoint localCvPoint6 = this.pt2;
      double[] arrayOfDouble5 = new double[2];
      arrayOfDouble5[0] = (5.0D + this.imageTipX);
      arrayOfDouble5[1] = (5.0D + this.imageTipY);
      localCvPoint6.put((byte)16, arrayOfDouble5);
      opencv_core.cvLine(this.binaryImage, this.pt1, this.pt2, opencv_core.CvScalar.GRAY, 2, 8, 16);
      opencv_core.CvPoint localCvPoint7 = this.pt1;
      double[] arrayOfDouble6 = new double[2];
      arrayOfDouble6[0] = (this.imageTipX - 5.0D);
      arrayOfDouble6[1] = (5.0D + this.imageTipY);
      localCvPoint7.put((byte)16, arrayOfDouble6);
      opencv_core.CvPoint localCvPoint8 = this.pt2;
      double[] arrayOfDouble7 = new double[2];
      arrayOfDouble7[0] = (5.0D + this.imageTipX);
      arrayOfDouble7[1] = (this.imageTipY - 5.0D);
      localCvPoint8.put((byte)16, arrayOfDouble7);
      opencv_core.cvLine(this.binaryImage, this.pt1, this.pt2, opencv_core.CvScalar.GRAY, 2, 8, 16);
      opencv_core.cvResetImageROI(this.binaryImage);
      this.imageUpdateNeeded = false;
    }
    return this.binaryImage;
  }
  
  public Settings getSettings()
  {
    return this.settings;
  }
  
  public double getX()
  {
    return this.tipX;
  }
  
  public double getY()
  {
    return this.tipY;
  }
  
  public boolean isClick()
  {
    return (isSteady()) && (this.tipTime - this.prevTipTime > this.settings.clickSteadyTime);
  }
  
  public boolean isSteady()
  {
    boolean bool1 = this.tipX < 0.0D;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = this.tipY < 0.0D;
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = this.prevTipX < 0.0D;
        bool2 = false;
        if (!bool4)
        {
          boolean bool5 = this.prevTipY < 0.0D;
          bool2 = false;
          if (!bool5)
          {
            double d1 = this.tipX - this.prevTipX;
            double d2 = this.tipY - this.prevTipY;
            int i = (this.roi.width() + this.roi.height()) / 2;
            double d3 = this.settings.clickSteadySize * i;
            boolean bool6 = d1 * d1 + d2 * d2 < d3 * d3;
            bool2 = false;
            if (bool6) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public void reset()
  {
    this.prevTipY = -1.0D;
    this.prevTipX = -1.0D;
    this.tipY = -1.0D;
    this.tipX = -1.0D;
  }
  
  public void setSettings(Settings paramSettings)
  {
    this.settings = paramSettings;
  }
  
  public void update(opencv_core.IplImage[] paramArrayOfIplImage, int paramInt, opencv_core.CvRect paramCvRect, double[] paramArrayOfDouble)
  {
    this.roi = paramCvRect;
    opencv_core.IplImage localIplImage1 = paramArrayOfIplImage[1];
    opencv_core.IplImage localIplImage2 = paramArrayOfIplImage[2];
    opencv_core.IplImage localIplImage3 = paramArrayOfIplImage[3];
    opencv_core.IplImage localIplImage4 = paramArrayOfIplImage[4];
    int i = paramCvRect.width();
    int j = paramCvRect.height();
    int k = localIplImage3.nChannels();
    this.relativeResidual = opencv_core.IplImage.createIfNotCompatible(this.relativeResidual, localIplImage4);
    this.binaryImage = opencv_core.IplImage.createIfNotCompatible(this.binaryImage, localIplImage4);
    opencv_core.cvResetImageROI(this.relativeResidual);
    opencv_core.cvResetImageROI(this.binaryImage);
    int m;
    double d1;
    double d2;
    double d3;
    ByteBuffer localByteBuffer1;
    FloatBuffer localFloatBuffer1;
    FloatBuffer localFloatBuffer2;
    FloatBuffer localFloatBuffer3;
    ByteBuffer localByteBuffer2;
    if (k > 3)
    {
      m = 3;
      d1 = m * this.settings.brightnessMin;
      d2 = j * (i * ((i + j) / 2)) * this.settings.edgeAreaMax;
      d3 = j * (i * ((i + j) / 2)) * this.settings.edgeAreaMin;
      localByteBuffer1 = localIplImage4.getByteBuffer();
      localFloatBuffer1 = localIplImage3.getFloatBuffer();
      localFloatBuffer2 = localIplImage1.getFloatBuffer();
      localFloatBuffer3 = localIplImage2.getFloatBuffer();
      localByteBuffer2 = this.relativeResidual.getByteBuffer();
    }
    for (;;)
    {
      if ((!localByteBuffer1.hasRemaining()) || (!localFloatBuffer1.hasRemaining()) || (!localFloatBuffer2.hasRemaining()) || (!localFloatBuffer3.hasRemaining()) || (!localByteBuffer2.hasRemaining())) {
        break label444;
      }
      if (localByteBuffer1.get() == 0)
      {
        localFloatBuffer1.position(k + localFloatBuffer1.position());
        localFloatBuffer2.position(k + localFloatBuffer2.position());
        localFloatBuffer3.position(k + localFloatBuffer3.position());
        localByteBuffer2.put((byte)0);
        continue;
        m = k;
        break;
      }
      double d34 = 0.0D;
      double d35 = 0.0D;
      for (int i15 = 0; i15 < k; i15++)
      {
        float f1 = Math.abs(localFloatBuffer1.get());
        float f2 = localFloatBuffer2.get();
        float f3 = localFloatBuffer3.get();
        if (i15 < 3)
        {
          float f4 = Math.max(f2, f3);
          d35 += f4;
          d34 = Math.max(f1 / f4, d34);
        }
      }
      if (d35 < d1)
      {
        localByteBuffer2.put((byte)0);
      }
      else
      {
        double d36 = 255.0D / this.settings.thresholdHigh;
        double d37 = this.settings.thresholdHigh;
        localByteBuffer2.put((byte)(int)Math.round(d36 * Math.min(d34, d37)));
      }
    }
    label444:
    JavaCV.hysteresisThreshold(this.relativeResidual, this.binaryImage, 255.0D, 255.0D * this.settings.thresholdLow / this.settings.thresholdHigh, 255.0D);
    int n = paramCvRect.x();
    int i1 = paramCvRect.y();
    opencv_core.cvSetImageROI(this.binaryImage, paramCvRect);
    if (this.settings.mopIterations > 0)
    {
      opencv_imgproc.cvMorphologyEx(this.binaryImage, this.binaryImage, null, null, 2, this.settings.mopIterations);
      opencv_imgproc.cvMorphologyEx(this.binaryImage, this.binaryImage, null, null, 3, this.settings.mopIterations);
    }
    Object localObject1 = new opencv_core.CvContour(null);
    opencv_imgproc.cvFindContours(this.binaryImage, this.storage, (opencv_core.CvSeq)localObject1, Loader.sizeof(opencv_core.CvContour.class), 0, 1);
    double d4 = 0.0D;
    Object localObject2 = null;
    while ((localObject1 != null) && (!((opencv_core.CvSeq)localObject1).isNull()))
    {
      this.contourPointsSize = ((opencv_core.CvSeq)localObject1).total();
      if ((this.contourPoints == null) || (this.contourPoints.capacity() < this.contourPointsSize))
      {
        this.contourPoints = new opencv_core.CvPoint(this.contourPointsSize);
        this.contourPointsBuffer = this.contourPoints.asByteBuffer().asIntBuffer();
      }
      opencv_core.cvCvtSeqToArray((opencv_core.CvSeq)localObject1, this.contourPoints.position(0));
      double[] arrayOfDouble = new double[paramArrayOfDouble.length];
      for (int i7 = 0;; i7++)
      {
        int i8 = paramArrayOfDouble.length / 2;
        if (i7 >= i8) {
          break;
        }
        arrayOfDouble[(i7 * 2)] = (paramArrayOfDouble[(i7 * 2)] / (1 << paramInt) - n);
        arrayOfDouble[(1 + i7 * 2)] = (paramArrayOfDouble[(1 + i7 * 2)] / (1 << paramInt) - i1);
      }
      double d17 = 0.0D;
      double d18 = 0.0D;
      double d19 = 0.0D;
      int i9 = 0;
      int i10 = this.contourPointsSize;
      if (i9 < i10)
      {
        int i11 = this.contourPointsBuffer.get(i9 * 2);
        int i12 = this.contourPointsBuffer.get(1 + i9 * 2);
        for (int i13 = 0;; i13++)
        {
          int i14 = paramArrayOfDouble.length / 2;
          if (i13 < i14)
          {
            double d22 = arrayOfDouble[(i13 * 2)];
            double d23 = arrayOfDouble[(1 + i13 * 2)];
            double d24 = arrayOfDouble[((2 + i13 * 2) % arrayOfDouble.length)];
            double d25 = arrayOfDouble[((3 + i13 * 2) % arrayOfDouble.length)];
            double d26 = d24 - d22;
            double d27 = d25 - d23;
            double d28 = d26 * d26 + d27 * d27;
            double d29 = (d26 * (i11 - d22) + d27 * (i12 - d23)) / d28;
            double d30 = d22 + d29 * d26;
            double d31 = d23 + d29 * d27;
            double d32 = d30 - i11;
            double d33 = d31 - i12;
            if (d32 * d32 + d33 * d33 < 2.0D)
            {
              d17 += 1.0D;
              d18 += i11;
              d19 += i12;
            }
          }
          else
          {
            i9++;
            break;
          }
        }
      }
      double d20 = d17 * Math.abs(opencv_imgproc.cvContourArea((opencv_core.CvArr)localObject1, opencv_core.CV_WHOLE_SEQ, 0));
      if ((d20 > d3) && (d20 < d2) && (d20 > d4))
      {
        d4 = d20;
        localObject2 = localObject1;
        double d21 = 1.0D / d17;
        this.edgeX = (d18 * d21);
        this.edgeY = (d19 * d21);
      }
      localObject1 = ((opencv_core.CvSeq)localObject1).h_next();
    }
    if (isClick())
    {
      this.prevTipX = -1.0D;
      this.prevTipY = -1.0D;
      this.prevTipTime = 0L;
    }
    while (localObject2 == null)
    {
      this.tipX = -1.0D;
      this.tipY = -1.0D;
      this.tipTime = 0L;
      this.imageUpdateNeeded = false;
      opencv_core.cvClearMemStorage(this.storage);
      return;
      if (!isSteady())
      {
        this.prevTipX = this.tipX;
        this.prevTipY = this.tipY;
        this.prevTipTime = System.currentTimeMillis();
      }
    }
    opencv_imgproc.CvMoments localCvMoments = this.moments;
    opencv_imgproc.cvMoments((opencv_core.CvArr)localObject2, localCvMoments, 0);
    double d5 = 1.0D / this.moments.m00();
    this.centerX = (d5 * this.moments.m10());
    this.centerY = (d5 * this.moments.m01());
    this.contourPointsSize = ((opencv_core.CvSeq)localObject2).total();
    opencv_core.CvPoint localCvPoint = this.contourPoints.position(0);
    opencv_core.cvCvtSeqToArray((opencv_core.CvSeq)localObject2, localCvPoint);
    double d6 = 0.0D;
    int i2 = 0;
    for (int i3 = 0;; i3++)
    {
      int i4 = this.contourPointsSize;
      if (i3 >= i4) {
        break;
      }
      int i5 = this.contourPointsBuffer.get(i3 * 2);
      int i6 = this.contourPointsBuffer.get(1 + i3 * 2);
      double d8 = this.centerX - this.edgeX;
      double d9 = this.centerY - this.edgeY;
      double d10 = d8 * d8 + d9 * d9;
      double d11 = (d8 * (i5 - this.edgeX) + d9 * (i6 - this.edgeY)) / d10;
      double d12 = this.edgeX + d11 * d8;
      double d13 = this.edgeY + d11 * d9;
      double d14 = d12 - this.edgeX;
      double d15 = d13 - this.edgeY;
      double d16 = d14 * d14 + d15 * d15;
      if (d16 > d6)
      {
        i2 = i3;
        d6 = d16;
      }
    }
    if ((this.imageTipX < 0.0D) || (this.imageTipY < 0.0D)) {}
    for (double d7 = 1.0D;; d7 = this.settings.updateAlpha)
    {
      this.imageTipX = (d7 * this.contourPointsBuffer.get(i2 * 2) + (1.0D - d7) * this.imageTipX);
      this.imageTipY = (d7 * this.contourPointsBuffer.get(1 + i2 * 2) + (1.0D - d7) * this.imageTipY);
      this.tipX = ((this.imageTipX + n) * (1 << paramInt));
      this.tipY = ((this.imageTipY + i1) * (1 << paramInt));
      this.tipTime = System.currentTimeMillis();
      this.imageUpdateNeeded = true;
      break;
    }
  }
  
  public static class Settings
    extends BaseChildSettings
  {
    double brightnessMin = 0.1D;
    double clickSteadySize = 0.05D;
    long clickSteadyTime = 250L;
    double edgeAreaMax = 0.1D;
    double edgeAreaMin = 0.001D;
    int mopIterations = 1;
    double thresholdHigh = 0.5D;
    double thresholdLow = 0.25D;
    double updateAlpha = 0.5D;
    
    public Settings() {}
    
    public Settings(Settings paramSettings)
    {
      paramSettings.mopIterations = this.mopIterations;
      paramSettings.clickSteadySize = this.clickSteadySize;
      paramSettings.clickSteadyTime = this.clickSteadyTime;
      paramSettings.edgeAreaMin = this.edgeAreaMin;
      paramSettings.edgeAreaMax = this.edgeAreaMax;
      paramSettings.thresholdHigh = this.thresholdHigh;
      paramSettings.thresholdLow = this.thresholdLow;
      paramSettings.brightnessMin = this.brightnessMin;
      paramSettings.updateAlpha = this.updateAlpha;
    }
    
    public double getBrightnessMin()
    {
      return this.brightnessMin;
    }
    
    public double getClickSteadySize()
    {
      return this.clickSteadySize;
    }
    
    public long getClickSteadyTime()
    {
      return this.clickSteadyTime;
    }
    
    public double getEdgeAreaMax()
    {
      return this.edgeAreaMax;
    }
    
    public double getEdgeAreaMin()
    {
      return this.edgeAreaMin;
    }
    
    public int getMopIterations()
    {
      return this.mopIterations;
    }
    
    public double getThresholdHigh()
    {
      return this.thresholdHigh;
    }
    
    public double getThresholdLow()
    {
      return this.thresholdLow;
    }
    
    public double getUpdateAlpha()
    {
      return this.updateAlpha;
    }
    
    public void setBrightnessMin(double paramDouble)
    {
      this.brightnessMin = paramDouble;
    }
    
    public void setClickSteadySize(double paramDouble)
    {
      this.clickSteadySize = paramDouble;
    }
    
    public void setClickSteadyTime(long paramLong)
    {
      this.clickSteadyTime = paramLong;
    }
    
    public void setEdgeAreaMax(double paramDouble)
    {
      this.edgeAreaMax = paramDouble;
    }
    
    public void setEdgeAreaMin(double paramDouble)
    {
      this.edgeAreaMin = paramDouble;
    }
    
    public void setMopIterations(int paramInt)
    {
      this.mopIterations = paramInt;
    }
    
    public void setThresholdHigh(double paramDouble)
    {
      this.thresholdHigh = paramDouble;
    }
    
    public void setThresholdLow(double paramDouble)
    {
      this.thresholdLow = paramDouble;
    }
    
    public void setUpdateAlpha(double paramDouble)
    {
      this.updateAlpha = paramDouble;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\HandMouse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */