package com.example.ranjith.attendencereco.googlecode.javacv;

import com.jogamp.opencl.CLImage2d;

public abstract interface ImageAlignerCL
  extends ImageAligner
{
  public abstract CLImage2d[] getImagesCL();
  
  public abstract CLImage2d getMaskImageCL();
  
  public abstract CLImage2d getResidualImageCL();
  
  public abstract CLImage2d getTargetImageCL();
  
  public abstract CLImage2d getTemplateImageCL();
  
  public abstract CLImage2d getTransformedImageCL();
  
  public abstract void setTargetImageCL(CLImage2d paramCLImage2d);
  
  public abstract void setTemplateImageCL(CLImage2d paramCLImage2d, double[] paramArrayOfDouble);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ImageAlignerCL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */