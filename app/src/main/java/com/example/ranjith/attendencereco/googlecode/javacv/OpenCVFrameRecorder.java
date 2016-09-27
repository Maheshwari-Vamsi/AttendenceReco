package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.cpp.opencv_highgui.CvVideoWriter;
import java.io.File;

public class OpenCVFrameRecorder
  extends FrameRecorder
{
  private static FrameRecorder.Exception loadingException = null;
  private static final boolean windows = Loader.getPlatformName().startsWith("windows");
  private String filename;
  private opencv_highgui.CvVideoWriter writer = null;
  
  public OpenCVFrameRecorder(File paramFile, int paramInt1, int paramInt2)
  {
    this(paramFile.getAbsolutePath(), paramInt1, paramInt2);
  }
  
  public OpenCVFrameRecorder(String paramString, int paramInt1, int paramInt2)
  {
    this.filename = paramString;
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    this.pixelFormat = 1;
    if (windows) {}
    for (int i = -1;; i = opencv_highgui.CV_FOURCC_DEFAULT)
    {
      this.videoCodec = i;
      this.frameRate = 30.0D;
      return;
    }
  }
  
  public static OpenCVFrameRecorder createDefault(File paramFile, int paramInt1, int paramInt2)
    throws FrameRecorder.Exception
  {
    return new OpenCVFrameRecorder(paramFile, paramInt1, paramInt2);
  }
  
  public static OpenCVFrameRecorder createDefault(String paramString, int paramInt1, int paramInt2)
    throws FrameRecorder.Exception
  {
    return new OpenCVFrameRecorder(paramString, paramInt1, paramInt2);
  }
  
  public static void tryLoad()
    throws FrameRecorder.Exception
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
      FrameRecorder.Exception localException = new FrameRecorder.Exception("Failed to load " + OpenCVFrameRecorder.class, localThrowable);
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
  
  public void record(opencv_core.IplImage paramIplImage)
    throws FrameRecorder.Exception
  {
    if (this.writer != null)
    {
      if (opencv_highgui.cvWriteFrame(this.writer, paramIplImage) == 0) {
        throw new FrameRecorder.Exception("cvWriteFrame(): Could not record frame");
      }
    }
    else {
      throw new FrameRecorder.Exception("Cannot record: There is no writer (Has start() been called?)");
    }
  }
  
  public void release()
    throws FrameRecorder.Exception
  {
    if (this.writer != null)
    {
      opencv_highgui.cvReleaseVideoWriter(this.writer);
      this.writer = null;
    }
  }
  
  public void start()
    throws FrameRecorder.Exception
  {
    this.writer = opencv_highgui.cvCreateVideoWriter(this.filename, this.videoCodec, this.frameRate, opencv_core.cvSize(this.imageWidth, this.imageHeight), this.pixelFormat);
    if (this.writer == null) {
      throw new FrameRecorder.Exception("cvCreateVideoWriter(): Could not create a writer");
    }
  }
  
  public void stop()
    throws FrameRecorder.Exception
  {
    release();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\OpenCVFrameRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */