package com.google.android.gms.dynamic;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class zze<T>
  extends zzd.zza
{
  private final T mWrappedObject;
  
  private zze(T paramT)
  {
    this.mWrappedObject = paramT;
  }
  
  public static <T> zzd zzB(T paramT)
  {
    return new zze(paramT);
  }
  
  public static <T> T zzp(zzd paramzzd)
  {
    if ((paramzzd instanceof zze)) {
      return (T)((zze)paramzzd).mWrappedObject;
    }
    IBinder localIBinder = paramzzd.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    if (arrayOfField.length == 1)
    {
      Field localField = arrayOfField[0];
      if (!localField.isAccessible())
      {
        localField.setAccessible(true);
        try
        {
          Object localObject = localField.get(localIBinder);
          return (T)localObject;
        }
        catch (NullPointerException localNullPointerException)
        {
          throw new IllegalArgumentException("Binder object is null.", localNullPointerException);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", localIllegalArgumentException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", localIllegalAccessException);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\dynamic\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */