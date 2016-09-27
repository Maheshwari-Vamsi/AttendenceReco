package com.example.ranjith.attendencereco.googlecode.javacv;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.beancontext.BeanContextSupport;
import java.util.Arrays;

public class BaseSettings
  extends BeanContextSupport
  implements Comparable<BaseSettings>
{
  public void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    this.pcSupport.addPropertyChangeListener(paramPropertyChangeListener);
    Object[] arrayOfObject = toArray();
    int i = arrayOfObject.length;
    int j = 0;
    if (j < i)
    {
      Object localObject = arrayOfObject[j];
      if ((localObject instanceof BaseChildSettings)) {
        ((BaseChildSettings)localObject).addPropertyChangeListener(paramPropertyChangeListener);
      }
      for (;;)
      {
        j++;
        break;
        if ((localObject instanceof BaseSettings)) {
          ((BaseSettings)localObject).addPropertyChangeListener(paramPropertyChangeListener);
        }
      }
    }
  }
  
  public int compareTo(BaseSettings paramBaseSettings)
  {
    return getName().compareTo(paramBaseSettings.getName());
  }
  
  protected String getName()
  {
    return "";
  }
  
  public void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    this.pcSupport.removePropertyChangeListener(paramPropertyChangeListener);
    Object[] arrayOfObject = toArray();
    int i = arrayOfObject.length;
    int j = 0;
    if (j < i)
    {
      Object localObject = arrayOfObject[j];
      if ((localObject instanceof BaseChildSettings)) {
        ((BaseChildSettings)localObject).removePropertyChangeListener(paramPropertyChangeListener);
      }
      for (;;)
      {
        j++;
        break;
        if ((localObject instanceof BaseSettings)) {
          ((BaseSettings)localObject).addPropertyChangeListener(paramPropertyChangeListener);
        }
      }
    }
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = super.toArray();
    Arrays.sort(arrayOfObject);
    return arrayOfObject;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = super.toArray(paramArrayOfObject);
    Arrays.sort(arrayOfObject);
    return arrayOfObject;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\BaseSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */