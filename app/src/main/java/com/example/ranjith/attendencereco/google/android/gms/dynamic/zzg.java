package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

public abstract class zzg<T>
{
  private final String zzatD;
  private T zzatE;
  
  protected zzg(String paramString)
  {
    this.zzatD = paramString;
  }
  
  protected final T zzaA(Context paramContext)
    throws zzg.zza
  {
    ClassLoader localClassLoader;
    if (this.zzatE == null)
    {
      zzx.zzy(paramContext);
      Context localContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (localContext == null) {
        throw new zza("Could not get remote context.");
      }
      localClassLoader = localContext.getClassLoader();
    }
    try
    {
      this.zzatE = zzd((IBinder)localClassLoader.loadClass(this.zzatD).newInstance());
      return (T)this.zzatE;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new zza("Could not load creator class.", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new zza("Could not instantiate creator.", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new zza("Could not access creator.", localIllegalAccessException);
    }
  }
  
  protected abstract T zzd(IBinder paramIBinder);
  
  public static class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\dynamic\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */