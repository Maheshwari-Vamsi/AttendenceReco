package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(include={"<opencv2/photo/photo_c.h>", "<opencv2/photo/photo.hpp>", "opencv_adapters.h"}, includepath={"/usr/local/include:/opt/local/include/"}, link={"opencv_photo@.2.4", "opencv_imgproc@.2.4", "opencv_core@.2.4"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, link={"opencv_photo245", "opencv_imgproc245", "opencv_core245"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x86/vc10/lib/"}, preloadpath={"C:/opencv/build/x86/vc10/bin/"}, value={"windows-x86"}), @com.googlecode.javacpp.annotation.Platform(linkpath={"C:/opencv/build/x64/vc10/lib/"}, preloadpath={"C:/opencv/build/x64/vc10/bin/"}, value={"windows-x86_64"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class opencv_photo
{
  public static final int CV_INPAINT_NS = 0;
  public static final int CV_INPAINT_TELEA = 1;
  
  static
  {
    Loader.load(opencv_imgproc.class);
    Loader.load();
  }
  
  public static native void cvInpaint(opencv_core.CvArr paramCvArr1, opencv_core.CvArr paramCvArr2, opencv_core.CvArr paramCvArr3, double paramDouble, int paramInt);
  
  @Namespace("cv")
  public static native void fastNlMeansDenoising(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, float paramFloat, int paramInt1, int paramInt2);
  
  @Namespace("cv")
  public static native void fastNlMeansDenoisingColored(@opencv_core.InputArray opencv_core.CvArr paramCvArr1, @opencv_core.InputArray opencv_core.CvArr paramCvArr2, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  @Namespace("cv")
  public static native void fastNlMeansDenoisingColoredMulti(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4);
  
  @Namespace("cv")
  public static native void fastNlMeansDenoisingMulti(@ByRef opencv_core.MatVector paramMatVector, @opencv_core.InputArray opencv_core.CvArr paramCvArr, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\opencv_photo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */