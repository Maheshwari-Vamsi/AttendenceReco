package com.example.ranjith.attendencereco.googlecode.javacv;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.beancontext.BeanContextChildSupport;
import java.util.ListResourceBundle;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class BaseChildSettings
  extends BeanContextChildSupport
  implements Comparable<BaseChildSettings>
{
  public void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    this.pcSupport.addPropertyChangeListener(paramPropertyChangeListener);
  }
  
  public int compareTo(BaseChildSettings paramBaseChildSettings)
  {
    return getName().compareTo(paramBaseChildSettings.getName());
  }
  
  protected String getName()
  {
    return "";
  }
  
  public void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    this.pcSupport.removePropertyChangeListener(paramPropertyChangeListener);
  }
  
  public static class PropertyVetoExceptionThatNetBeansLikes
    extends PropertyVetoException
    implements Callable
  {
    public PropertyVetoExceptionThatNetBeansLikes(String paramString, PropertyChangeEvent paramPropertyChangeEvent)
    {
      super(paramPropertyChangeEvent);
    }
    
    public Object call()
      throws Exception
    {
      LogRecord localLogRecord = new LogRecord(Level.ALL, getMessage());
      localLogRecord.setResourceBundle(new ListResourceBundle()
      {
        protected Object[][] getContents()
        {
          Object[][] arrayOfObject = new Object[1][];
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = PropertyVetoExceptionThatNetBeansLikes.this.getMessage();
          arrayOfObject1[1] = PropertyVetoExceptionThatNetBeansLikes.this.getMessage();
          arrayOfObject[0] = arrayOfObject1;
          return arrayOfObject;
        }
      });
      return new LogRecord[] { localLogRecord };
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\BaseChildSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */