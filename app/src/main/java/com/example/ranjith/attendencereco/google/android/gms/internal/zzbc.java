package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

@zzha
public class zzbc
{
  private zzbb zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel, final zza<zzbb> paramzza, zzan paramzzan)
  {
    final zzbd localzzbd = new zzbd(paramContext, paramVersionInfoParcel, paramzzan);
    paramzza.zzst = localzzbd;
    localzzbd.zza(new zzbb.zza()
    {
      public void zzcr()
      {
        paramzza.zzf(localzzbd);
      }
    });
    return localzzbd;
  }
  
  public Future<zzbb> zza(final Context paramContext, final VersionInfoParcel paramVersionInfoParcel, final String paramString, final zzan paramzzan)
  {
    final zza localzza = new zza(null);
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        zzbc.zza(zzbc.this, paramContext, paramVersionInfoParcel, localzza, paramzzan).zzt(paramString);
      }
    });
    return localzza;
  }
  
  private static class zza<JavascriptEngine>
    extends zzjb<JavascriptEngine>
  {
    JavascriptEngine zzst;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */