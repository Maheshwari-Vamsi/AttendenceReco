package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libpostproc/postprocess.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"postproc@.52", "avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(define={"__STDC_CONSTANT_MACROS", "pp_help pp_help_bad[]; __declspec(dllimport) extern const char pp_help"}, includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"postproc-52"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class postproc
{
  public static final int LIBPOSTPROC_BUILD = LIBPOSTPROC_VERSION_INT;
  public static final String LIBPOSTPROC_IDENT = "postproc" + LIBPOSTPROC_VERSION;
  public static final String LIBPOSTPROC_VERSION;
  public static final int LIBPOSTPROC_VERSION_INT = 0;
  public static final int LIBPOSTPROC_VERSION_MAJOR = 52;
  public static final int LIBPOSTPROC_VERSION_MICRO = 100;
  public static final int LIBPOSTPROC_VERSION_MINOR = 2;
  public static final int PP_CPU_CAPS_3DNOW = 1073741824;
  public static final int PP_CPU_CAPS_ALTIVEC = 268435456;
  public static final int PP_CPU_CAPS_AUTO = 524288;
  public static final int PP_CPU_CAPS_MMX = Integer.MIN_VALUE;
  public static final int PP_CPU_CAPS_MMX2 = 536870912;
  public static final int PP_FORMAT = 8;
  public static final int PP_FORMAT_411 = 10;
  public static final int PP_FORMAT_420 = 25;
  public static final int PP_FORMAT_422 = 9;
  public static final int PP_FORMAT_444 = 8;
  public static final int PP_PICT_TYPE_QP2 = 16;
  public static final int PP_QUALITY_MAX = 6;
  
  static
  {
    Loader.load(avutil.class);
    Loader.load();
    LIBPOSTPROC_VERSION_INT = avutil.AV_VERSION_INT(52, 2, 100);
    LIBPOSTPROC_VERSION = avutil.AV_VERSION(52, 2, 100);
  }
  
  public static native String postproc_configuration();
  
  public static native String postproc_license();
  
  @Cast({"unsigned"})
  public static native int postproc_version();
  
  public static native void pp_free_context(pp_context parampp_context);
  
  public static native void pp_free_mode(pp_mode parampp_mode);
  
  public static native pp_context pp_get_context(int paramInt1, int paramInt2, int paramInt3);
  
  public static native pp_mode pp_get_mode_by_name_and_quality(String paramString, int paramInt);
  
  @MemberGetter
  @Name({"\n #undef pp_help \n pp_help"})
  public static native String pp_help();
  
  public static native void pp_postprocess(@Cast({"const uint8_t**"}) PointerPointer paramPointerPointer1, int[] paramArrayOfInt1, @Cast({"uint8_t**"}) PointerPointer paramPointerPointer2, int[] paramArrayOfInt2, int paramInt1, int paramInt2, @Cast({"QP_STORE_T*"}) byte[] paramArrayOfByte, int paramInt3, pp_mode parampp_mode, pp_context parampp_context, int paramInt4);
  
  @Opaque
  public static class pp_context
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public pp_context() {}
    
    public pp_context(Pointer paramPointer)
    {
      super();
    }
  }
  
  @Opaque
  public static class pp_mode
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public pp_mode() {}
    
    public pp_mode(Pointer paramPointer)
    {
      super();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\postproc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */