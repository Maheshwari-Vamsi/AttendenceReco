package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libswresample/swresample.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"swresample@.0", "avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"swresample-0"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class swresample
{
  public static final int LIBSWRESAMPLE_BUILD = LIBSWRESAMPLE_VERSION_INT;
  public static final String LIBSWRESAMPLE_IDENT = "SwR" + LIBSWRESAMPLE_VERSION;
  public static final String LIBSWRESAMPLE_VERSION;
  public static final int LIBSWRESAMPLE_VERSION_INT = 0;
  public static final int LIBSWRESAMPLE_VERSION_MAJOR = 0;
  public static final int LIBSWRESAMPLE_VERSION_MICRO = 102;
  public static final int LIBSWRESAMPLE_VERSION_MINOR = 17;
  public static final int SWR_CH_MAX = 32;
  public static final int SWR_DITHER_NONE = 0;
  public static final int SWR_DITHER_NS_F_WEIGHTED = 66;
  public static final int SWR_DITHER_NS_HIGH_SHIBATA = 71;
  public static final int SWR_DITHER_NS_IMPROVED_E_WEIGHTED = 68;
  public static final int SWR_DITHER_NS_LIPSHITZ = 65;
  public static final int SWR_DITHER_NS_LOW_SHIBATA = 70;
  public static final int SWR_DITHER_NS_MODIFIED_E_WEIGHTED = 67;
  public static final int SWR_DITHER_NS_SHIBATA = 69;
  public static final int SWR_DITHER_RECTANGULAR = 1;
  public static final int SWR_DITHER_TRIANGULAR = 2;
  public static final int SWR_DITHER_TRIANGULAR_HIGHPASS = 3;
  public static final int SWR_ENGINE_SOXR = 1;
  public static final int SWR_ENGINE_SWR = 0;
  public static final int SWR_FILTER_TYPE_BLACKMAN_NUTTALL = 1;
  public static final int SWR_FILTER_TYPE_CUBIC = 0;
  public static final int SWR_FILTER_TYPE_KAISER = 2;
  public static final int SWR_FLAG_RESAMPLE = 1;
  
  static
  {
    Loader.load(avutil.class);
    Loader.load();
    LIBSWRESAMPLE_VERSION_INT = avutil.AV_VERSION_INT(0, 17, 102);
    LIBSWRESAMPLE_VERSION = avutil.AV_VERSION(0, 17, 102);
  }
  
  public static native SwrContext swr_alloc();
  
  public static native SwrContext swr_alloc_set_opts(SwrContext paramSwrContext, long paramLong1, @Cast({"AVSampleFormat"}) int paramInt1, int paramInt2, long paramLong2, @Cast({"AVSampleFormat"}) int paramInt3, int paramInt4, int paramInt5, Pointer paramPointer);
  
  public static native int swr_convert(SwrContext paramSwrContext, @ByPtrPtr @Cast({"uint8_t**"}) BytePointer paramBytePointer1, int paramInt1, @ByPtrPtr @Cast({"const uint8_t**"}) BytePointer paramBytePointer2, int paramInt2);
  
  public static native int swr_convert(SwrContext paramSwrContext, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer1, int paramInt1, @Cast({"const uint8_t**"}) PointerPointer paramPointerPointer2, int paramInt2);
  
  public static native int swr_drop_output(SwrContext paramSwrContext, int paramInt);
  
  public static native void swr_free(@ByPtrPtr SwrContext paramSwrContext);
  
  @Const
  public static native avutil.AVClass swr_get_class();
  
  public static native long swr_get_delay(SwrContext paramSwrContext, long paramLong);
  
  public static native int swr_init(SwrContext paramSwrContext);
  
  public static native int swr_inject_silence(SwrContext paramSwrContext, int paramInt);
  
  public static native long swr_next_pts(SwrContext paramSwrContext, long paramLong);
  
  public static native int swr_set_channel_mapping(SwrContext paramSwrContext, int[] paramArrayOfInt);
  
  public static native int swr_set_compensation(SwrContext paramSwrContext, int paramInt1, int paramInt2);
  
  public static native int swr_set_matrix(SwrContext paramSwrContext, double[] paramArrayOfDouble, int paramInt);
  
  public static native String swresample_configuration();
  
  public static native String swresample_license();
  
  @Cast({"unsigned"})
  public static native int swresample_version();
  
  @Opaque
  public static class SwrContext
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public SwrContext() {}
    
    public SwrContext(Pointer paramPointer)
    {
      super();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\swresample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */