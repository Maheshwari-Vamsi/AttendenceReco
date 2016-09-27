package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class FrameRecorder
{
  public static final List<String> list = new LinkedList(Arrays.asList(new String[] { "FFmpeg", "OpenCV" }));
  protected int audioBitrate;
  protected int audioChannels;
  protected int audioCodec;
  protected HashMap<String, String> audioOptions = new HashMap();
  protected double audioQuality = -1.0D;
  protected String format;
  protected int frameNumber = 0;
  protected double frameRate;
  protected int imageHeight;
  protected int imageWidth;
  protected boolean interleaved;
  protected int pixelFormat;
  protected int sampleFormat;
  protected int sampleRate;
  protected long timestamp = 0L;
  protected int videoBitrate;
  protected int videoCodec;
  protected HashMap<String, String> videoOptions = new HashMap();
  protected double videoQuality = -1.0D;
  
  public static FrameRecorder create(Class<? extends FrameRecorder> paramClass, Class paramClass1, Object paramObject, int paramInt1, int paramInt2)
    throws Exception
  {
    try
    {
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = paramClass1;
      arrayOfClass[1] = Integer.TYPE;
      arrayOfClass[2] = Integer.TYPE;
      Constructor localConstructor = paramClass.getConstructor(arrayOfClass);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramObject;
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = Integer.valueOf(paramInt2);
      FrameRecorder localFrameRecorder = (FrameRecorder)localConstructor.newInstance(arrayOfObject);
      return localFrameRecorder;
    }
    catch (InstantiationException localInstantiationException)
    {
      localObject = localInstantiationException;
      throw new Exception("Could not create new " + paramClass.getSimpleName() + "(" + paramObject + ", " + paramInt1 + ", " + paramInt2 + ")", (Throwable)localObject);
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
  
  public static FrameRecorder create(String paramString, File paramFile, int paramInt1, int paramInt2)
    throws Exception
  {
    return create(get(paramString), File.class, paramFile, paramInt1, paramInt2);
  }
  
  public static FrameRecorder create(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws Exception
  {
    return create(get(paramString1), String.class, paramString2, paramInt1, paramInt2);
  }
  
  public static FrameRecorder createDefault(File paramFile, int paramInt1, int paramInt2)
    throws Exception
  {
    return create(getDefault(), File.class, paramFile, paramInt1, paramInt2);
  }
  
  public static FrameRecorder createDefault(String paramString, int paramInt1, int paramInt2)
    throws Exception
  {
    return create(getDefault(), String.class, paramString, paramInt1, paramInt2);
  }
  
  public static Class<? extends FrameRecorder> get(String paramString)
    throws Exception
  {
    String str1 = FrameRecorder.class.getPackage().getName() + "." + paramString;
    try
    {
      Class localClass2 = Class.forName(str1).asSubclass(FrameRecorder.class);
      return localClass2;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      String str2 = str1 + "FrameRecorder";
      try
      {
        Class localClass1 = Class.forName(str2).asSubclass(FrameRecorder.class);
        return localClass1;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        throw new Exception("Could not get FrameRecorder class for " + str1 + " or " + str2, localClassNotFoundException1);
      }
    }
  }
  
  public static Class<? extends FrameRecorder> getDefault()
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
        return localClass;
      }
      catch (Throwable localThrowable) {}
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
  
  public int getAudioBitrate()
  {
    return this.audioBitrate;
  }
  
  public int getAudioChannels()
  {
    return this.audioChannels;
  }
  
  public int getAudioCodec()
  {
    return this.audioCodec;
  }
  
  public String getAudioOption(String paramString)
  {
    return (String)this.audioOptions.get(paramString);
  }
  
  public double getAudioQuality()
  {
    return this.audioQuality;
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
  
  public int getImageHeight()
  {
    return this.imageHeight;
  }
  
  public int getImageWidth()
  {
    return this.imageWidth;
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
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getVideoBitrate()
  {
    return this.videoBitrate;
  }
  
  public int getVideoCodec()
  {
    return this.videoCodec;
  }
  
  public String getVideoOption(String paramString)
  {
    return (String)this.videoOptions.get(paramString);
  }
  
  public double getVideoQuality()
  {
    return this.videoQuality;
  }
  
  public boolean isInterleaved()
  {
    return this.interleaved;
  }
  
  public void record(Frame paramFrame)
    throws Exception
  {
    if ((paramFrame == null) || ((paramFrame.image == null) && (paramFrame.samples == null))) {
      record((opencv_core.IplImage)null);
    }
    do
    {
      return;
      if (paramFrame.image != null) {
        record(paramFrame.image);
      }
    } while (paramFrame.samples == null);
    record(paramFrame.samples);
  }
  
  public abstract void record(opencv_core.IplImage paramIplImage)
    throws Exception;
  
  public void record(Buffer[] paramArrayOfBuffer)
    throws Exception
  {
    throw new UnsupportedOperationException("This FrameRecorder does not support audio.");
  }
  
  public abstract void release()
    throws Exception;
  
  public void setAudioBitrate(int paramInt)
  {
    this.audioBitrate = paramInt;
  }
  
  public void setAudioChannels(int paramInt)
  {
    this.audioChannels = paramInt;
  }
  
  public void setAudioCodec(int paramInt)
  {
    this.audioCodec = paramInt;
  }
  
  public void setAudioOption(String paramString1, String paramString2)
  {
    this.audioOptions.put(paramString1, paramString2);
  }
  
  public void setAudioQuality(double paramDouble)
  {
    this.audioQuality = paramDouble;
  }
  
  public void setFormat(String paramString)
  {
    this.format = paramString;
  }
  
  public void setFrameNumber(int paramInt)
  {
    this.frameNumber = paramInt;
  }
  
  public void setFrameRate(double paramDouble)
  {
    this.frameRate = paramDouble;
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setInterleaved(boolean paramBoolean)
  {
    this.interleaved = paramBoolean;
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
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void setVideoBitrate(int paramInt)
  {
    this.videoBitrate = paramInt;
  }
  
  public void setVideoCodec(int paramInt)
  {
    this.videoCodec = paramInt;
  }
  
  public void setVideoOption(String paramString1, String paramString2)
  {
    this.videoOptions.put(paramString1, paramString2);
  }
  
  public void setVideoQuality(double paramDouble)
  {
    this.videoQuality = paramDouble;
  }
  
  public abstract void start()
    throws Exception;
  
  public abstract void stop()
    throws Exception;
  
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
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\FrameRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */