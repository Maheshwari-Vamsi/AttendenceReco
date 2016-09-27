package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

@zzha
public class zziz
{
  public static <T> T zzb(Callable<T> paramCallable)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    try
    {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitDiskReads().permitDiskWrites().build());
      Object localObject2 = paramCallable.call();
      return (T)localObject2;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzb("Unexpected exception.", localThrowable);
      zzp.zzbA().zzb(localThrowable, true);
      return null;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zziz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */