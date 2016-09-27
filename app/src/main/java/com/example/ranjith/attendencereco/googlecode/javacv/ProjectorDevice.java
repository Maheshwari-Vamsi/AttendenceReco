package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvFileNode;
import com.googlecode.javacv.cpp.opencv_core.CvFileStorage;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProjectorDevice
  extends ProjectiveDevice
{
  private static ThreadLocal<opencv_core.CvMat> B4x3 = opencv_core.CvMat.createThreadLocal(4, 3);
  private static ThreadLocal<opencv_core.CvMat> x23x1 = opencv_core.CvMat.createThreadLocal(3, 1);
  private static ThreadLocal<opencv_core.CvMat> x34x1 = opencv_core.CvMat.createThreadLocal(4, 1);
  private Settings settings;
  
  public ProjectorDevice(Settings paramSettings)
    throws ProjectiveDevice.Exception
  {
    super((ProjectiveDevice.Settings)paramSettings);
  }
  
  public ProjectorDevice(String paramString)
  {
    super(paramString);
  }
  
  public ProjectorDevice(String paramString, opencv_core.CvFileStorage paramCvFileStorage)
    throws ProjectiveDevice.Exception
  {
    super(paramString, paramCvFileStorage);
    this.settings.setImageWidth(this.imageWidth);
    this.settings.setImageHeight(this.imageHeight);
  }
  
  public ProjectorDevice(String paramString1, String paramString2)
    throws ProjectiveDevice.Exception
  {
    super(paramString1, paramString2);
    this.settings.setImageWidth(this.imageWidth);
    this.settings.setImageHeight(this.imageHeight);
  }
  
  public static ProjectorDevice[] read(opencv_core.CvFileStorage paramCvFileStorage)
    throws ProjectiveDevice.Exception
  {
    opencv_core.CvSeq localCvSeq = opencv_core.cvGetFileNodeByName(paramCvFileStorage, null, "Projectors").data_seq();
    int i = localCvSeq.total();
    ProjectorDevice[] arrayOfProjectorDevice = new ProjectorDevice[i];
    int j = 0;
    if (j < i)
    {
      Pointer localPointer = opencv_core.cvGetSeqElem(localCvSeq, j);
      if (localPointer == null) {}
      for (;;)
      {
        j++;
        break;
        arrayOfProjectorDevice[j] = new ProjectorDevice(opencv_core.cvReadString(new opencv_core.CvFileNode(localPointer), null), paramCvFileStorage);
      }
    }
    return arrayOfProjectorDevice;
  }
  
  public static ProjectorDevice[] read(String paramString)
    throws ProjectiveDevice.Exception
  {
    opencv_core.CvFileStorage localCvFileStorage = opencv_core.CvFileStorage.open(paramString, null, 0);
    ProjectorDevice[] arrayOfProjectorDevice = read(localCvFileStorage);
    localCvFileStorage.release();
    return arrayOfProjectorDevice;
  }
  
  public CanvasFrame createCanvasFrame()
    throws CanvasFrame.Exception
  {
    CanvasFrame localCanvasFrame;
    if (this.settings.getScreenNumber() < 0) {
      localCanvasFrame = null;
    }
    label330:
    Dimension localDimension;
    do
    {
      return localCanvasFrame;
      DisplayMode localDisplayMode = new DisplayMode(this.settings.getImageWidth(), this.settings.getImageHeight(), this.settings.getBitDepth(), this.settings.getRefreshRate());
      Object localObject = null;
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder().append(CanvasFrame.class.getPackage().getName());
          if (!this.settings.isUseOpenGL()) {
            continue;
          }
          str = ".GLCanvasFrame";
          Class localClass = Class.forName(str).asSubclass(CanvasFrame.class);
          Class[] arrayOfClass = new Class[4];
          arrayOfClass[0] = String.class;
          arrayOfClass[1] = Integer.TYPE;
          arrayOfClass[2] = DisplayMode.class;
          arrayOfClass[3] = Double.TYPE;
          Constructor localConstructor = localClass.getConstructor(arrayOfClass);
          Object[] arrayOfObject = new Object[4];
          arrayOfObject[0] = this.settings.getName();
          arrayOfObject[1] = Integer.valueOf(this.settings.getScreenNumber());
          arrayOfObject[2] = localDisplayMode;
          arrayOfObject[3] = Double.valueOf(this.settings.getResponseGamma());
          localCanvasFrame = (CanvasFrame)localConstructor.newInstance(arrayOfObject);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          String str;
          localObject = localClassNotFoundException;
          localCanvasFrame = null;
          continue;
        }
        catch (InstantiationException localInstantiationException)
        {
          localObject = localInstantiationException;
          localCanvasFrame = null;
          continue;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localObject = localIllegalAccessException;
          localCanvasFrame = null;
          continue;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject = localIllegalArgumentException;
          localCanvasFrame = null;
          continue;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          localObject = localNoSuchMethodException;
          localCanvasFrame = null;
          continue;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localObject = localInvocationTargetException.getCause();
          localCanvasFrame = null;
          continue;
        }
        if (localObject == null) {
          break label330;
        }
        if (!(localObject instanceof CanvasFrame.Exception)) {
          break;
        }
        throw ((CanvasFrame.Exception)localObject);
        str = ".CanvasFrame";
      }
      throw new CanvasFrame.Exception("Failed to create CanvasFrame", (Throwable)localObject);
      localCanvasFrame.setLatency(this.settings.getLatency());
      localDimension = localCanvasFrame.getCanvasSize();
    } while ((localDimension.width == this.imageWidth) && (localDimension.height == this.imageHeight));
    rescale(localDimension.width, localDimension.height);
    return localCanvasFrame;
  }
  
  public double getAttenuation(double paramDouble1, double paramDouble2, opencv_core.CvMat paramCvMat, double paramDouble3)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)B4x3.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)x23x1.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)x34x1.get();
    getBackProjectionMatrix(paramCvMat, paramDouble3, localCvMat1);
    localCvMat2.put(new double[] { paramDouble1, paramDouble2, 1.0D });
    opencv_core.cvMatMul(localCvMat1, localCvMat2, localCvMat3);
    opencv_core.cvGEMM(this.R, this.T, -1.0D, null, 0.0D, localCvMat2, 1);
    localCvMat3.rows(3);
    opencv_core.cvAddWeighted(localCvMat3, 1.0D / localCvMat3.get(3), localCvMat2, -1.0D, 0.0D, localCvMat2);
    double d1 = opencv_core.cvDotProduct(localCvMat2, localCvMat2);
    double d2 = Math.sqrt(d1);
    double d3 = -Math.signum(paramDouble3) * opencv_core.cvDotProduct(localCvMat2, paramCvMat) / (d2 * Math.sqrt(opencv_core.cvDotProduct(paramCvMat, paramCvMat))) / d1;
    localCvMat3.rows(4);
    return d3;
  }
  
  public ProjectiveDevice.Settings getSettings()
  {
    return (ProjectiveDevice.Settings)this.settings;
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
        StringBuilder localStringBuilder = new StringBuilder().append("Projector ");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(this.settings.getScreenNumber());
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
  
  public void setSettings(Settings paramSettings)
  {
    setSettings((ProjectiveDevice.Settings)paramSettings);
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
    
    public int getBitDepth()
    {
      return this.si.getBitDepth();
    }
    
    public String getDescription()
    {
      return this.si.getDescription();
    }
    
    public int getImageHeight()
    {
      return this.si.getImageHeight();
    }
    
    public int getImageWidth()
    {
      return this.si.getImageWidth();
    }
    
    public long getLatency()
    {
      return this.si.getLatency();
    }
    
    public String getName()
    {
      return this.si.getName();
    }
    
    public int getRefreshRate()
    {
      return this.si.getRefreshRate();
    }
    
    public double getResponseGamma()
    {
      return this.si.getResponseGamma();
    }
    
    public int getScreenNumber()
    {
      return this.si.getScreenNumber();
    }
    
    public boolean isUseOpenGL()
    {
      return this.si.isUseOpenGL();
    }
    
    public void setBitDepth(int paramInt)
    {
      this.si.setBitDepth(paramInt);
    }
    
    public void setImageHeight(int paramInt)
    {
      this.si.setImageHeight(paramInt);
    }
    
    public void setImageWidth(int paramInt)
    {
      this.si.setImageWidth(paramInt);
    }
    
    public void setLatency(long paramLong)
    {
      this.si.setLatency(paramLong);
    }
    
    public void setName(String paramString)
    {
      this.si.setName(paramString);
    }
    
    public void setRefreshRate(int paramInt)
    {
      this.si.setRefreshRate(paramInt);
    }
    
    public void setResponseGamma(double paramDouble)
    {
      this.si.setResponseGamma(paramDouble);
    }
    
    public void setScreenNumber(int paramInt)
    {
      this.si.setScreenNumber(paramInt);
    }
    
    public void setUseOpenGL(boolean paramBoolean)
    {
      this.si.setUseOpenGL(paramBoolean);
    }
  }
  
  public static class CalibrationSettings
    extends ProjectiveDevice.CalibrationSettings
    implements Settings
  {
    double brightnessBackground = 0.0D;
    double brightnessForeground = 1.0D;
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
      if ((paramCalibrationSettings instanceof CalibrationSettings))
      {
        CalibrationSettings localCalibrationSettings = (CalibrationSettings)paramCalibrationSettings;
        this.si = new SettingsImplementation(localCalibrationSettings.si);
        this.brightnessBackground = localCalibrationSettings.brightnessBackground;
        this.brightnessForeground = localCalibrationSettings.brightnessForeground;
      }
    }
    
    public int getBitDepth()
    {
      return this.si.getBitDepth();
    }
    
    public double getBrightnessBackground()
    {
      return this.brightnessBackground;
    }
    
    public double getBrightnessForeground()
    {
      return this.brightnessForeground;
    }
    
    public String getDescription()
    {
      return this.si.getDescription();
    }
    
    public int getImageHeight()
    {
      return this.si.getImageHeight();
    }
    
    public int getImageWidth()
    {
      return this.si.getImageWidth();
    }
    
    public long getLatency()
    {
      return this.si.getLatency();
    }
    
    public String getName()
    {
      return this.si.getName();
    }
    
    public int getRefreshRate()
    {
      return this.si.getRefreshRate();
    }
    
    public double getResponseGamma()
    {
      return this.si.getResponseGamma();
    }
    
    public int getScreenNumber()
    {
      return this.si.getScreenNumber();
    }
    
    public boolean isUseOpenGL()
    {
      return this.si.isUseOpenGL();
    }
    
    public void setBitDepth(int paramInt)
    {
      this.si.setBitDepth(paramInt);
    }
    
    public void setBrightnessBackground(double paramDouble)
    {
      Double localDouble = Double.valueOf(this.brightnessBackground);
      this.brightnessBackground = paramDouble;
      firePropertyChange("brightnessBackground", localDouble, Double.valueOf(paramDouble));
    }
    
    public void setBrightnessForeground(double paramDouble)
    {
      Double localDouble = Double.valueOf(this.brightnessForeground);
      this.brightnessForeground = paramDouble;
      firePropertyChange("brightnessForeground", localDouble, Double.valueOf(paramDouble));
    }
    
    public void setImageHeight(int paramInt)
    {
      this.si.setImageHeight(paramInt);
    }
    
    public void setImageWidth(int paramInt)
    {
      this.si.setImageWidth(paramInt);
    }
    
    public void setLatency(long paramLong)
    {
      this.si.setLatency(paramLong);
    }
    
    public void setName(String paramString)
    {
      this.si.setName(paramString);
    }
    
    public void setRefreshRate(int paramInt)
    {
      this.si.setRefreshRate(paramInt);
    }
    
    public void setResponseGamma(double paramDouble)
    {
      this.si.setResponseGamma(paramDouble);
    }
    
    public void setScreenNumber(int paramInt)
    {
      this.si.setScreenNumber(paramInt);
    }
    
    public void setUseOpenGL(boolean paramBoolean)
    {
      this.si.setUseOpenGL(paramBoolean);
    }
  }
  
  public static abstract interface Settings
  {
    public abstract void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
    
    public abstract int getBitDepth();
    
    public abstract String getDescription();
    
    public abstract int getImageHeight();
    
    public abstract int getImageWidth();
    
    public abstract long getLatency();
    
    public abstract String getName();
    
    public abstract int getRefreshRate();
    
    public abstract double getResponseGamma();
    
    public abstract int getScreenNumber();
    
    public abstract boolean isUseOpenGL();
    
    public abstract void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
    
    public abstract void setBitDepth(int paramInt);
    
    public abstract void setImageHeight(int paramInt);
    
    public abstract void setImageWidth(int paramInt);
    
    public abstract void setLatency(long paramLong);
    
    public abstract void setName(String paramString);
    
    public abstract void setRefreshRate(int paramInt);
    
    public abstract void setResponseGamma(double paramDouble);
    
    public abstract void setScreenNumber(int paramInt);
    
    public abstract void setUseOpenGL(boolean paramBoolean);
  }
  
  public static class SettingsImplementation
    extends ProjectiveDevice.Settings
    implements Settings
  {
    int bitDepth;
    int imageHeight;
    int imageWidth;
    long latency;
    int refreshRate;
    int screenNumber;
    private boolean useOpenGL;
    
    public SettingsImplementation()
    {
      if (CanvasFrame.getScreenDevices().length > i) {}
      for (;;)
      {
        this.screenNumber = i;
        this.latency = 200L;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.bitDepth = 0;
        this.refreshRate = 0;
        this.useOpenGL = false;
        this.name = "Projector  0";
        setScreenNumber(this.screenNumber);
        return;
        i = 0;
      }
    }
    
    public SettingsImplementation(ProjectiveDevice.Settings paramSettings)
    {
      super();
      if (CanvasFrame.getScreenDevices().length > i) {}
      for (;;)
      {
        this.screenNumber = i;
        this.latency = 200L;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.bitDepth = 0;
        this.refreshRate = 0;
        this.useOpenGL = false;
        if ((paramSettings instanceof SettingsImplementation))
        {
          SettingsImplementation localSettingsImplementation = (SettingsImplementation)paramSettings;
          this.screenNumber = localSettingsImplementation.screenNumber;
          this.latency = localSettingsImplementation.latency;
          this.imageWidth = localSettingsImplementation.imageWidth;
          this.imageHeight = localSettingsImplementation.imageHeight;
          this.bitDepth = localSettingsImplementation.bitDepth;
          this.refreshRate = localSettingsImplementation.refreshRate;
          this.useOpenGL = localSettingsImplementation.useOpenGL;
        }
        return;
        i = 0;
      }
    }
    
    public int getBitDepth()
    {
      return this.bitDepth;
    }
    
    public String getDescription()
    {
      String[] arrayOfString = CanvasFrame.getScreenDescriptions();
      if ((arrayOfString != null) && (this.screenNumber >= 0) && (this.screenNumber < arrayOfString.length)) {
        return arrayOfString[this.screenNumber];
      }
      return "";
    }
    
    public int getImageHeight()
    {
      return this.imageHeight;
    }
    
    public int getImageWidth()
    {
      return this.imageWidth;
    }
    
    public long getLatency()
    {
      return this.latency;
    }
    
    public int getRefreshRate()
    {
      return this.refreshRate;
    }
    
    public int getScreenNumber()
    {
      return this.screenNumber;
    }
    
    public boolean isUseOpenGL()
    {
      return this.useOpenGL;
    }
    
    public void setBitDepth(int paramInt)
    {
      this.bitDepth = paramInt;
    }
    
    public void setImageHeight(int paramInt)
    {
      Integer localInteger = Integer.valueOf(this.imageHeight);
      this.imageHeight = paramInt;
      firePropertyChange("imageHeight", localInteger, Integer.valueOf(paramInt));
    }
    
    public void setImageWidth(int paramInt)
    {
      Integer localInteger = Integer.valueOf(this.imageWidth);
      this.imageWidth = paramInt;
      firePropertyChange("imageWidth", localInteger, Integer.valueOf(paramInt));
    }
    
    public void setLatency(long paramLong)
    {
      this.latency = paramLong;
    }
    
    public void setRefreshRate(int paramInt)
    {
      this.refreshRate = paramInt;
    }
    
    public void setScreenNumber(int paramInt)
    {
      DisplayMode localDisplayMode = CanvasFrame.getDisplayMode(paramInt);
      String str = getDescription();
      Integer localInteger1 = Integer.valueOf(this.screenNumber);
      this.screenNumber = paramInt;
      firePropertyChange("screenNumber", localInteger1, Integer.valueOf(paramInt));
      firePropertyChange("description", str, getDescription());
      Integer localInteger2 = Integer.valueOf(this.imageWidth);
      int i;
      int j;
      label98:
      int k;
      label133:
      Integer localInteger5;
      int m;
      if (localDisplayMode == null)
      {
        i = 0;
        this.imageWidth = i;
        firePropertyChange("imageWidth", localInteger2, Integer.valueOf(i));
        Integer localInteger3 = Integer.valueOf(this.imageHeight);
        if (localDisplayMode != null) {
          break label231;
        }
        j = 0;
        this.imageHeight = j;
        firePropertyChange("imageHeight", localInteger3, Integer.valueOf(j));
        Integer localInteger4 = Integer.valueOf(this.bitDepth);
        if (localDisplayMode != null) {
          break label240;
        }
        k = 0;
        this.bitDepth = k;
        firePropertyChange("bitDepth", localInteger4, Integer.valueOf(k));
        localInteger5 = Integer.valueOf(this.refreshRate);
        m = 0;
        if (localDisplayMode != null) {
          break label249;
        }
      }
      for (;;)
      {
        this.refreshRate = m;
        firePropertyChange("refreshRate", localInteger5, Integer.valueOf(m));
        Double localDouble = Double.valueOf(this.responseGamma);
        double d = CanvasFrame.getGamma(paramInt);
        this.responseGamma = d;
        firePropertyChange("responseGamma", localDouble, Double.valueOf(d));
        return;
        i = localDisplayMode.getWidth();
        break;
        label231:
        j = localDisplayMode.getHeight();
        break label98;
        label240:
        k = localDisplayMode.getBitDepth();
        break label133;
        label249:
        m = localDisplayMode.getRefreshRate();
      }
    }
    
    public void setUseOpenGL(boolean paramBoolean)
    {
      this.useOpenGL = paramBoolean;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProjectorDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */