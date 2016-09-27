package com.example.ranjith.attendencereco.googlecode.javacv;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;

public class CameraSettings
  extends BaseSettings
{
  boolean calibrated = false;
  Class<? extends FrameGrabber> frameGrabber = null;
  double monitorWindowsScale = 1.0D;
  
  public CameraSettings()
  {
    this(false);
  }
  
  public CameraSettings(boolean paramBoolean)
  {
    this.calibrated = paramBoolean;
  }
  
  public Class<? extends FrameGrabber> getFrameGrabber()
  {
    return this.frameGrabber;
  }
  
  public double getMonitorWindowsScale()
  {
    return this.monitorWindowsScale;
  }
  
  public int getQuantity()
  {
    return size();
  }
  
  public void setFrameGrabber(Class<? extends FrameGrabber> paramClass)
  {
    PropertyChangeSupport localPropertyChangeSupport = this.pcSupport;
    Class localClass = this.frameGrabber;
    this.frameGrabber = paramClass;
    localPropertyChangeSupport.firePropertyChange("frameGrabber", localClass, paramClass);
  }
  
  public void setMonitorWindowsScale(double paramDouble)
  {
    this.monitorWindowsScale = paramDouble;
  }
  
  public void setQuantity(int paramInt)
    throws PropertyVetoException
  {
    int i = Math.max(1, paramInt);
    CameraDevice.Settings[] arrayOfSettings = toArray();
    for (int j = arrayOfSettings.length; j > i; j--) {
      remove(arrayOfSettings[(j - 1)]);
    }
    if (j < i)
    {
      if (this.calibrated) {}
      for (Object localObject = new CameraDevice.CalibratedSettings();; localObject = new CameraDevice.CalibrationSettings())
      {
        CameraDevice.Settings localSettings = (CameraDevice.Settings)localObject;
        StringBuilder localStringBuilder = new StringBuilder().append("Camera ");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(j);
        localSettings.setName(String.format("%2d", arrayOfObject));
        localSettings.setDeviceNumber(Integer.valueOf(j));
        localSettings.setFrameGrabber(this.frameGrabber);
        add(localSettings);
        j++;
        break;
      }
    }
    this.pcSupport.firePropertyChange("quantity", arrayOfSettings.length, i);
  }
  
  public CameraDevice.Settings[] toArray()
  {
    return (CameraDevice.Settings[])toArray(new CameraDevice.Settings[size()]);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\CameraSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */