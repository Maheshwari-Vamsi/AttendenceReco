package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import com.googlecode.javacv.cpp.videoInputLib;
import com.googlecode.javacv.cpp.videoInputLib.videoInput;
import java.io.File;

public class VideoInputFrameGrabber
  extends FrameGrabber
{
  private static FrameGrabber.Exception loadingException = null;
  private opencv_core.IplImage bgrImage = null;
  private BytePointer bgrImageData = null;
  private int deviceNumber = 0;
  private opencv_core.IplImage grayImage = null;
  private videoInputLib.videoInput myVideoInput = null;
  
  public VideoInputFrameGrabber(int paramInt)
  {
    this.deviceNumber = paramInt;
  }
  
  public static VideoInputFrameGrabber createDefault(int paramInt)
    throws FrameGrabber.Exception
  {
    return new VideoInputFrameGrabber(paramInt);
  }
  
  public static VideoInputFrameGrabber createDefault(File paramFile)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static VideoInputFrameGrabber createDefault(String paramString)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static String[] getDeviceDescriptions()
    throws FrameGrabber.Exception
  {
    tryLoad();
    String[] arrayOfString = new String[videoInputLib.videoInput.listDevices()];
    for (int i = 0; i < arrayOfString.length; i++) {
      arrayOfString[i] = videoInputLib.videoInput.getDeviceName(i);
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
      Loader.load(videoInputLib.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      FrameGrabber.Exception localException = new FrameGrabber.Exception("Failed to load " + VideoInputFrameGrabber.class, localThrowable);
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
  
  public double getGamma()
  {
    if (this.gamma == 0.0D) {
      return 2.2D;
    }
    return this.gamma;
  }
  
  public int getImageHeight()
  {
    if (this.myVideoInput == null) {
      return super.getImageHeight();
    }
    return this.myVideoInput.getHeight(this.deviceNumber);
  }
  
  public int getImageWidth()
  {
    if (this.myVideoInput == null) {
      return super.getImageWidth();
    }
    return this.myVideoInput.getWidth(this.deviceNumber);
  }
  
  public opencv_core.IplImage grab()
    throws FrameGrabber.Exception
  {
    if (this.myVideoInput == null) {
      throw new FrameGrabber.Exception("videoInput is null. (Has start() been called?)");
    }
    int i = this.myVideoInput.getWidth(this.deviceNumber);
    int j = this.myVideoInput.getHeight(this.deviceNumber);
    if ((this.bgrImage == null) || (this.bgrImage.width() != i) || (this.bgrImage.height() != j))
    {
      this.bgrImage = opencv_core.IplImage.create(i, j, 8, 3);
      this.bgrImageData = this.bgrImage.imageData();
    }
    if (!this.myVideoInput.getPixels(this.deviceNumber, this.bgrImageData, false, true)) {
      throw new FrameGrabber.Exception("videoInput.getPixels() Error: Could not get pixels.");
    }
    this.timestamp = (System.nanoTime() / 1000L);
    if (this.imageMode == FrameGrabber.ImageMode.GRAY)
    {
      if (this.grayImage == null) {
        this.grayImage = opencv_core.IplImage.create(i, j, 8, 1);
      }
      opencv_imgproc.cvCvtColor(this.bgrImage, this.grayImage, 6);
      return this.grayImage;
    }
    return this.bgrImage;
  }
  
  public void release()
    throws FrameGrabber.Exception
  {
    stop();
  }
  
  public void start()
    throws FrameGrabber.Exception
  {
    start(-1);
  }
  
  public void start(int paramInt)
    throws FrameGrabber.Exception
  {
    this.myVideoInput = new videoInputLib.videoInput();
    if (this.frameRate > 0.0D) {
      this.myVideoInput.setIdealFramerate(this.deviceNumber, (int)this.frameRate);
    }
    if ((this.imageWidth <= 0) || (this.imageHeight <= 0))
    {
      if (this.myVideoInput.setupDevice(this.deviceNumber, paramInt)) {}
    }
    else {
      while (!this.myVideoInput.setupDevice(this.deviceNumber, this.imageWidth, this.imageHeight, paramInt))
      {
        this.myVideoInput = null;
        throw new FrameGrabber.Exception("videoInput.setupDevice() Error: Could not setup device.");
      }
    }
    if ((this.format != null) && (this.format.length() > 0))
    {
      int i;
      if (this.format.equals("VI_NTSC_M")) {
        i = 0;
      }
      while ((i >= 0) && (!this.myVideoInput.setFormat(this.deviceNumber, i)))
      {
        throw new FrameGrabber.Exception("videoInput.setFormat() Error: Could not set format " + this.format + ".");
        if (this.format.equals("VI_PAL_B")) {
          i = 1;
        } else if (this.format.equals("VI_PAL_D")) {
          i = 2;
        } else if (this.format.equals("VI_PAL_G")) {
          i = 3;
        } else if (this.format.equals("VI_PAL_H")) {
          i = 4;
        } else if (this.format.equals("VI_PAL_I")) {
          i = 5;
        } else if (this.format.equals("VI_PAL_M")) {
          i = 6;
        } else if (this.format.equals("VI_PAL_N")) {
          i = 7;
        } else if (this.format.equals("VI_PAL_NC")) {
          i = 8;
        } else if (this.format.equals("VI_SECAM_B")) {
          i = 9;
        } else if (this.format.equals("VI_SECAM_D")) {
          i = 10;
        } else if (this.format.equals("VI_SECAM_G")) {
          i = 11;
        } else if (this.format.equals("VI_SECAM_H")) {
          i = 12;
        } else if (this.format.equals("VI_SECAM_K")) {
          i = 13;
        } else if (this.format.equals("VI_SECAM_K1")) {
          i = 14;
        } else if (this.format.equals("VI_SECAM_L")) {
          i = 15;
        } else if (this.format.equals("VI_NTSC_M_J")) {
          i = 16;
        } else if (this.format.equals("VI_NTSC_433")) {
          i = 17;
        } else {
          i = -1;
        }
      }
    }
  }
  
  public void stop()
    throws FrameGrabber.Exception
  {
    if (this.myVideoInput != null)
    {
      this.myVideoInput.stopDevice(this.deviceNumber);
      this.myVideoInput = null;
    }
  }
  
  public void trigger()
    throws FrameGrabber.Exception
  {
    if (this.myVideoInput == null) {
      throw new FrameGrabber.Exception("videoInput is null. (Has start() been called?)");
    }
    int i = this.myVideoInput.getWidth(this.deviceNumber);
    int j = this.myVideoInput.getHeight(this.deviceNumber);
    if ((this.bgrImage == null) || (this.bgrImage.width() != i) || (this.bgrImage.height() != j))
    {
      this.bgrImage = opencv_core.IplImage.create(i, j, 8, 3);
      this.bgrImageData = this.bgrImage.imageData();
    }
    for (int k = 0; k < 1 + this.numBuffers; k++) {
      this.myVideoInput.getPixels(this.deviceNumber, this.bgrImageData, false, true);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\VideoInputFrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */