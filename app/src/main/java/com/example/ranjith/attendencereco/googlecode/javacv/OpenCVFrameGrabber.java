package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;

public class OpenCVFrameGrabber
  extends FrameGrabber
{
  private static FrameGrabber.Exception loadingException = null;
  private opencv_highgui.CvCapture capture = null;
  private int deviceNumber = 0;
  private String filename = null;
  private opencv_core.IplImage return_image = null;
  
  public OpenCVFrameGrabber(int paramInt)
  {
    this.deviceNumber = paramInt;
  }
  
  public OpenCVFrameGrabber(File paramFile)
  {
    this(paramFile.getAbsolutePath());
  }
  
  public OpenCVFrameGrabber(String paramString)
  {
    this.filename = paramString;
  }
  
  public static OpenCVFrameGrabber createDefault(int paramInt)
    throws FrameGrabber.Exception
  {
    return new OpenCVFrameGrabber(paramInt);
  }
  
  public static OpenCVFrameGrabber createDefault(File paramFile)
    throws FrameGrabber.Exception
  {
    return new OpenCVFrameGrabber(paramFile);
  }
  
  public static OpenCVFrameGrabber createDefault(String paramString)
    throws FrameGrabber.Exception
  {
    return new OpenCVFrameGrabber(paramString);
  }
  
  public static String[] getDeviceDescriptions()
    throws FrameGrabber.Exception
  {
    tryLoad();
    throw new UnsupportedOperationException("Device enumeration not support by OpenCV.");
  }
  
  public static void tryLoad()
    throws FrameGrabber.Exception
  {
    if (loadingException != null) {
      throw loadingException;
    }
    try
    {
      Loader.load(opencv_highgui.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      FrameGrabber.Exception localException = new FrameGrabber.Exception("Failed to load " + OpenCVFrameGrabber.class, localThrowable);
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
  
  public String getFormat()
  {
    if (this.capture == null) {
      return super.getFormat();
    }
    int i = (int)opencv_highgui.cvGetCaptureProperty(this.capture, 6);
    return "" + (char)(i & 0xFF) + (char)(0xFF & i >> 8) + (char)(0xFF & i >> 16) + (char)(0xFF & i >> 24);
  }
  
  public int getFrameNumber()
  {
    if (this.capture == null) {
      return super.getFrameNumber();
    }
    return (int)opencv_highgui.cvGetCaptureProperty(this.capture, 1);
  }
  
  public double getFrameRate()
  {
    if (this.capture == null) {
      return super.getFrameRate();
    }
    return (int)opencv_highgui.cvGetCaptureProperty(this.capture, 5);
  }
  
  public double getGamma()
  {
    if (this.gamma == 0.0D) {
      return 2.2D;
    }
    return this.gamma;
  }
  
  public int getImageHeight()
  {
    if (this.return_image != null) {
      return this.return_image.height();
    }
    if (this.capture == null) {
      return super.getImageHeight();
    }
    return (int)opencv_highgui.cvGetCaptureProperty(this.capture, 4);
  }
  
  public int getImageWidth()
  {
    if (this.return_image != null) {
      return this.return_image.width();
    }
    if (this.capture == null) {
      return super.getImageWidth();
    }
    return (int)opencv_highgui.cvGetCaptureProperty(this.capture, 3);
  }
  
  public int getLengthInFrames()
  {
    if (this.capture == null) {
      return super.getLengthInFrames();
    }
    return (int)opencv_highgui.cvGetCaptureProperty(this.capture, 7);
  }
  
  public long getLengthInTime()
  {
    return Math.round(1000000L * getLengthInFrames() / getFrameRate());
  }
  
  public int getPixelFormat()
  {
    if (this.capture == null) {
      return super.getPixelFormat();
    }
    return (int)opencv_highgui.cvGetCaptureProperty(this.capture, 16);
  }
  
  public long getTimestamp()
  {
    if (this.capture == null) {
      return super.getTimestamp();
    }
    return Math.round(1000.0D * opencv_highgui.cvGetCaptureProperty(this.capture, 0));
  }
  
  public opencv_core.IplImage grab()
    throws FrameGrabber.Exception
  {
    opencv_core.IplImage localIplImage = opencv_highgui.cvRetrieveFrame(this.capture);
    if (localIplImage == null) {
      throw new FrameGrabber.Exception("cvRetrieveFrame() Error: Could not retrieve frame. (Has start() been called?)");
    }
    if ((!this.triggerMode) && (opencv_highgui.cvGrabFrame(this.capture) == 0)) {
      throw new FrameGrabber.Exception("cvGrabFrame() Error: Could not grab frame. (Has start() been called?)");
    }
    if ((this.imageMode == FrameGrabber.ImageMode.GRAY) && (localIplImage.nChannels() > 1))
    {
      if (this.return_image == null) {
        this.return_image = opencv_core.IplImage.create(localIplImage.width(), localIplImage.height(), localIplImage.depth(), 1);
      }
      opencv_imgproc.cvCvtColor(localIplImage, this.return_image, 6);
    }
    for (;;)
    {
      return this.return_image;
      if ((this.imageMode == FrameGrabber.ImageMode.COLOR) && (localIplImage.nChannels() == 1))
      {
        if (this.return_image == null) {
          this.return_image = opencv_core.IplImage.create(localIplImage.width(), localIplImage.height(), localIplImage.depth(), 3);
        }
        opencv_imgproc.cvCvtColor(localIplImage, this.return_image, 8);
      }
      else
      {
        this.return_image = localIplImage;
      }
    }
  }
  
  public void release()
    throws FrameGrabber.Exception
  {
    stop();
  }
  
  public void setFrameNumber(int paramInt)
    throws FrameGrabber.Exception
  {
    if (this.capture == null) {
      super.setFrameNumber(paramInt);
    }
    while (opencv_highgui.cvSetCaptureProperty(this.capture, 1, paramInt) != 0) {
      return;
    }
    throw new FrameGrabber.Exception("cvSetCaptureProperty() Error: Could not set CV_CAP_PROP_POS_FRAMES to " + paramInt + ".");
  }
  
  public void setImageMode(FrameGrabber.ImageMode paramImageMode)
  {
    if (paramImageMode != this.imageMode) {
      this.return_image = null;
    }
    super.setImageMode(paramImageMode);
  }
  
  public void setTimestamp(long paramLong)
    throws FrameGrabber.Exception
  {
    if (this.capture == null) {
      super.setTimestamp(paramLong);
    }
    while (opencv_highgui.cvSetCaptureProperty(this.capture, 0, paramLong / 1000.0D) != 0) {
      return;
    }
    throw new FrameGrabber.Exception("cvSetCaptureProperty() Error: Could not set CV_CAP_PROP_POS_MSEC to " + paramLong / 1000.0D + ".");
  }
  
  public void start()
    throws FrameGrabber.Exception
  {
    double d = 0.0D;
    if ((this.filename != null) && (this.filename.length() > 0))
    {
      this.capture = opencv_highgui.cvCreateFileCapture(this.filename);
      if (this.capture == null) {
        throw new FrameGrabber.Exception("cvCreateFileCapture() Error: Could not create camera capture.");
      }
    }
    else
    {
      this.capture = opencv_highgui.cvCreateCameraCapture(this.deviceNumber);
      if (this.capture == null) {
        throw new FrameGrabber.Exception("cvCreateCameraCapture() Error: Could not create camera capture.");
      }
    }
    if ((this.imageWidth > 0) && (opencv_highgui.cvSetCaptureProperty(this.capture, 3, this.imageWidth) == 0)) {
      opencv_highgui.cvSetCaptureProperty(this.capture, 9, this.imageWidth);
    }
    if ((this.imageHeight > 0) && (opencv_highgui.cvSetCaptureProperty(this.capture, 4, this.imageHeight) == 0)) {
      opencv_highgui.cvSetCaptureProperty(this.capture, 9, this.imageHeight);
    }
    if (this.frameRate > d) {
      opencv_highgui.cvSetCaptureProperty(this.capture, 5, this.frameRate);
    }
    if (this.bpp > 0) {
      opencv_highgui.cvSetCaptureProperty(this.capture, 8, this.bpp);
    }
    opencv_highgui.CvCapture localCvCapture = this.capture;
    if (this.imageMode == FrameGrabber.ImageMode.COLOR) {
      d = 1.0D;
    }
    opencv_highgui.cvSetCaptureProperty(localCvCapture, 16, d);
    int i = 0;
    for (;;)
    {
      int j = i + 1;
      if ((i >= 100) || (opencv_highgui.cvGrabFrame(this.capture) == 0) || (opencv_highgui.cvRetrieveFrame(this.capture) != null)) {
        break;
      }
      try
      {
        Thread.sleep(100L);
        i = j;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = j;
      }
    }
    if ((!this.triggerMode) && (opencv_highgui.cvGrabFrame(this.capture) == 0)) {
      throw new FrameGrabber.Exception("cvGrabFrame() Error: Could not grab frame. (Has start() been called?)");
    }
  }
  
  public void stop()
    throws FrameGrabber.Exception
  {
    if (this.capture != null)
    {
      opencv_highgui.cvReleaseCapture(this.capture);
      this.capture = null;
    }
  }
  
  public void trigger()
    throws FrameGrabber.Exception
  {
    for (int i = 0; i < 1 + this.numBuffers; i++) {
      opencv_highgui.cvQueryFrame(this.capture);
    }
    if (opencv_highgui.cvGrabFrame(this.capture) == 0) {
      throw new FrameGrabber.Exception("cvGrabFrame() Error: Could not grab frame. (Has start() been called?)");
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\OpenCVFrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */