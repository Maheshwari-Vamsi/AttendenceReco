package com.example.ranjith.attendencereco.googlecode.javacv;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProjectorSettings
  extends BaseSettings
{
  boolean calibrated = false;
  
  public ProjectorSettings()
  {
    this(false);
  }
  
  public ProjectorSettings(boolean paramBoolean)
  {
    this.calibrated = paramBoolean;
  }
  
  public int getQuantity()
  {
    return size();
  }
  
  public void setQuantity(int paramInt)
  {
    ProjectorDevice.Settings[] arrayOfSettings = toArray();
    int i = arrayOfSettings.length;
    while (i > paramInt)
    {
      remove(arrayOfSettings[(i - 1)]);
      i--;
      continue;
      i++;
    }
    if (i < paramInt)
    {
      if (this.calibrated) {}
      for (Object localObject = new ProjectorDevice.CalibratedSettings();; localObject = new ProjectorDevice.CalibrationSettings())
      {
        ProjectorDevice.Settings localSettings = (ProjectorDevice.Settings)localObject;
        StringBuilder localStringBuilder = new StringBuilder().append("Projector ");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i);
        localSettings.setName(String.format("%2d", arrayOfObject));
        localSettings.setScreenNumber(i + localSettings.getScreenNumber());
        add(localSettings);
        for (PropertyChangeListener localPropertyChangeListener : this.pcSupport.getPropertyChangeListeners()) {
          ((BaseChildSettings)localSettings).addPropertyChangeListener(localPropertyChangeListener);
        }
        break;
      }
    }
    this.pcSupport.firePropertyChange("quantity", arrayOfSettings.length, paramInt);
  }
  
  public ProjectorDevice.Settings[] toArray()
  {
    return (ProjectorDevice.Settings[])toArray(new ProjectorDevice.Settings[size()]);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProjectorSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */