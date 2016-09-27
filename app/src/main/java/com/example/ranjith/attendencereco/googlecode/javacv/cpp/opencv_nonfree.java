package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoOffset;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacpp.annotation.StdVector;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/nonfree/nonfree.hpp>", "<opencv2/features2d/features2d.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_nonfree@.2.4", "opencv_features2d@.2.4", "opencv_flann@.2.4", "opencv_highgui@.2.4", "opencv_imgproc@2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_nonfree245", "opencv_features2d245", "opencv_flann245", "opencv_highgui245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_nonfree
{
  static
  {
    Loader.load(opencv_highgui.class);
    Loader.load(opencv_flann.class);
    Loader.load(opencv_features2d.class);
    if (Loader.load() != null) {
      initModule_nonfree();
    }
  }
  
  @Cast({"bool"})
  @Namespace("cv")
  public static native boolean initModule_nonfree();
  
  @Namespace("cv")
  public static class SIFT
    extends opencv_features2d.Feature2D
  {
    static
    {
      Loader.load();
    }
    
    public SIFT()
    {
      allocate();
    }
    
    public SIFT(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3)
    {
      allocate(paramInt1, paramInt2, paramDouble1, paramDouble2, paramDouble3);
    }
    
    public SIFT(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocate(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3);
    
    public native void buildDoGPyramid(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray1, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray2);
    
    public native void buildGaussianPyramid(opencv_core.IplImage paramIplImage, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray, int paramInt);
    
    public native int descriptorSize();
    
    public native int descriptorType();
    
    @Name({"operator()"})
    public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    @Name({"operator()"})
    public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
    
    public native void findScaleSpaceExtrema(@Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray1, @Const(true) @StdVector("IplImage*,cv::Mat") opencv_core.IplImageArray paramIplImageArray2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    public native opencv_core.AlgorithmInfo info();
  }
  
  @Namespace("cv")
  @NoOffset
  public static class SURF
    extends opencv_features2d.Feature2D
  {
    static
    {
      Loader.load();
    }
    
    public SURF(double paramDouble)
    {
      allocate(paramDouble);
    }
    
    public SURF(double paramDouble, int paramInt1, int paramInt2, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2)
    {
      allocate(paramDouble, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    
    public SURF(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(double paramDouble);
    
    private native void allocate(double paramDouble, int paramInt1, int paramInt2, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2);
    
    public native int descriptorSize();
    
    public native int descriptorType();
    
    @Name({"operator()"})
    public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint);
    
    @Name({"operator()"})
    public native void detect(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, @StdVector opencv_features2d.KeyPoint paramKeyPoint, @opencv_core.OutputArray opencv_core.CvMat paramCvMat, @Cast({"bool"}) boolean paramBoolean);
    
    public native SURF extended(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean extended();
    
    public native double hessianThreshold();
    
    public native SURF hessianThreshold(double paramDouble);
    
    public native opencv_core.AlgorithmInfo info();
    
    public native int nOctaveLayers();
    
    public native SURF nOctaveLayers(int paramInt);
    
    public native int nOctaves();
    
    public native SURF nOctaves(int paramInt);
    
    public native SURF upright(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean upright();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_nonfree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */