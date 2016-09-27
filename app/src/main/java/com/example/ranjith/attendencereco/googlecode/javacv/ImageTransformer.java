package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;

public abstract interface ImageTransformer
{
  public abstract Parameters createParameters();
  
  public abstract void transform(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, Parameters paramParameters, boolean paramBoolean);
  
  public abstract void transform(Data[] paramArrayOfData, opencv_core.CvRect paramCvRect, Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean);
  
  public static class Data
  {
    public int dstCount;
    public int dstCountOutlier;
    public int dstCountZero;
    public DoubleBuffer dstDstDot;
    public opencv_core.IplImage dstImg;
    public opencv_core.IplImage mask;
    public double outlierThreshold;
    public int pyramidLevel;
    public opencv_core.IplImage srcDotImg;
    public double srcDstDot;
    public opencv_core.IplImage srcImg;
    public opencv_core.IplImage subImg;
    public opencv_core.IplImage transImg;
    public double zeroThreshold;
    
    public Data()
    {
      this(null, null, null, null, 0.0D, 0.0D, 0, null, null, 0);
    }
    
    public Data(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, opencv_core.IplImage paramIplImage4, double paramDouble1, double paramDouble2, int paramInt1, opencv_core.IplImage paramIplImage5, opencv_core.IplImage paramIplImage6, int paramInt2)
    {
      this.srcImg = paramIplImage1;
      this.subImg = paramIplImage2;
      this.srcDotImg = paramIplImage3;
      this.mask = paramIplImage4;
      this.zeroThreshold = paramDouble1;
      this.outlierThreshold = paramDouble2;
      this.pyramidLevel = paramInt1;
      this.transImg = paramIplImage5;
      this.dstImg = paramIplImage6;
      if (paramInt2 == 0) {}
      for (DoubleBuffer localDoubleBuffer = null;; localDoubleBuffer = ByteBuffer.allocateDirect(paramInt2 * 8).order(ByteOrder.nativeOrder()).asDoubleBuffer())
      {
        this.dstDstDot = localDoubleBuffer;
        return;
      }
    }
  }
  
  public static abstract interface Parameters
    extends Cloneable
  {
    public abstract Parameters clone();
    
    public abstract void compose(Parameters paramParameters1, boolean paramBoolean1, Parameters paramParameters2, boolean paramBoolean2);
    
    public abstract double get(int paramInt);
    
    public abstract double[] get();
    
    public abstract double getConstraintError();
    
    public abstract double[] getSubspace();
    
    public abstract boolean preoptimize();
    
    public abstract void reset(boolean paramBoolean);
    
    public abstract void set(int paramInt, double paramDouble);
    
    public abstract void set(Parameters paramParameters);
    
    public abstract void set(double... paramVarArgs);
    
    public abstract void setSubspace(double... paramVarArgs);
    
    public abstract int size();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ImageTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */