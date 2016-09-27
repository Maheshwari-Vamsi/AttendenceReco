package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libswscale/swscale.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"swscale@.2", "avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"swscale-2"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class swscale
{
  public static final int LIBSWSCALE_BUILD = LIBSWSCALE_VERSION_INT;
  public static final String LIBSWSCALE_IDENT = "SwS" + LIBSWSCALE_VERSION;
  public static final String LIBSWSCALE_VERSION;
  public static final int LIBSWSCALE_VERSION_INT = 0;
  public static final int LIBSWSCALE_VERSION_MAJOR = 2;
  public static final int LIBSWSCALE_VERSION_MICRO = 100;
  public static final int LIBSWSCALE_VERSION_MINOR = 2;
  public static final int SWS_ACCURATE_RND = 262144;
  public static final int SWS_AREA = 32;
  public static final int SWS_BICUBIC = 4;
  public static final int SWS_BICUBLIN = 64;
  public static final int SWS_BILINEAR = 2;
  public static final int SWS_BITEXACT = 524288;
  public static final int SWS_CS_DEFAULT = 5;
  public static final int SWS_CS_FCC = 4;
  public static final int SWS_CS_ITU601 = 5;
  public static final int SWS_CS_ITU624 = 5;
  public static final int SWS_CS_ITU709 = 1;
  public static final int SWS_CS_SMPTE170M = 5;
  public static final int SWS_CS_SMPTE240M = 7;
  public static final int SWS_DIRECT_BGR = 32768;
  public static final int SWS_ERROR_DIFFUSION = 8388608;
  public static final int SWS_FAST_BILINEAR = 1;
  public static final int SWS_FULL_CHR_H_INP = 16384;
  public static final int SWS_FULL_CHR_H_INT = 8192;
  public static final int SWS_GAUSS = 128;
  public static final int SWS_LANCZOS = 512;
  public static final double SWS_MAX_REDUCE_CUTOFF = 0.002D;
  public static final int SWS_PARAM_DEFAULT = 123456;
  public static final int SWS_POINT = 16;
  public static final int SWS_PRINT_INFO = 4096;
  public static final int SWS_SINC = 256;
  public static final int SWS_SPLINE = 1024;
  public static final int SWS_SRC_V_CHR_DROP_MASK = 196608;
  public static final int SWS_SRC_V_CHR_DROP_SHIFT = 16;
  public static final int SWS_X = 8;
  
  static
  {
    Loader.load(avutil.class);
    Loader.load();
    LIBSWSCALE_VERSION_INT = avutil.AV_VERSION_INT(2, 2, 100);
    LIBSWSCALE_VERSION = avutil.AV_VERSION(2, 2, 100);
  }
  
  public static native void sws_addVec(SwsVector paramSwsVector1, SwsVector paramSwsVector2);
  
  public static native SwsVector sws_allocVec(int paramInt);
  
  public static native SwsContext sws_alloc_context();
  
  public static native SwsVector sws_cloneVec(SwsVector paramSwsVector);
  
  public static native void sws_convVec(SwsVector paramSwsVector1, SwsVector paramSwsVector2);
  
  public static native void sws_convertPalette8ToPacked24(@Cast({"uint8_t*"}) BytePointer paramBytePointer1, @Cast({"uint8_t*"}) BytePointer paramBytePointer2, int paramInt, @Cast({"uint8_t*"}) BytePointer paramBytePointer3);
  
  public static native void sws_convertPalette8ToPacked32(@Cast({"uint8_t*"}) BytePointer paramBytePointer1, @Cast({"uint8_t*"}) BytePointer paramBytePointer2, int paramInt, @Cast({"uint8_t*"}) BytePointer paramBytePointer3);
  
  public static native void sws_freeContext(SwsContext paramSwsContext);
  
  public static native void sws_freeFilter(SwsFilter paramSwsFilter);
  
  public static native void sws_freeVec(SwsVector paramSwsVector);
  
  public static native SwsContext sws_getCachedContext(SwsContext paramSwsContext, int paramInt1, int paramInt2, @Cast({"AVPixelFormat"}) int paramInt3, int paramInt4, int paramInt5, @Cast({"AVPixelFormat"}) int paramInt6, int paramInt7, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2, double[] paramArrayOfDouble);
  
  @Const
  public static native IntPointer sws_getCoefficients(int paramInt);
  
  public static native int sws_getColorspaceDetails(SwsContext paramSwsContext, @ByPtrPtr IntPointer paramIntPointer1, int[] paramArrayOfInt1, @ByPtrPtr IntPointer paramIntPointer2, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5);
  
  public static native SwsVector sws_getConstVec(double paramDouble, int paramInt);
  
  public static native SwsFilter sws_getDefaultFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt);
  
  public static native SwsVector sws_getGaussianVec(double paramDouble1, double paramDouble2);
  
  public static native SwsVector sws_getIdentityVec();
  
  @Const
  public static native avutil.AVClass sws_get_class();
  
  public static native int sws_init_context(SwsContext paramSwsContext, SwsFilter paramSwsFilter1, SwsFilter paramSwsFilter2);
  
  public static native int sws_isSupportedInput(@Cast({"AVPixelFormat"}) int paramInt);
  
  public static native int sws_isSupportedOutput(@Cast({"AVPixelFormat"}) int paramInt);
  
  public static native void sws_normalizeVec(SwsVector paramSwsVector, double paramDouble);
  
  public static native void sws_printVec2(SwsVector paramSwsVector, avutil.AVClass paramAVClass, int paramInt);
  
  public static native int sws_scale(SwsContext paramSwsContext, @ByPtrPtr @Cast({"const uint8_t**"}) BytePointer paramBytePointer1, IntPointer paramIntPointer1, int paramInt1, int paramInt2, @ByPtrPtr @Cast({"uint8_t**"}) BytePointer paramBytePointer2, IntPointer paramIntPointer2);
  
  public static native int sws_scale(SwsContext paramSwsContext, @ByPtrPtr @Cast({"const uint8_t**"}) BytePointer paramBytePointer1, int[] paramArrayOfInt1, int paramInt1, int paramInt2, @ByPtrPtr @Cast({"uint8_t**"}) BytePointer paramBytePointer2, int[] paramArrayOfInt2);
  
  public static native int sws_scale(SwsContext paramSwsContext, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer1, IntPointer paramIntPointer1, int paramInt1, int paramInt2, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer2, IntPointer paramIntPointer2);
  
  public static native int sws_scale(SwsContext paramSwsContext, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer1, int[] paramArrayOfInt1, int paramInt1, int paramInt2, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer2, int[] paramArrayOfInt2);
  
  public static native void sws_scaleVec(SwsVector paramSwsVector, double paramDouble);
  
  public static native int sws_setColorspaceDetails(SwsContext paramSwsContext, int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void sws_shiftVec(SwsVector paramSwsVector, int paramInt);
  
  public static native void sws_subVec(SwsVector paramSwsVector1, SwsVector paramSwsVector2);
  
  public static native String swscale_configuration();
  
  public static native String swscale_license();
  
  @Cast({"unsigned"})
  public static native int swscale_version();
  
  @Opaque
  public static class SwsContext
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public SwsContext() {}
    
    public SwsContext(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class SwsFilter
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public SwsFilter()
    {
      allocate();
    }
    
    public SwsFilter(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public SwsFilter(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native SwsFilter chrH(SwsVector paramSwsVector);
    
    public native SwsVector chrH();
    
    public native SwsFilter chrV(SwsVector paramSwsVector);
    
    public native SwsVector chrV();
    
    public native SwsFilter lumH(SwsVector paramSwsVector);
    
    public native SwsVector lumH();
    
    public native SwsFilter lumV(SwsVector paramSwsVector);
    
    public native SwsVector lumV();
    
    public SwsFilter position(int paramInt)
    {
      return (SwsFilter)super.position(paramInt);
    }
  }
  
  public static class SwsVector
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public SwsVector()
    {
      allocate();
    }
    
    public SwsVector(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public SwsVector(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native DoublePointer coeff();
    
    public native SwsVector coeff(DoublePointer paramDoublePointer);
    
    public native int length();
    
    public native SwsVector length(int paramInt);
    
    public SwsVector position(int paramInt)
    {
      return (SwsVector)super.position(paramInt);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\swscale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */