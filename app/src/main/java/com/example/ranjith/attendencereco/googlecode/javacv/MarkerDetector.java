package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacv.cpp.ARToolKitPlus.ARMarkerInfo;
import com.googlecode.javacv.cpp.ARToolKitPlus.ArtLogFunction;
import com.googlecode.javacv.cpp.ARToolKitPlus.MultiTracker;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvBox2D;
import com.googlecode.javacv.cpp.opencv_core.CvFont;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvPoint2D32f;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSize;
import com.googlecode.javacv.cpp.opencv_core.CvSize2D32f;
import com.googlecode.javacv.cpp.opencv_core.CvTermCriteria;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.util.Arrays;
import java.util.logging.Logger;

public class MarkerDetector
{
  private int channels = 0;
  private opencv_core.CvPoint2D32f corners = new opencv_core.CvPoint2D32f(4);
  private int depth = 0;
  private opencv_core.CvFont font = new opencv_core.CvFont(1, 1.0D, 1);
  private int height = 0;
  private opencv_core.CvMemStorage memory = opencv_core.CvMemStorage.create();
  private opencv_core.CvMat points = opencv_core.CvMat.create(1, 4, 5, 2);
  private opencv_core.CvPoint pt1 = new opencv_core.CvPoint();
  private opencv_core.CvPoint pt2 = new opencv_core.CvPoint();
  private opencv_core.CvPoint pts = new opencv_core.CvPoint(4);
  private Settings settings;
  private opencv_core.IplImage sqSumImage;
  private opencv_core.CvSize subPixelSize = null;
  private opencv_core.CvTermCriteria subPixelTermCriteria = null;
  private opencv_core.CvSize subPixelZeroZone = null;
  private opencv_core.IplImage sumImage;
  private opencv_core.IplImage tempImage;
  private opencv_core.IplImage tempImage2;
  private opencv_core.CvSize textSize = new opencv_core.CvSize();
  private opencv_core.IplImage thresholdedImage;
  private ARToolKitPlus.MultiTracker tracker = null;
  private int width = 0;
  
  public MarkerDetector()
  {
    this(new Settings());
  }
  
  public MarkerDetector(Settings paramSettings)
  {
    setSettings(paramSettings);
  }
  
  private void init(opencv_core.IplImage paramIplImage)
  {
    if ((this.tracker != null) && (paramIplImage.width() == this.width) && (paramIplImage.height() == this.height) && (paramIplImage.depth() == this.depth) && (paramIplImage.nChannels() == this.channels)) {
      return;
    }
    this.width = paramIplImage.width();
    this.height = paramIplImage.height();
    this.depth = paramIplImage.depth();
    this.channels = paramIplImage.nChannels();
    if ((this.depth != 8) || (this.channels > 1)) {
      this.tempImage = opencv_core.IplImage.create(this.width, this.height, 8, 1);
    }
    if ((this.depth != 8) && (this.channels > 1)) {
      this.tempImage2 = opencv_core.IplImage.create(this.width, this.height, 8, 3);
    }
    this.sumImage = opencv_core.IplImage.create(1 + this.width, 1 + this.height, 64, 1);
    this.sqSumImage = opencv_core.IplImage.create(1 + this.width, 1 + this.height, 64, 1);
    this.thresholdedImage = opencv_core.IplImage.create(this.width, this.height, 8, 1);
    this.tracker = new ARToolKitPlus.MultiTracker(this.thresholdedImage.widthStep(), this.thresholdedImage.height());
    this.tracker.setLoggerFunction(new ARToolKitPlus.ArtLogFunction()
    {
      public void call(String paramAnonymousString)
      {
        Logger.getLogger(MarkerDetector.class.getName()).warning(paramAnonymousString);
      }
    });
    this.tracker.setPixelFormat(7);
    this.tracker.setBorderWidth(0.125D);
    this.tracker.setUndistortionMode(0);
    this.tracker.setMarkerMode(2);
    this.tracker.setImageProcessingMode(1);
  }
  
  public Marker[] detect(opencv_core.IplImage paramIplImage, boolean paramBoolean)
  {
    init(paramIplImage);
    int i7;
    label85:
    double d2;
    label143:
    ARToolKitPlus.ARMarkerInfo localARMarkerInfo;
    Marker[] arrayOfMarker;
    int m;
    int n;
    label214:
    int i2;
    if ((this.depth != 8) && (this.channels > 1))
    {
      opencv_core.IplImage localIplImage6 = this.tempImage2;
      double d5 = 255.0D / paramIplImage.highValue();
      opencv_core.cvConvertScale(paramIplImage, localIplImage6, d5, 0.0D);
      opencv_core.IplImage localIplImage7 = this.tempImage2;
      opencv_core.IplImage localIplImage8 = this.tempImage;
      if (this.channels > 3)
      {
        i7 = 11;
        opencv_imgproc.cvCvtColor(localIplImage7, localIplImage8, i7);
        paramIplImage = this.tempImage;
        opencv_core.IplImage localIplImage2 = this.sumImage;
        opencv_core.IplImage localIplImage3 = this.sqSumImage;
        opencv_core.IplImage localIplImage4 = this.thresholdedImage;
        int j = this.settings.thresholdWindowMax;
        int k = this.settings.thresholdWindowMin;
        double d1 = this.settings.thresholdVarMultiplier;
        if (!paramBoolean) {
          break label357;
        }
        d2 = this.settings.thresholdKWhiteMarkers;
        JavaCV.adaptiveThreshold(paramIplImage, localIplImage2, localIplImage3, localIplImage4, paramBoolean, j, k, d1, d2);
        int[] arrayOfInt = new int[1];
        localARMarkerInfo = new ARToolKitPlus.ARMarkerInfo(null);
        this.tracker.arDetectMarkerLite(this.thresholdedImage.getByteBuffer(), 128, localARMarkerInfo, arrayOfInt);
        arrayOfMarker = new Marker[arrayOfInt[0]];
        m = 0;
        n = 0;
        int i1 = arrayOfInt[0];
        if ((n >= i1) || (localARMarkerInfo.isNull())) {
          break label1031;
        }
        localARMarkerInfo.position(n);
        i2 = localARMarkerInfo.id();
        if (i2 >= 0) {
          break label369;
        }
      }
    }
    for (;;)
    {
      n++;
      break label214;
      i7 = 6;
      break;
      if (this.depth != 8)
      {
        opencv_core.IplImage localIplImage5 = this.tempImage;
        double d4 = 255.0D / paramIplImage.highValue();
        opencv_core.cvConvertScale(paramIplImage, localIplImage5, d4, 0.0D);
        paramIplImage = this.tempImage;
        break label85;
      }
      if (this.channels <= 1) {
        break label85;
      }
      opencv_core.IplImage localIplImage1 = this.tempImage;
      if (this.channels > 3) {}
      for (int i = 11;; i = 6)
      {
        opencv_imgproc.cvCvtColor(paramIplImage, localIplImage1, i);
        paramIplImage = this.tempImage;
        break;
      }
      label357:
      d2 = this.settings.thresholdKBlackMarkers;
      break label143;
      label369:
      int i3 = localARMarkerInfo.dir();
      double d3 = localARMarkerInfo.cf();
      double[] arrayOfDouble = new double[8];
      localARMarkerInfo.vertex().get(arrayOfDouble);
      int i4 = 1 + this.settings.subPixelWindow / 2;
      if ((arrayOfDouble[0] - i4 >= 0.0D) && (arrayOfDouble[0] + i4 < this.width) && (arrayOfDouble[1] - i4 >= 0.0D) && (arrayOfDouble[1] + i4 < this.height) && (arrayOfDouble[2] - i4 >= 0.0D) && (arrayOfDouble[2] + i4 < this.width) && (arrayOfDouble[3] - i4 >= 0.0D) && (arrayOfDouble[3] + i4 < this.height) && (arrayOfDouble[4] - i4 >= 0.0D) && (arrayOfDouble[4] + i4 < this.width) && (arrayOfDouble[5] - i4 >= 0.0D) && (arrayOfDouble[5] + i4 < this.height) && (arrayOfDouble[6] - i4 >= 0.0D) && (arrayOfDouble[6] + i4 < this.width) && (arrayOfDouble[7] - i4 >= 0.0D) && (arrayOfDouble[7] + i4 < this.height))
      {
        opencv_core.CvBox2D localCvBox2D = opencv_imgproc.cvMinAreaRect2(this.points.put(arrayOfDouble), this.memory);
        float f1 = localCvBox2D.size().width();
        float f2 = localCvBox2D.size().height();
        opencv_core.cvClearMemStorage(this.memory);
        if ((f1 > 0.0F) && (f2 > 0.0F) && (f1 / f2 >= 0.1D) && (f1 / f2 <= 10.0F))
        {
          for (int i5 = 0; i5 < 4; i5++) {
            this.corners.position(i5).put(arrayOfDouble[(i5 * 2)], arrayOfDouble[(1 + i5 * 2)]);
          }
          opencv_core.CvPoint2D32f localCvPoint2D32f = this.corners.position(0);
          opencv_core.CvSize localCvSize1 = this.subPixelSize;
          opencv_core.CvSize localCvSize2 = this.subPixelZeroZone;
          opencv_core.CvTermCriteria localCvTermCriteria = this.subPixelTermCriteria;
          opencv_imgproc.cvFindCornerSubPix(paramIplImage, localCvPoint2D32f, 4, localCvSize1, localCvSize2, localCvTermCriteria);
          arrayOfDouble[0] = this.corners.position((4 - i3) % 4).x();
          arrayOfDouble[1] = this.corners.position((4 - i3) % 4).y();
          arrayOfDouble[2] = this.corners.position((5 - i3) % 4).x();
          arrayOfDouble[3] = this.corners.position((5 - i3) % 4).y();
          arrayOfDouble[4] = this.corners.position((6 - i3) % 4).x();
          arrayOfDouble[5] = this.corners.position((6 - i3) % 4).y();
          arrayOfDouble[6] = this.corners.position((7 - i3) % 4).x();
          arrayOfDouble[7] = this.corners.position((7 - i3) % 4).y();
          int i6 = m + 1;
          arrayOfMarker[m] = new Marker(i2, arrayOfDouble, d3);
          m = i6;
        }
      }
    }
    label1031:
    return (Marker[])Arrays.copyOf(arrayOfMarker, m);
  }
  
  public void draw(opencv_core.IplImage paramIplImage, Marker[] paramArrayOfMarker)
  {
    int i = paramArrayOfMarker.length;
    for (int j = 0; j < i; j++)
    {
      Marker localMarker = paramArrayOfMarker[j];
      int k = 0;
      int m = 0;
      for (int n = 0; n < 4; n++)
      {
        int i3 = (int)Math.round(65536.0D * localMarker.corners[(n * 2)]);
        int i4 = (int)Math.round(65536.0D * localMarker.corners[(1 + n * 2)]);
        this.pts.position(n).x(i3);
        this.pts.position(n).y(i4);
        k += i3;
        m += i4;
      }
      int i1 = k / 4;
      int i2 = m / 4;
      opencv_core.cvPolyLine(paramIplImage, this.pts, new int[] { 4 }, 1, 1, opencv_core.CV_RGB(0.0D, 0.0D, paramIplImage.highValue()), 1, 16, 16);
      String str = Integer.toString(localMarker.id);
      int[] arrayOfInt = new int[1];
      opencv_core.cvGetTextSize(str, this.font, this.textSize, arrayOfInt);
      this.pt1.x(i1 - (3 * this.textSize.width() / 2 << 16) / 2);
      this.pt1.y(i2 + (3 * this.textSize.height() / 2 << 16) / 2);
      this.pt2.x(i1 + (3 * this.textSize.width() / 2 << 16) / 2);
      this.pt2.y(i2 - (3 * this.textSize.height() / 2 << 16) / 2);
      opencv_core.cvRectangle(paramIplImage, this.pt1, this.pt2, opencv_core.CV_RGB(0.0D, paramIplImage.highValue(), 0.0D), -1, 16, 16);
      this.pt1.x((int)Math.round(i1 / 65536.0D - this.textSize.width() / 2));
      this.pt1.y((int)Math.round(1.0D + (i2 / 65536.0D + this.textSize.height() / 2)));
      opencv_core.cvPutText(paramIplImage, str, this.pt1, this.font, opencv_core.CvScalar.BLACK);
    }
  }
  
  public Settings getSettings()
  {
    return this.settings;
  }
  
  public opencv_core.IplImage getThresholdedImage()
  {
    return this.thresholdedImage;
  }
  
  public void setSettings(Settings paramSettings)
  {
    this.settings = paramSettings;
    this.subPixelSize = opencv_core.cvSize(paramSettings.subPixelWindow / 2, paramSettings.subPixelWindow / 2);
    this.subPixelZeroZone = opencv_core.cvSize(-1, -1);
    this.subPixelTermCriteria = opencv_core.cvTermCriteria(2, 100, 0.001D);
  }
  
  public static class Settings
    extends BaseChildSettings
  {
    int subPixelWindow = 11;
    double thresholdKBlackMarkers = 0.6D;
    double thresholdKWhiteMarkers = 1.0D;
    double thresholdVarMultiplier = 1.0D;
    int thresholdWindowMax = 63;
    int thresholdWindowMin = 5;
    
    public int getSubPixelWindow()
    {
      return this.subPixelWindow;
    }
    
    public double getThresholdKBlackMarkers()
    {
      return this.thresholdKBlackMarkers;
    }
    
    public double getThresholdKWhiteMarkers()
    {
      return this.thresholdKWhiteMarkers;
    }
    
    public double getThresholdVarMultiplier()
    {
      return this.thresholdVarMultiplier;
    }
    
    public int getThresholdWindowMax()
    {
      return this.thresholdWindowMax;
    }
    
    public int getThresholdWindowMin()
    {
      return this.thresholdWindowMin;
    }
    
    public void setSubPixelWindow(int paramInt)
    {
      this.subPixelWindow = paramInt;
    }
    
    public void setThresholdKBlackMarkers(double paramDouble)
    {
      this.thresholdKBlackMarkers = paramDouble;
    }
    
    public void setThresholdKWhiteMarkers(double paramDouble)
    {
      this.thresholdKWhiteMarkers = paramDouble;
    }
    
    public void setThresholdVarMultiplier(double paramDouble)
    {
      this.thresholdVarMultiplier = paramDouble;
    }
    
    public void setThresholdWindowMax(int paramInt)
    {
      this.thresholdWindowMax = paramInt;
    }
    
    public void setThresholdWindowMin(int paramInt)
    {
      this.thresholdWindowMin = paramInt;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\MarkerDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */