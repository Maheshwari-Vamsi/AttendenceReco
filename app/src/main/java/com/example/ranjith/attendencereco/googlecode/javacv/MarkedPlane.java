package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_calib3d;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;

public class MarkedPlane
{
  private static ThreadLocal<opencv_core.CvMat> tempWarp3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
  private opencv_core.CvScalar backgroundColor;
  private opencv_core.CvScalar foregroundColor;
  private ThreadLocal<opencv_core.CvMat> localDstPts;
  private ThreadLocal<opencv_core.CvMat> localSrcPts;
  private Marker[] markers = null;
  private opencv_core.IplImage planeImage = null;
  private opencv_core.CvMat prewarp;
  private opencv_core.IplImage superPlaneImage = null;
  
  public MarkedPlane(int paramInt1, int paramInt2, Marker[] paramArrayOfMarker, double paramDouble)
  {
    this(paramInt1, paramInt2, paramArrayOfMarker, false, opencv_core.CvScalar.BLACK, opencv_core.CvScalar.WHITE, paramDouble);
  }
  
  public MarkedPlane(int paramInt1, int paramInt2, Marker[] paramArrayOfMarker, boolean paramBoolean, opencv_core.CvScalar paramCvScalar1, opencv_core.CvScalar paramCvScalar2, double paramDouble)
  {
    this.markers = paramArrayOfMarker;
    this.foregroundColor = paramCvScalar1;
    this.backgroundColor = paramCvScalar2;
    this.prewarp = null;
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    if (paramBoolean)
    {
      this.prewarp = opencv_core.CvMat.create(3, 3);
      d1 = Double.MAX_VALUE;
      d2 = Double.MAX_VALUE;
      d3 = Double.MIN_VALUE;
      d4 = Double.MIN_VALUE;
      int i = paramArrayOfMarker.length;
      for (int j = 0; j < i; j++)
      {
        double[] arrayOfDouble5 = paramArrayOfMarker[j].corners;
        double d8 = arrayOfDouble5[0];
        d1 = Math.min(Math.min(Math.min(Math.min(d1, d8), arrayOfDouble5[2]), arrayOfDouble5[4]), arrayOfDouble5[6]);
        double d9 = arrayOfDouble5[1];
        d2 = Math.min(Math.min(Math.min(Math.min(d2, d9), arrayOfDouble5[3]), arrayOfDouble5[5]), arrayOfDouble5[7]);
        d3 = Math.max(Math.max(Math.max(Math.max(d3, arrayOfDouble5[0]), arrayOfDouble5[2]), arrayOfDouble5[4]), arrayOfDouble5[6]);
        double d10 = arrayOfDouble5[1];
        d4 = Math.max(Math.max(Math.max(Math.max(d4, d10), arrayOfDouble5[3]), arrayOfDouble5[5]), arrayOfDouble5[7]);
      }
      d5 = (d3 - d1) / (d4 - d2);
      if (d5 > paramInt1 / paramInt2)
      {
        double d7 = paramInt1 / d5;
        double[] arrayOfDouble3 = { d1, d2, d3, d2, d3, d4, d1, d4 };
        double[] arrayOfDouble4 = new double[8];
        arrayOfDouble4[0] = 0.0D;
        arrayOfDouble4[1] = (paramInt2 - d7);
        arrayOfDouble4[2] = paramInt1;
        arrayOfDouble4[3] = (paramInt2 - d7);
        arrayOfDouble4[4] = paramInt1;
        arrayOfDouble4[5] = paramInt2;
        arrayOfDouble4[6] = 0.0D;
        arrayOfDouble4[7] = paramInt2;
        JavaCV.getPerspectiveTransform(arrayOfDouble3, arrayOfDouble4, this.prewarp);
      }
    }
    else if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.planeImage = opencv_core.IplImage.create(paramInt1, paramInt2, 8, 1);
      if (paramDouble != 1.0D) {
        break label586;
      }
    }
    label586:
    for (this.superPlaneImage = null;; this.superPlaneImage = opencv_core.IplImage.create((int)Math.ceil(paramDouble * paramInt1), (int)Math.ceil(paramDouble * paramInt2), 8, 1))
    {
      setPrewarp(this.prewarp);
      this.localSrcPts = opencv_core.CvMat.createThreadLocal(4 * paramArrayOfMarker.length, 2);
      this.localDstPts = opencv_core.CvMat.createThreadLocal(4 * paramArrayOfMarker.length, 2);
      return;
      double d6 = d5 * paramInt2;
      double[] arrayOfDouble1 = { d1, d2, d3, d2, d3, d4, d1, d4 };
      double[] arrayOfDouble2 = new double[8];
      arrayOfDouble2[0] = 0.0D;
      arrayOfDouble2[1] = 0.0D;
      arrayOfDouble2[2] = d6;
      arrayOfDouble2[3] = 0.0D;
      arrayOfDouble2[4] = d6;
      arrayOfDouble2[5] = paramInt2;
      arrayOfDouble2[6] = 0.0D;
      arrayOfDouble2[7] = paramInt2;
      JavaCV.getPerspectiveTransform(arrayOfDouble1, arrayOfDouble2, this.prewarp);
      break;
    }
  }
  
  public opencv_core.CvScalar getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public opencv_core.CvScalar getForegroundColor()
  {
    return this.foregroundColor;
  }
  
  public int getHeight()
  {
    return this.planeImage.height();
  }
  
  public opencv_core.IplImage getImage()
  {
    return this.planeImage;
  }
  
  public Marker[] getMarkers()
  {
    return this.markers;
  }
  
  public opencv_core.CvMat getPrewarp()
  {
    return this.prewarp;
  }
  
  public double getTotalWarp(Marker[] paramArrayOfMarker, opencv_core.CvMat paramCvMat)
  {
    return getTotalWarp(paramArrayOfMarker, paramCvMat, false);
  }
  
  public double getTotalWarp(Marker[] paramArrayOfMarker, opencv_core.CvMat paramCvMat, boolean paramBoolean)
  {
    double d1 = Double.POSITIVE_INFINITY;
    int i;
    opencv_core.CvMat localCvMat1;
    opencv_core.CvMat localCvMat2;
    int j;
    int m;
    label81:
    Marker localMarker1;
    int i1;
    if (paramBoolean)
    {
      i = 1;
      localCvMat1 = (opencv_core.CvMat)this.localSrcPts.get();
      localCvMat1.rows(i * this.markers.length);
      localCvMat2 = (opencv_core.CvMat)this.localDstPts.get();
      localCvMat2.rows(i * this.markers.length);
      j = 0;
      Marker[] arrayOfMarker = this.markers;
      int k = arrayOfMarker.length;
      m = 0;
      if (m < k)
      {
        localMarker1 = arrayOfMarker[m];
        i1 = paramArrayOfMarker.length;
      }
    }
    else
    {
      for (int i2 = 0;; i2++)
      {
        Marker localMarker2;
        if (i2 < i1)
        {
          localMarker2 = paramArrayOfMarker[i2];
          if (localMarker1.id != localMarker2.id) {
            continue;
          }
          if (!paramBoolean) {
            break label181;
          }
          localCvMat1.put(j * 2, localMarker1.getCenter());
          localCvMat2.put(j * 2, localMarker2.getCenter());
        }
        for (;;)
        {
          j += i;
          m++;
          break label81;
          i = 4;
          break;
          label181:
          localCvMat1.put(j * 2, localMarker1.corners);
          localCvMat2.put(j * 2, localMarker2.corners);
        }
      }
    }
    if ((j > 4) || ((localCvMat1.rows() == 4) && (j == 4)))
    {
      localCvMat1.rows(j);
      localCvMat2.rows(j);
      if (j == 4) {
        JavaCV.getPerspectiveTransform(localCvMat1.get(), localCvMat2.get(), paramCvMat);
      }
      double d2;
      for (;;)
      {
        localCvMat1.cols(1);
        localCvMat1.type(6, 2);
        localCvMat2.cols(1);
        localCvMat2.type(6, 2);
        opencv_core.cvPerspectiveTransform(localCvMat1, localCvMat1, paramCvMat);
        localCvMat1.cols(2);
        localCvMat1.type(6, 1);
        localCvMat2.cols(2);
        localCvMat2.type(6, 1);
        d2 = 0.0D;
        for (int n = 0; n < j; n++)
        {
          double d3 = localCvMat2.get(n * 2) - localCvMat1.get(n * 2);
          double d4 = localCvMat2.get(1 + n * 2) - localCvMat1.get(1 + n * 2);
          d2 += d3 * d3 + d4 * d4;
        }
        opencv_calib3d.cvFindHomography(localCvMat1, localCvMat2, paramCvMat);
      }
      d1 = Math.sqrt(d2 / j);
      if (this.prewarp != null)
      {
        opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)tempWarp3x3.get();
        opencv_core.cvInvert(this.prewarp, localCvMat3);
        opencv_core.cvMatMul(paramCvMat, localCvMat3, paramCvMat);
      }
    }
    return d1;
  }
  
  public int getWidth()
  {
    return this.planeImage.width();
  }
  
  public void setBackgroundColor(opencv_core.CvScalar paramCvScalar)
  {
    this.backgroundColor = paramCvScalar;
    setPrewarp(this.prewarp);
  }
  
  public void setColors(opencv_core.CvScalar paramCvScalar1, opencv_core.CvScalar paramCvScalar2)
  {
    this.foregroundColor = paramCvScalar1;
    this.backgroundColor = paramCvScalar2;
    setPrewarp(this.prewarp);
  }
  
  public void setForegroundColor(opencv_core.CvScalar paramCvScalar)
  {
    this.foregroundColor = paramCvScalar;
    setPrewarp(this.prewarp);
  }
  
  public void setPrewarp(opencv_core.CvMat paramCvMat)
  {
    this.prewarp = paramCvMat;
    int i;
    if (this.superPlaneImage == null)
    {
      opencv_core.cvSet(this.planeImage, this.backgroundColor);
      i = 0;
      label25:
      if (i >= this.markers.length) {
        break label118;
      }
      if (this.superPlaneImage != null) {
        break label80;
      }
      this.markers[i].draw(this.planeImage, this.foregroundColor, 1.0D, paramCvMat);
    }
    for (;;)
    {
      i++;
      break label25;
      opencv_core.cvSet(this.superPlaneImage, this.backgroundColor);
      break;
      label80:
      this.markers[i].draw(this.superPlaneImage, this.foregroundColor, this.superPlaneImage.width() / this.planeImage.width(), paramCvMat);
    }
    label118:
    if (this.superPlaneImage != null) {
      opencv_imgproc.cvResize(this.superPlaneImage, this.planeImage, 3);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\MarkedPlane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */