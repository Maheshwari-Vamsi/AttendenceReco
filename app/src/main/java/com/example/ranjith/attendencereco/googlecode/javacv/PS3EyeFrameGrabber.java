package com.example.ranjith.attendencereco.googlecode.javacv;

import cl.eye.CLCamera;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.IntBuffer;
import sun.misc.Unsafe;

public class PS3EyeFrameGrabber
  extends FrameGrabber
{
  private static FrameGrabber.Exception loadingException = null;
  CLCamera camera = null;
  int cameraIndex = 0;
  opencv_core.IplImage image_1ch = null;
  opencv_core.IplImage image_4ch = null;
  byte[] ipl_frame = null;
  int[] ps3_frame = null;
  String stat;
  protected Triggered triggered = Triggered.NO_TRIGGER;
  String uuid;
  
  public PS3EyeFrameGrabber()
    throws FrameGrabber.Exception
  {
    this(0);
  }
  
  public PS3EyeFrameGrabber(int paramInt)
    throws FrameGrabber.Exception
  {
    this(paramInt, 640, 480, 60);
  }
  
  public PS3EyeFrameGrabber(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws FrameGrabber.Exception
  {
    this(paramInt1, 640, 480, 60, null);
  }
  
  public PS3EyeFrameGrabber(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
    throws FrameGrabber.Exception
  {
    if (!CLCamera.IsLibraryLoaded()) {
      throw new FrameGrabber.Exception("CLEye multicam dll not loaded");
    }
    try
    {
      this.camera = ((CLCamera)CLCamera.class.newInstance());
      this.cameraIndex = paramInt1;
      this.stat = "created";
      this.uuid = CLCamera.cameraUUID(paramInt1);
      if (((paramInt2 == 640) && (paramInt3 == 480)) || ((paramInt2 == 320) && (paramInt3 == 240)))
      {
        setImageWidth(paramInt2);
        setImageHeight(paramInt3);
        setImageMode(FrameGrabber.ImageMode.COLOR);
        setFrameRate(paramInt4);
        setTimeout(1 + 1000 / paramInt4);
        setBitsPerPixel(8);
        setTriggerMode(false);
        setNumBuffers(4);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        if (paramObject == null) {
          try
          {
            Field localField = Unsafe.class.getDeclaredField("theUnsafe");
            localField.setAccessible(true);
            this.camera = ((CLCamera)((Unsafe)localField.get(null)).allocateInstance(CLCamera.class));
          }
          catch (Throwable localThrowable2)
          {
            throw new FrameGrabber.Exception("Failed to construct " + PS3EyeFrameGrabber.class, localThrowable2);
          }
        } else {
          this.camera = ((CLCamera)CLCamera.class.getConstructors()[0].newInstance(new Object[] { paramObject }));
        }
      }
      throw new FrameGrabber.Exception("Only 640x480 or 320x240 images supported");
    }
  }
  
  public static PS3EyeFrameGrabber createDefault(int paramInt)
    throws FrameGrabber.Exception
  {
    return new PS3EyeFrameGrabber(paramInt);
  }
  
  public static PS3EyeFrameGrabber createDefault(File paramFile)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static PS3EyeFrameGrabber createDefault(String paramString)
    throws FrameGrabber.Exception
  {
    return null;
  }
  
  public static int getCameraCount()
  {
    return CLCamera.cameraCount();
  }
  
  public static String[] getDeviceDescriptions()
    throws FrameGrabber.Exception
  {
    tryLoad();
    String[] arrayOfString = new String[CLCamera.cameraCount()];
    for (int i = 0; i < arrayOfString.length; i++) {
      arrayOfString[i] = CLCamera.cameraUUID(i);
    }
    return arrayOfString;
  }
  
  public static String[] listPS3Cameras()
  {
    int i = getCameraCount();
    if (i > 0)
    {
      arrayOfString = new String[i];
      for (int j = i - 1; j >= 0; j--) {
        arrayOfString[j] = CLCamera.cameraUUID(j);
      }
    }
    String[] arrayOfString = null;
    return arrayOfString;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    String[] arrayOfString = listPS3Cameras();
    for (int i = 0; i < arrayOfString.length; i++) {
      System.out.println(i + ": " + arrayOfString[i]);
    }
  }
  
  public static void tryLoad()
    throws FrameGrabber.Exception
  {
    if (loadingException != null) {
      throw loadingException;
    }
    try
    {
      CLCamera.IsLibraryLoaded();
      return;
    }
    catch (Throwable localThrowable)
    {
      FrameGrabber.Exception localException = new FrameGrabber.Exception("Failed to load " + PS3EyeFrameGrabber.class, localThrowable);
      loadingException = localException;
      throw localException;
    }
  }
  
  public void dispose()
  {
    release();
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public CLCamera getCamera()
  {
    return this.camera;
  }
  
  public String getUUID()
  {
    return this.uuid;
  }
  
  public opencv_core.IplImage grab()
    throws FrameGrabber.Exception
  {
    switch (this.triggered)
    {
    default: 
      throw new FrameGrabber.Exception("Int. error - unknown triggering state");
    case ???: 
    case ???: 
      for (opencv_core.IplImage localIplImage = grab_RGB4();; localIplImage = makeImage(this.ps3_frame))
      {
        if ((localIplImage != null) && (this.imageMode == FrameGrabber.ImageMode.GRAY))
        {
          opencv_imgproc.cvCvtColor(localIplImage, this.image_1ch, 7);
          localIplImage = this.image_1ch;
        }
        return localIplImage;
        this.triggered = Triggered.NO_TRIGGER;
      }
    }
    this.triggered = Triggered.NO_TRIGGER;
    return null;
  }
  
  public opencv_core.IplImage grab_RGB4()
  {
    if (this.camera.getCameraFrame(this.ps3_frame, this.timeout))
    {
      this.timestamp = (System.nanoTime() / 1000L);
      this.image_4ch.getIntBuffer().put(this.ps3_frame);
      return this.image_4ch;
    }
    return null;
  }
  
  public int[] grab_raw()
  {
    if (this.camera.getCameraFrame(this.ps3_frame, this.timeout)) {
      return this.ps3_frame;
    }
    return null;
  }
  
  public opencv_core.IplImage makeImage(int[] paramArrayOfInt)
  {
    this.image_4ch.getIntBuffer().put(this.ps3_frame);
    return this.image_4ch;
  }
  
  public void release()
  {
    if (this.camera != null)
    {
      this.camera.dispose();
      this.camera = null;
    }
    if (this.image_4ch != null)
    {
      this.image_4ch.release();
      this.image_4ch = null;
    }
    if (this.image_1ch != null)
    {
      this.image_1ch.release();
      this.image_1ch = null;
    }
    if (this.ipl_frame != null) {
      this.ipl_frame = null;
    }
    if (this.ps3_frame != null) {
      this.ps3_frame = null;
    }
    this.stat = "released";
  }
  
  public void start()
    throws FrameGrabber.Exception
  {
    if (this.ps3_frame == null)
    {
      this.ps3_frame = new int[this.imageWidth * this.imageHeight];
      this.image_4ch = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 8, 4);
      this.image_1ch = opencv_core.IplImage.create(this.imageWidth, this.imageHeight, 8, 1);
    }
    CLCamera localCLCamera = this.camera;
    int i = this.cameraIndex;
    int j;
    if (this.imageMode == FrameGrabber.ImageMode.GRAY)
    {
      j = CLCamera.CLEYE_MONO_PROCESSED;
      if ((this.imageWidth != 320) || (this.imageHeight != 240)) {
        break label141;
      }
    }
    label141:
    for (int k = CLCamera.CLEYE_QVGA;; k = CLCamera.CLEYE_VGA)
    {
      if (localCLCamera.createCamera(i, j, k, (int)this.frameRate)) {
        break label149;
      }
      throw new FrameGrabber.Exception("Low level createCamera() failed");
      j = CLCamera.CLEYE_COLOR_PROCESSED;
      break;
    }
    label149:
    if (!this.camera.startCamera()) {
      throw new FrameGrabber.Exception("Camera start() failed");
    }
    this.stat = "started";
  }
  
  public void stop()
    throws FrameGrabber.Exception
  {
    if (this.camera.stopCamera())
    {
      this.stat = "stopped";
      return;
    }
    throw new FrameGrabber.Exception("Camera stop() failed");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("UUID=").append(this.uuid).append("; status=").append(this.stat).append("; timeout=").append(this.timeout).append("; ");
    if (this.camera != null) {}
    for (String str = this.camera.toString();; str = "<no camera>") {
      return str;
    }
  }
  
  public void trigger()
    throws FrameGrabber.Exception
  {
    for (int i = 0; i < 1 + this.numBuffers; i++) {
      grab_raw();
    }
    int[] arrayOfInt = grab_raw();
    this.ps3_frame = arrayOfInt;
    if (arrayOfInt != null)
    {
      this.triggered = Triggered.HAS_FRAME;
      this.timestamp = (System.nanoTime() / 1000L);
      return;
    }
    this.triggered = Triggered.NO_FRAME;
  }
  
  protected static enum Triggered
  {
    static
    {
      HAS_FRAME = new Triggered("HAS_FRAME", 1);
      NO_FRAME = new Triggered("NO_FRAME", 2);
      Triggered[] arrayOfTriggered = new Triggered[3];
      arrayOfTriggered[0] = NO_TRIGGER;
      arrayOfTriggered[1] = HAS_FRAME;
      arrayOfTriggered[2] = NO_FRAME;
      $VALUES = arrayOfTriggered;
    }
    
    private Triggered() {}
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\PS3EyeFrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */