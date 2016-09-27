package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.CharPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Opaque;
import com.googlecode.javacpp.annotation.Platform;

@Platform(define={"VI_COM_MULTI_THREADED"}, include={"<videoInput.cpp>"}, includepath={"../videoInput0.1995/videoInputSrcAndDemos/libs/videoInput/", "../videoInput0.1995/videoInputSrcAndDemos/libs/DShow/Include/"}, link={"ole32", "oleaut32", "amstrmid", "strmiids", "uuid"}, value={"windows"})
public class videoInputLib
{
  public static final int VI_1394 = 4;
  public static final int VI_COMPOSITE = 0;
  public static final int VI_MAX_CAMERAS = 20;
  public static final int VI_NTSC_433 = 17;
  public static final int VI_NTSC_M = 0;
  public static final int VI_NTSC_M_J = 16;
  public static final int VI_NUM_FORMATS = 18;
  public static final int VI_NUM_TYPES = 18;
  public static final int VI_PAL_B = 1;
  public static final int VI_PAL_D = 2;
  public static final int VI_PAL_G = 3;
  public static final int VI_PAL_H = 4;
  public static final int VI_PAL_I = 5;
  public static final int VI_PAL_M = 6;
  public static final int VI_PAL_N = 7;
  public static final int VI_PAL_NC = 8;
  public static final int VI_SECAM_B = 9;
  public static final int VI_SECAM_D = 10;
  public static final int VI_SECAM_G = 11;
  public static final int VI_SECAM_H = 12;
  public static final int VI_SECAM_K = 13;
  public static final int VI_SECAM_K1 = 14;
  public static final int VI_SECAM_L = 15;
  public static final int VI_S_VIDEO = 1;
  public static final int VI_TUNER = 2;
  public static final int VI_USB = 3;
  public static final double VI_VERSION = 0.1995D;
  
  static
  {
    Loader.load();
  }
  
  public static native int comInitCount();
  
  public static native void comInitCount(int paramInt);
  
  public static native void verbose(boolean paramBoolean);
  
  @Cast({"bool"})
  public static native boolean verbose();
  
  @Opaque
  public static class GUID
    extends Pointer
  {}
  
  @Opaque
  public static class IAMCrossbar
    extends Pointer
  {}
  
  @Opaque
  public static class IAMStreamConfig
    extends Pointer
  {}
  
  @Opaque
  public static class IBaseFilter
    extends Pointer
  {}
  
  @Opaque
  public static class ICaptureGraphBuilder2
    extends Pointer
  {}
  
  @Opaque
  public static class IGraphBuilder
    extends Pointer
  {}
  
  @Opaque
  public static class IMediaControl
    extends Pointer
  {}
  
  @Opaque
  public static class IMediaEventEx
    extends Pointer
  {}
  
  @Opaque
  public static class ISampleGrabber
    extends Pointer
  {}
  
  @Opaque
  public static class SampleGrabberCallback
    extends Pointer
  {}
  
  @Opaque
  public static class _AMMediaType
    extends Pointer
  {}
  
  public static class videoDevice
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public videoDevice()
    {
      allocate();
    }
    
    public videoDevice(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public native void NukeDownstream(IBaseFilter paramIBaseFilter);
    
    public native videoDevice autoReconnect(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean autoReconnect();
    
    public native int connection();
    
    public native videoDevice connection(int paramInt);
    
    public native void destroyGraph();
    
    @Cast({"long"})
    public native int formatType();
    
    public native videoDevice formatType(int paramInt);
    
    public native int height();
    
    public native videoDevice height(int paramInt);
    
    public native int myID();
    
    public native videoDevice myID(int paramInt);
    
    @Cast({"char*"})
    @MemberGetter
    public native BytePointer nDeviceName();
    
    public native int nFramesForReconnect();
    
    public native videoDevice nFramesForReconnect(int paramInt);
    
    @Cast({"unsigned long"})
    public native int nFramesRunning();
    
    public native videoDevice nFramesRunning(int paramInt);
    
    public native _AMMediaType pAmMediaType();
    
    public native videoDevice pAmMediaType(_AMMediaType param_AMMediaType);
    
    @Cast({"char*"})
    public native BytePointer pBuffer();
    
    public native videoDevice pBuffer(BytePointer paramBytePointer);
    
    public native ICaptureGraphBuilder2 pCaptureGraph();
    
    public native videoDevice pCaptureGraph(ICaptureGraphBuilder2 paramICaptureGraphBuilder2);
    
    public native IMediaControl pControl();
    
    public native videoDevice pControl(IMediaControl paramIMediaControl);
    
    public native IBaseFilter pDestFilter();
    
    public native videoDevice pDestFilter(IBaseFilter paramIBaseFilter);
    
    public native ISampleGrabber pGrabber();
    
    public native videoDevice pGrabber(ISampleGrabber paramISampleGrabber);
    
    public native IBaseFilter pGrabberF();
    
    public native videoDevice pGrabberF(IBaseFilter paramIBaseFilter);
    
    public native IGraphBuilder pGraph();
    
    public native videoDevice pGraph(IGraphBuilder paramIGraphBuilder);
    
    public native IMediaEventEx pMediaEvent();
    
    public native videoDevice pMediaEvent(IMediaEventEx paramIMediaEventEx);
    
    public native IBaseFilter pVideoInputFilter();
    
    public native videoDevice pVideoInputFilter(IBaseFilter paramIBaseFilter);
    
    @Cast({"unsigned char*"})
    public native BytePointer pixels();
    
    public native videoDevice pixels(BytePointer paramBytePointer);
    
    public native videoDevice readyToCapture(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean readyToCapture();
    
    @Cast({"long"})
    public native int requestedFrameTime();
    
    public native videoDevice requestedFrameTime(int paramInt);
    
    public native void setSize(int paramInt1, int paramInt2);
    
    public native videoDevice setupStarted(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean setupStarted();
    
    public native SampleGrabberCallback sgCallback();
    
    public native videoDevice sgCallback(SampleGrabberCallback paramSampleGrabberCallback);
    
    public native videoDevice sizeSet(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean sizeSet();
    
    public native videoDevice specificFormat(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean specificFormat();
    
    public native int storeConn();
    
    public native videoDevice storeConn(int paramInt);
    
    public native IAMStreamConfig streamConf();
    
    public native videoDevice streamConf(IAMStreamConfig paramIAMStreamConfig);
    
    public native videoDevice tryDiffSize(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean tryDiffSize();
    
    public native int tryHeight();
    
    public native videoDevice tryHeight(int paramInt);
    
    public native int tryWidth();
    
    public native videoDevice tryWidth(int paramInt);
    
    public native videoDevice useCrossbar(boolean paramBoolean);
    
    @Cast({"bool"})
    public native boolean useCrossbar();
    
    public native int videoSize();
    
    public native videoDevice videoSize(int paramInt);
    
    @ByRef
    public native videoInputLib.GUID videoType();
    
    public native videoDevice videoType(GUID paramGUID);
    
    @Cast({"WCHAR*"})
    @MemberGetter
    public native CharPointer wDeviceName();
    
    public native int width();
    
    public native videoDevice width(int paramInt);
  }
  
  public static class videoInput
    extends Pointer
  {
    static
    {
      Loader.load();
    }
    
    public videoInput()
    {
      allocate();
    }
    
    public videoInput(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    public static native String getDeviceName(int paramInt);
    
    public static int listDevices()
    {
      return listDevices(false);
    }
    
    public static native int listDevices(@Cast({"bool"}) boolean paramBoolean);
    
    public static native void setVerbose(@Cast({"bool"}) boolean paramBoolean);
    
    public native int devicesFound();
    
    public native videoInput devicesFound(int paramInt);
    
    public native int getHeight(int paramInt);
    
    public BytePointer getPixels(int paramInt)
    {
      return getPixels(paramInt, true, false);
    }
    
    @Cast({"unsigned char*"})
    public native BytePointer getPixels(int paramInt, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2);
    
    public boolean getPixels(int paramInt, BytePointer paramBytePointer)
    {
      return getPixels(paramInt, paramBytePointer, true, false);
    }
    
    public native boolean getPixels(int paramInt, @Cast({"unsigned char*"}) BytePointer paramBytePointer, @Cast({"bool"}) boolean paramBoolean1, @Cast({"bool"}) boolean paramBoolean2);
    
    public native int getSize(int paramInt);
    
    public native boolean getVideoSettingCamera(int paramInt1, @Cast({"long"}) int paramInt2, @ByRef @Cast({"long*"}) int[] paramArrayOfInt1, @ByRef @Cast({"long*"}) int[] paramArrayOfInt2, @ByRef @Cast({"long*"}) int[] paramArrayOfInt3, @ByRef @Cast({"long*"}) int[] paramArrayOfInt4, @ByRef @Cast({"long*"}) int[] paramArrayOfInt5, @ByRef @Cast({"long*"}) int[] paramArrayOfInt6);
    
    public native boolean getVideoSettingFilter(int paramInt1, @Cast({"long"}) int paramInt2, @ByRef @Cast({"long*"}) int[] paramArrayOfInt1, @ByRef @Cast({"long*"}) int[] paramArrayOfInt2, @ByRef @Cast({"long*"}) int[] paramArrayOfInt3, @ByRef @Cast({"long*"}) int[] paramArrayOfInt4, @ByRef @Cast({"long*"}) int[] paramArrayOfInt5, @ByRef @Cast({"long*"}) int[] paramArrayOfInt6);
    
    public native int getWidth(int paramInt);
    
    public native boolean isDeviceSetup(int paramInt);
    
    public native boolean isFrameNew(int paramInt);
    
    @Cast({"long"})
    public native int propBacklightCompensation();
    
    public native videoInput propBacklightCompensation(int paramInt);
    
    @Cast({"long"})
    public native int propBrightness();
    
    public native videoInput propBrightness(int paramInt);
    
    @Cast({"long"})
    public native int propColorEnable();
    
    public native videoInput propColorEnable(int paramInt);
    
    @Cast({"long"})
    public native int propContrast();
    
    public native videoInput propContrast(int paramInt);
    
    @Cast({"long"})
    public native int propExposure();
    
    public native videoInput propExposure(int paramInt);
    
    @Cast({"long"})
    public native int propFocus();
    
    public native videoInput propFocus(int paramInt);
    
    @Cast({"long"})
    public native int propGain();
    
    public native videoInput propGain(int paramInt);
    
    @Cast({"long"})
    public native int propGamma();
    
    public native videoInput propGamma(int paramInt);
    
    @Cast({"long"})
    public native int propHue();
    
    public native videoInput propHue(int paramInt);
    
    @Cast({"long"})
    public native int propIris();
    
    public native videoInput propIris(int paramInt);
    
    @Cast({"long"})
    public native int propPan();
    
    public native videoInput propPan(int paramInt);
    
    @Cast({"long"})
    public native int propRoll();
    
    public native videoInput propRoll(int paramInt);
    
    @Cast({"long"})
    public native int propSaturation();
    
    public native videoInput propSaturation(int paramInt);
    
    @Cast({"long"})
    public native int propSharpness();
    
    public native videoInput propSharpness(int paramInt);
    
    @Cast({"long"})
    public native int propTilt();
    
    public native videoInput propTilt(int paramInt);
    
    @Cast({"long"})
    public native int propWhiteBalance();
    
    public native videoInput propWhiteBalance(int paramInt);
    
    @Cast({"long"})
    public native int propZoom();
    
    public native videoInput propZoom(int paramInt);
    
    public native boolean restartDevice(int paramInt);
    
    public native void setAutoReconnectOnFreeze(int paramInt1, @Cast({"bool"}) boolean paramBoolean, int paramInt2);
    
    public native boolean setFormat(int paramInt1, int paramInt2);
    
    public native void setIdealFramerate(int paramInt1, int paramInt2);
    
    public native void setUseCallback(@Cast({"bool"}) boolean paramBoolean);
    
    public native boolean setVideoSettingCamera(int paramInt1, @Cast({"long"}) int paramInt2, @Cast({"long"}) int paramInt3, @Cast({"long"}) int paramInt4, @Cast({"bool"}) boolean paramBoolean);
    
    public native boolean setVideoSettingCameraPct(int paramInt1, @Cast({"long"}) int paramInt2, float paramFloat, @Cast({"long"}) int paramInt3);
    
    public native boolean setVideoSettingFilter(int paramInt1, @Cast({"long"}) int paramInt2, @Cast({"long"}) int paramInt3, @Cast({"long"}) int paramInt4, @Cast({"bool"}) boolean paramBoolean);
    
    public native boolean setVideoSettingFilterPct(int paramInt1, @Cast({"long"}) int paramInt2, float paramFloat, @Cast({"long"}) int paramInt3);
    
    public native boolean setupDevice(int paramInt);
    
    public native boolean setupDevice(int paramInt1, int paramInt2);
    
    public native boolean setupDevice(int paramInt1, int paramInt2, int paramInt3);
    
    public native boolean setupDevice(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public native void showSettingsWindow(int paramInt);
    
    public native void stopDevice(int paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\videoInputLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */