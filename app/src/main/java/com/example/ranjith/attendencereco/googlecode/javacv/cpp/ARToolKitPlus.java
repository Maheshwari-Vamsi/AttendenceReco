package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByPtrPtr;
import com.googlecode.javacpp.annotation.ByPtrRef;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Platform;
import java.nio.ByteBuffer;

@Namespace("ARToolKitPlus")
@Platform(define={"LIBRPP_STATIC"}, include={"<ARToolKitPlus/template.h>", "<MemoryManager.cpp>", "<librpp/rpp.cpp>", "<librpp/rpp_quintic.cpp>", "<librpp/rpp_vecmat.cpp>", "<librpp/rpp_svd.cpp>", "<librpp/librpp.cpp>", "<extra/Profiler.cpp>"}, includepath={"/usr/include/malloc/", "../ARToolKitPlus_2.1.1t/include/", "../ARToolKitPlus_2.1.1t/src/"}, options={"fastfpu"})
public class ARToolKitPlus
{
  public static final int IMAGE_FULL_RES = 1;
  public static final int IMAGE_HALF_RES = 0;
  public static final int MARKER_ID_BCH = 2;
  public static final int MARKER_ID_SIMPLE = 1;
  public static final int MARKER_TEMPLATE = 0;
  public static final int PIXEL_FORMAT_ABGR = 1;
  public static final int PIXEL_FORMAT_BGR = 3;
  public static final int PIXEL_FORMAT_BGRA = 2;
  public static final int PIXEL_FORMAT_LUM = 7;
  public static final int PIXEL_FORMAT_RGB = 5;
  public static final int PIXEL_FORMAT_RGB565 = 6;
  public static final int PIXEL_FORMAT_RGBA = 4;
  public static final int POSE_ESTIMATOR_ORIGINAL = 0;
  public static final int POSE_ESTIMATOR_ORIGINAL_CONT = 1;
  public static final int POSE_ESTIMATOR_RPP = 2;
  public static final int UNDIST_LUT = 2;
  public static final int UNDIST_NONE = 0;
  public static final int UNDIST_STD = 1;
  
  static
  {
    Loader.load();
  }
  
  public static native void createImagePatternBCH(int paramInt, @Cast({"ARToolKitPlus::ARUint8*"}) ByteBuffer paramByteBuffer);
  
  public static native void createImagePatternBCH(int paramInt, @Cast({"ARToolKitPlus::ARUint8*"}) byte[] paramArrayOfByte);
  
  public static native void createImagePatternSimple(int paramInt, @Cast({"ARToolKitPlus::ARUint8*"}) ByteBuffer paramByteBuffer);
  
  public static native void createImagePatternSimple(int paramInt, @Cast({"ARToolKitPlus::ARUint8*"}) byte[] paramArrayOfByte);
  
  public static class ARMarkerInfo
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ARMarkerInfo()
    {
      allocate();
    }
    
    public ARMarkerInfo(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public ARMarkerInfo(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native int area();
    
    public native ARMarkerInfo area(int paramInt);
    
    public native double cf();
    
    public native ARMarkerInfo cf(double paramDouble);
    
    public native int dir();
    
    public native ARMarkerInfo dir(int paramInt);
    
    public native int id();
    
    public native ARMarkerInfo id(int paramInt);
    
    @Cast({"ARFloat(*)[3]"})
    @MemberGetter
    public native DoublePointer line();
    
    @MemberGetter
    public native DoublePointer pos();
    
    public ARMarkerInfo position(int paramInt)
    {
      return (ARMarkerInfo)super.position(paramInt);
    }
    
    @Cast({"ARFloat(*)[2]"})
    @MemberGetter
    public native DoublePointer vertex();
  }
  
  public static class ARMultiEachMarkerInfoT
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ARMultiEachMarkerInfoT()
    {
      allocate();
    }
    
    public ARMultiEachMarkerInfoT(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public ARMultiEachMarkerInfoT(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @MemberGetter
    public native DoublePointer center();
    
    @Cast({"ARFloat(*)[4]"})
    @MemberGetter
    public native DoublePointer itrans();
    
    public native int patt_id();
    
    public native ARMultiEachMarkerInfoT patt_id(int paramInt);
    
    @Cast({"ARFloat(*)[3]"})
    @MemberGetter
    public native DoublePointer pos3d();
    
    public ARMultiEachMarkerInfoT position(int paramInt)
    {
      return (ARMultiEachMarkerInfoT)super.position(paramInt);
    }
    
    @Cast({"ARFloat(*)[4]"})
    @MemberGetter
    public native DoublePointer trans();
    
    public native int visible();
    
    public native ARMultiEachMarkerInfoT visible(int paramInt);
    
    public native int visibleR();
    
    public native ARMultiEachMarkerInfoT visibleR(int paramInt);
    
    public native double width();
    
    public native ARMultiEachMarkerInfoT width(double paramDouble);
  }
  
  public static class ARMultiMarkerInfoT
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public ARMultiMarkerInfoT()
    {
      allocate();
    }
    
    public ARMultiMarkerInfoT(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public ARMultiMarkerInfoT(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    public native ARMultiEachMarkerInfoT marker();
    
    public native ARMultiMarkerInfoT marker(ARMultiEachMarkerInfoT paramARMultiEachMarkerInfoT);
    
    public native int marker_num();
    
    public native ARMultiMarkerInfoT marker_num(int paramInt);
    
    public ARMultiMarkerInfoT position(int paramInt)
    {
      return (ARMultiMarkerInfoT)super.position(paramInt);
    }
    
    public native int prevF();
    
    public native ARMultiMarkerInfoT prevF(int paramInt);
    
    @Cast({"ARFloat(*)[4]"})
    @MemberGetter
    public native DoublePointer trans();
    
    @Cast({"ARFloat(*)[4]"})
    @MemberGetter
    public native DoublePointer transR();
  }
  
  public static class ArtLogFunction
    extends FunctionPointer
  {
    static
    {
      Loader.load();
    }
    
    protected ArtLogFunction()
    {
      allocate();
    }
    
    public ArtLogFunction(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void call(String paramString);
  }
  
  @Opaque
  public static class Camera
    extends Pointer
  {
    public Camera() {}
    
    public Camera(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class FunctionLogger
    extends Logger
  {
    static
    {
      Loader.load();
    }
    
    public FunctionLogger(Pointer paramPointer)
    {
      super();
    }
    
    public FunctionLogger(ArtLogFunction paramArtLogFunction)
    {
      allocate(paramArtLogFunction);
    }
    
    private native void allocate(ArtLogFunction paramArtLogFunction);
  }
  
  public static class Logger
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Logger() {}
    
    public Logger(Pointer paramPointer)
    {
      super();
    }
    
    public native void artLog(String paramString);
  }
  
  public static class MultiTracker
    extends Tracker
  {
    static
    {
      Loader.load();
    }
    
    public MultiTracker(int paramInt1, int paramInt2)
    {
      allocate(paramInt1, paramInt2);
    }
    
    public MultiTracker(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(int paramInt1, int paramInt2);
    
    public native int calc(@Cast({"unsigned char*"}) BytePointer paramBytePointer);
    
    public native int calc(@Cast({"unsigned char*"}) ByteBuffer paramByteBuffer);
    
    public native int calc(@Cast({"unsigned char*"}) byte[] paramArrayOfByte);
    
    public native void getARMatrix(@Cast({"ARFloat(*)[4]"}) double[] paramArrayOfDouble);
    
    @ByRef
    @Const
    public native ARToolKitPlus.ARMarkerInfo getDetectedMarker(int paramInt);
    
    public native void getDetectedMarkers(@ByPtrRef IntPointer paramIntPointer);
    
    @Const
    public native ARToolKitPlus.ARMultiMarkerInfoT getMultiMarkerConfig();
    
    public native int getNumDetectedMarkers();
    
    public native boolean init(String paramString1, String paramString2, double paramDouble1, double paramDouble2, Logger paramLogger);
    
    public native void setLoggerFunction(ArtLogFunction paramArtLogFunction);
    
    public native void setUseDetectLite(boolean paramBoolean);
  }
  
  @Opaque
  public static class Profiler
    extends Pointer
  {
    public Profiler() {}
    
    public Profiler(Pointer paramPointer)
    {
      super();
    }
  }
  
  public static class SingleTracker
    extends Tracker
  {
    static
    {
      Loader.load();
    }
    
    public SingleTracker(int paramInt1, int paramInt2)
    {
      allocate(paramInt1, paramInt2);
    }
    
    public SingleTracker(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate(int paramInt1, int paramInt2);
    
    public native void setLoggerFunction(ArtLogFunction paramArtLogFunction);
  }
  
  public static class Tracker
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public Tracker() {}
    
    public Tracker(Pointer paramPointer)
    {
      super();
    }
    
    public native void activateAutoThreshold(boolean paramBoolean);
    
    public native void activateBinaryMarker(int paramInt);
    
    public native void activateVignettingCompensation(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
    
    public native int arDetectMarker(@Cast({"ARToolKitPlus::ARUint8*"}) BytePointer paramBytePointer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
    
    public native int arDetectMarker(@Cast({"ARToolKitPlus::ARUint8*"}) ByteBuffer paramByteBuffer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
    
    public native int arDetectMarker(@Cast({"ARToolKitPlus::ARUint8*"}) byte[] paramArrayOfByte, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
    
    public native int arDetectMarkerLite(@Cast({"ARToolKitPlus::ARUint8*"}) BytePointer paramBytePointer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
    
    public native int arDetectMarkerLite(@Cast({"ARToolKitPlus::ARUint8*"}) ByteBuffer paramByteBuffer, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
    
    public native int arDetectMarkerLite(@Cast({"ARToolKitPlus::ARUint8*"}) byte[] paramArrayOfByte, int paramInt, @ByPtrPtr ARToolKitPlus.ARMarkerInfo paramARMarkerInfo, int[] paramArrayOfInt);
    
    public native int arFreePatt(int paramInt);
    
    public native double arGetTransMat(ARMarkerInfo paramARMarkerInfo, double[] paramArrayOfDouble1, double paramDouble, @Cast({"ARFloat(*)[4]"}) double[] paramArrayOfDouble2);
    
    public native double arGetTransMatCont(ARMarkerInfo paramARMarkerInfo, @Cast({"ARFloat(*)[4]"}) double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble, @Cast({"ARFloat(*)[4]"}) double[] paramArrayOfDouble3);
    
    public native int arLoadPatt(@Cast({"char*"}) String paramString);
    
    public native int arMultiFreeConfig(ARMultiMarkerInfoT paramARMultiMarkerInfoT);
    
    public native double arMultiGetTransMat(ARMarkerInfo paramARMarkerInfo, int paramInt, ARMultiMarkerInfoT paramARMultiMarkerInfoT);
    
    public native ARMultiMarkerInfoT arMultiReadConfigFile(String paramString);
    
    public native double calcOpenGLMatrixFromMarker(ARMarkerInfo paramARMarkerInfo, double[] paramArrayOfDouble1, double paramDouble, double[] paramArrayOfDouble2);
    
    public native void changeCameraSize(int paramInt1, int paramInt2);
    
    public native double executeMultiMarkerPoseEstimator(ARMarkerInfo paramARMarkerInfo, int paramInt, ARMultiMarkerInfoT paramARMultiMarkerInfoT);
    
    public native double executeSingleMarkerPoseEstimator(ARMarkerInfo paramARMarkerInfo, double[] paramArrayOfDouble1, double paramDouble, @Cast({"ARFloat(*)[4]"}) double[] paramArrayOfDouble2);
    
    public native int getBitsPerPixel();
    
    public native Camera getCamera();
    
    public native String getDescription();
    
    @Const
    public native DoublePointer getModelViewMatrix();
    
    public native int getNumLoadablePatterns();
    
    @Cast({"ARToolKitPlus::PIXEL_FORMAT"})
    public native int getPixelFormat();
    
    @ByRef
    public native ARToolKitPlus.Profiler getProfiler();
    
    @Const
    public native DoublePointer getProjectionMatrix();
    
    public native int getThreshold();
    
    public native boolean isAutoThresholdActivated();
    
    public native boolean loadCameraFile(String paramString, double paramDouble1, double paramDouble2);
    
    public native double rppGetTransMat(ARMarkerInfo paramARMarkerInfo, double[] paramArrayOfDouble1, double paramDouble, @Cast({"ARFloat(*)[4]"}) double[] paramArrayOfDouble2);
    
    public native double rppMultiGetTransMat(ARMarkerInfo paramARMarkerInfo, int paramInt, ARMultiMarkerInfoT paramARMultiMarkerInfoT);
    
    public native void setBorderWidth(double paramDouble);
    
    public native void setCamera(Camera paramCamera);
    
    public native void setCamera(Camera paramCamera, double paramDouble1, double paramDouble2);
    
    public native void setImageProcessingMode(@Cast({"ARToolKitPlus::IMAGE_PROC_MODE"}) int paramInt);
    
    public native void setLoadUndistLUT(boolean paramBoolean);
    
    public native void setLogger(Logger paramLogger);
    
    public native void setMarkerMode(@Cast({"ARToolKitPlus::MARKER_MODE"}) int paramInt);
    
    public native void setNumAutoThresholdRetries(int paramInt);
    
    public native boolean setPixelFormat(@Cast({"ARToolKitPlus::PIXEL_FORMAT"}) int paramInt);
    
    public native boolean setPoseEstimator(@Cast({"ARToolKitPlus::POSE_ESTIMATOR"}) int paramInt);
    
    public native void setThreshold(int paramInt);
    
    public native void setUndistortionMode(@Cast({"ARToolKitPlus::UNDIST_MODE"}) int paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\ARToolKitPlus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */