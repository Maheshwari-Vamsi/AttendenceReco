package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public abstract interface ImageAligner
{
  public abstract opencv_core.IplImage[] getImages();
  
  public abstract opencv_core.IplImage getMaskImage();
  
  public abstract ImageTransformer.Parameters getParameters();
  
  public abstract int getPyramidLevel();
  
  public abstract double getRMSE();
  
  public abstract opencv_core.IplImage getResidualImage();
  
  public abstract opencv_core.CvRect getRoi();
  
  public abstract Settings getSettings();
  
  public abstract opencv_core.IplImage getTargetImage();
  
  public abstract opencv_core.IplImage getTemplateImage();
  
  public abstract opencv_core.IplImage getTransformedImage();
  
  public abstract double[] getTransformedRoiPts();
  
  public abstract boolean iterate(double[] paramArrayOfDouble);
  
  public abstract void setParameters(ImageTransformer.Parameters paramParameters);
  
  public abstract void setPyramidLevel(int paramInt);
  
  public abstract void setSettings(Settings paramSettings);
  
  public abstract void setTargetImage(opencv_core.IplImage paramIplImage);
  
  public abstract void setTemplateImage(opencv_core.IplImage paramIplImage, double[] paramArrayOfDouble);
  
  public static class Settings
    extends BaseChildSettings
    implements Cloneable
  {
    int pyramidLevelMax = 4;
    int pyramidLevelMin = 0;
    boolean thresholdsMulRMSE = false;
    double[] thresholdsOutlier = { 0.2D };
    double[] thresholdsZero = { 0.04D, 0.03D, 0.02D, 0.01D, 0.0D };
    
    public Settings() {}
    
    public Settings(Settings paramSettings)
    {
      this.pyramidLevelMin = paramSettings.pyramidLevelMin;
      this.pyramidLevelMax = paramSettings.pyramidLevelMax;
      this.thresholdsZero = paramSettings.thresholdsZero;
      this.thresholdsOutlier = paramSettings.thresholdsOutlier;
      this.thresholdsMulRMSE = paramSettings.thresholdsMulRMSE;
    }
    
    public Settings clone()
    {
      return new Settings(this);
    }
    
    public int getPyramidLevelMax()
    {
      return this.pyramidLevelMax;
    }
    
    public int getPyramidLevelMin()
    {
      return this.pyramidLevelMin;
    }
    
    public double[] getThresholdsOutlier()
    {
      return this.thresholdsOutlier;
    }
    
    public double[] getThresholdsZero()
    {
      return this.thresholdsZero;
    }
    
    public boolean isThresholdsMulRMSE()
    {
      return this.thresholdsMulRMSE;
    }
    
    public void setPyramidLevelMax(int paramInt)
    {
      this.pyramidLevelMax = paramInt;
    }
    
    public void setPyramidLevelMin(int paramInt)
    {
      this.pyramidLevelMin = paramInt;
    }
    
    public void setThresholdsMulRMSE(boolean paramBoolean)
    {
      this.thresholdsMulRMSE = paramBoolean;
    }
    
    public void setThresholdsOutlier(double[] paramArrayOfDouble)
    {
      this.thresholdsOutlier = paramArrayOfDouble;
    }
    
    public void setThresholdsZero(double[] paramArrayOfDouble)
    {
      this.thresholdsZero = paramArrayOfDouble;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ImageAligner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */