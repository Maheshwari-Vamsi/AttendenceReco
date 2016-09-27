package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvFileNode;
import com.googlecode.javacv.cpp.opencv_core.CvFileStorage;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.lang.reflect.Method;

public class CameraDevice
  extends ProjectiveDevice
{
  private Settings settings;
  
  public CameraDevice(Settings paramSettings)
    throws ProjectiveDevice.Exception
  {
    super((ProjectiveDevice.Settings)paramSettings);
  }
  
  public CameraDevice(String paramString)
  {
    super(paramString);
  }
  
  public CameraDevice(String paramString, opencv_core.CvFileStorage paramCvFileStorage)
    throws ProjectiveDevice.Exception
  {
    super(paramString, paramCvFileStorage);
    this.settings.setImageWidth(this.imageWidth);
    this.settings.setImageHeight(this.imageHeight);
  }
  
  public CameraDevice(String paramString1, String paramString2)
    throws ProjectiveDevice.Exception
  {
    super(paramString1, paramString2);
    this.settings.setImageWidth(this.imageWidth);
    this.settings.setImageHeight(this.imageHeight);
  }
  
  public static CameraDevice[] read(opencv_core.CvFileStorage paramCvFileStorage)
    throws ProjectiveDevice.Exception
  {
    opencv_core.CvSeq localCvSeq = opencv_core.cvGetFileNodeByName(paramCvFileStorage, null, "Cameras").data_seq();
    int i = localCvSeq.total();
    CameraDevice[] arrayOfCameraDevice = new CameraDevice[i];
    int j = 0;
    if (j < i)
    {
      Pointer localPointer = opencv_core.cvGetSeqElem(localCvSeq, j);
      if (localPointer == null) {}
      for (;;)
      {
        j++;
        break;
        arrayOfCameraDevice[j] = new CameraDevice(opencv_core.cvReadString(new opencv_core.CvFileNode(localPointer), null), paramCvFileStorage);
      }
    }
    return arrayOfCameraDevice;
  }
  
  public static CameraDevice[] read(String paramString)
    throws ProjectiveDevice.Exception
  {
    opencv_core.CvFileStorage localCvFileStorage = opencv_core.CvFileStorage.open(paramString, null, 0);
    CameraDevice[] arrayOfCameraDevice = read(localCvFileStorage);
    localCvFileStorage.release();
    return arrayOfCameraDevice;
  }
  
  /* Error */
  public FrameGrabber createFrameGrabber()
    throws FrameGrabber.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   4: invokeinterface 101 1 0
    //   9: ldc 103
    //   11: iconst_0
    //   12: anewarray 105	java/lang/Class
    //   15: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   18: aconst_null
    //   19: iconst_0
    //   20: anewarray 111	java/lang/Object
    //   23: invokevirtual 117	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   26: pop
    //   27: aload_0
    //   28: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   31: invokeinterface 121 1 0
    //   36: ifnull +214 -> 250
    //   39: aload_0
    //   40: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   43: invokeinterface 101 1 0
    //   48: iconst_1
    //   49: anewarray 105	java/lang/Class
    //   52: dup
    //   53: iconst_0
    //   54: ldc 123
    //   56: aastore
    //   57: invokevirtual 127	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   60: astore 15
    //   62: iconst_1
    //   63: anewarray 111	java/lang/Object
    //   66: astore 16
    //   68: aload 16
    //   70: iconst_0
    //   71: aload_0
    //   72: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   75: invokeinterface 121 1 0
    //   80: aastore
    //   81: aload 15
    //   83: aload 16
    //   85: invokevirtual 133	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 135	com/googlecode/javacv/FrameGrabber
    //   91: astore 8
    //   93: aload 8
    //   95: aload_0
    //   96: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   99: invokeinterface 139 1 0
    //   104: invokevirtual 142	com/googlecode/javacv/FrameGrabber:setFormat	(Ljava/lang/String;)V
    //   107: aload 8
    //   109: aload_0
    //   110: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   113: invokeinterface 145 1 0
    //   118: invokevirtual 146	com/googlecode/javacv/FrameGrabber:setImageWidth	(I)V
    //   121: aload 8
    //   123: aload_0
    //   124: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   127: invokeinterface 149 1 0
    //   132: invokevirtual 150	com/googlecode/javacv/FrameGrabber:setImageHeight	(I)V
    //   135: aload 8
    //   137: aload_0
    //   138: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   141: invokeinterface 154 1 0
    //   146: invokevirtual 158	com/googlecode/javacv/FrameGrabber:setFrameRate	(D)V
    //   149: aload 8
    //   151: aload_0
    //   152: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   155: invokeinterface 162 1 0
    //   160: invokevirtual 166	com/googlecode/javacv/FrameGrabber:setTriggerMode	(Z)V
    //   163: aload 8
    //   165: aload_0
    //   166: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   169: invokeinterface 169 1 0
    //   174: invokevirtual 172	com/googlecode/javacv/FrameGrabber:setBitsPerPixel	(I)V
    //   177: aload 8
    //   179: aload_0
    //   180: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   183: invokeinterface 176 1 0
    //   188: invokevirtual 180	com/googlecode/javacv/FrameGrabber:setImageMode	(Lcom/googlecode/javacv/FrameGrabber$ImageMode;)V
    //   191: aload 8
    //   193: aload_0
    //   194: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   197: invokeinterface 183 1 0
    //   202: invokevirtual 186	com/googlecode/javacv/FrameGrabber:setTimeout	(I)V
    //   205: aload 8
    //   207: aload_0
    //   208: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   211: invokeinterface 189 1 0
    //   216: invokevirtual 192	com/googlecode/javacv/FrameGrabber:setNumBuffers	(I)V
    //   219: aload 8
    //   221: aload_0
    //   222: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   225: invokeinterface 195 1 0
    //   230: invokevirtual 198	com/googlecode/javacv/FrameGrabber:setGamma	(D)V
    //   233: aload 8
    //   235: aload_0
    //   236: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   239: invokeinterface 201 1 0
    //   244: invokevirtual 204	com/googlecode/javacv/FrameGrabber:setDeinterlace	(Z)V
    //   247: aload 8
    //   249: areturn
    //   250: aload_0
    //   251: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   254: invokeinterface 207 1 0
    //   259: ifnull +75 -> 334
    //   262: aload_0
    //   263: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   266: invokeinterface 207 1 0
    //   271: invokevirtual 212	java/lang/String:length	()I
    //   274: ifle +60 -> 334
    //   277: aload_0
    //   278: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   281: invokeinterface 101 1 0
    //   286: iconst_1
    //   287: anewarray 105	java/lang/Class
    //   290: dup
    //   291: iconst_0
    //   292: ldc -47
    //   294: aastore
    //   295: invokevirtual 127	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   298: astore 13
    //   300: iconst_1
    //   301: anewarray 111	java/lang/Object
    //   304: astore 14
    //   306: aload 14
    //   308: iconst_0
    //   309: aload_0
    //   310: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   313: invokeinterface 207 1 0
    //   318: aastore
    //   319: aload 13
    //   321: aload 14
    //   323: invokevirtual 133	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   326: checkcast 135	com/googlecode/javacv/FrameGrabber
    //   329: astore 8
    //   331: goto -238 -> 93
    //   334: aload_0
    //   335: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   338: invokeinterface 216 1 0
    //   343: astore_3
    //   344: iconst_0
    //   345: istore 4
    //   347: aload_3
    //   348: ifnonnull +66 -> 414
    //   351: aload_0
    //   352: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   355: invokeinterface 101 1 0
    //   360: astore 9
    //   362: iconst_1
    //   363: anewarray 105	java/lang/Class
    //   366: astore 10
    //   368: aload 10
    //   370: iconst_0
    //   371: getstatic 222	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   374: aastore
    //   375: aload 9
    //   377: aload 10
    //   379: invokevirtual 127	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   382: astore 11
    //   384: iconst_1
    //   385: anewarray 111	java/lang/Object
    //   388: astore 12
    //   390: aload 12
    //   392: iconst_0
    //   393: iload 4
    //   395: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   398: aastore
    //   399: aload 11
    //   401: aload 12
    //   403: invokevirtual 133	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   406: checkcast 135	com/googlecode/javacv/FrameGrabber
    //   409: astore 8
    //   411: goto -318 -> 93
    //   414: aload_0
    //   415: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   418: invokeinterface 216 1 0
    //   423: invokevirtual 229	java/lang/Integer:intValue	()I
    //   426: istore 4
    //   428: goto -77 -> 351
    //   431: astore 5
    //   433: aload_0
    //   434: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   437: invokeinterface 101 1 0
    //   442: iconst_1
    //   443: anewarray 105	java/lang/Class
    //   446: dup
    //   447: iconst_0
    //   448: ldc -38
    //   450: aastore
    //   451: invokevirtual 127	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   454: astore 6
    //   456: iconst_1
    //   457: anewarray 111	java/lang/Object
    //   460: astore 7
    //   462: aload 7
    //   464: iconst_0
    //   465: iload 4
    //   467: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   470: aastore
    //   471: aload 6
    //   473: aload 7
    //   475: invokevirtual 133	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   478: checkcast 135	com/googlecode/javacv/FrameGrabber
    //   481: astore 8
    //   483: goto -390 -> 93
    //   486: astore_1
    //   487: aload_1
    //   488: instanceof 231
    //   491: ifeq +11 -> 502
    //   494: aload_1
    //   495: checkcast 231	java/lang/reflect/InvocationTargetException
    //   498: invokevirtual 235	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   501: astore_1
    //   502: aload_1
    //   503: instanceof 93
    //   506: ifeq +8 -> 514
    //   509: aload_1
    //   510: checkcast 93	com/googlecode/javacv/FrameGrabber$Exception
    //   513: athrow
    //   514: new 93	com/googlecode/javacv/FrameGrabber$Exception
    //   517: dup
    //   518: new 237	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   525: ldc -15
    //   527: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: getfield 23	com/googlecode/javacv/CameraDevice:settings	Lcom/googlecode/javacv/CameraDevice$Settings;
    //   534: invokeinterface 101 1 0
    //   539: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: aload_1
    //   546: invokespecial 254	com/googlecode/javacv/FrameGrabber$Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   549: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	this	CameraDevice
    //   486	9	1	localThrowable1	Throwable
    //   501	45	1	localThrowable2	Throwable
    //   343	5	3	localInteger	Integer
    //   345	121	4	i	int
    //   431	1	5	localNoSuchMethodException	NoSuchMethodException
    //   454	18	6	localConstructor1	java.lang.reflect.Constructor
    //   460	14	7	arrayOfObject1	Object[]
    //   91	391	8	localFrameGrabber	FrameGrabber
    //   360	16	9	localClass	Class
    //   366	12	10	arrayOfClass	Class[]
    //   382	18	11	localConstructor2	java.lang.reflect.Constructor
    //   388	14	12	arrayOfObject2	Object[]
    //   298	22	13	localConstructor3	java.lang.reflect.Constructor
    //   304	18	14	arrayOfObject3	Object[]
    //   60	22	15	localConstructor4	java.lang.reflect.Constructor
    //   66	18	16	arrayOfObject4	Object[]
    // Exception table:
    //   from	to	target	type
    //   351	411	431	java/lang/NoSuchMethodException
    //   0	93	486	java/lang/Throwable
    //   93	247	486	java/lang/Throwable
    //   250	331	486	java/lang/Throwable
    //   334	344	486	java/lang/Throwable
    //   351	411	486	java/lang/Throwable
    //   414	428	486	java/lang/Throwable
    //   433	483	486	java/lang/Throwable
  }
  
  public ProjectiveDevice.Settings getSettings()
  {
    return (ProjectiveDevice.Settings)this.settings;
  }
  
  public void setSettings(Settings paramSettings)
  {
    setSettings((ProjectiveDevice.Settings)paramSettings);
  }
  
  public void setSettings(ProjectiveDevice.Settings paramSettings)
  {
    super.setSettings(paramSettings);
    if ((paramSettings instanceof ProjectiveDevice.CalibrationSettings)) {
      this.settings = new CalibrationSettings((ProjectiveDevice.CalibrationSettings)paramSettings);
    }
    for (;;)
    {
      if ((this.settings.getName() == null) || (this.settings.getName().length() == 0))
      {
        Settings localSettings = this.settings;
        StringBuilder localStringBuilder = new StringBuilder().append("Camera ");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.settings.getDeviceNumber();
        localSettings.setName(String.format("%2d", arrayOfObject));
      }
      return;
      if ((paramSettings instanceof ProjectiveDevice.CalibratedSettings)) {
        this.settings = new CalibratedSettings((ProjectiveDevice.CalibratedSettings)paramSettings);
      } else {
        this.settings = new SettingsImplementation(paramSettings);
      }
    }
  }
  
  public static class CalibratedSettings
    extends ProjectiveDevice.CalibratedSettings
    implements Settings
  {
    SettingsImplementation si = new SettingsImplementation()
    {
      public void firePropertyChange(String paramAnonymousString, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        CalibratedSettings.this.firePropertyChange(paramAnonymousString, paramAnonymousObject1, paramAnonymousObject2);
      }
    };
    
    public CalibratedSettings() {}
    
    public CalibratedSettings(ProjectiveDevice.CalibratedSettings paramCalibratedSettings)
    {
      super();
      if ((paramCalibratedSettings instanceof CalibratedSettings)) {
        this.si = new SettingsImplementation(((CalibratedSettings)paramCalibratedSettings).si);
      }
    }
    
    public int getBitsPerPixel()
    {
      return this.si.getBitsPerPixel();
    }
    
    public String getDescription()
    {
      return this.si.getDescription();
    }
    
    public File getDeviceFile()
    {
      return this.si.getDeviceFile();
    }
    
    public String getDeviceFilename()
    {
      return this.si.getDeviceFilename();
    }
    
    public Integer getDeviceNumber()
    {
      return this.si.getDeviceNumber();
    }
    
    public String getDevicePath()
    {
      return this.si.getDevicePath();
    }
    
    public String getFormat()
    {
      return this.si.getFormat();
    }
    
    public Class<? extends FrameGrabber> getFrameGrabber()
    {
      return this.si.getFrameGrabber();
    }
    
    public double getFrameRate()
    {
      return this.si.getFrameRate();
    }
    
    public int getImageHeight()
    {
      return this.si.getImageHeight();
    }
    
    public FrameGrabber.ImageMode getImageMode()
    {
      return this.si.getImageMode();
    }
    
    public int getImageWidth()
    {
      return this.si.getImageWidth();
    }
    
    public String getName()
    {
      return this.si.getName();
    }
    
    public int getNumBuffers()
    {
      return this.si.getNumBuffers();
    }
    
    public double getResponseGamma()
    {
      return this.si.getResponseGamma();
    }
    
    public int getTimeout()
    {
      return this.si.getTimeout();
    }
    
    public boolean isDeinterlace()
    {
      return this.si.isDeinterlace();
    }
    
    public boolean isTriggerMode()
    {
      return this.si.isTriggerMode();
    }
    
    public void setBitsPerPixel(int paramInt)
    {
      this.si.setBitsPerPixel(paramInt);
    }
    
    public void setDeinterlace(boolean paramBoolean)
    {
      this.si.setDeinterlace(paramBoolean);
    }
    
    public void setDeviceFile(File paramFile)
      throws PropertyVetoException
    {
      this.si.setDeviceFile(paramFile);
    }
    
    public void setDeviceFilename(String paramString)
      throws PropertyVetoException
    {
      this.si.setDeviceFilename(paramString);
    }
    
    public void setDeviceNumber(Integer paramInteger)
      throws PropertyVetoException
    {
      this.si.setDeviceNumber(paramInteger);
    }
    
    public void setDevicePath(String paramString)
      throws PropertyVetoException
    {
      this.si.setDevicePath(paramString);
    }
    
    public void setFormat(String paramString)
    {
      this.si.setFormat(paramString);
    }
    
    public void setFrameGrabber(Class<? extends FrameGrabber> paramClass)
    {
      this.si.setFrameGrabber(paramClass);
    }
    
    public void setFrameRate(double paramDouble)
    {
      this.si.setFrameRate(paramDouble);
    }
    
    public void setImageHeight(int paramInt)
    {
      this.si.setImageHeight(paramInt);
    }
    
    public void setImageMode(FrameGrabber.ImageMode paramImageMode)
    {
      this.si.setImageMode(paramImageMode);
    }
    
    public void setImageWidth(int paramInt)
    {
      this.si.setImageWidth(paramInt);
    }
    
    public void setName(String paramString)
    {
      this.si.setName(paramString);
    }
    
    public void setNumBuffers(int paramInt)
    {
      this.si.setNumBuffers(paramInt);
    }
    
    public void setResponseGamma(double paramDouble)
    {
      this.si.setResponseGamma(paramDouble);
    }
    
    public void setTimeout(int paramInt)
    {
      this.si.setTimeout(paramInt);
    }
    
    public void setTriggerMode(boolean paramBoolean)
    {
      this.si.setTriggerMode(paramBoolean);
    }
  }
  
  public static class CalibrationSettings
    extends ProjectiveDevice.CalibrationSettings
    implements Settings
  {
    SettingsImplementation si = new SettingsImplementation()
    {
      public void firePropertyChange(String paramAnonymousString, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        CalibrationSettings.this.firePropertyChange(paramAnonymousString, paramAnonymousObject1, paramAnonymousObject2);
      }
    };
    
    public CalibrationSettings() {}
    
    public CalibrationSettings(ProjectiveDevice.CalibrationSettings paramCalibrationSettings)
    {
      super();
      if ((paramCalibrationSettings instanceof CalibrationSettings)) {
        this.si = new SettingsImplementation(((CalibrationSettings)paramCalibrationSettings).si);
      }
    }
    
    public int getBitsPerPixel()
    {
      return this.si.getBitsPerPixel();
    }
    
    public String getDescription()
    {
      return this.si.getDescription();
    }
    
    public File getDeviceFile()
    {
      return this.si.getDeviceFile();
    }
    
    public String getDeviceFilename()
    {
      return this.si.getDeviceFilename();
    }
    
    public Integer getDeviceNumber()
    {
      return this.si.getDeviceNumber();
    }
    
    public String getDevicePath()
    {
      return this.si.getDevicePath();
    }
    
    public String getFormat()
    {
      return this.si.getFormat();
    }
    
    public Class<? extends FrameGrabber> getFrameGrabber()
    {
      return this.si.getFrameGrabber();
    }
    
    public double getFrameRate()
    {
      return this.si.getFrameRate();
    }
    
    public int getImageHeight()
    {
      return this.si.getImageHeight();
    }
    
    public FrameGrabber.ImageMode getImageMode()
    {
      return this.si.getImageMode();
    }
    
    public int getImageWidth()
    {
      return this.si.getImageWidth();
    }
    
    public String getName()
    {
      return this.si.getName();
    }
    
    public int getNumBuffers()
    {
      return this.si.getNumBuffers();
    }
    
    public double getResponseGamma()
    {
      return this.si.getResponseGamma();
    }
    
    public int getTimeout()
    {
      return this.si.getTimeout();
    }
    
    public boolean isDeinterlace()
    {
      return this.si.isDeinterlace();
    }
    
    public boolean isTriggerMode()
    {
      return this.si.isTriggerMode();
    }
    
    public void setBitsPerPixel(int paramInt)
    {
      this.si.setBitsPerPixel(paramInt);
    }
    
    public void setDeinterlace(boolean paramBoolean)
    {
      this.si.setDeinterlace(paramBoolean);
    }
    
    public void setDeviceFile(File paramFile)
      throws PropertyVetoException
    {
      this.si.setDeviceFile(paramFile);
    }
    
    public void setDeviceFilename(String paramString)
      throws PropertyVetoException
    {
      this.si.setDeviceFilename(paramString);
    }
    
    public void setDeviceNumber(Integer paramInteger)
      throws PropertyVetoException
    {
      this.si.setDeviceNumber(paramInteger);
    }
    
    public void setDevicePath(String paramString)
      throws PropertyVetoException
    {
      this.si.setDevicePath(paramString);
    }
    
    public void setFormat(String paramString)
    {
      this.si.setFormat(paramString);
    }
    
    public void setFrameGrabber(Class<? extends FrameGrabber> paramClass)
    {
      this.si.setFrameGrabber(paramClass);
    }
    
    public void setFrameRate(double paramDouble)
    {
      this.si.setFrameRate(paramDouble);
    }
    
    public void setImageHeight(int paramInt)
    {
      this.si.setImageHeight(paramInt);
    }
    
    public void setImageMode(FrameGrabber.ImageMode paramImageMode)
    {
      this.si.setImageMode(paramImageMode);
    }
    
    public void setImageWidth(int paramInt)
    {
      this.si.setImageWidth(paramInt);
    }
    
    public void setName(String paramString)
    {
      this.si.setName(paramString);
    }
    
    public void setNumBuffers(int paramInt)
    {
      this.si.setNumBuffers(paramInt);
    }
    
    public void setResponseGamma(double paramDouble)
    {
      this.si.setResponseGamma(paramDouble);
    }
    
    public void setTimeout(int paramInt)
    {
      this.si.setTimeout(paramInt);
    }
    
    public void setTriggerMode(boolean paramBoolean)
    {
      this.si.setTriggerMode(paramBoolean);
    }
  }
  
  public static abstract interface Settings
  {
    public abstract void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
    
    public abstract int getBitsPerPixel();
    
    public abstract String getDescription();
    
    public abstract File getDeviceFile();
    
    public abstract String getDeviceFilename();
    
    public abstract Integer getDeviceNumber();
    
    public abstract String getDevicePath();
    
    public abstract String getFormat();
    
    public abstract Class<? extends FrameGrabber> getFrameGrabber();
    
    public abstract double getFrameRate();
    
    public abstract int getImageHeight();
    
    public abstract FrameGrabber.ImageMode getImageMode();
    
    public abstract int getImageWidth();
    
    public abstract String getName();
    
    public abstract int getNumBuffers();
    
    public abstract double getResponseGamma();
    
    public abstract int getTimeout();
    
    public abstract boolean isDeinterlace();
    
    public abstract boolean isTriggerMode();
    
    public abstract void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
    
    public abstract void setBitsPerPixel(int paramInt);
    
    public abstract void setDeinterlace(boolean paramBoolean);
    
    public abstract void setDeviceFile(File paramFile)
      throws PropertyVetoException;
    
    public abstract void setDeviceFilename(String paramString)
      throws PropertyVetoException;
    
    public abstract void setDeviceNumber(Integer paramInteger)
      throws PropertyVetoException;
    
    public abstract void setDevicePath(String paramString)
      throws PropertyVetoException;
    
    public abstract void setFormat(String paramString);
    
    public abstract void setFrameGrabber(Class<? extends FrameGrabber> paramClass);
    
    public abstract void setFrameRate(double paramDouble);
    
    public abstract void setImageHeight(int paramInt);
    
    public abstract void setImageMode(FrameGrabber.ImageMode paramImageMode);
    
    public abstract void setImageWidth(int paramInt);
    
    public abstract void setName(String paramString);
    
    public abstract void setNumBuffers(int paramInt);
    
    public abstract void setResponseGamma(double paramDouble);
    
    public abstract void setTimeout(int paramInt);
    
    public abstract void setTriggerMode(boolean paramBoolean);
  }
  
  public static class SettingsImplementation
    extends ProjectiveDevice.Settings
    implements Settings
  {
    int bpp = 0;
    boolean deinterlace = false;
    File deviceFile = null;
    Integer deviceNumber = null;
    String devicePath = null;
    String format = "";
    Class<? extends FrameGrabber> frameGrabber = null;
    double frameRate = 0.0D;
    int imageHeight = 0;
    FrameGrabber.ImageMode imageMode = FrameGrabber.ImageMode.COLOR;
    int imageWidth = 0;
    int numBuffers = 4;
    int timeout = 10000;
    boolean triggerMode = false;
    
    public SettingsImplementation()
    {
      this.name = "Camera  0";
    }
    
    public SettingsImplementation(ProjectiveDevice.Settings paramSettings)
    {
      super();
      if ((paramSettings instanceof SettingsImplementation))
      {
        SettingsImplementation localSettingsImplementation = (SettingsImplementation)paramSettings;
        this.deviceNumber = localSettingsImplementation.deviceNumber;
        this.deviceFile = localSettingsImplementation.deviceFile;
        this.devicePath = localSettingsImplementation.devicePath;
        this.frameGrabber = localSettingsImplementation.frameGrabber;
        this.format = localSettingsImplementation.format;
        this.imageWidth = localSettingsImplementation.imageWidth;
        this.imageHeight = localSettingsImplementation.imageHeight;
        this.frameRate = localSettingsImplementation.frameRate;
        this.triggerMode = localSettingsImplementation.triggerMode;
        this.bpp = localSettingsImplementation.bpp;
        this.imageMode = localSettingsImplementation.imageMode;
        this.timeout = localSettingsImplementation.timeout;
        this.numBuffers = localSettingsImplementation.numBuffers;
        this.deinterlace = localSettingsImplementation.deinterlace;
      }
    }
    
    public int getBitsPerPixel()
    {
      return this.bpp;
    }
    
    public String getDescription()
    {
      try
      {
        arrayOfString = (String[])this.frameGrabber.getMethod("getDeviceDescriptions", new Class[0]).invoke(null, new Object[0]);
        if ((arrayOfString != null) && (this.deviceNumber != null) && (this.deviceNumber.intValue() < arrayOfString.length)) {
          return arrayOfString[this.deviceNumber.intValue()];
        }
        return "";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String[] arrayOfString = null;
        }
      }
    }
    
    public File getDeviceFile()
    {
      return this.deviceFile;
    }
    
    public String getDeviceFilename()
    {
      if (getDeviceFile() == null) {
        return "";
      }
      return getDeviceFile().getPath();
    }
    
    public Integer getDeviceNumber()
    {
      return this.deviceNumber;
    }
    
    public String getDevicePath()
    {
      return this.devicePath;
    }
    
    public String getFormat()
    {
      return this.format;
    }
    
    public Class<? extends FrameGrabber> getFrameGrabber()
    {
      return this.frameGrabber;
    }
    
    public double getFrameRate()
    {
      return this.frameRate;
    }
    
    public int getImageHeight()
    {
      return this.imageHeight;
    }
    
    public FrameGrabber.ImageMode getImageMode()
    {
      return this.imageMode;
    }
    
    public int getImageWidth()
    {
      return this.imageWidth;
    }
    
    public int getNumBuffers()
    {
      return this.numBuffers;
    }
    
    public int getTimeout()
    {
      return this.timeout;
    }
    
    public boolean isDeinterlace()
    {
      return this.deinterlace;
    }
    
    public boolean isTriggerMode()
    {
      return this.triggerMode;
    }
    
    public void setBitsPerPixel(int paramInt)
    {
      this.bpp = paramInt;
    }
    
    public void setDeinterlace(boolean paramBoolean)
    {
      this.deinterlace = paramBoolean;
    }
    
    public void setDeviceFile(File paramFile)
      throws PropertyVetoException
    {
      if (paramFile != null) {}
      try
      {
        if (this.frameGrabber != null) {
          this.frameGrabber.getConstructor(new Class[] { File.class });
        }
        setDeviceNumber(null);
        setDevicePath(null);
        String str1 = getDescription();
        File localFile1 = this.deviceFile;
        this.deviceFile = paramFile;
        firePropertyChange("deviceFile", localFile1, paramFile);
        firePropertyChange("description", str1, getDescription());
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        String str2 = this.frameGrabber.getSimpleName() + " does not accept a deviceFile.";
        File localFile2 = this.deviceFile;
        this.deviceFile = null;
        throw new BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes(str2, new PropertyChangeEvent(this, "deviceFile", localFile2, null));
      }
    }
    
    public void setDeviceFilename(String paramString)
      throws PropertyVetoException
    {
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (File localFile = null;; localFile = new File(paramString))
      {
        setDeviceFile(localFile);
        return;
      }
    }
    
    /* Error */
    public void setDeviceNumber(Integer paramInteger)
      throws PropertyVetoException
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +51 -> 52
      //   4: aload_0
      //   5: getfield 41	com/googlecode/javacv/CameraDevice$SettingsImplementation:frameGrabber	Ljava/lang/Class;
      //   8: astore 7
      //   10: aload 7
      //   12: ifnull +30 -> 42
      //   15: aload_0
      //   16: getfield 41	com/googlecode/javacv/CameraDevice$SettingsImplementation:frameGrabber	Ljava/lang/Class;
      //   19: astore 10
      //   21: iconst_1
      //   22: anewarray 86	java/lang/Class
      //   25: astore 11
      //   27: aload 11
      //   29: iconst_0
      //   30: getstatic 201	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   33: aastore
      //   34: aload 10
      //   36: aload 11
      //   38: invokevirtual 146	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
      //   41: pop
      //   42: aload_0
      //   43: aconst_null
      //   44: invokevirtual 154	com/googlecode/javacv/CameraDevice$SettingsImplementation:setDevicePath	(Ljava/lang/String;)V
      //   47: aload_0
      //   48: aconst_null
      //   49: invokevirtual 196	com/googlecode/javacv/CameraDevice$SettingsImplementation:setDeviceFile	(Ljava/io/File;)V
      //   52: aload_0
      //   53: invokevirtual 156	com/googlecode/javacv/CameraDevice$SettingsImplementation:getDescription	()Ljava/lang/String;
      //   56: astore_2
      //   57: aload_0
      //   58: getfield 35	com/googlecode/javacv/CameraDevice$SettingsImplementation:deviceNumber	Ljava/lang/Integer;
      //   61: astore_3
      //   62: aload_0
      //   63: aload_1
      //   64: putfield 35	com/googlecode/javacv/CameraDevice$SettingsImplementation:deviceNumber	Ljava/lang/Integer;
      //   67: aload_0
      //   68: ldc -54
      //   70: aload_3
      //   71: aload_1
      //   72: invokevirtual 161	com/googlecode/javacv/CameraDevice$SettingsImplementation:firePropertyChange	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   75: aload_0
      //   76: ldc -93
      //   78: aload_2
      //   79: aload_0
      //   80: invokevirtual 156	com/googlecode/javacv/CameraDevice$SettingsImplementation:getDescription	()Ljava/lang/String;
      //   83: invokevirtual 161	com/googlecode/javacv/CameraDevice$SettingsImplementation:firePropertyChange	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   86: return
      //   87: astore 8
      //   89: aload_0
      //   90: getfield 41	com/googlecode/javacv/CameraDevice$SettingsImplementation:frameGrabber	Ljava/lang/Class;
      //   93: iconst_1
      //   94: anewarray 86	java/lang/Class
      //   97: dup
      //   98: iconst_0
      //   99: ldc 102
      //   101: aastore
      //   102: invokevirtual 146	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
      //   105: pop
      //   106: goto -64 -> 42
      //   109: astore 4
      //   111: new 165	java/lang/StringBuilder
      //   114: dup
      //   115: invokespecial 166	java/lang/StringBuilder:<init>	()V
      //   118: aload_0
      //   119: getfield 41	com/googlecode/javacv/CameraDevice$SettingsImplementation:frameGrabber	Ljava/lang/Class;
      //   122: invokevirtual 169	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   125: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   128: ldc -52
      //   130: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   133: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   136: astore 5
      //   138: aload_0
      //   139: getfield 35	com/googlecode/javacv/CameraDevice$SettingsImplementation:deviceNumber	Ljava/lang/Integer;
      //   142: astore 6
      //   144: aload_0
      //   145: aconst_null
      //   146: putfield 35	com/googlecode/javacv/CameraDevice$SettingsImplementation:deviceNumber	Ljava/lang/Integer;
      //   149: new 180	com/googlecode/javacv/BaseChildSettings$PropertyVetoExceptionThatNetBeansLikes
      //   152: dup
      //   153: aload 5
      //   155: new 182	java/beans/PropertyChangeEvent
      //   158: dup
      //   159: aload_0
      //   160: ldc -54
      //   162: aload 6
      //   164: aconst_null
      //   165: invokespecial 185	java/beans/PropertyChangeEvent:<init>	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   168: invokespecial 188	com/googlecode/javacv/BaseChildSettings$PropertyVetoExceptionThatNetBeansLikes:<init>	(Ljava/lang/String;Ljava/beans/PropertyChangeEvent;)V
      //   171: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	172	0	this	SettingsImplementation
      //   0	172	1	paramInteger	Integer
      //   56	23	2	str1	String
      //   61	10	3	localInteger1	Integer
      //   109	1	4	localNoSuchMethodException1	NoSuchMethodException
      //   136	18	5	str2	String
      //   142	21	6	localInteger2	Integer
      //   8	3	7	localClass1	Class
      //   87	1	8	localNoSuchMethodException2	NoSuchMethodException
      //   19	16	10	localClass2	Class
      //   25	12	11	arrayOfClass	Class[]
      // Exception table:
      //   from	to	target	type
      //   15	42	87	java/lang/NoSuchMethodException
      //   4	10	109	java/lang/NoSuchMethodException
      //   42	52	109	java/lang/NoSuchMethodException
      //   89	106	109	java/lang/NoSuchMethodException
    }
    
    public void setDevicePath(String paramString)
      throws PropertyVetoException
    {
      if (paramString != null) {}
      try
      {
        if (this.frameGrabber != null) {
          this.frameGrabber.getConstructor(new Class[] { String.class });
        }
        setDeviceNumber(null);
        setDeviceFile(null);
        String str1 = getDescription();
        String str2 = this.devicePath;
        this.devicePath = paramString;
        firePropertyChange("devicePath", str2, paramString);
        firePropertyChange("description", str1, getDescription());
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        String str3 = this.frameGrabber.getSimpleName() + " does not accept a devicePath.";
        String str4 = this.devicePath;
        this.devicePath = null;
        throw new BaseChildSettings.PropertyVetoExceptionThatNetBeansLikes(str3, new PropertyChangeEvent(this, "devicePath", str4, null));
      }
    }
    
    public void setFormat(String paramString)
    {
      this.format = paramString;
    }
    
    public void setFrameGrabber(Class<? extends FrameGrabber> paramClass)
    {
      String str1 = getDescription();
      Class localClass = this.frameGrabber;
      this.frameGrabber = paramClass;
      firePropertyChange("frameGrabber", localClass, paramClass);
      firePropertyChange("description", str1, getDescription());
      if (paramClass == null)
      {
        Integer localInteger2 = this.deviceNumber;
        this.deviceNumber = null;
        firePropertyChange("deviceNumber", localInteger2, null);
        File localFile2 = this.deviceFile;
        this.deviceFile = null;
        firePropertyChange("deviceFile", localFile2, null);
        String str3 = this.devicePath;
        this.devicePath = null;
        firePropertyChange("devicePath", str3, null);
      }
      for (;;)
      {
        return;
        try
        {
          Class[] arrayOfClass = new Class[1];
          arrayOfClass[0] = Integer.TYPE;
          paramClass.getConstructor(arrayOfClass);
          i = 1;
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          try
          {
            paramClass.getConstructor(new Class[] { File.class });
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            try
            {
              for (;;)
              {
                int i;
                paramClass.getConstructor(new Class[] { String.class });
                if ((i == 0) || (this.deviceNumber != null) || (this.deviceFile != null) || (this.devicePath != null)) {
                  break;
                }
                try
                {
                  setDeviceNumber(Integer.valueOf(0));
                  return;
                }
                catch (PropertyVetoException localPropertyVetoException)
                {
                  return;
                }
                localNoSuchMethodException1 = localNoSuchMethodException1;
                try
                {
                  paramClass.getConstructor(new Class[] { Integer.class });
                  i = 1;
                }
                catch (NoSuchMethodException localNoSuchMethodException2)
                {
                  Integer localInteger1 = this.deviceNumber;
                  this.deviceNumber = null;
                  firePropertyChange("deviceNumber", localInteger1, null);
                  i = 0;
                }
                continue;
                localNoSuchMethodException3 = localNoSuchMethodException3;
                File localFile1 = this.deviceFile;
                this.deviceFile = null;
                firePropertyChange("deviceFile", localFile1, null);
              }
            }
            catch (NoSuchMethodException localNoSuchMethodException4)
            {
              for (;;)
              {
                String str2 = this.devicePath;
                this.devicePath = null;
                firePropertyChange("devicePath", str2, null);
              }
            }
          }
        }
      }
    }
    
    public void setFrameRate(double paramDouble)
    {
      this.frameRate = paramDouble;
    }
    
    public void setImageHeight(int paramInt)
    {
      this.imageHeight = paramInt;
    }
    
    public void setImageMode(FrameGrabber.ImageMode paramImageMode)
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
    
    public void setTimeout(int paramInt)
    {
      this.timeout = paramInt;
    }
    
    public void setTriggerMode(boolean paramBoolean)
    {
      this.triggerMode = paramBoolean;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\CameraDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */