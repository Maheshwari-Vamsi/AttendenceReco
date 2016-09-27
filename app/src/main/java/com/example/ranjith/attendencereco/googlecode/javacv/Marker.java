package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.ARToolKitPlus;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Marker
  implements Cloneable
{
  private static ThreadLocal<opencv_core.CvMat> H3x3;
  private static ThreadLocal<opencv_core.CvMat> dstPts4x1 = opencv_core.CvMat.createThreadLocal(4, 1, 6, 2);
  private static opencv_core.IplImage[] imageCache = new opencv_core.IplImage['က'];
  private static final double[] src = { 0.0D, 0.0D, 8.0D, 0.0D, 8.0D, 8.0D, 0.0D, 8.0D };
  private static ThreadLocal<opencv_core.CvMat> srcPts4x1;
  public double confidence;
  public double[] corners;
  public int id;
  
  static
  {
    H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
    srcPts4x1 = opencv_core.CvMat.createThreadLocal(4, 1, 6, 2);
  }
  
  public Marker(int paramInt, double... paramVarArgs)
  {
    this(paramInt, paramVarArgs, 1.0D);
  }
  
  public Marker(int paramInt, double[] paramArrayOfDouble, double paramDouble)
  {
    this.id = paramInt;
    this.corners = paramArrayOfDouble;
    this.confidence = paramDouble;
  }
  
  public static void applyWarp(Marker[] paramArrayOfMarker, opencv_core.CvMat paramCvMat)
  {
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)srcPts4x1.get();
    int i = paramArrayOfMarker.length;
    for (int j = 0; j < i; j++)
    {
      Marker localMarker = paramArrayOfMarker[j];
      opencv_core.cvPerspectiveTransform(localCvMat.put(localMarker.corners), localCvMat, paramCvMat);
      localCvMat.get(localMarker.corners);
    }
  }
  
  public static Marker[][] createArray(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, boolean paramBoolean, double paramDouble5, double paramDouble6)
  {
    ArraySettings localArraySettings = new ArraySettings();
    localArraySettings.rows = paramInt1;
    localArraySettings.columns = paramInt2;
    localArraySettings.sizeX = paramDouble1;
    localArraySettings.sizeY = paramDouble2;
    localArraySettings.spacingX = paramDouble3;
    localArraySettings.spacingY = paramDouble4;
    localArraySettings.checkered = paramBoolean;
    return createArray(localArraySettings, paramDouble5, paramDouble6);
  }
  
  public static Marker[][] createArray(ArraySettings paramArraySettings)
  {
    return createArray(paramArraySettings, 0.0D, 0.0D);
  }
  
  public static Marker[][] createArray(ArraySettings paramArraySettings, double paramDouble1, double paramDouble2)
  {
    Marker[] arrayOfMarker1 = new Marker[paramArraySettings.rows * paramArraySettings.columns];
    int i = 0;
    for (int j = 0;; j++)
    {
      int k = paramArraySettings.rows;
      if (j >= k) {
        break;
      }
      for (int i4 = 0; i4 < paramArraySettings.columns; i4++)
      {
        double d1 = paramArraySettings.sizeX / 2.0D;
        double d2 = paramArraySettings.sizeY / 2.0D;
        double d3 = paramDouble1 + (d1 + i4 * paramArraySettings.spacingX);
        double d4 = paramDouble2 + (d2 + j * paramArraySettings.spacingY);
        double[] arrayOfDouble = new double[8];
        arrayOfDouble[0] = (d3 - d1);
        arrayOfDouble[1] = (d4 - d2);
        arrayOfDouble[2] = (d3 + d1);
        arrayOfDouble[3] = (d4 - d2);
        arrayOfDouble[4] = (d3 + d1);
        arrayOfDouble[5] = (d4 + d2);
        arrayOfDouble[6] = (d3 - d1);
        arrayOfDouble[7] = (d4 + d2);
        Marker localMarker = new Marker(i, arrayOfDouble, 1.0D);
        arrayOfMarker1[i] = localMarker;
        i++;
      }
    }
    if (!paramArraySettings.checkered) {
      return new Marker[][] { arrayOfMarker1 };
    }
    Marker[] arrayOfMarker2 = new Marker[arrayOfMarker1.length / 2];
    Marker[] arrayOfMarker3 = new Marker[arrayOfMarker1.length / 2];
    int m = 0;
    if (m < arrayOfMarker1.length)
    {
      int n = m % paramArraySettings.columns;
      int i1 = m / paramArraySettings.columns;
      int i2;
      label287:
      int i3;
      if (n % 2 == 0)
      {
        i2 = 1;
        if (i1 % 2 != 0) {
          break label329;
        }
        i3 = 1;
        label297:
        if ((i2 ^ i3) == 0) {
          break label335;
        }
        arrayOfMarker3[(m / 2)] = arrayOfMarker1[m];
      }
      for (;;)
      {
        m++;
        break;
        i2 = 0;
        break label287;
        label329:
        i3 = 0;
        break label297;
        label335:
        arrayOfMarker2[(m / 2)] = arrayOfMarker1[m];
      }
    }
    return new Marker[][] { arrayOfMarker3, arrayOfMarker2 };
  }
  
  public static opencv_core.IplImage getImage(int paramInt)
  {
    if (imageCache[paramInt] == null)
    {
      imageCache[paramInt] = opencv_core.IplImage.create(8, 8, 8, 1);
      ARToolKitPlus.createImagePatternBCH(paramInt, imageCache[paramInt].getByteBuffer());
    }
    return imageCache[paramInt];
  }
  
  public Marker clone()
  {
    return new Marker(this.id, (double[])this.corners.clone(), this.confidence);
  }
  
  public void draw(opencv_core.IplImage paramIplImage)
  {
    draw(paramIplImage, opencv_core.CvScalar.BLACK, 1.0D, null);
  }
  
  public void draw(opencv_core.IplImage paramIplImage, opencv_core.CvScalar paramCvScalar, double paramDouble1, double paramDouble2, opencv_core.CvMat paramCvMat)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)H3x3.get();
    JavaCV.getPerspectiveTransform(src, this.corners, localCvMat1);
    if (paramCvMat != null) {
      opencv_core.cvGEMM(paramCvMat, localCvMat1, 1.0D, null, 0.0D, localCvMat1, 0);
    }
    opencv_core.IplImage localIplImage = getImage();
    ByteBuffer localByteBuffer = localIplImage.getByteBuffer();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)srcPts4x1.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)dstPts4x1.get();
    opencv_core.CvPoint localCvPoint = new opencv_core.CvPoint(4);
    int i = localIplImage.height();
    int j = localIplImage.width();
    for (int k = 0; k < i; k++) {
      for (int m = 0; m < j; m++) {
        if (localByteBuffer.get(m + k * j) == 0)
        {
          double[] arrayOfDouble = new double[8];
          arrayOfDouble[0] = m;
          arrayOfDouble[1] = k;
          arrayOfDouble[2] = (m + 1);
          arrayOfDouble[3] = k;
          arrayOfDouble[4] = (m + 1);
          arrayOfDouble[5] = (k + 1);
          arrayOfDouble[6] = m;
          arrayOfDouble[7] = (k + 1);
          localCvMat2.put(arrayOfDouble);
          opencv_core.cvPerspectiveTransform(localCvMat2, localCvMat3, localCvMat1);
          double d1 = 0.0D;
          double d2 = 0.0D;
          for (int n = 0; n < 4; n++)
          {
            d1 += localCvMat3.get(n * 2);
            d2 += localCvMat3.get(1 + n * 2);
          }
          double d3 = d1 / 4.0D;
          double d4 = d2 / 4.0D;
          int i1 = 0;
          if (i1 < 4)
          {
            double d5 = localCvMat3.get(i1 * 2);
            double d6 = localCvMat3.get(1 + i1 * 2);
            double d7 = d3 - d5;
            double d8 = d4 - d6;
            double d9;
            if (d7 < 0.0D)
            {
              d9 = -1.0D;
              label352:
              if (d8 >= 0.0D) {
                break label429;
              }
            }
            label429:
            for (double d10 = -1.0D;; d10 = 0.0D)
            {
              localCvPoint.position(i1).x((int)Math.round(65536.0D * (d9 + d5 * paramDouble1)));
              localCvPoint.position(i1).y((int)Math.round(65536.0D * (d10 + d6 * paramDouble2)));
              i1++;
              break;
              d9 = 0.0D;
              break label352;
            }
          }
          opencv_core.cvFillConvexPoly(paramIplImage, localCvPoint.position(0), 4, paramCvScalar, 8, 16);
        }
      }
    }
  }
  
  public void draw(opencv_core.IplImage paramIplImage, opencv_core.CvScalar paramCvScalar, double paramDouble, opencv_core.CvMat paramCvMat)
  {
    draw(paramIplImage, paramCvScalar, paramDouble, paramDouble, paramCvMat);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Marker;
    boolean bool2 = false;
    if (bool1)
    {
      Marker localMarker = (Marker)paramObject;
      int i = localMarker.id;
      int j = this.id;
      bool2 = false;
      if (i == j)
      {
        boolean bool3 = Arrays.equals(localMarker.corners, this.corners);
        bool2 = false;
        if (bool3) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public double[] getCenter()
  {
    double d1 = 0.0D;
    double d2 = 0.0D;
    for (int i = 0; i < 4; i++)
    {
      d1 += this.corners[(i * 2)];
      d2 += this.corners[(1 + i * 2)];
    }
    return new double[] { d1 / 4.0D, d2 / 4.0D };
  }
  
  public opencv_core.IplImage getImage()
  {
    return getImage(this.id);
  }
  
  public int hashCode()
  {
    int i = 37 * (259 + this.id);
    if (this.corners != null) {}
    for (int j = this.corners.hashCode();; j = 0) {
      return i + j;
    }
  }
  
  public String toString()
  {
    return "[" + this.id + ": " + "(" + this.corners[0] + ", " + this.corners[1] + ") " + "(" + this.corners[2] + ", " + this.corners[3] + ") " + "(" + this.corners[4] + ", " + this.corners[5] + ") " + "(" + this.corners[6] + ", " + this.corners[7] + ")]";
  }
  
  public static class ArraySettings
    extends BaseChildSettings
  {
    boolean checkered = true;
    int columns = 12;
    int rows = 8;
    double sizeX = 200.0D;
    double sizeY = 200.0D;
    double spacingX = 300.0D;
    double spacingY = 300.0D;
    
    public int getColumns()
    {
      return this.columns;
    }
    
    public int getRows()
    {
      return this.rows;
    }
    
    public double getSizeX()
    {
      return this.sizeX;
    }
    
    public double getSizeY()
    {
      return this.sizeY;
    }
    
    public double getSpacingX()
    {
      return this.spacingX;
    }
    
    public double getSpacingY()
    {
      return this.spacingY;
    }
    
    public boolean isCheckered()
    {
      return this.checkered;
    }
    
    public void setCheckered(boolean paramBoolean)
    {
      Boolean localBoolean = Boolean.valueOf(this.checkered);
      this.checkered = paramBoolean;
      firePropertyChange("checkered", localBoolean, Boolean.valueOf(paramBoolean));
    }
    
    public void setColumns(int paramInt)
    {
      Integer localInteger = Integer.valueOf(this.columns);
      this.columns = paramInt;
      firePropertyChange("columns", localInteger, Integer.valueOf(paramInt));
    }
    
    public void setRows(int paramInt)
    {
      Integer localInteger = Integer.valueOf(this.rows);
      this.rows = paramInt;
      firePropertyChange("rows", localInteger, Integer.valueOf(paramInt));
    }
    
    public void setSizeX(double paramDouble)
    {
      Double localDouble = Double.valueOf(this.sizeX);
      this.sizeX = paramDouble;
      firePropertyChange("sizeX", localDouble, Double.valueOf(paramDouble));
    }
    
    public void setSizeY(double paramDouble)
    {
      Double localDouble = Double.valueOf(this.sizeY);
      this.sizeY = paramDouble;
      firePropertyChange("sizeY", localDouble, Double.valueOf(paramDouble));
    }
    
    public void setSpacingX(double paramDouble)
    {
      Double localDouble = Double.valueOf(this.spacingX);
      this.spacingX = paramDouble;
      firePropertyChange("spacingX", localDouble, Double.valueOf(paramDouble));
    }
    
    public void setSpacingY(double paramDouble)
    {
      Double localDouble = Double.valueOf(this.spacingY);
      this.spacingY = paramDouble;
      firePropertyChange("spacingY", localDouble, Double.valueOf(paramDouble));
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */