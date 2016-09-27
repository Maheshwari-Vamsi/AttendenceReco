package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacv.cpp.freenect;
import com.googlecode.javacv.cpp.freenect.freenect_context;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class OpenKinectFrameGrabber
  extends FrameGrabber
{
  private static FrameGrabber.Exception loadingException;
  private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
  private boolean depth = false;
  private int depthFormat = -1;
  private int deviceNumber = 0;
  private opencv_core.IplImage rawDepthImage = null;
  private BytePointer rawDepthImageData = new BytePointer((Pointer)null);
  private opencv_core.IplImage rawVideoImage = null;
  private BytePointer rawVideoImageData = new BytePointer((Pointer)null);
  private opencv_core.IplImage returnImage = null;
  private int[] timestamp = { 0 };
  private int videoFormat = -1;
  
  static
  {
    if (!OpenKinectFrameGrabber.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      loadingException = null;
      return;
    }
  }
  
  public OpenKinectFrameGrabber(int paramInt)
  {
    this.deviceNumber = paramInt;
  }
  
  public static OpenKinectFrameGrabber createDefault(int paramInt)
    throws FrameGrabber.Exception
  {
    return new OpenKinectFrameGrabber(paramInt);
  }
  
  public static OpenKinectFrameGrabber createDefault(File paramFile)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static OpenKinectFrameGrabber createDefault(String paramString)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static String[] getDeviceDescriptions()
    throws FrameGrabber.Exception
  {
    tryLoad();
    freenect.freenect_context localfreenect_context = new freenect.freenect_context(null);
    int i = freenect.freenect_init(localfreenect_context, null);
    if (i < 0) {
      throw new FrameGrabber.Exception("freenect_init() Error " + i + ": Failed to init context.");
    }
    int j = freenect.freenect_num_devices(localfreenect_context);
    if (j < 0) {
      throw new FrameGrabber.Exception("freenect_num_devices() Error " + i + ": Failed to get number of devices.");
    }
    String[] arrayOfString = new String[j];
    for (int k = 0; k < arrayOfString.length; k++) {
      arrayOfString[k] = ("Kinect #" + k);
    }
    int m = freenect.freenect_shutdown(localfreenect_context);
    if (m < 0) {
      throw new FrameGrabber.Exception("freenect_shutdown() Error " + m + ": Failed to shutdown context.");
    }
    return arrayOfString;
  }
  
  public static void tryLoad()
    throws FrameGrabber.Exception
  {
    if (loadingException != null) {
      throw loadingException;
    }
    try
    {
      Loader.load(freenect.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      FrameGrabber.Exception localException = new FrameGrabber.Exception("Failed to load " + OpenKinectFrameGrabber.class, localThrowable);
      loadingException = localException;
      throw localException;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public ByteOrder getByteOrder()
  {
    return this.byteOrder;
  }
  
  public int getDepthFormat()
  {
    return this.depthFormat;
  }
  
  public double getGamma()
  {
    if (this.gamma == 0.0D) {
      return 2.2D;
    }
    return this.gamma;
  }
  
  public int getVideoFormat()
  {
    return this.videoFormat;
  }
  
  public opencv_core.IplImage grab()
    throws FrameGrabber.Exception
  {
    opencv_core.IplImage localIplImage;
    int i;
    int j;
    int k;
    int m;
    if (this.depth)
    {
      localIplImage = grabDepth();
      i = localIplImage.width();
      j = localIplImage.height();
      k = localIplImage.depth();
      m = localIplImage.nChannels();
      if ((this.imageMode != FrameGrabber.ImageMode.COLOR) || (m != 1)) {
        break label94;
      }
      if (this.returnImage == null) {
        this.returnImage = opencv_core.IplImage.create(i, j, k, 3);
      }
      opencv_imgproc.cvCvtColor(localIplImage, this.returnImage, 8);
      localIplImage = this.returnImage;
    }
    label94:
    while ((this.imageMode != FrameGrabber.ImageMode.GRAY) || (m != 3))
    {
      return localIplImage;
      localIplImage = grabVideo();
      break;
    }
    if (this.returnImage == null) {
      this.returnImage = opencv_core.IplImage.create(i, j, k, 1);
    }
    opencv_imgproc.cvCvtColor(localIplImage, this.returnImage, 6);
    return this.returnImage;
  }
  
  public opencv_core.IplImage grabDepth()
    throws FrameGrabber.Exception
  {
    if (this.depthFormat < 0) {}
    for (int i = this.bpp;; i = this.depthFormat)
    {
      j = 16;
      k = 1;
      switch (i)
      {
      case 2: 
      case 3: 
      default: 
        if ($assertionsDisabled) {
          break label83;
        }
        throw new AssertionError();
      }
    }
    int j = 16;
    int k = 1;
    label83:
    int m = freenect.freenect_sync_get_depth(this.rawDepthImageData, this.timestamp, this.deviceNumber, i);
    if (m != 0) {
      throw new FrameGrabber.Exception("freenect_sync_get_depth() Error " + m + ": Failed to get depth synchronously.");
    }
    if ((this.rawDepthImage == null) || (this.rawDepthImage.width() != 640) || (this.rawDepthImage.height() != 480)) {
      this.rawDepthImage = opencv_core.IplImage.createHeader(640, 480, j, k);
    }
    opencv_core.cvSetData(this.rawDepthImage, this.rawDepthImageData, 1280);
    if ((j > 8) && (!ByteOrder.nativeOrder().equals(this.byteOrder)))
    {
      ByteBuffer localByteBuffer = this.rawDepthImage.getByteBuffer();
      ShortBuffer localShortBuffer = localByteBuffer.order(ByteOrder.BIG_ENDIAN).asShortBuffer();
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(localShortBuffer);
    }
    this.timestamp = this.timestamp[0];
    return this.rawDepthImage;
  }
  
  public opencv_core.IplImage grabVideo()
    throws FrameGrabber.Exception
  {
    if (this.videoFormat < 0) {}
    for (int i = this.bpp;; i = this.videoFormat)
    {
      j = 8;
      k = 3;
      switch (i)
      {
      case 4: 
      default: 
        if ($assertionsDisabled) {
          break label87;
        }
        throw new AssertionError();
      }
    }
    int j = 8;
    int k = 3;
    for (;;)
    {
      label87:
      int m = freenect.freenect_sync_get_video(this.rawVideoImageData, this.timestamp, this.deviceNumber, i);
      if (m == 0) {
        break;
      }
      throw new FrameGrabber.Exception("freenect_sync_get_video() Error " + m + ": Failed to get video synchronously.");
      j = 8;
      k = 1;
      continue;
      j = 16;
      k = 1;
      continue;
      j = 8;
      k = 3;
      continue;
      j = 8;
      k = 2;
    }
    if ((this.rawVideoImage == null) || (this.rawVideoImage.width() != 640) || (this.rawVideoImage.height() != 480)) {
      this.rawVideoImage = opencv_core.IplImage.createHeader(640, 480, j, k);
    }
    opencv_core.cvSetData(this.rawVideoImage, this.rawVideoImageData, j * (640 * k) / 8);
    if ((j > 8) && (!ByteOrder.nativeOrder().equals(this.byteOrder)))
    {
      ByteBuffer localByteBuffer = this.rawVideoImage.getByteBuffer();
      ShortBuffer localShortBuffer = localByteBuffer.order(ByteOrder.BIG_ENDIAN).asShortBuffer();
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(localShortBuffer);
    }
    if (k == 3) {
      opencv_imgproc.cvCvtColor(this.rawVideoImage, this.rawVideoImage, 4);
    }
    this.timestamp = this.timestamp[0];
    return this.rawVideoImage;
  }
  
  public void release()
    throws FrameGrabber.Exception
  {
    stop();
  }
  
  public void setByteOrder(ByteOrder paramByteOrder)
  {
    this.byteOrder = paramByteOrder;
  }
  
  public void setDepthFormat(int paramInt)
  {
    this.depthFormat = paramInt;
  }
  
  public void setImageMode(FrameGrabber.ImageMode paramImageMode)
  {
    if (paramImageMode != this.imageMode) {
      this.returnImage = null;
    }
    super.setImageMode(paramImageMode);
  }
  
  public void setVideoFormat(int paramInt)
  {
    this.videoFormat = paramInt;
  }
  
  public void start()
    throws FrameGrabber.Exception
  {
    this.depth = "depth".equalsIgnoreCase(this.format);
  }
  
  public void stop()
    throws FrameGrabber.Exception
  {}
  
  public void trigger()
    throws FrameGrabber.Exception
  {
    for (int i = 0; i < 1 + this.numBuffers; i++)
    {
      if (this.depth)
      {
        if (this.depthFormat < 0) {}
        for (int m = this.bpp;; m = this.depthFormat)
        {
          int n = freenect.freenect_sync_get_depth(this.rawDepthImageData, this.timestamp, this.deviceNumber, m);
          if (n == 0) {
            break;
          }
          throw new FrameGrabber.Exception("freenect_sync_get_depth() Error " + n + ": Failed to get depth synchronously.");
        }
      }
      if (this.videoFormat < 0) {}
      for (int j = this.bpp;; j = this.videoFormat)
      {
        int k = freenect.freenect_sync_get_video(this.rawVideoImageData, this.timestamp, this.deviceNumber, j);
        if (k == 0) {
          break;
        }
        throw new FrameGrabber.Exception("freenect_sync_get_video() Error " + k + ": Failed to get video synchronously.");
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\OpenKinectFrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */