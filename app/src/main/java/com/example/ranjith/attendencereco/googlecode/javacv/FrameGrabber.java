package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.beans.PropertyEditorSupport;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class FrameGrabber
{
  public static final long SENSOR_PATTERN_BGGR = 4294967297L;
  public static final long SENSOR_PATTERN_GBRG = 4294967296L;
  public static final long SENSOR_PATTERN_GRBG = 1L;
  public static final long SENSOR_PATTERN_RGGB;
  public static final List<String> list = new LinkedList(Arrays.asList(new String[] { "DC1394", "FlyCapture", "OpenKinect", "PS3Eye", "VideoInput", "OpenCV", "FFmpeg" }));
  protected int audioChannels = 0;
  protected int bpp = 0;
  protected boolean deinterlace = false;
  private opencv_core.IplImage delayedImage = null;
  private long delayedTime = 0L;
  private ExecutorService executor = Executors.newSingleThreadExecutor();
  protected String format = null;
  protected int frameNumber = 0;
  protected double frameRate = 0.0D;
  private Future<Void> future = null;
  protected double gamma = 0.0D;
  protected int imageHeight = 0;
  protected ImageMode imageMode = ImageMode.COLOR;
  protected int imageWidth = 0;
  protected int numBuffers = 4;
  protected int pixelFormat = -1;
  protected int sampleFormat = 0;
  protected int sampleRate = 0;
  protected long sensorPattern = -1L;
  protected int timeout = 10000;
  protected long timestamp = 0L;
  protected boolean triggerMode = false;
  
  public static FrameGrabber create(Class<? extends FrameGrabber> paramClass, Class paramClass1, Object paramObject)
    throws Exception
  {
    try
    {
      FrameGrabber localFrameGrabber = (FrameGrabber)paramClass.getConstructor(new Class[] { paramClass1 }).newInstance(new Object[] { paramObject });
      return localFrameGrabber;
    }
    catch (InstantiationException localInstantiationException)
    {
      localObject = localInstantiationException;
      throw new Exception("Could not create new " + paramClass.getSimpleName() + "(" + paramObject + ")", (Throwable)localObject);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localObject = localIllegalAccessException;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localObject = localIllegalArgumentException;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localObject = localNoSuchMethodException;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Object localObject = localInvocationTargetException.getCause();
      }
    }
  }
  
  public static FrameGrabber create(String paramString, int paramInt)
    throws Exception
  {
    try
    {
      FrameGrabber localFrameGrabber = create(get(paramString), Integer.TYPE, Integer.valueOf(paramInt));
      return localFrameGrabber;
    }
    catch (Exception localException) {}
    return create(get(paramString), Integer.class, Integer.valueOf(paramInt));
  }
  
  public static FrameGrabber create(String paramString, File paramFile)
    throws Exception
  {
    return create(get(paramString), File.class, paramFile);
  }
  
  public static FrameGrabber create(String paramString1, String paramString2)
    throws Exception
  {
    return create(get(paramString1), String.class, paramString2);
  }
  
  public static FrameGrabber createDefault(int paramInt)
    throws Exception
  {
    try
    {
      FrameGrabber localFrameGrabber = create(getDefault(), Integer.TYPE, Integer.valueOf(paramInt));
      return localFrameGrabber;
    }
    catch (Exception localException) {}
    return create(getDefault(), Integer.class, Integer.valueOf(paramInt));
  }
  
  public static FrameGrabber createDefault(File paramFile)
    throws Exception
  {
    return create(getDefault(), File.class, paramFile);
  }
  
  public static FrameGrabber createDefault(String paramString)
    throws Exception
  {
    return create(getDefault(), String.class, paramString);
  }
  
  public static Class<? extends FrameGrabber> get(String paramString)
    throws Exception
  {
    String str1 = FrameGrabber.class.getPackage().getName() + "." + paramString;
    try
    {
      Class localClass2 = Class.forName(str1).asSubclass(FrameGrabber.class);
      return localClass2;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      String str2 = str1 + "FrameGrabber";
      try
      {
        Class localClass1 = Class.forName(str2).asSubclass(FrameGrabber.class);
        return localClass1;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        throw new Exception("Could not get FrameGrabber class for " + str1 + " or " + str2, localClassNotFoundException1);
      }
    }
  }
  
  public static Class<? extends FrameGrabber> getDefault()
  {
    Iterator localIterator = list.iterator();
    for (;;)
    {
      String str;
      if (localIterator.hasNext()) {
        str = (String)localIterator.next();
      }
      try
      {
        Class localClass = get(str);
        localClass.getMethod("tryLoad", new Class[0]).invoke(null, new Object[0]);
        try
        {
          int j = ((String[])localClass.getMethod("getDeviceDescriptions", new Class[0]).invoke(null, new Object[0])).length;
          i = 0;
          if (j > 0) {
            i = 1;
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            boolean bool = localThrowable2.getCause() instanceof UnsupportedOperationException;
            int i = 0;
            if (bool) {
              i = 1;
            }
          }
        }
        if (i == 0) {
          continue;
        }
        return localClass;
      }
      catch (Throwable localThrowable1) {}
      return null;
    }
  }
  
  public static void init()
  {
    Iterator localIterator = list.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        get(str).getMethod("tryLoad", new Class[0]).invoke(null, new Object[0]);
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public Array createArray(FrameGrabber[] paramArrayOfFrameGrabber)
  {
    return new Array(paramArrayOfFrameGrabber);
  }
  
  public void delayedGrab(long paramLong)
  {
    this.delayedImage = null;
    this.delayedTime = 0L;
    final long l = System.nanoTime() / 1000L;
    if ((this.future != null) && (!this.future.isDone())) {
      return;
    }
    this.future = this.executor.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        do
        {
          FrameGrabber.access$002(FrameGrabber.this, FrameGrabber.this.grab());
          FrameGrabber.access$102(FrameGrabber.this, System.nanoTime() / 1000L - l);
        } while (FrameGrabber.this.delayedTime < this.val$delayTime);
        return null;
      }
    });
  }
  
  public void flush()
    throws Exception
  {
    for (int i = 0; i < 1 + this.numBuffers; i++) {
      grab();
    }
  }
  
  public int getAudioChannels()
  {
    return this.audioChannels;
  }
  
  public int getBitsPerPixel()
  {
    return this.bpp;
  }
  
  public opencv_core.IplImage getDelayedImage()
    throws InterruptedException, ExecutionException
  {
    if (this.future == null) {
      return null;
    }
    this.future.get();
    return this.delayedImage;
  }
  
  public long getDelayedTime()
    throws InterruptedException, ExecutionException
  {
    if (this.future == null) {
      return 0L;
    }
    this.future.get();
    return this.delayedTime;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public int getFrameNumber()
  {
    return this.frameNumber;
  }
  
  public double getFrameRate()
  {
    return this.frameRate;
  }
  
  public double getGamma()
  {
    return this.gamma;
  }
  
  public int getImageHeight()
  {
    return this.imageHeight;
  }
  
  public ImageMode getImageMode()
  {
    return this.imageMode;
  }
  
  public int getImageWidth()
  {
    return this.imageWidth;
  }
  
  public int getLengthInFrames()
  {
    return 0;
  }
  
  public long getLengthInTime()
  {
    return 0L;
  }
  
  public int getNumBuffers()
  {
    return this.numBuffers;
  }
  
  public int getPixelFormat()
  {
    return this.pixelFormat;
  }
  
  public int getSampleFormat()
  {
    return this.sampleFormat;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public long getSensorPattern()
  {
    return this.sensorPattern;
  }
  
  public int getTimeout()
  {
    return this.timeout;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public abstract opencv_core.IplImage grab()
    throws Exception;
  
  public Frame grabFrame()
    throws Exception
  {
    throw new UnsupportedOperationException("This FrameGrabber does not support audio.");
  }
  
  public boolean isDeinterlace()
  {
    return this.deinterlace;
  }
  
  public boolean isTriggerMode()
  {
    return this.triggerMode;
  }
  
  public abstract void release()
    throws Exception;
  
  public void restart()
    throws Exception
  {
    stop();
    start();
  }
  
  public void setAudioChannels(int paramInt)
  {
    this.audioChannels = paramInt;
  }
  
  public void setBitsPerPixel(int paramInt)
  {
    this.bpp = paramInt;
  }
  
  public void setDeinterlace(boolean paramBoolean)
  {
    this.deinterlace = paramBoolean;
  }
  
  public void setFormat(String paramString)
  {
    this.format = paramString;
  }
  
  public void setFrameNumber(int paramInt)
    throws Exception
  {
    this.frameNumber = paramInt;
  }
  
  public void setFrameRate(double paramDouble)
  {
    this.frameRate = paramDouble;
  }
  
  public void setGamma(double paramDouble)
  {
    this.gamma = paramDouble;
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageMode(ImageMode paramImageMode)
  {
    this.imageMode = paramImageMode;
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setNumBuffers(int paramInt)
  {
    this.numBuffers = paramInt;
  }
  
  public void setPixelFormat(int paramInt)
  {
    this.pixelFormat = paramInt;
  }
  
  public void setSampleFormat(int paramInt)
  {
    this.sampleFormat = paramInt;
  }
  
  public void setSampleRate(int paramInt)
  {
    this.sampleRate = paramInt;
  }
  
  public void setSensorPattern(long paramLong)
  {
    this.sensorPattern = paramLong;
  }
  
  public void setTimeout(int paramInt)
  {
    this.timeout = paramInt;
  }
  
  public void setTimestamp(long paramLong)
    throws Exception
  {
    this.timestamp = paramLong;
  }
  
  public void setTriggerMode(boolean paramBoolean)
  {
    this.triggerMode = paramBoolean;
  }
  
  public abstract void start()
    throws Exception;
  
  public abstract void stop()
    throws Exception;
  
  public abstract void trigger()
    throws Exception;
  
  public static class Array
  {
    private long bestInterval = Long.MAX_VALUE;
    private long[] bestLatencies = null;
    protected FrameGrabber[] frameGrabbers = null;
    private opencv_core.IplImage[] grabbedImages = null;
    private long lastNewestTimestamp = 0L;
    private long[] latencies = null;
    
    protected Array(FrameGrabber[] paramArrayOfFrameGrabber)
    {
      setFrameGrabbers(paramArrayOfFrameGrabber);
    }
    
    public FrameGrabber[] getFrameGrabbers()
    {
      return this.frameGrabbers;
    }
    
    public opencv_core.IplImage[] grab()
      throws Exception
    {
      if (this.frameGrabbers.length == 1)
      {
        this.grabbedImages[0] = this.frameGrabbers[0].grab();
        return this.grabbedImages;
      }
      long l = 0L;
      int i = 0;
      for (int j = 0; j < this.frameGrabbers.length; j++)
      {
        this.grabbedImages[j] = this.frameGrabbers[j].grab();
        if (this.grabbedImages[j] != null) {
          l = Math.max(l, this.frameGrabbers[j].getTimestamp());
        }
        if (this.frameGrabbers[j].getClass() != this.frameGrabbers[((j + 1) % this.frameGrabbers.length)].getClass()) {
          i = 1;
        }
      }
      if (i != 0) {
        return this.grabbedImages;
      }
      for (int k = 0; k < this.frameGrabbers.length; k++) {
        if (this.grabbedImages[k] != null) {
          this.latencies[k] = (l - Math.max(0L, this.frameGrabbers[k].getTimestamp()));
        }
      }
      if (this.bestLatencies == null) {
        this.bestLatencies = Arrays.copyOf(this.latencies, this.latencies.length);
      }
      for (;;)
      {
        this.bestInterval = Math.min(this.bestInterval, l - this.lastNewestTimestamp);
        for (int i2 = 0; i2 < this.bestLatencies.length; i2++) {
          this.bestLatencies[i2] = Math.min(this.bestLatencies[i2], 9L * this.bestInterval / 10L);
        }
        int m = 0;
        int n = 0;
        for (int i1 = 0; i1 < this.frameGrabbers.length; i1++)
        {
          m = (int)(m + this.latencies[i1]);
          n = (int)(n + this.bestLatencies[i1]);
        }
        if (m < n) {
          this.bestLatencies = Arrays.copyOf(this.latencies, this.latencies.length);
        }
      }
      for (int i3 = 0; i3 < 2; i3++)
      {
        int i4 = 0;
        if (i4 < this.frameGrabbers.length)
        {
          if ((this.frameGrabbers[i4].isTriggerMode()) || (this.grabbedImages[i4] == null)) {
            label399:
            i4++;
          }
          for (;;)
          {
            break;
            int i5 = (int)(l - Math.max(0L, this.frameGrabbers[i4].getTimestamp()));
            if (i5 - this.bestLatencies[i4] > 0.1D * this.bestLatencies[i4])
            {
              this.grabbedImages[i4] = this.frameGrabbers[i4].grab();
              if (this.grabbedImages[i4] != null)
              {
                i5 = (int)(l - Math.max(0L, this.frameGrabbers[i4].getTimestamp()));
                if (i5 >= 0) {
                  break label399;
                }
                l = Math.max(0L, this.frameGrabbers[i4].getTimestamp());
              }
            }
          }
        }
      }
      this.lastNewestTimestamp = l;
      return this.grabbedImages;
    }
    
    public void release()
      throws Exception
    {
      FrameGrabber[] arrayOfFrameGrabber = this.frameGrabbers;
      int i = arrayOfFrameGrabber.length;
      for (int j = 0; j < i; j++) {
        arrayOfFrameGrabber[j].release();
      }
    }
    
    public void setFrameGrabbers(FrameGrabber[] paramArrayOfFrameGrabber)
    {
      this.frameGrabbers = paramArrayOfFrameGrabber;
      this.grabbedImages = new opencv_core.IplImage[paramArrayOfFrameGrabber.length];
      this.latencies = new long[paramArrayOfFrameGrabber.length];
      this.bestLatencies = null;
      this.lastNewestTimestamp = 0L;
    }
    
    public int size()
    {
      return this.frameGrabbers.length;
    }
    
    public void start()
      throws Exception
    {
      FrameGrabber[] arrayOfFrameGrabber = this.frameGrabbers;
      int i = arrayOfFrameGrabber.length;
      for (int j = 0; j < i; j++) {
        arrayOfFrameGrabber[j].start();
      }
    }
    
    public void stop()
      throws Exception
    {
      FrameGrabber[] arrayOfFrameGrabber = this.frameGrabbers;
      int i = arrayOfFrameGrabber.length;
      for (int j = 0; j < i; j++) {
        arrayOfFrameGrabber[j].stop();
      }
    }
    
    public void trigger()
      throws Exception
    {
      for (FrameGrabber localFrameGrabber : this.frameGrabbers) {
        if (localFrameGrabber.isTriggerMode()) {
          localFrameGrabber.trigger();
        }
      }
    }
  }
  
  public static class Exception
    extends Exception
  {
    public Exception(String paramString)
    {
      super();
    }
    
    public Exception(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static enum ImageMode
  {
    static
    {
      ImageMode[] arrayOfImageMode = new ImageMode[3];
      arrayOfImageMode[0] = COLOR;
      arrayOfImageMode[1] = GRAY;
      arrayOfImageMode[2] = RAW;
      $VALUES = arrayOfImageMode;
    }
    
    private ImageMode() {}
  }
  
  public static class PropertyEditor
    extends PropertyEditorSupport
  {
    public String getAsText()
    {
      Class localClass = (Class)getValue();
      if (localClass == null) {
        return "null";
      }
      return localClass.getSimpleName().split("FrameGrabber")[0];
    }
    
    public String[] getTags()
    {
      return (String[])FrameGrabber.list.toArray(new String[FrameGrabber.list.size()]);
    }
    
    public void setAsText(String paramString)
    {
      if (paramString == null) {
        setValue(null);
      }
      try
      {
        setValue(FrameGrabber.get(paramString));
        return;
      }
      catch (Exception localException)
      {
        throw new IllegalArgumentException(localException);
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\FrameGrabber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */