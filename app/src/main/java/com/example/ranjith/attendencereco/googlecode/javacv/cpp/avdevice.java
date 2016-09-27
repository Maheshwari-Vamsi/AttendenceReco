package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Properties;

@Properties({@com.googlecode.javacpp.annotation.Platform(cinclude={"<libavdevice/avdevice.h>"}, define={"__STDC_CONSTANT_MACROS"}, includepath={"/usr/local/include/ffmpeg/:/usr/local/include/:/opt/local/include/ffmpeg/:/opt/local/include/:/usr/include/ffmpeg/"}, link={"avdevice@.54", "avfilter@.3", "swscale@.2", "swresample@.0", "postproc@.52", "avformat@.54", "avcodec@.54", "avutil@.52"}, linkpath={"/usr/local/lib/:/usr/local/lib64/:/opt/local/lib/:/opt/local/lib64/"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/MinGW/local/include/ffmpeg/;C:/MinGW/include/ffmpeg/;C:/MinGW/local/include/;src/main/resources/com/googlecode/javacv/cpp/"}, linkpath={"C:/MinGW/local/lib/;C:/MinGW/lib/"}, preload={"avdevice-54"}, preloadpath={"C:/MinGW/local/bin/;C:/MinGW/bin/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, linkpath={"../lib/"}, value={"android"})})
public class avdevice
{
  public static final int LIBAVDEVICE_BUILD = LIBAVDEVICE_VERSION_INT;
  public static final String LIBAVDEVICE_IDENT = "Lavf" + LIBAVDEVICE_VERSION;
  public static final String LIBAVDEVICE_VERSION;
  public static final int LIBAVDEVICE_VERSION_INT = 0;
  public static final int LIBAVDEVICE_VERSION_MAJOR = 54;
  public static final int LIBAVDEVICE_VERSION_MICRO = 103;
  public static final int LIBAVDEVICE_VERSION_MINOR = 3;
  
  static
  {
    Loader.load(avfilter.class);
    Loader.load();
    LIBAVDEVICE_VERSION_INT = avutil.AV_VERSION_INT(54, 3, 103);
    LIBAVDEVICE_VERSION = avutil.AV_VERSION(54, 3, 103);
  }
  
  public static native String avdevice_configuration();
  
  public static native String avdevice_license();
  
  public static native void avdevice_register_all();
  
  @Cast({"unsigned"})
  public static native int avdevice_version();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\avdevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */